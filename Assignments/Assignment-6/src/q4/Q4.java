package q4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Q4 {
	static void writeInFile(String line) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("sample.txt"))) {
			bw.write(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static String loadFileData() {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	static int countWord(String text, String word) {
		String[] words = text.split("\\s+");
		int count = 0;
		for (String w : words) {
			if (w.equals(word)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a line of text you want to write to the file:");
		String line = sc.nextLine();
		writeInFile(line);
		System.out.println("Data written to file. Now loading data from file:");

		String fileData = loadFileData();
		System.out.println("Data loaded from file:");
		System.out.println(fileData);

		// Count occurrences of each word
		String wordToFind;
		System.out.println("Enter a word to count its occurrences in the file:");
		wordToFind = sc.next();

		System.out.println(
				"The word '" + wordToFind + "' occurs " + countWord(fileData, wordToFind) + " times in the file.");
		sc.close();
	}
}
