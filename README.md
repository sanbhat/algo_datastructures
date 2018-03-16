# algo_datastructures
Repository which holds different implementation of famous data structures and algorithms. This repository is designed to be taken as a refernce, or to have a quick look at various implementations of algorithms and data structures. The short programs are categorized as below, with their documentation. 

## Sorting (with Complexity)

Algorithm | Time Complexity Best | Time Complexity Average | Time Complexity Worst | Space Complexity
--- | --- | --- | --- | ---
[BubbleSort](src/algo/sort/BubbleSort.java) | &Omega; (n) | &Theta; (n^2) | &Omicron; (n^2) | &Omicron; (1)
[SelectionSort](src/algo/sort/SelectionSort.java) | &Omega; (n^2) | &Theta; (n^2) | &Omicron; (n^2) | &Omicron; (1)
[InsertionSort](src/algo/sort/InsertionSort.java) | &Omega; (n) | &Theta; (n^2) | &Omicron; (n^2) | &Omicron; (1) 
[ShellSort](src/algo/sort/ShellSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)^2) | &Omicron; (n log(n)^2) | &Omicron; (1) 
[MergeSort](src/algo/sort/MergeSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)) | &Omicron; (n log(n)) | &Omicron; (n) 
[QuickSort](src/algo/sort/QuickSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)) | &Omicron; (n^2)) | &Omicron; ( log(n) )
[HeapSort](src/algo/sort/HeapSort.java) | &Omega; (n log(n)) | &Theta; (n log(n)) | &Omicron; ( n log(n)) | &Omicron; ( 1 )

## Data Structures

#### Array, List, Dynamic array
* [Dynamic Array / Vector ](src/data/structure/list/Vector.java)
* [Singly LinkedList](src/data/structure/list/SinglyLinkedList.java)
* [Doubly LinkedList](src/data/structure/list/DoublyLinkedList.java)

#### Stack / Queue / Heap
* [Array based Stack](src/data/structure/queue/Stack.java)
* [Stack - backed by Singly LinkedList](src/data/structure/queue/StackSLL.java)
* [Stack - backed by Doubly LinkedList](src/data/structure/queue/StackDLL.java)
* [Max Heap](src/data/structure/queue/MaxHeap.java) which extends [Heap](src/data/structure/queue/Heap.java)
* [Min Heap](src/data/structure/queue/MinHeap.java) which extends [Heap](src/data/structure/queue/Heap.java)





