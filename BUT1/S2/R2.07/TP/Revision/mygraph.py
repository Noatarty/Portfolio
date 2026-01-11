# coding: utf-8
""" 
Une classe Python pour creer et manipuler des graphes
"""

from collections import deque

class Graphe(object):

    def __init__(self, graphe_dict=None):
        """ initialise un objet graphe.
	    Si aucun dictionnaire n'est
	    créé ou donné, on en utilisera un 
	    vide
        """
        if graphe_dict == None:
            graphe_dict = dict()
        self._graphe_dict = graphe_dict

    def aretes(self, sommet):
        """ retourne une liste de toutes les aretes d'un sommet"""
        return self._graphe_dict[sommet]

    def all_sommets(self):
        """ retourne tous les sommets du graphe """
        return self._graphe_dict.keys()

    def all_aretes(self):
        """ retourne toutes les aretes du graphe """
        return self.__list_aretes()

    def add_sommet(self, sommet):
        """ Si le "sommet" n'est pas déjà présent
	dans le graphe, on rajoute au dictionnaire 
	une clé "sommet" avec une liste vide pour valeur. 
	Sinon on ne fait rien.
        """
        if sommet not in self._graphe_dict:
            self._graphe_dict[sommet] = []

    def add_arete(self, arete):
        """ l'arete est de  type set, tuple ou list;
            Entre deux sommets il peut y avoir plus
	    d'une arete (multi-graphe)
        """
        arete = set(arete)
        arete1, arete2 = tuple(arete)
        for x, y in [{arete1, arete2}, {arete2, arete1}]:
            if x in self._graphe_dict:
                self._graphe_dict[x].add(y)
            else:
                self._graphe_dict[x] = {y}

    def __list_aretes(self):
        """ Methode privée pour récupérer les aretes. 
	    Une arete est un ensemble (set)
            avec un (boucle) ou deux sommets.
        """
        aretes = []
        for sommet in self._graphe_dict:
            for voisin in self._graphe_dict[sommet]:
                if ({voisin, sommet}) not in aretes:
                    aretes.append({sommet, voisin})
        return aretes
    
    def trouve_chaine(self, sommet_dep, sommet_arr, chain=None):
        """ Trouver un chemin élémentaire de sommet_dep à sommet_arr 
            dans le graphe """
        graphe = self._graphe_dict
        if not ({sommet_dep, sommet_arr}.issubset(graphe)):
            return None
        if chain == None:
            chain = []
        chain = chain + [sommet_dep]
        if sommet_dep == sommet_arr:
            return chain
        for sommet in graphe[sommet_dep]:
            if sommet not in chain:
                ext_chain = self.trouve_chaine(sommet, sommet_arr, chain)
                if ext_chain:
                    return ext_chain
        return None


    def trouve_tous_chaines(self, sommet_dep, sommet_arr, chain=[]):
        """ Trouver tous les chemins élémentaires de sommet_dep à 
            sommet_arr dans le graphe """
        graphe = self._graphe_dict
        if not ({sommet_dep, sommet_arr}.issubset(graphe)):
            return []
        chain = chain + [sommet_dep]
        if sommet_dep == sommet_arr:
            return [chain]
        if sommet_dep not in graphe:
            return []
        chains = []
        for sommet in graphe[sommet_dep]:
            if sommet not in chain:
                ext_chains = self.trouve_tous_chaines(sommet, sommet_arr, chain)
                for c in ext_chains:
                    chains.append(c)
        return chains


    def __iter__(self):
        self._iter_obj = iter(self._graphe_dict)
        return self._iter_obj

    def __next__(self):
        """ Pour itérer sur les sommets du graphe """
        return next(self._iter_obj)

    def __str__(self):
        res = "sommets: "
        for k in self._graphe_dict.keys():
            res += str(k) + " "
        res += "\naretes: "
        for arete in self.__list_aretes():
            res += str(arete) + " "
        return res

    def sommet_degre(self, sommet):
        """ renvoie le degre du sommet """
        degre = len(self._graphe_dict[sommet])
        if sommet in self._graphe_dict[sommet]:
            degre += 1
        return degre

    def trouve_sommet_isole(self):
        """ renvoie la liste des sommets isoles """
        graphe = self._graphe_dict
        isoles = []
        for sommet in graphe:
            if not graphe[sommet]:
                isoles += [sommet]
        return isoles

    def Delta(self):
        """ le degre maximum  """
        max = 0
        for sommet in self._graphe_dict:
            sommet_degre = self.sommet_degre(sommet)
            if sommet_degre > max:
                max = sommet_degre
        return max

    def list_degres(self):
        """ calcule tous les degres et renvoie un
        tuple de degres decroissant
    """
        degres = []
        for sommet in self._graphe_dict:
            degres.append(self.sommet_degre(sommet))
        degres.sort(reverse=True)
        return degres

    # A PARTIR D'ICI C'EST NUL

    def bfs(self, sommet_dep):
        file = deque()
        file.append(sommet_dep)
        distances = {sommet_dep: 0}
        for sommet in self._graphe_dict:
            if sommet != sommet_dep:
                distances[sommet] = None
        arbre = dict()
        while len(file) > 0:
            v = file.pop()
            for w in self._graphe_dict[v]:
                if distances[w] == None:
                    distances[w] = distances[v] + 1
                    file.append(w)
                    arbre[v] = w
        return (distances, arbre)

    def dfs(self, sommet_dep):
        pile = deque()
        pile.append(sommet_dep)
        distances = {sommet_dep: 0}
        for sommet in self._graphe_dict:
            if sommet != sommet_dep:
                distances[sommet] = None
        arbre = dict()
        while len(pile) > 0:
            v = pile.popleft()
            for w in self._graphe_dict[v]:
                if distances[w] == None:
                    distances[w] = distances[v] + 1
                    pile.appendleft(w)
                    arbre[v] = w
        return (distances, arbre)


    def dijkstra(self, sommet_dep):
        distances = {sommet_dep: 0}
        for sommet in self._graphe_dict:
            if sommet != sommet_dep:
                distances[sommet] = None
        parents = {}
        file = deque()
        for sommet in self._graphe_dict:
            if sommet != sommet_dep:
                file.appendleft(sommet)
        while len(file) > 0:
            v = 100
            for voisin in self._graphe_dict[sommet_dep]:
                if self._graphe_dict[sommet_dep][voisin] < v:
                    v = self._graphe_dict[sommet_dep][voisin]
            file.remove(v)
            for u in self._graphe_dict[v]:
                if u not in file:
                    if distances[u] > distances[v] + self._graphe_dict[v][u]:
                        distances[u] = distances[v] + self._graphe_dict[v][u]
                        parents[u] = v
            return (distances, parents)

    def plus_court_chemin(self, sommet_dep, sommet_arr, parents):
        chemin = [sommet_arr]
        v = sommet_arr
        while len(parents[v]) > 0:
            chemin = chemin + parents[v]
            v = parents[v]
        chemin = chemin.reverse()
        return chemin


graphe = {"A" :{"C": 1},
"B" : {"C" : 2, "E" : 3},
"C" : {"A" : 1, "B" : 2, "D" : 4, "E" : 2},
"D" : {"C" : 4},
"E" : {"C" : 2, "B" : 3},
"F" : {}
}

g = Graphe(graphe)
print(g.dijkstra("A"))