import java.util.Scanner;

/**
 * file: Driver.java 
 * author: Himaja Kethiri 
 * course: Security Algorithms and Protocols 
 * assignment: lab 3 Due date: March 31, 2016 version: 1.4
 * 
 * This file contains the inputs we want to give to the AEScipher class and
 * aes() using Scanner class.
 * 
 */
public class Driver {
    public static void main(String args[]) {
        // Giving key as the input to the aes method in AEscipher class
        String keyInput = "";
        // Giving plaintext as the input to the aes method
        String plainText = "";
        // Reading input using Scanner
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        plainText = input.nextLine();
        if (input.hasNextLine())
            keyInput = input.nextLine();
        // Passing parameters key and plaintext to the aes().
        AEScipher.aes(plainText, keyInput);
    }
}