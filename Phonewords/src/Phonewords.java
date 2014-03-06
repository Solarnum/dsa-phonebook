import java.util.ArrayList;
import java.util.Arrays;

public class Phonewords {
	/*
	 * I was thinking there might be a way to do this problem without using any
	 * ArrayLists or anything. Basically just for loops for each number that
	 * would be like
	 * 
	 * for i->0 to DigitArray[0].length-1
	 * 
	 * It's probably doable and probably would cut the time down by a little
	 * bit. But its probably not worth it. I'm up way too late right now :|
	 */
	private static char[][] DigitArray = { { '0' }, { '1' }, { 'A', 'B', 'C' },
			{ 'D', 'E', 'F' }, { 'G', 'H', 'I' }, { 'J', 'K', 'L' },
			{ 'M', 'N', 'O' }, { 'P', 'Q', 'R', 'S' }, { 'T', 'U', 'V' },
			{ 'W', 'X', 'Y', 'Z' } };
	
	private static int count = 1;

	public static void main(String args[]) {
		ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();

		if (args != null && args.length > 0) {
			String number = args[0];
			String version = "2";

			if(args.length > 1 && args[1].length() == 1)
			{
				version = args[1];
			}
			
			switch(version){
			case "1":
				for (int i = 0; i < number.length(); i++) {
					list.add(getCharList(number.charAt(i)));
				}
				System.out.println("Number of Combinations for " + number + ": "
				+ getComboAmt(list));
				System.out
				.println("=================================================");
				displayCombos(list, "", 0);
				break;
			case "3":
				System.out.println("Number of Combinations for " + number + ": "
						+ getComboAmt_v2(number));
				System.out
				.println("=================================================");
				displayCombos_v3(number);
				break;
			default:
			case "2":
				System.out.println("Number of Combinations for " + number + ": "
						+ getComboAmt_v2(number));
				System.out
				.println("=================================================");
				displayCombos_v2(number, "", 0);
				break;
			}
		} else {
			System.out.println("Error: No arguments were passed in");
		}
	}

	private static ArrayList<Character> getCharList(char c) {
		ArrayList<Character> list = new ArrayList<Character>();

		switch (c) {
		case '0':
			// list = new ArrayList<Character>(Arrays.asList('0'));
			list = new ArrayList<Character>('0');
			break;
		case '1':
			list = new ArrayList<Character>(Arrays.asList('1'));
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

	private static int getIntegerValue(String str) {
		int num = 0;
		try {
			num = Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;
	}

	private static int getComboAmt(ArrayList<ArrayList<Character>> list) {
		int combos = 1;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).size() > 0)
				combos *= list.get(i).size();
		}

		return combos;
	}

	// Recursive algorithm using ArrayList
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

	private static int getComboAmt_v2(String str) {
		int combos = 1;

		for (int i = 0; i < str.length(); i++) {
			int index = getIntegerValue(str.substring(i, i + 1));
			if (DigitArray[index].length > 0)
				combos *= DigitArray[index].length;
		}

		return combos;
	}

	// Recursive algorithm without using ArrayList
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

	// Alternative algorithm without using recursion
	private static void displayCombos_v3(String str) {
		int index = getIntegerValue("" + str.charAt(str.length() - 1));
		int passes = getComboAmt_v2(str) / DigitArray[index].length;
		int[] arrayLastPos = getArrayLastPos(str);
		int pos = str.length() - 2;

		for (int i = 0; i < passes; i++) {
			try {
				String base = buildBase(str, arrayLastPos);
				System.out.println(count + ": " + base + DigitArray[index][0]);
				count++;
				System.out.println(count + ": " + base + DigitArray[index][1]);
				count++;
				System.out.println(count + ": " + base + DigitArray[index][2]);
				count++;
				System.out.println(count + ": " + base + DigitArray[index][3]);
				count++;
			} catch (Exception e) {
				// e.printStackTrace();
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

	private static int[] getArrayLastPos(String str) {
		int[] arraySizes = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			int index = getIntegerValue(str.substring(i, i + 1));
			arraySizes[i] = DigitArray[index].length - 1;
		}

		return arraySizes;
	}

	private static String buildBase(String str, int[] arrayPos) {
		String base = "";

		for (int i = 0; i < str.length() - 1; i++) {
			int val = getIntegerValue("" + str.charAt(i));
			base += DigitArray[val][arrayPos[i]];
		}

		return base;
	}
}
