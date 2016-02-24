import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		if (key.matches("[0-9a-fA-F]{32}")) {

			AesCipher.aesRoundKeys(key);

		} else

			System.out.println("Invalid key value");

	}

}
