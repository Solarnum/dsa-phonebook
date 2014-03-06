/**
 * COSC3100 Spring 2014 Homework 4
 * 
 * Created : Feb. 27, 2014 
 * Last Updated : March 6, 2014 
 * Purpose: Find and print all the phoneword combinations of an inputted number string.
 * 
 * @author Mark Schlottke & Charlie Beckwith
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Phonewords {
	private static char[][] DigitArray = { { '0' }, { '1' }, { 'A', 'B', 'C' },
			{ 'D', 'E', 'F' }, { 'G', 'H', 'I' }, { 'J', 'K', 'L' },
			{ 'M', 'N', 'O' }, { 'P', 'Q', 'R', 'S' }, { 'T', 'U', 'V' },
			{ 'W', 'X', 'Y', 'Z' } };

	private static int count = 1;

	/**
	 * Main entry point to the application.
	 * The first argument is required and is the number string used to find the combinations
	 * The second argument is not required and is used to choose which algorithm to run
	 * @param args
	 */
	public static void main(String args[]) {
		ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();

		if (args != null && args.length > 0) {
			String number = args[0];
			String version = "2";

			if (args.length > 1 && args[1].length() == 1) {
				version = args[1];
			}

			// Determines and prints out the combinations using the algorithm version chosen
			// Defaults to version 2 if no version is specified or the version is invalid
			switch (version) {
			case "1":
				for (int i = 0; i < number.length(); i++) {
					list.add(getCharList(number.charAt(i)));
				}
				System.out.println("Number of Combinations for " + number
						+ ": " + getComboAmt(list));
				System.out
						.println("=================================================");
				displayCombos(list, "", 0);
				break;
			case "3":
				System.out.println("Number of Combinations for " + number
						+ ": " + getComboAmt_v2(number));
				System.out
						.println("=================================================");
				displayCombos_v3(number);
				break;
			default:
			case "2":
				System.out.println("Number of Combinations for " + number
						+ ": " + getComboAmt_v2(number));
				System.out
						.println("=================================================");
				displayCombos_v2(number, "", 0);
				break;
			}
		} else {
			System.out.println("Error: No arguments were passed in");
		}
	}

	/**
	 * Builds the ArrayLists for the version 1 algorithm
	 * @param c - char that determines which ArrayList to add
	 * @return - the ArrayList for the input char
	 */
	private static ArrayList<Character> getCharList(char c) {
		ArrayList<Character> list = new ArrayList<Character>();

		switch (c) {
		case '0':
			list = new ArrayList<Character>('0');
			break;
		case '1':
			list = new ArrayList<Character>('1');
			break;
		case '2':
			list = new ArrayList<Character>(Arrays.asList('A', 'B', 'C'));
			break;
		case '3':
			list = new ArrayList<Character>(Arrays.asList('D', 'E', 'F'));
			break;
		case '4':
			list = new ArrayList<Character>(Arrays.asList('G', 'H', 'I'));
			break;
		case '5':
			list = new ArrayList<Character>(Arrays.asList('J', 'K', 'L'));
			break;
		case '6':
			list = new ArrayList<Character>(Arrays.asList('M', 'N', 'O'));
			break;
		case '7':
			list = new ArrayList<Character>(Arrays.asList('P', 'Q', 'R', 'S'));
			break;
		case '8':
			list = new ArrayList<Character>(Arrays.asList('T', 'U', 'V'));
			break;
		case '9':
			list = new ArrayList<Character>(Arrays.asList('W', 'X', 'Y', 'Z'));
			break;
		}

		return list;
	}

	/**
	 * Gets the integer value of the string passed in
	 * Used to check exceptions in a known place
	 * @param str - number string to convert to an integer
	 * @return - the integer value of the string
	 */
	private static int getIntegerValue(String str) {
		int num = 0;
		try {
			num = Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;
	}

	/**
	 * Gets the amount of combinations the phone number string has
	 * Used for algorithm version 1
	 * @param list - the ArrayList of the ArrayLists of char sets
	 * @return - the integer value of combinations
	 */
	private static int getComboAmt(ArrayList<ArrayList<Character>> list) {
		int combos = 1;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).size() > 0)
				combos *= list.get(i).size();
		}

		return combos;
	}

	/**
	 * A recursive algorithm that determines and prints the phoneword combinations
	 * using ArrayLists
	 * @param list - ArrayList of the ArrayList of chars
	 * @param base - the output string 
	 * @param pos - current position in the list
	 */
	private static void displayCombos(ArrayList<ArrayList<Character>> list,
			String base, int pos) {
		ArrayList<Character> cList = list.get(pos);

		for (int i = 0; i < cList.size(); i++) {
			if (pos + 1 < list.size()) {
				if (pos + 1 < base.length()) {
					base += cList.get(i);
				} else {
					base = base.substring(0, pos) + cList.get(i);
				}
			} else {
				System.out.print(count + ": " + base + cList.get(i) + "\n");
				count++;
			}

			if (pos + 1 < list.size()) {
				displayCombos(list, base, pos + 1);
			}
		}
	}

	/**
	 * Gets the amount of combinations the phone number string has
	 * Used for algorithm versions 2 and 3
	 * @param str - the phone number string 
	 * @return - the integer value of combinations
	 */
	private static int getComboAmt_v2(String str) {
		int combos = 1;

		for (int i = 0; i < str.length(); i++) {
			int index = getIntegerValue(str.substring(i, i + 1));
			if (DigitArray[index].length > 0)
				combos *= DigitArray[index].length;
		}

		return combos;
	}

	/**
	 * A recursive algorithm that determines and prints the phoneword combinations
	 * referencing a 2D array for the char arrays
	 * @param str - the phone number string
	 * @param base - the output string
	 * @param pos - current position in the phone number string
	 */
	private static void displayCombos_v2(String str, String base, int pos) {
		int index = getIntegerValue(str.substring(pos, pos + 1));

		for (int i = 0; i < DigitArray[index].length; i++) {
			if (pos + 1 < str.length()) {
				if (pos + 1 < base.length()) {
					base += DigitArray[index][i];
				} else {
					base = base.substring(0, pos) + DigitArray[index][i];
				}
			} else {
				System.out.print(count + ": " + base + DigitArray[index][i]
						+ "\n");
				count++;
			}

			if (pos + 1 < str.length()) {
				displayCombos_v2(str, base, pos + 1);
			}
		}
	}
	
	/**
	 * A non-recursive algorithm that determines and prints the phoneword combinations
	 * referencing a 2D array for the char arrays
	 * @param str -  the phone numbers string
	 */
	private static void displayCombos_v3(String str) {
		int index = getIntegerValue("" + str.charAt(str.length() - 1));
		int passes = getComboAmt_v2(str) / DigitArray[index].length;
		int[] arrayLastPos = getArrayLastPos(str);
		int pos = str.length() - 2;

		for (int i = 0; i < passes; i++) {
			String base = buildBase(str, arrayLastPos);

			switch (DigitArray[index].length) {
			case 4:
				System.out.println(count + ": " + base + DigitArray[index][3]);
				count++;
			case 3:
				System.out.println(count + ": " + base + DigitArray[index][2]);
				count++;
			case 2:
				System.out.println(count + ": " + base + DigitArray[index][1]);
				count++;
			case 1:
				System.out.println(count + ": " + base + DigitArray[index][0]);
				count++;
				break;
			}

			if (pos > 0 && arrayLastPos[pos] > 0) {
				arrayLastPos[pos] -= 1;
			} else {
				while (pos > 0 && arrayLastPos[pos] == 0) {
					arrayLastPos[pos] = DigitArray[getIntegerValue(""
							+ str.charAt(pos))].length - 1;

					pos -= 1;
				}

				arrayLastPos[pos] -= 1;

				pos = str.length() - 2;
			}
		}
	}

	/**
	 * Gets an integer array containing the last index for each array of chars
	 * in order of the phone number string
	 * @param str - the phone number string
	 * @return - integer array containing the last indexes
	 */
	private static int[] getArrayLastPos(String str) {
		int[] arraySizes = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			int index = getIntegerValue(str.substring(i, i + 1));
			arraySizes[i] = DigitArray[index].length - 1;
		}

		return arraySizes;
	}

	/**
	 * Builds the base string without the final character using the indexes for
	 * each array provided in the arrayPos array
	 * @param str - the phone number string
	 * @param arrayPos - an array containing the indexes for each char array
	 * @return - a concatenated string
	 */
	private static String buildBase(String str, int[] arrayPos) {
		String base = "";

		for (int i = 0; i < str.length() - 1; i++) {
			int val = getIntegerValue("" + str.charAt(i));
			base += DigitArray[val][arrayPos[i]];
		}

		return base;
	}
}
