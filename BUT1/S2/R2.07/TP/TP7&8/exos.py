def graphe_connexe_BFS(G, s):
  n = len(G.nodes())
  visited = [False] * n 
  Q = [s]
  visited[s] = True
  c = 1
  
  while Q:
    v = Q.pop(0)
    for w in G.neighbors(v):
      if not visited[w]:
        visited[w] = True
        c += 1
        Q.append(w)
        
  return c == n

def graphe_connexe_BFS(G, s):
  n = len(G.nodes())
  visited = [False] * n 
  Q = [s]
  visited[s] = True
  c = 1
  
  while Q:
    v = Q.pop(0)
    for w in G.neighbors(v):
      if not visited[w]:
        visited[w] = True
        c += 1
        Q.append(w)
        
  return c == n

def chemin_BFS(G, s, t):
  visited = [False] * len(G.nodes())
  Q = [s]
  visited[s] = True
  
  while Q:
    v = Q.pop(0)
    if v == t:
      return True
    for w in G.neighbors(v):
      if not visited[w]:
        visited[w] = True
        Q.append(w)
        
  return False

def chemin_DFS(G, s, t):
  visited = [False] * len(G.nodes()) 
  stack = [s]
  visited[s] = True
  
  while stack:
    v = stack.pop()
    if v == t:
      return True
    for w in G.neighbors(v):
      if not visited[w]:
        visited[w] = True
        stack.append(w)
        
  return False

def cycle_DFS(G):
  visited = [False] * len(G.nodes())
  recstack = [False] * len(G.nodes())

  for v in G.nodes():
    if not visited[v]:
      if cycle_DFS_recur(G, v, visited, recstack):
        return True

  return False

def cycle_DFS_recur(G, v, visited, recstack):
  visited[v] = True
  recstack[v] = True

  for w in G.neighbors(v):
    if not visited[w]:
      if cycle_DFS_recur(G, w, visited, recstack):
        return True
    elif recstack[w]:
      return True

  recstack[v] = False
  return False
