# Assignment 4: Graph Traversal and Representation System

## Yermek Dinmukhambet IT-2501

This project demonstrates graph representation and traversal algorithms in Java.

A graph is a non-linear data structure consisting of vertices (nodes) and edges (connections between nodes). Graphs are commonly used in computer science for representing networks, maps, social connections, and relationships between objects.

This project uses an adjacency list to represent the graph structure. An adjacency list stores each vertex together with the list of vertices connected to it.

Two graph traversal algorithms are implemented:

- Breadth-First Search (BFS)
- Depth-First Search (DFS)

---

## Class Descriptions

### Vertex Class

The Vertex class represents a single node in the graph.


---

### Edge Class

The Edge class represents a connection between two vertices.


---

### Graph Class

The Graph class represents the graph structure using an adjacency list.



Methods:

- `addVertex(Vertex v)`
- `addEdge(int from, int to)`
- `printGraph()`
- `bfs(int start)`
- `dfs(int start)`



---

### Experiment Class

The Experiment class is responsible for testing and performance analysis.



---

## Adjacency List Representation

An adjacency list is a graph representation where each vertex stores a list of connected neighboring vertices.



---

## Algorithm Descriptions

## Breadth-First Search (BFS)

Breadth-First Search explores the graph level by level.

How BFS works:

1. Start from the selected vertex
2. Mark it as visited
3. Add it to a queue
4. Remove a vertex from the queue
5. Visit all unvisited neighbors
6. Repeat until the queue becomes empty



Time Complexity:

O(V + E)

Where:

- V = number of vertices
- E = number of edges

---

## Depth-First Search (DFS)

Depth-First Search explores as deep as possible before backtracking.

How DFS works:

1. Start from the selected vertex
2. Mark it as visited
3. Visit one unvisited neighbor
4. Continue deeper
5. Backtrack when no more neighbors are available



Time Complexity:

O(V + E)

---



---

## Analysis Questions

### How does graph size affect BFS and DFS performance?

As graph size increases, execution time also increases because the algorithms must process more vertices and edges.

---

### Which traversal is faster in your experiments?

In most tests, BFS and DFS show similar performance because both have O(V + E) complexity. Small differences may occur depending on graph structure.

---

### Do results match the expected complexity O(V + E)?

Yes. Both algorithms visit each vertex and each edge once, which matches theoretical complexity.

---

### How does graph structure affect traversal order?

Traversal order depends on how vertices are connected.

BFS visits nodes level by level.

DFS follows one branch deeply before returning.

---

### When is BFS preferred over DFS?

BFS is preferred when:

- shortest path is required
- level-by-level traversal is needed
- exploring nearby nodes first

---

### What are the limitations of DFS?

DFS limitations:

- can go too deep
- possible stack overflow with recursion
- does not guarantee shortest path

---

## Reflection

This project helped me understand graph structures and graph traversal algorithms.

I learned the difference between BFS and DFS and how adjacency lists represent graph connections efficiently.

BFS explores nodes level by level using a queue, while DFS explores deeply using recursion or a stack.

One challenge was understanding traversal logic and preventing repeated visits using a visited set.

Overall, this project improved my understanding of graph algorithms, Java OOP design, and performance analysis.

---

## Conclusion

This assignment demonstrates graph representation, BFS and DFS traversal, performance testing, and Java object-oriented programming principles.