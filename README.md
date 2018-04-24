# algo_datastructures
Repository which holds different implementation of famous data structures and algorithms. This repository is designed to be taken as a refernce, or to have a quick look at various implementations of algorithms and data structures. The short programs are categorized as below, with their documentation. 

**language** - 
	
	Java

**java version** - 

	java version "1.8.0_131"
	Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
	Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
	
## Disclaimer

The code written in this repository, are not necessarily the original work of me (except for, some of them). Many of them are referenced from books or tutorial sites such as

* *Algorithms 4th Edition by Robert Sedgewick, Kevin Wayne* - https://algs4.cs.princeton.edu/home/
* www.geeksforgeeks.org
* www.hackerearth.com
	
## Table of Content

1. [Sorting Algorithms](#sorting_algo)
2. [Data Structures](#ds)
	1. [Basic Data Structures](#basicds)
		1. [Dynamic Array](#basicds_array)
    	2. [Linked List](#basicds_linkedlist)
    	3. [Stack](#basicds_stack)
    	4. [Heap](#basicds_heap)
    	5. [IndexMinHeap](#index_min_heap)
    	6. [Binary Search Tree](#basicds_bst)
	2. [Advanced Data Structures](#advanceds)
	    1. [Graphs](#advanceds_graphs)
	    2. [Graph Traversal](#advanceds_graphs_traversal)
	    3. [UnionFind & ConnectedComponents](#advanceds_unionfind)
	    4. [Spanning Tree and MST](#advanceds_spanning)
	    5. [Prim's MST](#advanceds_prims)
	    6. [Kruskal's MST](#advanceds_kruskal)
	    7. [Cycle Detection - Directed Graph](#advanceds_directedcycle)
	    8. [DFS Order](#advanceds_dfsorder)
	    9. [Topological Sort](#advanceds_topological_sort)
	   10. [Kosaraju's Strong Connected Component algorithm](#advanceds_kosarajuscc)
	   11. [Dijkstra's SP](#advanceds_dijkstra)

<a id='sorting_algo' />

## Sorting Algorithms

Algorithm | Time Complexity Best | Time Complexity Average | Time Complexity Worst | Space Complexity | Is [Stable?](https://en.wikipedia.org/wiki/Sorting_algorithm#Stability)
--- | --- | --- | --- | --- | ---
[BubbleSort](src/main/java/algo/sort/BubbleSort.java) | &Omega; (n) | &Theta; (n^2) | &Omicron; (n^2) | &Omicron; (1) | Yes
[SelectionSort](src/main/java/algo/sort/SelectionSort.java) | &Omega; (n^2) | &Theta; (n^2) | &Omicron; (n^2) | &Omicron; (1) | No
[InsertionSort](src/main/java/algo/sort/InsertionSort.java) | &Omega; (n) | &Theta; (n^2) | &Omicron; (n^2) | &Omicron; (1)  | Yes
[ShellSort](src/main/java/algo/sort/ShellSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)^2) | &Omicron; (n log(n)^2) | &Omicron; (1) | No 
[MergeSort](src/main/java/algo/sort/MergeSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)) | &Omicron; (n log(n)) | &Omicron; (n)  | Yes
[QuickSort](src/main/java/algo/sort/QuickSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)) | &Omicron; (n^2)) | &Omicron; (log(n)) | No
[HeapSort](src/main/java/algo/sort/HeapSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)) | &Omicron; (n log(n)) | &Omicron; (1)  | No

<a id='ds' />

## Data Structures

Data structures are a particular way of organizing the data in a computer, so that it can be accessed and modified efficiently.

<a id='basicds' />

### Basic Data Structures


<a id='basicds_array' />

#### Dynamic array
Dynamic array is an array based data-structure (insert - &Omicron;(1) and deleteAtIndex - &Omicron;(1)), which adjusts its size and rearranges the items (re-indexing), as and when data gets added or deleted. 

* [Dynamic Array / Vector ](src/main/java/data/structure/list/Vector.java)

<a id='basicds_linkedlist' />

#### Linked List 
Linked List is a special data structure of connected items, represented by a special structure called as `Node`. A `Node` structure stores the data as well as a link (or memory address) to the next `Node` item present in the sequence.

In singly linked list, `Node` will have a pointer to the `Node` present ahead of it in the sequence (`Node next;`). In doubly linked list, a `Node` will be connected to both *next* and *previous* `Node` in the sequence.

* [Singly LinkedList](src/main/java/data/structure/list/SinglyLinkedList.java)
* [Doubly LinkedList](src/main/java/data/structure/list/DoublyLinkedList.java)

<a id='basicds_stack' />

#### Queue and Stack 
Stack is a popular data structure in which items inserted last will sit on top of the structure, pushing the previously inserted items to the bottom. It gives convenient methods to check, what is at the top of the structure (`peek()`)? and to **get** and **delete** the item on the top of the structure (`pop()`), with a time complexity of - &Omicron;(1). It is also called as *LIFO* data-structure. Following are some different implementations of stack, backed by array, singly linked list and doubly linked list.

* [Array based Stack](src/main/java/data/structure/queue/Stack.java) - **Bonus!** - This implementation also finds out the minimum element present within the stack with &Omicron;(1) time complexity.
* [Stack - backed by Singly LinkedList](src/main/java/data/structure/queue/StackSLL.java)
* [Stack - backed by Doubly LinkedList](src/main/java/data/structure/queue/StackDLL.java)

Queue too is a popular data structure in which items inserted first will sit on *front* of the structure, pushing the next items to be inserted to the *back*. It gives convenient methods to check, what is at the beginning of the structure (`peek()`)? and to **get** and **delete** the item on the front of the structure  (`enQueue()`), with a time complexity of - &Omicron;(1). It is also called as *FIFO* data-structure. Following are some different implementations of queue, backed by array and singly linked list.

* [Array based Queue](src/main/java/data/structure/queue/ArrayBasedQueue.java)
* [LinkedList based Queue](src/main/java/data/structure/queue/LinkedListBasedQueue.java)

<a id='basicds_heap' />

#### Heap
Heap is a tree based data structure, where each node follows the heap rule. Heaps can be of types - **Min** and **Max**. In **Min** heap, if a node within the tree is not a leaf node, then its *key* will always be less than its children. In this way the root of the tree will always be the item, with the least key among all the items present in the heap. **Max** heap is just the opposite, where the root node's *key* is the highest, and all non-leaf nodes will always be greater than their children.

* [Max Heap](src/main/java/data/structure/heap/MaxHeap.java) which extends [Heap](src/main/java/data/structure/heap/Heap.java)
* [Min Heap](src/main/java/data/structure/heap/MinHeap.java) which extends [Heap](src/main/java/data/structure/heap/Heap.java)

<a id='index_min_heap' />

#### Index Min Heap
[IndexMinHeap](src/main/java/data/structure/heap/IndexMinHeap.java) is an extension of Min Heap implementation which associates a particular `Index` with the `Key`. The `Key` will be inserted and used to maintain the heap order, and the `Index` will be mapped with the key, to have a 1-1 mapping between them. When a method such as `getMin()` and `delMin()` is called, the `Index` corresponding to the *minimum* key will be returned by the method.

<a id='basicds_bst' />

#### Binary Search Tree
[BinarySearchTree](src/main/java/data/structure/tree/BinarySearchTree.java) is one of the most popular **tree** based data structure, which provides efficient means of performing search operation on given set of data. BST is a binary tree (Tree, where each node has max of 2 children), with following unique characteristics.

* All the keys on the left sub-tree of *any* Node `x`, are **less** than the value of `x.key`
* All the keys on the right sub-tree of *any* Node `x` are **greater** than the value of `x.key`

We can use BST's `get(key)` method to access the data associated with a particular `key`, and we can use `put(key,value)`,  `delete(key)`, `deleteMin()` and `deleteMax()` to modify its content. BST provides effective ways to find out `min()`, `max()`, `floor(key`, `ceiling(key)` and `range(lowKey, highKey)` methods to do various types of search operations on its contents.

<a id='advanceds' />

### Advanced Data Structures

<a id='advanceds_graphs' />

#### Graphs

Graph is a data structure which represents the vertices (data) and the connection between the vertices. 

* A **dense** graph is a graph, where most of the vertices are connected with each other.  
* A **sparse** graph is a graph, where only some of the vertices are connected with other vertices.

In real world applications, sparse graphs are common than dense graphs.

There are two ways in which Graphs can be represented.

[Graph using Adjacency Matrix](src/main/java/data/structure/graph/undirected/GraphAM.java) - Here the connection between the vertices within the graph are represented in (`v * v`) boolean matrix, where `v` represents the number of vertices present in the graph. 

**Advantage** - `O(1)` access time to check if a particular vertex is connected to another vertex or not. 

**Disadvantage** - The space required to represent the graph is `v * v`, even though, not all vertices are connected.

**Usage** - Can be efficiently used to represent dense graphs.
  
[Graph using Adjacency List](src/main/java/data/structure/graph/undirected/GraphAL.java) - Here the graph is represented as array of vertices `v[]` and each array will have a Dynamic List pointing to the vertices it is connected to.

**Advantage** - Only `O(E)` space is required to represent a graph with `E` edges.

**Disadvantage** - The time complexity of finding out a connection between vertices is `O(E)`.

**Usage** - Can be efficiently used to represent sparse graphs

Also, there are 2 kinds of Graphs - **Directed** and **Undirected**. Below algorithms are categorized based on the kind of graph they work on.

<a id='advanceds_graphs_traversal' />

#### Graph Traversal (Undirected)

There are two ways in which the graph's vertices can be traversed for searching purpose. 

[Depth First Search](src/main/java/data/structure/graph/undirected/DepthFirstPaths.java) - In DFS, the child vertices of each vertex are visited first, until all the vertex are covered OR the leaf vertex is reached. Once the vertex has no more children, then backtracking is done and other children are visited / searched.

[Breadth First Search](src/main/java/data/structure/graph/undirected/BreadthFirstPaths.java) - In BFS, first all the children of a vertex are visited one after the other, once finished, then children at the next level are visited.

[Cycle Detection](src/main/java/data/structure/graph/undirected/CycleDetection.java) -of undirected graph - is the process of finding, whether a cycle exists or not in the graph, by using DFS path search along with parent back tracking.

**Theory** - If all the adjacent vertex (w) of a particular vertex (v) is visited (marked), then it should be equal to the parent (from which the vertex got searched using dfs). Else, there is a **Cycle**.
  
<a id='advanceds_unionfind' />

#### UnionFind and Connected Components(Undirected)

[UnionFind](src/main/java/data/structure/graph/undirected/UnionFind.java) (or [Disjoint-Set data structure](https://en.wikipedia.org/wiki/Disjoint-set_data_structure)) is a data structure which helps to connect components to form  a set, to track disjoint sets and to see if two components are connected (part of a same set) or not.

The application of this data structure varies from, finding if two Computers are connected within a network (either directly or indirectly), or variable name equivalence tracking in some languages (checking if two aliases point to same variable) to name a few. [This article](https://www.hackerearth.com/practice/notes/disjoint-set-union-union-find/) gives a good insight into the data structure and how it evolved to become more efficient! 

It is also used to detect cycle within the graph, which is used as part of Kruskal's MST algorithm.

[ConnectedComponent](src/main/java/data/structure/graph/undirected/ConnectedComponent.java) is another algorithm to find connected vertices in a graph and dividing the vertices within a graph based on which component they belong to. The application of this algorithm is same as `UnionFind`, but this algorithm is bit slower due to undreneath DFS implementation.

<a id='advanceds_kruskal' />

<a id='advanceds_spanning' />  

#### Spanning Tree and MST

**Spanning Tree** - Spanning tree of a graph is a sub-graph, where all the vertices of the graph are connected by edges without any cycle.

**Minimum Spanning Tree** - Is a spanning tree calculated from the undirected weighted graph, where the weight of the edges connecting the spanning tree is minimum.

<a id='advanceds_prims' />   

#### Prim's algorithm to find Minimum Spanning Tree (Undirected)

[Prim's algorithm](src/main/java/data/structure/graph/undirected/LazyPrimMST.java) is a Greedy algorithm, which starts with a vertex to build a MST, and then keeps adding it more connections which have the least weight.

<a id='advanceds_kruskals' />  

#### Kruskal's algorithm to find Minimum Spanning Tree (Undirected)

[Kruskal's algorithm](src/main/java/data/structure/graph/undirected/KruskalMST.java) is a simple algorithm, which first orders all the edges of the graph in the ascending order, then adds them to the MST,  by making sure that, edge to be added to the mst, does NOT form a cycle with already existing edges in MST. The check of determining cycle is performed using `UnionFind` data structure.

<a id='advanceds_directedcycle' />  

#### Cycle Detection (Directed)

[Cycle detection on the directed graph](src/main/java/data/structure/graph/directed/DirectedCycleDetection.java), is little bit more work compared to Cycle detection on undirected graph. The algorithm is achieved by doing DFS traversal and tracking the *recursive call stack*.

**Theory** - While doing DFS, If we ever find a directed edge `v -> w` to a vertex `w` that is on that stack, we have found a cycle, since the stack is evidence of a directed path from `w` to `v`, and the edge `v -> w` completes the cycle.

<a id='advanceds_dfsorder' />  

#### DFS Orders (Directed)

[DepthFirstOder](src/main/java/data/structure/graph/directed/DepthFirstOrder.java) - is the ways in which we record the visited vertices during DFS traversal on the directed graph. There are 3 ways in which we can record the encountered vertices.

**Pre** - In the DFS method, collect the current vertex in a `Queue`, at the beginning of the method - This records the vertices in the same order as they encounter during the DFS traversal.

**Post** - In the DFS method, collect the current vertex in a `Queue`, at the end of the method - This records the vertices in the manner of "Level Order Traversal" from the leaf node to the root node.

**Reverse Post** - In the DFS method, collect the current vertex in a `Stack`, at the end of the method - This records the vertices in *Topological Order*.

<a id='advanceds_topological_sort' />

#### Topological Sort (Directed)

[Topological Sort](src/main/java/data/structure/graph/directed/TopologicalSort.java) is the process of arranging the vertices of a directed graph in such a way that, for all `v` , `w` in the graph, if there exists a directed edge `v -> w`  ( `v` to `w`) then `v` will appear before `w` in the ordered arrangement. In other words, the Topological Order makes sure that, head vertex is always ahead of tail vertex, for all the head-tail edges. To find the order, the graph must **not** contain **Cycles** (The ordering only works on DAGs).  

<a id='advanceds_kosarajuscc' />

#### Strong Connectivity and Strongly Connected Components (SCC)    (Directed)

In a directed graph, two vertices `v` and `w` are said to be **strongly connected**, if there is a path from `v` to `w` in both the directions, directly or indirectly. A **Strongly connected component (SCC) ** of a graph is a subset of vertices with the graph, which have *strong connectivity* between them. Remember that in a graph having SCC's, there ought to be a Directed Cycle!

[KosarajuSCC algorithm](src/main/java/data/structure/graph/directed/KosarajuSCC.java) helps us to find the SCC within a given directed graph in 3 simple steps.

1. Calculate the **ReversePost** order of transpose `G(r)` of the given digraph `G` 
2. Iterate through the reverse oder and do the DFS
3. Increment the counter when one round of DFS ends. The vertices discovered during the round of DFS belong to a single SCC
	a. Continue the DFS discovery, until all the vertices ordered as per Step 1 exhausts.


<a id='advanceds_dijkstra' />  

#### Dijkstra's algorithm to find Shortest Path (Directed)

[Dijkstra's algorithm](src/main/java/data/structure/graph/directed/DijkstraSP.java) is an efficient algorithm, which finds shortest path from a **source** vertex, to all the verties it is connected to (directly / indirectly), by forming a Shortest Path Tree. It takes help of `IndexMinHeap` to get the next vertex to process (thus achieving the &Omicron; (E log V) ), along with a process called as **Edge Relaxation**.
