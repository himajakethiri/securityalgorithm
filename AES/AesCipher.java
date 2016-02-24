public class AesCipher {

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
	private final static String[][] keyMatrix = new String[4][4];
	private final static String[][] WMatrix = new String[4][44];

	public static void aesRoundKeys(String KeyHex) {
		int value = 0;
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				keyMatrix[i][j] = KeyHex.substring(value, value + 2);

				System.out.println(keyMatrix[i][j]);
				value += 2;

			}

		}
		getWMatrix();
		printKeys();
	}

	// XORing the values
	private static String ComputeXOR(String hex1, String hex2) {
		int hexVal1 = Integer.parseInt(hex1, 16);
		int hexVal2 = Integer.parseInt(hex2, 16);
		int hexResult = hexVal1 ^ hexVal2;
		String hexXORResult = Integer.toHexString(hexResult);
		return hexXORResult.length() == 1 ? ("0" + hexXORResult) : hexXORResult;

	}

	// aesSBox
	private static String aesSBox(String inHex) {
		Integer firstInt = Integer.parseInt(inHex.split("")[0], 16);
		Integer secondInt = Integer.parseInt(inHex.split("")[1], 16);
		return S_Box[firstInt][secondInt];

	}

	// aesRon
	private static String aesRcon(int round) {
		return Round_Keys[0][round / 4];

	}

	// 3.a and 3.b
	private static void getWMatrix() {
		String W_New[][] = new String[1][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				WMatrix[i][j] = keyMatrix[i][j];
			}
		}
		for (int j = 4; j < 44; j++) {
			if (j % 4 != 0) {
				for (int i = 0; i < 4; i++) {
					WMatrix[i][j] = ComputeXOR(WMatrix[i][j - 4],
							WMatrix[i][j - 1]);
				}
			}

			else {
				W_New[0][0] = aesSBox(WMatrix[1][j - 1]);
				W_New[0][1] = aesSBox(WMatrix[2][j - 1]);
				W_New[0][2] = aesSBox(WMatrix[3][j - 1]);
				W_New[0][3] = aesSBox(WMatrix[0][j - 1]);

				String Rcon_Val = aesRcon(j);
				W_New[0][0] = ComputeXOR(Rcon_Val, W_New[0][0]);
				for (int i = 0; i < 4; i++) {
					WMatrix[i][j] = ComputeXOR(WMatrix[i][j - 4], W_New[0][i]);
				}

			}

		}

	}

	public static void printKeys() {
		String Round_key = "";
		
		for(int j=0;j<44;j++){
			for(int i=0;i<4;i++){
				int rounds=0;
				if(rounds==11){
				Round_key=Round_key+WMatrix[i][j];
				rounds++;
			}
				else
				{
					System.out.println(Round_key);
					rounds=0;
				}
					
			
		
//		int count = 0;
//		int b = 0;
//		int numberOfRounds =11;
//		while (count < numberOfRounds) {
//			for (int j = 0; j < 4; b++, j++) {
//				for (int a = 0; a < 4; a++) {
//					System.out.print(WMatrix[a][b]);
//				}
//			}
//			System.out.println("");
//			count++;
		}
		
		

	}
}
}