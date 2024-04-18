package comprehensive;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 * This class represents the UI for the TextGeneratorModel class. If only three
 * arguments are passed, the list of most probable words will be returned. If
 * "all" is passed as a fourth argument then the resultant phrase will be based
 * on randomness and probability. If "one" is passed then only the most probable
 * words will be printed in the phrase.
 */
public class TextGenerator {

	public static void main(String[] args) throws NoSuchElementException, FileNotFoundException {
		if (args.length == 3) {
			TextGeneratorModel.findKMostProbable(args[0], args[1], args[2]);
		} else if (args[3].equals("all")) {
			TextGeneratorModel.createPhrase(args[0], args[1], args[2]);
		} else if (args[3].equals("one")) {
			TextGeneratorModel.createOnePhrase(args[0], args[1], args[2]);

		}

	}

}
