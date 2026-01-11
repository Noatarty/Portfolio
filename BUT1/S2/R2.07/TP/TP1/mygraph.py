# coding: utf-8
""" 
Une classe Python pour creer et manipuler des graphes
L'ob jectif de ces premières séances est de faire notre propre mo dule, mygraph.py, p our créer et manipuler des
graphes.
Comme on le verra tout au long du cours, il existe plusieures manières de représenter un graphe. On commencera
par traîter des graphes non-orientés et on utilisera un dictionnaire p our représenter les listes d'adjacences du
graphe, le graphe suivant par exemple :
A
B
C
D
E F
a sera représenté grâce au dictionnaire suivant :
graphe = {"A " :{"C"},
"B" : {"C", "E"},
"C" : {"A", "B", "D", "E"},
"D" : {"C"},
"E" : {"C", "B"},
"F" : {}
}
les appels de fonctions et l'importation de ce fichier en tant que module se feras 
dans test.py
"""


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
        return self._graphe_dict.get(sommet, [])
        

    def all_sommets(self):
        """ retourne tous les sommets du graphe """
        return self._graphe_dict.keys()

    def all_aretes(self):
        """ retourne toutes les aretes du graphe """
        sommets = self.all_sommets()
        aretes = []
        for sommet in sommets:
            for arete in self.aretes(sommet):
                aretes.append((sommet, arete))
                return aretes

        
    def add_sommet(self, sommet):
        """ Si le "sommet" n'set pas déjà présent
	    dans le graphe, on rajoute au dictionnaire 
	    une clé "sommet" avec une liste vide pour valeur. 
	    Sinon on ne fait rien.
        """
        if sommet not in self._graphe_dict.keys():
            self._graphe_dict[sommet] = []
            return self._graphe_dict[sommet]
        else:
            return self._graphe_dict[sommet]

    def add_arete(self, arete):
        """ l'arete est de  type set, tuple ou list;
            Entre deux sommets il peut y avoir plus
	    d'une arete (multi-graphe)
        """
        if type(arete) == set:
            arete = list(arete)
            if len(arete) == 2:
                self.add_arete(arete[0], arete[1])
            else:
                raise ValueError("L'arete doit contenir 2 sommets")
        elif type(arete) == tuple or type(arete) == list:
            if len(arete) == 2:
                self.add_arete(arete[0], arete[1])
            else:
                raise ValueError("L'arete doit contenir 2 sommets")
        else:
            raise TypeError("L'arete doit être de type set, tuple ou list")
        return self._graphe_dict

    def __list_aretes(self):
        """ Methode privée pour récupérer les aretes. 
	    Une arete est un ensemble (set)
            avec un (boucle) ou deux sommets.
        """
        res = []
        for sommet in self._graphe_dict.keys():
            for arete in self.aretes(sommet):
                if arete not in res:
                    res.append(arete)
                    return res
                else:
                    return res
        
    
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
