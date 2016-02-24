import java.util.Scanner;

/*
 * It will take input key from the command line 
 * 
 */
public class Driver {
	public static void main(String[] args) {
		// Takes input from user
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		// Checks whether the input key matches with the regular expression
		if (key.matches("[0-9a-fA-F]{32}")) {

			AesCipher.aesRoundKeys(key);

		} else

			System.out.println("Invalid key value");

	}

}
