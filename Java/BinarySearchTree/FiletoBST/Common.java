package BinarySearchTree.FiletoBST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Common {

	public Common() {

	}

	public String[] readLines(String filename) throws IOException {
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
		}
		bufferedReader.close();
		return lines.toArray(new String[lines.size()]);
	}

	public ArrayList<String> splitString(String filename) throws IOException {
		ArrayList<String> inputArray = new ArrayList<>();
		Scanner input = new Scanner(new FileReader(filename));
		String str;

		while (input.hasNext()) {
			str = input.next();
			str = stringCleanUp(str);
			inputArray.add(str);
		}
		input.close();
		return inputArray;
	}

	public <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
		ArrayList<T> newList = new ArrayList<T>();
		for (T element : list) {
			if (!newList.contains(element)) {
				newList.add(element);
			}
		}
		return newList;
	}

	public String stringCleanUp(String string) {

		return string.toLowerCase().replaceAll("^[^a-z]+|[^a-z]+$", "");
	}

}