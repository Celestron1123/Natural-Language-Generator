
package comprehensive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MarkovChain {

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

			while (scan.hasNext()) {
				String word = simplify(scan.next());
				if (chain.get(prevWord) == null && word != null && prevWord != null) {
					ArrayList<String> arr = new ArrayList<String>();
					arr.add(word);
					chain.put(prevWord, arr);

				} else if (word != null && prevWord != null) {
					chain.get(prevWord).add(word);
				}
				prevWord = word;
			}
			scan.close();
			return chain;
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}

	public static HashMap<String, HashMap<String, Integer>> generateHighProbText(String file)
			throws FileNotFoundException {
		HashMap<String, HashMap<String, Integer>> chain = new HashMap<>();
		try {
			Scanner scan = new Scanner(new File(file));
			String prevWord = null;

			if (scan.hasNext()) {
				prevWord = simplify(scan.next());
			} else {
				throw new NoSuchElementException();
			}

			while (scan.hasNext()) {
				String word = simplify(scan.next());
				if (!chain.containsKey(prevWord)) {
					chain.put(prevWord, new HashMap<>());
				}

				Map<String, Integer> transitions = chain.get(prevWord);
				transitions.put(word, transitions.getOrDefault(word, 0) + 1);
				prevWord = word;
			}

			scan.close();
			return chain;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String simplify(String word) {
		String[] stringArr = word.toLowerCase().split("[\\p{Punct}\\s]+");
		if (stringArr[0].equals(""))
			return null;
		else
			return stringArr[0];
	}

}
