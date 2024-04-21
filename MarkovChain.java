
package comprehensive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A supplemental class for the TextGeneratorModel class designed to create a
 * Markov Chain based off of a text-based input file. Each word is made
 * undercase and is split up to the first punctuation mark in the word (which
 * has the consequence that if words start with punctuation, they are
 * neglected).
 * 
 * @authors - Elijah Potter & William Ngo
 * @version April 16, 2024
 */
public class MarkovChain {

	/**
	 * A static class to create a HashMap-based Markov Chain. It takes a file and
	 * processes what words follow a given word. The "following" words are then
	 * logged in an ArrayList as to determine valid word combinations and to
	 * determine likelyhood of word combinations.
	 * 
	 * @param file - The input file
	 * @return A HashMap Markov Chain
	 * @throws NoSuchElementException If the file is empty
	 * @throws FileNotFoundException  If the file name is invalid
	 */
	public static HashMap<String, ArrayList<String>> generateText(String file)
			throws NoSuchElementException, FileNotFoundException {
		HashMap<String, ArrayList<String>> chain = new HashMap<String, ArrayList<String>>();
		try {
			Scanner scan = new Scanner(new File(file));
			String prevWord = null;

			if (scan.hasNext())
				prevWord = simplify(scan.next());

			else
				throw new NoSuchElementException();

			while (prevWord == null) {
				prevWord = simplify(scan.next());
			}

			while (scan.hasNext()) {
				String word = simplify(scan.next());
				while (word == null) {
					word = simplify(scan.next());
				}
				if (chain.get(prevWord) == null) {
					ArrayList<String> arr = new ArrayList<String>();
					arr.add(word);
					chain.put(prevWord, arr);

				} else {
					chain.get(prevWord).add(word);
				}
				prevWord = word;
			}
			scan.close();
			return chain;
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException();
		}
	}

	/**
	 * A static class to create a HashMap-based Markov Chain. It takes a file and
	 * processes what words follow a given word. The "following" words are then
	 * logged in a HashMap as to determine valid word combinations and to determine
	 * likelyhood of word combinations.
	 * 
	 * @param file - The input file
	 * @return A HashMap Markov Chain
	 * @throws NoSuchElementException If the file is empty
	 * @throws FileNotFoundException  If the file name is invalid
	 */
	public static HashMap<String, HashMap<String, Integer>> generateOneText(String file)
			throws NoSuchElementException, FileNotFoundException {
		HashMap<String, HashMap<String, Integer>> chain = new HashMap<String, HashMap<String, Integer>>();
		try {
			Scanner scan = new Scanner(new File(file));
			String prevWord = null;

			if (scan.hasNext())
				prevWord = simplify(scan.next());

			else
				throw new NoSuchElementException();

			while (prevWord == null) {
				prevWord = simplify(scan.next());
			}

			while (scan.hasNext()) {
				String word = simplify(scan.next());
				while (word == null) {
					word = simplify(scan.next());
				}

				if (!chain.containsKey(prevWord)) {
					HashMap<String, Integer> map = new HashMap<String, Integer>();
					map.put(word, 1);
					chain.put(prevWord, map);

				} else {
					HashMap<String, Integer> bruh = chain.get(prevWord);
					bruh.put(word, bruh.getOrDefault(word, 0) + 1);
				}

				prevWord = word;
			}
			scan.close();
			return chain;
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException();
		}
	}

	/**
	 * A private helper class to set a word to lowercase and deliminate based on
	 * punctuation.
	 * 
	 * @param word - The word to be processed
	 * @return The newly formatted word
	 */
	private static String simplify(String word) {
		word = word.replaceAll("[^a-zA-Z0-9_ ]", "'");
		String[] stringArr = word.toLowerCase().split("'");
		if (stringArr.length == 0)
			return null;
		else if (stringArr[0].equals(""))
			return null;
		else
			return stringArr[0];
	}

}
