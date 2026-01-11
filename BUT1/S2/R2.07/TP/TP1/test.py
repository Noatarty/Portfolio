import mygraph as gr
graphe = {"A " :{"C"},
"B" : {"C", "E"},
"C" : {"A", "B", "D", "E"},
"D" : {"C"},
"E" : {"C", "B"},
"F" : {}
}
g=gr.Graphe(graphe)
print(g.all_aretes())
print(g.all_sommets())