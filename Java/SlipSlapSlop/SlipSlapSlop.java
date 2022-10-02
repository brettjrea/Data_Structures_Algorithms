package SlipSlapSlop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SlipSlapSlop {

    /**
     * A slip has the following rules
     * Its first character is either D of E
     * The first character is followed by a string of 1 or more F's
     * the string of F's is followed by another Slip (D or E) or a G
     * the Slip (D or E) or G that follows the string of F's ends the string.  Ex EFFFFG
     * Examples of Slips: DFG, EFG, DFFFFFG, DFDFDFDFG, DFEFFFFFG
     */
	public static boolean isSlip(String s, int index) {
		if (index == s.length())
			return false;
		if (index + 1 == s.length()) { // this is the last character.
			return s.charAt(index) == 'G';
		}
		// check if the first char is not either D or 'E'
		if (!(s.charAt(index) == 'D' || s.charAt(index) == 'E'))
			return false;
		index++;
		if (s.charAt(index) != 'F')
			return false;
		while (index < s.length() && s.charAt(index) == 'F') {
			index++;
		}
		return isSlip(s, index);

	}
	   /**
     * A slap has the following rules
     * its first character is an A
     * if it is a two character slap, then its second character is an H
     * if it is not a two character slap, then it is in one of these two forms:
     *      A followed by B followed by a Slap (AB, or AH) followed by a C
     *      A followed by a Slip followed by a C
     * Examples of Slaps: AH, ABAHC, ABABAHCC, ADFGC, ADFFFFGC, ABAEFGCC, ADFDFGC
     */
	public static boolean isSlap(String s, int index) {
		if (index == s.length())
			return false;
		if (s.length() == 2) {
			return (s.charAt(1) == 'H' && s.charAt(0) == 'A');
		}
		if (index + 1 == s.length()) {
			return (s.charAt(index) == 'C');
		}
		if (index + 2 == s.length()) {
			// last two characters
			return (s.charAt(index) == 'A' && s.charAt(index + 1) == 'E');
		}
		// choose a substring from index to excluding last index.
		index++;
		String slip = s.substring(index, s.length() - 1);
		boolean temp = isSlip(slip, 0) && (s.charAt(s.length() - 1) == 'C');
		String slap = s.substring(index + 1, s.length() - 1);
		temp = temp || (s.charAt(index) == 'B' && isSlap(slap, 0) && s.charAt(s.length() - 1) == 'C');
		return temp;

	}
	   /** A slop is a character string that contains a Slap followed by a Slip
     * Examples of Slops: AHDFG, ADFGCDFFFFFG, ABAEFGCCDFEFFFFFG
     */
	public static void isSlop(String s) {
		boolean temp = false;
		int index = -1;

		// get index of last character for slap string
		index = s.indexOf('C');
		if (index == -1) {
			index = s.indexOf('H');
		}

		if (index == -1) {
			temp = false;
		} else {
			System.out.println(s.substring(0, index + 1));
			System.out.println(s.substring(index + 1));

			// split string for slap or slip
			temp = isSlap(s.substring(0, index), 0) || isSlip(s.substring(index + 1), 0);
		}

		for (int i = 2; i < s.length() - 2; i++) {
			temp = temp || (isSlap(s.substring(0, i), 0) && isSlip(s.substring(i + 1), 0));
		}

		if (temp == true) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader buffReader = new BufferedReader(new FileReader("Java/SlipSlapSlop/sss.in"));
		int i = 0;
		@SuppressWarnings("unused")
		int N = 0;
		String line;
		System.out.println("SLOPS OUTPUT");

		// read line by line
		while ((line = buffReader.readLine()) != null) {

			// read first line and convert to integer
			if (i == 0) {
				N = Integer.parseInt(line);
			} else {

				// each string is slop or not
				isSlop(line);
			}
			i++;
		}
		buffReader.close();
		System.out.println("END OF OUTPUT");
	}

}