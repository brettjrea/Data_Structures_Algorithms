package HashTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // uses common script that was made to read text from file
    public static void main(String[] args) throws IOException {
        Common common = new Common();
        ArrayList<String> inputList = common.splitString("Java/HashTable/input.txt");
        HashTable hashtable = new HashTable();

        for (int i = 0; i < inputList.size(); i++) {
            Random rand = new Random();
            hashtable.put(inputList.get(i), rand.nextInt(1000));
        }
        // scanner that scans from user input
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter search criteria, enter -1 to quit: ");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                break;
            }
            if (hashtable.findObject(input) == null) {
                System.out.println("No items found.  Result returned with 0 elements searched");
            }
        } while (true);
    }
}