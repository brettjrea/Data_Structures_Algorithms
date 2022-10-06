package TreeTraversal;
//https://pencilprogrammer.com/algorithms/inorder-preorder-postorder/#:~:text=In-order%2C%20pre-order%2C%20and%20post-order%20are%20three%20forms%20of,other%20in%20context%20of%20depth-first%20traversal.%20Inorder%20Traversal

class Node{
    int value;
    Node left;
    Node right;
   
    //Constructor to initialize value to node
    Node(int value){
      this.value = value;
      left = right = null;
    }
   
    //Function to insert data i.e to form binary tree
    public void insert(int v){
   
      if(v < value){
        if(left == null){
          left = new Node(v);
        } else {
          left.insert(v);
        }
      } else {
        if(right == null){
          right = new Node(v);
        } else{
          right.insert(v);
        }
      }
    }
   
    //Function to perform Pre-Order Traversal
    public void preOrder(){
      //1. Root
      System.out.print(value+" ");
   
      //2. Left subtree
      if(left != null){
        left.preOrder();
      }
   
      //3. Right subtree
      if(right != null){
        right.preOrder();
      }
    }
   
    //Function to perform Post-Order Traversal
    public void postOrder(){
   
      //1. Left subtree
      if(left != null){
        left.postOrder();
      }
   
      //2. Right subtree 
      if(right != null){
        right.postOrder();
      }
   
      //3. Root
      System.out.print(value+" ");
    }
   
    //Function to perform In-Order Traversal
    public void inOrder(){
   
      //1. Left subtree
      if(left != null){
        left.inOrder();
      }
   
      //2. Root
      System.out.print(value+" ");
   
      //3. Right subtree 
      if(right != null){
        right.inOrder();
      }
    }
  }
   
  class Main {
    public static void main(String[] args) {
      Node root = new Node(25);
   
      root.insert(20);
      root.insert(31);
      root.insert(19);
      root.insert(23);
      root.insert(26);
      root.insert(36);
   
      System.out.print("\n Inorder: ");
      root.inOrder();
   
      System.out.print("\n Preorder: ");
      root.preOrder();
      
      System.out.print("\n Postorder: ");
      root.postOrder();

      System.out.print("\n\n");
    }
  }