package comprehensive;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
	

}
