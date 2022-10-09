package BinarySearchTree.FiletoBST;

public class BSTree {
	// node class that defines BST node
	class Node {
		String name;
		Node leftChild;
		Node rightChild;

		Node(String name) {
			this.name = name;
		}

		public String toString() {
			return name;
		}
	}

	Node root;

	// add node to tree addNode time complexity of O(n)
	public void addNode(String name) {
		// initialize newly created node
		Node newNode = new Node(name);
		// self explanatory... if there is no root, newly created node becomes root
		if (root == null) {
			root = newNode;
		} else {
			// set root as node to start with
			Node focusNode = root;
			// future parent for new node
			Node parent;
			while (true) {
				// start at top parent
				parent = focusNode;
				// check if node should go on left side
				if (name.compareTo(focusNode.name) < 0) {
					// change focus to the left child
					focusNode = focusNode.leftChild;
					// if left node is empty
					if (focusNode == null) {
						// then place node on the left
						parent.leftChild = newNode;
						return;
					}
				}
				// at this point put node on the right
				else if (name.compareTo(focusNode.name) > 0) {
					// focus to the right side
					focusNode = focusNode.rightChild;
					// if right side is empty
					if (focusNode == null) {
						// place node to the right
						parent.rightChild = newNode;
						return;
					}
				} else {
					return;
				}
			}
		}
	}

	// visit nodes in ascending order from left to right
	public void inOrderTraverseTree(Node focusNode) {// time complexity of O(n) with n being the number of nodes in the
														// tree
		if (focusNode != null) {
			// left side
			inOrderTraverseTree(focusNode.leftChild);
			// current
			System.out.println(focusNode);
			// right side
			inOrderTraverseTree(focusNode.rightChild);
		}
	}

	
	public boolean remove(String name) {
		// start from the top
		Node focusNode = root;
		Node parent = root;

		boolean isALeftChild = true;

		while (!focusNode.name.equals(name)) {
			parent = focusNode;
			if (name.compareTo(focusNode.name) < 0) {
				isALeftChild = true;
				// focus left side
				focusNode = focusNode.leftChild;
			} else {
				isALeftChild = false;
				// focus right side
				focusNode = focusNode.rightChild;
			}
			// node not found
			if (focusNode == null)
				return false;
		}
		
		// if node is empty delete
		if (focusNode.leftChild == null && focusNode.rightChild == null) {
			// delete root
			if (focusNode == root) {
				root = null;
				// if left of the parent delete node
			} else if (isALeftChild) {
				parent.leftChild = null;
			} else {
				// same for right side
				parent.rightChild = null;
			} 
			
			// if no right child
		} else if (focusNode.rightChild == null) {
			if (focusNode == root)
				// if focus node was on left, move focus nodes to parent node
				root = focusNode.leftChild;
			else if (isALeftChild)
				// same for left
				parent.leftChild = focusNode.leftChild;
			else
				parent.rightChild = focusNode.leftChild;
			
			
				// if no left child
		} else if (focusNode.leftChild == null) {
			if (focusNode == root)
				root = focusNode.rightChild;
			// if focus node was on right, move focus nodes to parent node

			else if (isALeftChild)
				parent.leftChild = focusNode.rightChild;
			else
				parent.rightChild = focusNode.rightChild;
		} else {

			// deleted nodes replacement
			Node replacement = getReplacementNode(focusNode);
			// if focus is the root replace with replacement
			if (focusNode == root)
				root = replacement;
			else if (isALeftChild)
				// if deleted was left, make replacement left
				parent.leftChild = replacement;
			else
				// same for right
				parent.rightChild = replacement;

			replacement.leftChild = focusNode.leftChild;
		}
		return true;
	}

	
	// replacement for when a node is deleted
	private Node getReplacementNode(Node replacedNode) {
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;

		Node focusNode = replacedNode.rightChild;
		// no left children
		while (focusNode != null) {
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftChild;
		}
		// If the replacement isn't the right child
		// move the replacement into the parents
		// leftChild slot and move the replaced nodes
		// right child into the replacement rightChild
		if (replacement != replacedNode.rightChild) {
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		return replacement;
	}


	// searches for node by name
	public void findNode(String name) {
		// start at top
		Node focusNode = root;
		int count = 0;

		if (focusNode == null) {
			System.out.println("Inspected " + count + " elements" + "\n" + name + " was not located");
			return;
		}

		if (focusNode.name.equals(name)) {
			System.out.println("Inspected " + count + " elements" + "\n" + name + " located");
			return;
		}
		// if not found, continue looking
		while (!focusNode.name.equals(name)) {
			// search left
			if (name.compareTo(focusNode.name) < 0) {
				count++;
				focusNode = focusNode.leftChild;
				//
				if (focusNode == null) {
					System.out.println("Inspected " + count + " elements" + "\n" + name + " was not located");
					return;
				}

				// search right
				} else if (name.compareTo(focusNode.name) > 0) {
					count++;
					focusNode = focusNode.rightChild;
					//
					if (focusNode == null) {
						System.out.println("Inspected " + count + " elements" + "\n" + name + " was not located");
						return;
					}
				}
		}

		System.out.println("Inspected " + count + " elements" + "\n" + name + " located");
	}

}
