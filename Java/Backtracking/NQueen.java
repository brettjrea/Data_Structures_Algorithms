import java.util.ArrayList;
import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        System.out.print("Enter Number of Queens:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
      

        char[][] board = new char[size][size];
        for (int rowNo = 0; rowNo < size; rowNo++) {
            for (int colNo = 0; colNo < size; colNo++) {
                board[rowNo][colNo] = '.';
            }
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        NQueen(size, board, 0, ans);

        if (ans.size() == 0) {
            System.out.println("No solution!");
        } else {
            System.out.println(ans);
        }


    }

    public static void NQueen(int size, char[][] b, int colNo, ArrayList<ArrayList<String>> ans) {
        if (colNo == size) {
            ArrayList<String> al = new ArrayList<>();
            for (int rowNo = 0; rowNo < size; rowNo++) {
                char[] arr = b[rowNo];
                String s = new String(arr);
                al.add(s);
            }
            ans.add(al);
            return;
        }

        for (int rowNo = 0; rowNo < size; rowNo++) {

            if (isSafe(rowNo, colNo, b, size)) {

                b[rowNo][colNo] = 'Q';

                NQueen(size, b, colNo + 1, ans);

                b[rowNo][colNo] = '.';

            }
        }

        return;
    }

    public static boolean isSafe(int i, int j, char[][] b, int size) {

        for (int colNo = 0; colNo < j; colNo++) {
            if (b[i][colNo] == 'Q') {
                return false;
            }
        }
        int rowNo = i;
        int colNo = j;
        while (rowNo >= 0 && colNo >= 0) {
            if (b[rowNo][colNo] == 'Q') {
                return false;
            }
            rowNo--;
            colNo--;
        }
        colNo = j;
        rowNo = i;
        while (rowNo < size && colNo >= 0) {

            if (b[rowNo][colNo] == 'Q') {
                return false;
            }
            rowNo++;
            colNo--;
        }

        return true;

    }
}