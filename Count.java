package wordcount;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Count {

	public static void main(String[] args) {
		Boolean ans = true;
		while (ans) {
			Info info = new Info();
			int count = 0;
			System.out.println("=================================");
			System.out.println("==== WELCOME TO WORD COUNTER ====");
			System.out.println("1. Sentence");
			System.out.println("2. Provide File");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			if (choice == 1) {
				System.out.println("=================================");
				System.out.println("Please Enter Sentence : ");
				String sentence = info.getSentence();
				String[] arrayString = sentence.split("[, . ']+");
				System.out.println("TOTAL WORDS : " + arrayString.length);
				System.out.println("=================================");

			} else if (choice == 2) {
				System.out.println("=================================");
				System.out.println("Please enter file path : ");
				Scanner scann = new Scanner(System.in);
				String filePath = scann.nextLine();

				String fileString = info.getFileSentence(filePath);

				String[] arrayString = null;
				if (fileString != null) {
					arrayString = fileString.split("[, . ']+");
					System.out.println("TOTAL WORDS : " + arrayString.length);
				}

				System.out.println("=================================");
			} else {
				System.out.println("Invalid choice Please enter 1 or2");
				System.out.println("=================================");
			}
			System.out.println("== DO YOU WANT TO COUNT AGAIN ===");
			System.out.println("=== IF You Want Count Enter Y ===");
			System.out.println("=== Other wise Enter Any key ====");
			char anss = info.UserGuessAns();
			if (anss == 'y' || anss == 'Y') {
				ans = true;
			} else {
				ans = false;
			}

		}

	}

}

class Info {
	public String getSentence() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public String getFileSentence(String filePath) {
		File f = new File(filePath);
		StringBuilder sb = new StringBuilder();
		try {
			Scanner scan = new Scanner(f);
			String fileData = scan.nextLine();
			while (scan.hasNextLine()) {
				sb.append(scan.nextLine());
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("Check File Path");
			System.out.println("=================================");
			return null;
		} catch (NoSuchElementException e) {
			System.out.println("No data in file");
			System.out.println("=================================");
			return null;
		}

	}

	public char UserGuessAns() {
		Scanner scan = new Scanner(System.in);
		char ans = scan.next().charAt(0);
		return ans;
	}
}
