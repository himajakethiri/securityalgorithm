
import java.util.Scanner;/**
 * file: AesCipher.java 
 * author: Himaja Kethiri 
 * course: Security Algorithms and
 * Protocols assignment: lab 3
 * Due date: March 31, 2016
 * version: 1.3
 * 
 * This file contains all methods which we have used to generate 11 round keys
 * by implementing in AES algorithm.It also contains the some methods to encrypt 
 * the plaintext using key.
 * 
 */
public class Driver {
	public static void main(String args[]) {
		// Takes input from console
		Scanner input = new Scanner(System.in);
		String keyInput = input.nextLine();
		Scanner input1 = new Scanner(System.in);
		String plainText = input1.nextLine();
		if ((keyInput.matches("[0-9A-F]{32}"))
				&& (plainText.matches("[0-9A-F]{32}"))) {
			String[][] c = AEScipher.aes(plainText, keyInput);

		} else {
			System.out.println("Invalid input");
		}
	}
}