class Graphe:

    def __init__(self, sommets, aretes):
        self.sommets = sommets
        self.aretes = aretes

    def trouve_chaine(self, sommet_dep, sommet_arr, chaine=None):
        if chaine is None:
            chaine = [sommet_dep]
        
        if sommet_dep == sommet_arr:
            return chaine
        
        for voisin in self.voisins(sommet_dep):
            if voisin not in chaine:
                nouvelle_chaine = self.trouve_chaine(voisin, sommet_arr, chaine + [voisin])
                if nouvelle_chaine:
                    return nouvelle_chaine

        return None

    def trouve_toutes_chaines(self, sommet_dep, sommet_arr, chaines=[]):
        chaine = [sommet_dep]

        if sommet_dep == sommet_arr:
            return [chaine]

        for voisin in self.voisins(sommet_dep):
            if voisin not in chaine:
                sous_chaines = self.trouve_toutes_chaines(voisin, sommet_arr, chaine + [voisin])
                chaines.extend(sous_chaines)

        return chaines

class Graphe2(Graphe):
    
    def sommet_degre(self, sommet):
        return len(self.voisins(sommet))
    
    def trouve_sommet_isole(self):
        isoles = []
        for s in self.sommets:
            if self.sommet_degre(s) == 0:
                isoles.append(s)
        return isoles
    
    def Delta(self):
        return max([self.sommet_degre(s) for s in self.sommets])
        
    def list_degres(self):
        degres = [self.sommet_degre(s) for s in self.sommets]
        degres.sort(reverse=True)
        return tuple(degres)


def verifie_lemme_poignees(graphe):
    degres = graphe.list_degres()
    return sum(degres) == 2 * len(graphe.aretes)

# Création d'un graphe
sommets = ['A', 'B', 'C', 'D', 'E']
aretes = [('A', 'B'), ('A', 'C'), ('B', 'C'), ('B', 'D'), ('C', 'E')]
graphe = Graphe(sommets, aretes)

# Test de trouve_chaine
chaine1 = graphe.trouve_chaine('A', 'E') 
print(chaine1) # ['A', 'C', 'E']

chaine2 = graphe.trouve_chaine('B', 'E')
print(chaine2) # ['B', 'C', 'E'] 

# Test de trouve_toutes_chaines
chaines = graphe.trouve_toutes_chaines('A', 'E')
print(chaines) # [['A', 'C', 'E']]

# Création d'un Graphe2
graphe2 = Graphe2(sommets, aretes)

# Test des méthodes de Graphe2
print(graphe2.sommet_degre('B')) # 3 
print(graphe2.trouve_sommet_isole()) # []
print(graphe2.Delta()) # 3
print(graphe2.list_degres()) # (3, 3, 2, 1, 1)

# Vérification du lemme des poignées de mains
print(verifie_lemme_poignees(graphe2)) # True
