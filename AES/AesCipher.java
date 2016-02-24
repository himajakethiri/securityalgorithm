/**
 * @author Himaja
 * @CWID 20062532
 * @Program produces 10 round keys by taking one input key
 */
public class AesCipher {
	// S_Box is a substitute box which is an array
	public static final String[][] S_Box = {
			{ "63", "7C", "77", "7B", "F2", "6B", "6F", "C5", "30", "01", "67",
					"2B", "FE", "D7", "AB", "76" },
			{ "CA", "82", "C9", "7D", "FA", "59", "47", "F0", "AD", "D4", "A2",
					"AF", "9C", "A4", "72", "C0" },
			{ "B7", "FD", "93", "26", "36", "3F", "F7", "CC", "34", "A5", "E5",
					"F1", "71", "D8", "31", "15" },
			{ "04", "C7", "23", "C3", "18", "96", "05", "9A", "07", "12", "80",
					"E2", "EB", "27", "B2", "75" },
			{ "09", "83", "2C", "1A", "1B", "6E", "5A", "A0", "52", "3B", "D6",
					"B3", "29", "E3", "2F", "84" },
			{ "53", "D1", "00", "ED", "20", "FC", "B1", "5B", "6A", "CB", "BE",
					"39", "4A", "4C", "58", "CF" },
			{ "D0", "EF", "AA", "FB", "43", "4D", "33", "85", "45", "F9", "02",
					"7F", "50", "3C", "9F", "A8" },
			{ "51", "A3", "40", "8F", "92", "9D", "38", "F5", "BC", "B6", "DA",
					"21", "10", "FF", "F3", "D2" },
			{ "CD", "0C", "13", "EC", "5F", "97", "44", "17", "C4", "A7", "7E",
					"3D", "64", "5D", "19", "73" },
			{ "60", "81", "4F", "DC", "22", "2A", "90", "88", "46", "EE", "B8",
					"14", "DE", "5E", "0B", "DB" },
			{ "E0", "32", "3A", "0A", "49", "06", "24", "5C", "C2", "D3", "AC",
					"62", "91", "95", "E4", "79" },
			{ "E7", "C8", "37", "6D", "8D", "D5", "4E", "A9", "6C", "56", "F4",
					"EA", "65", "7A", "AE", "08" },
			{ "BA", "78", "25", "2E", "1C", "A6", "B4", "C6", "E8", "DD", "74",
					"1F", "4B", "BD", "8B", "8A" },
			{ "70", "3E", "B5", "66", "48", "03", "F6", "0E", "61", "35", "57",
					"B9", "86", "C1", "1D", "9E" },
			{ "E1", "F8", "98", "11", "69", "D9", "8E", "94", "9B", "1E", "87",
					"E9", "CE", "55", "28", "DF" },
			{ "8C", "A1", "89", "0D", "BF", "E6", "42", "68", "41", "99", "2D",
					"0F", "B0", "54", "BB", "16" } };
	// Round_keys is to generate the keys
	public static final String[][] Round_Keys = {
			{ "8D", "01", "02", "04", "08", "10", "20", "40", "80", "1B", "36",
					"6C", "D8", "AB", "4D", "9A" },
			{ "2F", "5E", "BC", "63", "C6", "97", "35", "6A", "D4", "B3", "7D",
					"FA", "EF", "C5", "91", "39" },
			{ "72", "E4", "D3", "BD", "61", "C2", "9F", "25", "4A", "94", "33",
					"66", "CC", "83", "1D", "3A" },
			{ "74", "E8", "CB", "8D", "01", "02", "04", "08", "10", "20", "40",
					"80", "1B", "36", "6C", "D8" },
			{ "AB", "4D", "9A", "2F", "5E", "BC", "63", "C6", "97", "35", "6A",
					"D4", "B3", "7D", "FA", "EF" },
			{ "C5", "91", "39", "72", "E4", "D3", "BD", "61", "C2", "9F", "25",
					"4A", "94", "33", "66", "CC" },
			{ "83", "1D", "3A", "74", "E8", "CB", "8D", "01", "02", "04", "08",
					"10", "20", "40", "80", "1B" },
			{ "36", "6C", "D8", "AB", "4D", "9A", "2F", "5E", "BC", "63", "C6",
					"97", "35", "6A", "D4", "B3" },
			{ "7D", "FA", "EF", "C5", "91", "39", "72", "E4", "D3", "BD", "61",
					"C2", "9F", "25", "4A", "94" },
			{ "33", "66", "CC", "83", "1D", "3A", "74", "E8", "CB", "8D", "01",
					"02", "04", "08", "10", "20" },
			{ "40", "80", "1B", "36", "6C", "D8", "AB", "4D", "9A", "2F", "5E",
					"BC", "63", "C6", "97", "35" },
			{ "6A", "D4", "B3", "7D", "FA", "EF", "C5", "91", "39", "72", "E4",
					"D3", "BD", "61", "C2", "9F" },
			{ "25", "4A", "94", "33", "66", "CC", "83", "1D", "3A", "74", "E8",
					"CB", "8D", "01", "02", "04" },
			{ "08", "10", "20", "40", "80", "1B", "36", "6C", "D8", "AB", "4D",
					"9A", "2F", "5E", "BC", "63" },
			{ "C6", "97", "35", "6A", "D4", "B3", "7D", "FA", "EF", "C5", "91",
					"39", "72", "E4", "D3", "BD" },
			{ "61", "C2", "9F", "25", "4A", "94", "33", "66", "CC", "83", "1D",
					"3A", "74", "E8", "CB", "8D" } };
	// It will create two-dimensional array of keyMatrix[4][4]
	private final static String[][] keyMatrix = new String[4][4];
	// It will create two-dimensional array of WMatrix[4][44]
	private final static String[][] WMatrix = new String[4][44];

