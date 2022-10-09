       Binary Search Tree.

        BST tree example
              45 
           /     \ 
          10      90 
         /  \    /  \ 
        7   12  50  100 

The data stored in a binary search tree is unique. It doesn’t allow duplicate values.

The nodes of the left subtree are less than the root node.

The nodes of the right subtree are greater than the root node.

The above is true recursively for all subtrees.

We can use Binary Search Trees to solve some continuous functions in mathematics. Searching of data in hierarchical structures becomes more efficient with Binary Search Trees. With every step, we reduce the search by half subtree.

Worst-case performance:  O(n)
Best-case performance:  O(1)
Average performance:  O(log n)
Worst-case space complexity:  O(1)

Searching: For searching element 1, we have to traverse all elements (in order 3, 2, 1). Therefore, searching in binary search tree has worst case complexity of O(n). In general, time complexity is O(h) where h is height of BST.

Insertion: For inserting element 0, it must be inserted as left child of 1. Therefore, we need to traverse all elements (in order 3, 2, 1) to insert 0 which has worst case complexity of O(n). In general, time complexity is O(h).

Deletion: For deletion of element 1, we have to traverse all elements to find 1 (in order 3, 2, 1). Therefore, deletion in binary tree has worst case complexity of O(n). In general, time complexity is O(h).

