package BinarySearchTree.FiletoBST;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		BSTree bSTree = new BSTree();
		Common common = new Common();

		ArrayList<String> inputArray = common.splitString("Java/BinarySearchTree/FiletoBST/input.in");

		System.out.println("\n");
		System.out.println(inputArray.toString());

		for (int i = 0; i <= inputArray.size() - 1; i++) {
			bSTree.addNode(inputArray.get(i));
		}

		System.out.println("\n");

		bSTree.inOrderTraverseTree(bSTree.root);
		System.out.println("\n");
		// scanner for user input
		try (Scanner scanner = new Scanner(System.in)) {

			do {

				System.out.println("Enter string, enter -1 to quit: ");
				String input = scanner.nextLine();
				if (input.equals("-1")) {

					break;
				}

				bSTree.findNode(input);
			} while (true);

			System.out.println("Enter string to remove: ");

			do {

				System.out.println("Enter string to remove, enter -1 to quit: ");
				String removedString = scanner.nextLine();
				if (removedString.equals("-1")) {

					break;

				}

				boolean isRemoved = bSTree.remove(removedString);
				if (isRemoved) {

					bSTree.inOrderTraverseTree(bSTree.root);
				} else {

					System.out.println(removedString + " not found, nothing removed.");
					bSTree.inOrderTraverseTree(bSTree.root);

				}

			} while (true);
		}
	}
}