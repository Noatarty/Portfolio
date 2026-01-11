import time
import sdl2.ext
import numpy
import os
import random
import main


RESOURCES = sdl2.ext.Resources(__file__, "images")
WINDOW_SIZE = (800, 600)
R_SPEED = -16
ACCEL = 1

SPEED = 1

def elapsed_frames(elpsed_time, game_speed):
    time_record = time.time()

    frames = (time_record - elpsed_time) * 60
    elpsed_time = time_record - (frames - int(frames)) / 60

    return int(frames) * game_speed, elpsed_time

def set_sprites(factory):
    sprites = []
    pipes = []

    bird = factory.from_image(RESOURCES.get_path("bird.png"))
    bird.position = 20, int(WINDOW_SIZE[1] / 2 - 120)

    background = factory.from_image(RESOURCES.get_path("background.png"))

    sprites.append(background)
    sprites.append(bird)

    for i in range(5):
        pipe = factory.from_image(RESOURCES.get_path("pipes.png"))
        pipe.x = WINDOW_SIZE[0] + (i+1) * 320
        pipe.y = -numpy.random.choice([0, 50, 100])
        pipes.append(pipe)

    return sprites, pipes

def update_pos(sprites, pipes, frames, speed):
    acceleration = ACCEL

    # Pipes
    for pipe in pipes:
        pipe.x -= frames * 4
        if pipe.x + pipe.size[0] < 0:
            pipe.x += 1600
            pipe.y = -numpy.random.choice([0, 50, 100])

    # Bird
    speed = speed + acceleration * frames

    y = sprites[1].y
    y = y + speed * frames

    if y > WINDOW_SIZE[1] - 60:
        y = WINDOW_SIZE[1] - 60
        return y, False

    if y < 0:
        y = 0
        speed = 0

    sprites[1].y = y
    return speed, True

def update_pos_gen(birds, pipes, frames, bird_number, next_birds):
    acceleration = ACCEL

    # Pipes
    for pipe in pipes:
        pipe.x -= frames * 5
        if pipe.x + pipe.size[0] < 0:
            pipe.x += 1600
            pipe.y = -numpy.random.choice([0, 50, 100])


    # Bird
    for bird in birds:
        bird.speed = bird.speed + acceleration * frames

        y = bird.sprite.y
        y = y + bird.speed * frames

        if y > WINDOW_SIZE[1] - 60:
            y = WINDOW_SIZE[1] - 60
            bird.playing = False

            if bird.alive:
                dead_birds = 0
                for b in birds:
                    if not b.alive:
                        dead_birds += 1
                
                dead_birds += 1
                if dead_birds > bird_number:
                    next_birds.append(bird)
                
                bird.alive = False

        if y < 0:
            y = 0
            bird.speed = 0

        bird.sprite.y = y

    for bird in birds:
        if bird.playing:
            return True
    
    return False

def render(sprites, pipes, spriterenderer):
    sprites_all = []
    sprites_all.append(sprites[0])

    for pipe in pipes:
        sprites_all.append(pipe)

    sprites_all.append(sprites[1])

    spriterenderer.render(sprites_all)

def render_gen(birds, background, pipes, spriterenderer):
    sprites = []
    sprites.append(background)

    for pipe in pipes:
        sprites.append(pipe)

    for bird in birds:
        sprites.append(bird.sprite)

    spriterenderer.render(sprites)


def hit_pipes(sprite, pipes):
    for pipe in pipes:
        if pipe.x < -20 and pipe.x > -120:
            if (sprite.y < pipe.y + 230) or (sprite.y > pipe.y + 395):
                return False
    return True

def hit_pipes_gen(birds, pipes, factory, next_birds, bird_number):
    dead_birds = 0
    for bird in birds:
        if not bird.alive:
            dead_birds += 1

    for bird in birds:
        if bird.alive:
            for pipe in pipes:
                if pipe.x < -20 and pipe.x > -120:
                    kill_b = False
                    if (bird.sprite.y < pipe.y + 230):
                        kill_b = True
                        bird.dead_side = True
                    if (bird.sprite.y > pipe.y + 395):
                        kill_b = True
                        bird.dead_side = False
                    if kill_b:
                        bird.alive = False
                        # Kill
                        kill_gen(factory, bird)
                        dead_birds += 1

                        if dead_birds > bird_number:
                            next_birds.append(bird)

def kill(factory, sprites):
    pos = sprites[1].position
    sprite = factory.from_image(RESOURCES.get_path("reverse_bird.png"))
    sprite.position = pos
    sprites[1] = sprite
    return 15

def kill_gen(factory, bird):
    pos = bird.sprite.position
    sprite = factory.from_image(RESOURCES.get_path("reverse_bird.png"))
    sprite.position = pos
    bird.sprite = sprite
    bird.speed = 15

def generate_new(): 
    return main.attente_saut()

def init_birds(number, factory):
    birds = []

    for i in range(number):
        birds.append(Bird(factory))

        for j in range(10):
            birds[i].mooves.append(generate_new())
    
    return birds