	/*
	 * Produces the matrix with 4*4 by taking KeyHex(128-bit) input
	 */
	public static void aesRoundKeys(String KeyHex) {
		int value = 0;
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				// Splits the key for every 2 values using subString() method.

				keyMatrix[i][j] = KeyHex.substring(value, value + 2);

				value += 2;
			}
		}
		getWMatrix();
		printKeys();
	}

	/*
	 * It will perform the XOR operation of hexadecimal values hex1 is first
	 * value and hex 2 is the second value hexResult is the result produced
	 * after XORing.
	 */

	private static String ComputeXOR(String hex1, String hex2) {
		int hexVal1 = Integer.parseInt(hex1, 16);
		int hexVal2 = Integer.parseInt(hex2, 16);
		int hexResult = hexVal1 ^ hexVal2;
		String hexXORResult = Integer.toHexString(hexResult);
		return hexXORResult.length() == 1 ? ("0" + hexXORResult) : hexXORResult;

	}

	/*
	 * Takes an input from S_Box using inHex based on firstInt and secondInt
	 */
	private static String aesSBox(String inHex) {
		Integer firstInt = Integer.parseInt(inHex.split("")[0], 16);
		Integer secondInt = Integer.parseInt(inHex.split("")[1], 16);
		return S_Box[firstInt][secondInt];

	}

	/*
	 * Takes the Rcon value using rounds
	 */
	private static String aesRcon(int round) {
		return Round_Keys[0][round / 4];

	}

	/*
	 * To perform operations on WMatrix to generate elements into array
	 */
	private static void getWMatrix() {
		// It will create the new matrix
		String W_New[][] = new String[1][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				WMatrix[i][j] = keyMatrix[i][j];
			}
		}
		for (int j = 4; j < 44; j++) {
			// If j value is not multiple of 4 then
			if (j % 4 != 0) {
				for (int i = 0; i < 4; i++) {
					WMatrix[i][j] = ComputeXOR(WMatrix[i][j - 4],
							WMatrix[i][j - 1]);
				}
			}

			else {
				// Performing left shift operation and transpose of matrix
				W_New[0][0] = aesSBox(WMatrix[1][j - 1]);
				W_New[0][1] = aesSBox(WMatrix[2][j - 1]);
				W_New[0][2] = aesSBox(WMatrix[3][j - 1]);
				W_New[0][3] = aesSBox(WMatrix[0][j - 1]);
				// XOR the Rcon_value with the new matrix
				String Rcon_Val = aesRcon(j);
				W_New[0][0] = ComputeXOR(Rcon_Val, W_New[0][0]);
				for (int i = 0; i < 4; i++) {
					WMatrix[i][j] = ComputeXOR(WMatrix[i][j - 4], W_New[0][i]);
				}

			}

		}

	}

	/*
	 * It will print the all round keys in 10 rounds
	 */
	public static void printKeys() {
		int Rounds_key = 1;
		int x = 0;
		while (Rounds_key <= 11) {
			for (int j = 1; j <= 4; j++, x++) {
				for (int i = 0; i <= 3; i++) {
					System.out.print(WMatrix[i][x].toUpperCase());
				}
			}
			System.out.println();
			Rounds_key++;
		}
		System.out.println("");

	}

}
