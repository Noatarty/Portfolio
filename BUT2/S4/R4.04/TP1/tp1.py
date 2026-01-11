import numpy as np

def f1prime(x):
    return 2*x - 4

def f2prime(x):
    return 3*x**2 - 4

def f3prime(x):
    return np.exp(x) - 10

def Gradient1D(x0, alpha, n, fp):
    x = x0
    for _ in range(n):
        x = x - alpha * fp(x)
        print(f"x : {x}")
    return x

#Q3
x_min_f1_x0 = Gradient1D(x0=-2, alpha=0.2, n=1, fp=f1prime)
print(f"x1 : {x_min_f1_x0}")
x_min_f1 = Gradient1D(x0=-2, alpha=0.2, n=2, fp=f1prime)
print(f"x2 : {x_min_f1}")
#Q4
x_min_f2 = Gradient1D(x0=0, alpha=0.1, n=35, fp=f2prime)
print(f"Minimum estimé pour f2 : {x_min_f2}")
#Q5
x_min_f3 = Gradient1D(x0=0, alpha=0.1, n=10, fp=f3prime)
print(f"Minimum estimé pour f3 : {x_min_f3}")


#B

# Dérivées partielles de f1
def df1x(x, y):
    return 4*x + 2 + y

def df1y(x, y):
    return 10*y + x

# Dérivées partielles de f2
def df2x(x, y):
    return 2*x - 1.9

def df2y(x, y):
    return 2*y

def Gradient2D(fx, fy, x0, y0, alpha, n):
    x, y = x0, y0
    for _ in range(n):
        x_old = x
        x = x - alpha * fx(x, y)
        y = y - alpha * fy(x_old, y)
        print(f"x : {x}, y : {y}")
    
    return x, y

x_min_f1_x0, y_min_f1_x0 = Gradient2D(df1x, df1y, x0=-2, y0=2, alpha=0.2, n=1)
print(f"x1,y1 : ({x_min_f1_x0}, {y_min_f1_x0})")
x_min_f1, y_min_f1 = Gradient2D(df1x, df1y, x0=-2, y0=2, alpha=0.2, n=2)
print(f"x2,y2 : ({x_min_f1}, {y_min_f1})")

x_min_f2, y_min_f2 = Gradient2D(df2x, df2y, x0=0, y0=0, alpha=0.1, n=161)
print(f"Minimum estimé pour f2 : ({x_min_f2}, {y_min_f2})")


def dFa(a, b):
    return 13,5632*a + 11,44*b - 90,4

def dFb(a, b):
    return 10*b + 11,44*a - 72

x_min_f1_x0, y_min_f1_x0 = Gradient2D(dFa, dFb, x0=20, y0=-10, alpha=0.05, n=1)
print(f"x1,y1 : ({x_min_f1_x0}, {y_min_f1_x0})")
x_min_f1, y_min_f1 = Gradient2D(dFa, dFb, x0=20, y0=-10, alpha=0.05, n=2)
print(f"x2,y2 : ({x_min_f1}, {y_min_f1})")