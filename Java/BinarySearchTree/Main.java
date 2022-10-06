package BinarySearchTree;

class BST_class { 
    //node class that defines BST node
    class Node { 
        int key; 
        Node left, right; 
   
        public Node(int data){ 
            key = data; 
            left = right = null; 
        } 
    } 

    
    // BST root node 
    Node root; 
  
   // Constructor for BST =>initial empty tree
    BST_class(){ 
        root = null; 
    } 
    // insert a node in BST 
    void insert(int key)  { 
        root = insert_Recursive(root, key); 
    } 
   
    //recursive insert function
    Node insert_Recursive(Node root, int key) { 
          //tree is empty
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key); 
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key); 
          // return pointer
        return root; 
    } 
    //delete a node from BST
    void deleteKey(int key) { 
        root = delete_Recursive(root, key); 
    } 
   
    //recursive delete function
    Node delete_Recursive(Node root, int key)  { 
        //tree is empty
        if (root == null)  return root; 
   
        //traverse the tree
        if (key < root.key)     //traverse left subtree 
            root.left = delete_Recursive(root.left, key); 
        else if (key > root.key)  //traverse right subtree
            root.right = delete_Recursive(root.right, key); 
        else  { 
            // node contains only one child
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
   
            // node has two children; 
            //get inorder successor (min value in the right subtree) 
            root.key = minValue(root.right); 
   
            // Delete the inorder successor 
            root.right = delete_Recursive(root.right, root.key); 
        } 
        return root; 
    } 
   
    int minValue(Node root)  { 
        //initially minval = root
        int minval = root.key; 
        //find minval
        while (root.left != null)  { 
            minval = root.left.key; 
            root = root.left; 
        } 
        return minval; 
    } 
 
    // method for inorder traversal of BST 
    void inOrder() { 
        inOrder_Recursive(root); 
    } 
   
    // recursively traverse the BST  
    void inOrder_Recursive(Node root)  { 
        if (root == null) 
            return; 
        //first traverse left subtree recursively
        inOrder_Recursive(root.left); 
   
        //then go for root node
        System.out.print(root.key + " "); 
   
        //next traverse right subtree recursively
        inOrder_Recursive(root.right); 
    } 

    void preOrder(){
        preOrder_Recursive(root);
    }
    void preOrder_Recursive(Node root)  { 
        if (root == null) 
            return; 
   
        //first print root node first
        System.out.print(root.key + " "); 
        // then traverse left subtree recursively
        preOrder_Recursive(root.left); 
        // next traverse right subtree recursively
        preOrder_Recursive(root.right); 
    } 

    void postOrder(){
        postOrder_Recursive(root);
    }
    void postOrder_Recursive(Node root)  { 
        if (root == null) 
            return; 
   
        // first traverse left subtree recursively 
        postOrder_Recursive(root.left); 
   
        // then traverse right subtree recursively 
        postOrder_Recursive(root.right); 
   
        // now process root node 
        System.out.print(root.key + " "); 
    }   
     
    boolean search(int key)  { 
        root = search_Recursive(root, key); 
        if (root!= null)
            return true;
        else
            return false;
    } 
   
    //recursive insert function
    Node search_Recursive(Node root, int key)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.key==key) 
            return root; 
        // val is greater than root's key 
        if (root.key > key) 
            return search_Recursive(root.left, key); 
        // val is less than root's key 
        return search_Recursive(root.right, key); 
    } 
}
class Main{
    public static void main(String[] args)  { 
       //create a BST object
        BST_class bst = new BST_class(); 
        /* BST tree example
              45 
           /     \ 
          10      90 
         /  \    /   
        7   12  50   */
        //insert data into BST
        bst.insert(45); 
        bst.insert(10); 
        bst.insert(7); 
        bst.insert(12); 
        bst.insert(90); 
        bst.insert(50);             
        //InOrder Traversal
        System.out.println("\nBST => InOrder Traversal:"); 
        bst.inOrder();
        //PreOrder Traversal
        System.out.println("\n\nBST => PreOrder Traversal:"); 
        bst.preOrder(); 
        //PostOrder Traversal
        System.out.println("\n\nBST => PostOrder Traversal:"); 
        bst.postOrder();         
        //delete leaf node  
        System.out.println("\n\nThe BST after Delete 12(leaf node):"); 
        bst.deleteKey(12); 
        bst.inOrder(); 
        //delete the node with one child
        System.out.println("\n\nThe BST after Delete 90 (node with 1 child):"); 
        bst.deleteKey(90); 
        bst.inOrder();                  
        //delete node with two children  
        System.out.println("\n\nThe BST after Delete 45 (Node with two children):"); 
        bst.deleteKey(45); 
        bst.inOrder(); 
        //InOrder Traversal
        System.out.println("\n\nBST => InOrder Traversal:"); 
        bst.inOrder();      
        //PreOrder Traversal
        System.out.println("\n\nBST => PreOrder Traversal:"); 
        bst.preOrder(); 
        System.out.println("\n\nBST => PostOrder Traversal:"); 
        bst.postOrder(); 
        //search a key in the BST
        boolean ret_val = bst.search (50);
        System.out.println("\n\nIs key 50 found in BST:" + ret_val );
        ret_val = bst.search (12);
        System.out.println("\nIs key 12 found in BST:" + ret_val );
     } 
}