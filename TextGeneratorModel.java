package comprehensive;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Random;

public class TextGeneratorModel {

	public static String createPhrase(String file, String seed, String kString)
			throws NoSuchElementException, FileNotFoundException {

		int k = Integer.parseInt(kString);
		k--;
		HashMap<String, ArrayList<String>> chain = MarkovChain.generateText(file);
		String phrase = seed;
		String tempWord = seed;
		Random rand = new Random();
		int index = 0;

		for (int i = 0; i < k; i++) {
			try {
				index = rand.nextInt(chain.get(tempWord).size());
				tempWord = chain.get(tempWord).get(index);
				phrase += " " + tempWord;
			} catch (NullPointerException e) {
				tempWord = seed;
				phrase += " " + tempWord;
			}

		}

		return phrase;

	}

	public static String createOnePhrase(String file, String seed, String kString)
			throws NoSuchElementException, FileNotFoundException {

		int k = Integer.parseInt(kString);
		k--;
		HashMap<String, ArrayList<String>> chain = MarkovChain.generateText(file);
		HashMap<String, Integer> tally = new HashMap<>();
		String phrase = seed;
		String tempWord = seed;

		for (int i = 0; i < k; i++) {
			try {
				for (int j = 0; j < chain.get(tempWord).size(); j++) {
					String key = chain.get(tempWord).get(j);
					if (tally.containsKey(key)) {
						int count = tally.get(key);
						count++;
						tally.put(key, count);
					} else {
						tally.put(key, 1);
					}
				}

				int maxCount = 0;
				String maxKey = null;
				for (Entry<String, Integer> pair : tally.entrySet()) {
					if (maxCount < pair.getValue()) {
						maxKey = pair.getKey();
						maxCount = pair.getValue();
					} else if (maxCount == pair.getValue()) {
						if (maxKey.compareTo(pair.getKey()) > 0)
							maxKey = pair.getKey();

					}
				}

				tally.clear();
				tempWord = maxKey;
				phrase += " " + tempWord;
			} catch (NullPointerException e) {
				tempWord = seed;
				phrase += " " + tempWord;
			}

		}

		return phrase;

	}

	public static String findKMostProbable(String file, String seed, String kString)
			throws NoSuchElementException, FileNotFoundException {

		int k = Integer.parseInt(kString);
		HashMap<String, ArrayList<String>> chain = MarkovChain.generateText(file);
		HashMap<String, Integer> tally = new HashMap<>();
		String phrase = null;
		String tempWord = seed;

		for (int j = 0; j < chain.get(tempWord).size(); j++) {
			String key = chain.get(tempWord).get(j);
			if (tally.containsKey(key)) {
				int count = tally.get(key);
				count++;
				tally.put(key, count);
			} else {
				tally.put(key, 1);
			}
		}

		for (int i = 0; i < k; i++) {
			int maxCount = 0;
			String maxKey = null;
			for (Entry<String, Integer> pair : tally.entrySet()) {
				if (maxCount < pair.getValue()) {
					maxKey = pair.getKey();
					maxCount = pair.getValue();
				} else if (maxCount == pair.getValue()) {
					if (maxKey.compareTo(pair.getKey()) > 0)
						maxKey = pair.getKey();

				}
			}

			tally.remove(maxKey);
			if (phrase == null)
				phrase = maxKey;
			else
				phrase += " " + maxKey;
			if (tally.isEmpty())
				break;

		}

		return phrase;

	}

}
