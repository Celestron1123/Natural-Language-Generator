package comprehensive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MarkovChain {

	public static HashMap<String, ArrayList<String>> generateText(String file, int k)
			throws NoSuchElementException, FileNotFoundException {
		HashMap<String, ArrayList<String>> chain = new HashMap<String, ArrayList<String>>();
		try {
			Scanner scan = new Scanner(new File(file));
			String prevWord = null;

			if (scan.hasNext())
				prevWord = scan.next();

			else
				throw new NoSuchElementException();

			while (scan.hasNext()) {
				String word = scan.next();
				if (chain.get(prevWord) == null) {
					ArrayList<String> arr = new ArrayList<String>();
					arr.add(word);
					chain.put(prevWord, arr);
				} else {
					chain.get(prevWord).add(word);
				}
				prevWord = word;
			}

			return chain;
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}

}
