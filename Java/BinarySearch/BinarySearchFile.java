package BinarySearch;
// BinarySearchFile.java : Java program to read words from file and search strings using binary search

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchFile {                                                

    // method to sort the array of Strings by size in ascending order using
    // selection sort
    public static void sort(String[] words, int size) {              //Big O (n^2)
        int min;
        // loop over the array from index 0 to second last index
        for (int i = 0; i < size - 1; i++) {
            min = i;
            // loop to get the ith minimum string from index i+1 to end
            for (int j = i + 1; j < size; j++) {
                if (words[j].compareTo(words[min]) < 0)
                    min = j;
            }

            if (min != i) // index i and min are not equal, swap the strings at index i and min
            {
                String temp = words[i];
                words[i] = words[min];
                words[min] = temp;
            }
        }
    }

    public static void bubbleSort(String[] words, int size) {                  //Big O (n^2)
        String temp;

        // Sorting strings using bubble sort
        for (int j = 0; j < size - 1; j++) {
            for (int i = j + 1; i < size; i++) {
                if (words[j].compareTo(words[i]) > 0) {
                    temp = words[j];
                    words[j] = words[i];
                    words[i] = temp;
                }
            }
        }
    }

    // method to search for a string key in array words using binary search
    public static int binarySearch(String[] words, String key, int size) {        // Big O(Log N)
        int low = 0, high = size - 1; // initialize low and high to first and last index of array words
        int mid;
        // loop that continues until range is invalid or key is found
        while (low <= high) {
            mid = (low + high) / 2; // get the middle index of range
            if (words[mid].equals(key)) // key found
                return mid;
            else if (words[mid].compareTo(key) > 0) // string at mid > key, find the key in left subarray
                high = mid - 1;
            else // string at mid < key, find the key in right subarray
                low = mid + 1;
        }

        return -1; // key not found
    }

    public static void main(String[] args) {

        // create an array of 10,000 strings
        String[] words = new String[10000];
        int nWords = 0;
        String word;
        File file = new File("Java/BinarySearch/text.txt"); // create a File object

        try {
            // open the input file
            Scanner fileScan = new Scanner(file);
            // loop that continues until end of file is reached or 10,000 words have been
            // read
            while (fileScan.hasNext() && nWords < words.length) {
                word = fileScan.next(); // read the next word from file
                if (word.length() > 0) // word is not an empty string
                {
                    words[nWords] = word; // store it at index nWords
                    nWords++; // increment number of words
                }
            }
            fileScan.close(); // close the file

            /* Display unsorted array. */
            System.out.println("Unsorted list:");
            System.out.println(" ");
            for (int i = 0; i < nWords; i++) {
                System.out.print(words[i] + " ");
            }
            System.out.println();
            System.out.println(" ");

            /* sort the words in ascending order */
            // sort(words, nWords);

            bubbleSort(words, nWords);

            /* Display sorted array. */
            System.out.println("Sorted list:");
            System.out.println(" ");
            for (int i = 0; i < nWords; i++) {
                System.out.print(words[i] + " ");
            }
            System.out.println();
            System.out.println(" ");

            Scanner scan = new Scanner(System.in);

            // loop that continues to search for string until the user exits
            do {
                System.out.print("Enter a word to search(0 to exit): ");
                word = scan.next(); // input a word to search
                if (!word.equals("0")) // check if user wants to exit
                {
                    int index = binarySearch(words, word, nWords); // get the index of word using binarySearch method
                    if (index == -1) // word not found
                        System.out.println(word + " not found.");
                    else // word found
                        System.out.println(word + " found at index: " + index);
                }
            } while (!word.equals("0"));
            scan.close(); // close the file

        } catch (FileNotFoundException e) {
            System.err.println("Unable to open file: text.txt");
        }
    }
}
