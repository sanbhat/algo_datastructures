# algo_datastructures
Repository which holds different implementation of famous data structures and algorithms. This repository is designed to be taken as a refernce, or to have a quick look at various implementations of algorithms and data structures. The short programs are categorized as below, with their documentation. 

**language** - 
	
	Java

**java version** - 

	java version "1.8.0_131"
	Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
	Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)

## Sorting (with Complexity)

Algorithm | Time Complexity Best | Time Complexity Average | Time Complexity Worst | Space Complexity | Is [Stable?](https://en.wikipedia.org/wiki/Sorting_algorithm#Stability)
--- | --- | --- | --- | --- | ---
[BubbleSort](src/algo/sort/BubbleSort.java) | &Omega; (n) | &Theta; (n^2) | &Omicron; (n^2) | &Omicron; (1) | Yes
[SelectionSort](src/algo/sort/SelectionSort.java) | &Omega; (n^2) | &Theta; (n^2) | &Omicron; (n^2) | &Omicron; (1) | No
[InsertionSort](src/algo/sort/InsertionSort.java) | &Omega; (n) | &Theta; (n^2) | &Omicron; (n^2) | &Omicron; (1)  | Yes
[ShellSort](src/algo/sort/ShellSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)^2) | &Omicron; (n log(n)^2) | &Omicron; (1) | No 
[MergeSort](src/algo/sort/MergeSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)) | &Omicron; (n log(n)) | &Omicron; (n)  | Yes
[QuickSort](src/algo/sort/QuickSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)) | &Omicron; (n^2)) | &Omicron; (log(n)) | No
[HeapSort](src/algo/sort/HeapSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)) | &Omicron; (n log(n)) | &Omicron; (1)  | No

## Data Structures

Data structures are a particular way of organizing the data in a computer, so that it can be accessed and modified efficiently.

### Basic Data Structures

#### Dynamic array
Dynamic array is an array based data-structure (insert - &Omicron;(1) and deleteAtIndex - &Omicron;(1)), which adjusts its size and rearranges the items (re-indexing), as and when data gets added or deleted. 

* [Dynamic Array / Vector ](src/data/structure/list/Vector.java)

#### Linked List 
Linked List is a special data structure of connected items, represented by a special structure called as `Node`. A `Node` structure stores the data as well as a link (or memory address) to the next `Node` item present in the sequence.

In singly linked list, `Node` will have a pointer to the `Node` present ahead of it in the sequence (`Node next;`). In doubly linked list, a `Node` will be connected to both *next* and *previous* `Node` in the sequence.

* [Singly LinkedList](src/data/structure/list/SinglyLinkedList.java)
* [Doubly LinkedList](src/data/structure/list/DoublyLinkedList.java)

#### Stack 
Stack is a popular data structure in which items inserted last will sit on top of the structure, pushing the previously inserted items to the bottom. It gives convenient methods to to check what is at the top of the structure (`peek()`)? and to **get** and **delete** the item on the top of the structure `pop()`, with a time complexity of - &Omicron;(1). It is also called as *LIFO* data-structure. Following are some different implementations of stack, backed by array, singly linked list and doubly linked list.

* [Array based Stack](src/data/structure/queue/Stack.java) 
* [Stack - backed by Singly LinkedList](src/data/structure/queue/StackSLL.java)
* [Stack - backed by Doubly LinkedList](src/data/structure/queue/StackDLL.java)

#### Heap
Heap is a tree based data structure, where each node follows the heap rule. Heaps can be of types - **Min** and **Max**. In **Min** heap, if a node within the tree is not a leaf node, then its *key* will always be less than its children. In this way the root of the tree will always be the item, with the least key among all the items present in the heap. **Max** heap is just the opposite, where the root node's *key* is the highest, and all non-leaf nodes will always be greater than their children.

* [Max Heap](src/data/structure/queue/MaxHeap.java) which extends [Heap](src/data/structure/queue/Heap.java)
* [Min Heap](src/data/structure/queue/MinHeap.java) which extends [Heap](src/data/structure/queue/Heap.java)


### Advanced Data Structures

#### Graphs

Graph is a data structure which represents the vertices (data) and the connection between the vertices. 

* A **dense** graph is a graph, where most of the vertices are connected with each other.  
* A **sparse** graph is a graph, where only some of the vertices are connected with other vertices.

In real world applications, sparse graphs are common than dense graphs.

There are two ways in which Graphs can be represented.

[Graph using Adjacency Matrix](src/data/structure/graph/GraphAM.java) - Here the connection between the vertices within the graph are represented in (`v * v`) boolean matrix, where `v` represents the number of vertices present in the graph. 

**Advantage** - `O(1)` access time to check if a particular vertex is connected to another vertex or not. 

**Disadvantage** - The space required to represent the graph is `v * v`, even though, not all vertices are connected.

**Usage** - Can be efficiently used to represent dense graphs.
  
[Graph using Adjacency List](src/data/structure/graph/GraphAL.java) - Here the graph is represented as array of vertices `v[]` and each array will have a Dynamic List pointing to the vertices it is connected to.

**Advantage** - Only `O(E)` space is required to represent a graph with `E` edges.

**Disadvantage** - The time complexity of finding out a connection between vertices is `O(E)`.

**Usage** - Can be efficiently used to represent sparse graphs
  
##### Graph Traversal

There are two ways in which the graph's vertices can be traversed for searching purpose. 

**Depth First Search** - In DFS, the child vertices of each vertex are visited first, until all the vertex are covered OR the leaf vertex is reached. Once the vertex has no more children, then backtracking is done and other children are visited / searched.

**Breadth First Search** - In BFS, first all the children of a vertex are visited one after the other, once finished, then children at the next level are visited.
  
   

#### Prim's algorithm to find Minimum Spanning Tree

**Spanning Tree** - Spanning tree of a graph is a sub-graph, where all the vertices of the graph are connected by edges without any cycle.

**Minimum Spanning Tree** - Is a spanning tree calculated from the *undirected weighted graph*, where the weight of the edges connecting the spanning tree is minimum.

[Prim's algorithm](src/data/structure/graph/LazyPrimMST.java) is a Greedy algorithm, which starts with a vertex to build a MST, and then keeps adding it more connections which have the least weight.




