from collections import deque

def bfs(graph, start):
    visited = set()
    queue = deque([start]) 
    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    tree = {}
    
    while queue:
        node = queue.popleft()
        visited.add(node)
        
        for neighbour in graph[node]:
            if neighbour not in visited:
                queue.append(neighbour)
                distances[neighbour] = distances[node] + 1
                tree[node] = neighbour
    
    return distances, tree

def dfs(graph, start):
    visited = set()
    stack = [start]
    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    tree = {}
    
    while stack:
        node = stack.pop()
        visited.add(node)
        
        for neighbour in graph[node]:
            if neighbour not in visited:
                stack.append(neighbour)
                distances[neighbour] = distances[node] + 1
                tree[node] = neighbour
        
    return distances, tree

graph = {
  'A': ['B','C'],
  'B': ['A', 'D', 'E'],
  'C': ['A', 'F'],
  'D': ['B'],
  'E': ['B', 'F'],
  'F': ['C', 'E']
}
distances, tree = bfs(graph, 'A')
print(distances)
print(tree)

distances, tree = dfs(graph, 'A') 
print(distances)
print(tree)