def fly_birds(birds, frames):
    for bird in birds:
        if bird.alive:
            bird.frames += frames
            if bird.frames >= bird.mooves[bird.iter]:
                bird.frames = bird.frames - bird.mooves[bird.iter]
                bird.iter = bird.iter + 1
                bird.speed = R_SPEED

                if bird.iter > len(bird.mooves) -10:
                    bird.mooves.append(generate_new())

def reset_birds(next_birds, bird_number, factory):
    birds = []
    
    for _ in range(int(bird_number)):
        b = Bird(factory)
        i = random.randint(0, len(next_birds) - 1)
        b.copy_bird(next_birds[i])
        
        liste = main.nouveau_macareux(b.mooves[max(0, next_birds[i].iter - 4) : next_birds[i].iter + 1], next_birds[i].dead_side)

        for j in range(5):
            b.mooves[next_birds[i].iter - 4 + j] = liste[j]

        birds.append(b)

    for bird in next_birds:
        bird.reset()
        birds.append(bird)

    return birds

def genetic_start(nb_pop, pourc_selec): 

    # Init SDL
    sdl2.ext.init()

    factory = sdl2.ext.SpriteFactory(sdl2.ext.SOFTWARE)
    window = sdl2.ext.Window("Flapp'IUT", size=WINDOW_SIZE)
    window.show()

    background = factory.from_image(RESOURCES.get_path("background.png"))
    spriterenderer = factory.create_sprite_render_system(window)

    bird_number = nb_pop
    next_birds = []
    game_speed = SPEED
    birds = init_birds(bird_number, factory)

    close = False
    while(not close):
        numpy.random.seed(os.getpid())
        _, pipes = set_sprites(factory)

        next_birds = []

        running = True
        elpsed_time = time.time()

        while running:
            # Get number of frames
            frames, elpsed_time  = elapsed_frames(elpsed_time, game_speed)

            # Update pos
            running = update_pos_gen(birds, pipes, frames, int(bird_number * pourc_selec / 100.0), next_birds)

            # Render
            if frames != 0:
                render_gen(birds, background, pipes, spriterenderer)

            # Make bird fly
            fly_birds(birds, frames)

            # Check hit pipes
            hit_pipes_gen(birds, pipes, factory, next_birds, int(bird_number * pourc_selec / 100.0))

            events = sdl2.ext.get_events()

            for event in events:
                if event.type == sdl2.SDL_QUIT:
                    close = True
                    running = False
                    break
            
        if not close:
            birds = reset_birds(next_birds, int(bird_number * pourc_selec / 100.0), factory)
            time.sleep(0.3)
    
    # Exit SDL
    sdl2.ext.quit()

def game_start():

    # Init SDL
    sdl2.ext.init()

    numpy.random.seed(os.getpid())

    elpsed_time = time.time()

    factory = sdl2.ext.SpriteFactory(sdl2.ext.SOFTWARE)
    window = sdl2.ext.Window("Flapp'IUT", size=WINDOW_SIZE)
    window.show()

    sprites, pipes = set_sprites(factory)

    spriterenderer = factory.create_sprite_render_system(window)

    # Speed 0 pixels/frames
    speed = -15

    running = True
    alive = True

    while running:

        # Get number of frames
        frames, elpsed_time  = elapsed_frames(elpsed_time, 1)

        # Update pos
        speed, running = update_pos(sprites, pipes, frames, speed)

        # Render
        if frames != 0:
            render(sprites, pipes, spriterenderer)

        # Check hit pipes
        if alive:
            alive = hit_pipes(sprites[1], pipes)

            # Kill
            if not alive:
                speed = kill(factory, sprites)


        events = sdl2.ext.get_events()

        for event in events:
            if event.type == sdl2.SDL_QUIT:
                running = False
                break
            if event.type == sdl2.SDL_KEYDOWN:
                if event.key.keysym.sym == sdl2.SDLK_SPACE and alive:
                    speed = R_SPEED
    
    time.sleep(1)

    # Exit SDL
    sdl2.ext.quit()


class Bird:
    def __init__(self, factory):
        self.sprite = factory.from_image(RESOURCES.get_path("bird.png"))
        self.sprite.position = 20, int(WINDOW_SIZE[1] / 2 - 120)
        self.factory = factory
        self.speed = -10
        self.playing = True
        self.alive = True
        self.frames = 0
        self.mooves = []
        self.iter = 0
        self.dead_side = False
    
    def copy_bird(self, bird):
        for moove in bird.mooves:
            self.mooves.append(moove)

    def reset(self):
        self.iter = 0
        self.frames = 0
        self.speed = -10
        self.playing = True
        self.alive = True
        self.sprite = self.factory.from_image(RESOURCES.get_path("bird.png"))
        self.sprite.position = 20, int(WINDOW_SIZE[1] / 2 - 120)
        self.dead_side = False

jeu, nb_pop, pourc_selec = main.__main__()

if jeu:
    game_start()
else:
    genetic_start(nb_pop, pourc_selec)
