package comprehensive;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class TextGenerator {

	public static void main(String[] args) throws NoSuchElementException, FileNotFoundException {
		if (args.length == 3) {
			System.out.println(TextGeneratorModel.findKMostProbable(args[0], args[1], args[2]));
		} else if (args[3].equals("all")) {
			System.out.println(TextGeneratorModel.createPhrase(args[0], args[1], args[2]));
		} else if (args[3].equals("one")) {
			System.out.println(TextGeneratorModel.createOnePhrase(args[0], args[1], args[2]));

		}

	}

}
