package comprehensive;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class TextGenerator {

	public static void main(String[] args) throws NoSuchElementException, FileNotFoundException {
		if (args.length == 3) {
			// K-next probable words
		} else if (args[3].equals("all")) {
			System.out.println(TextGeneratorModel.createPhrase(args[0], args[1], args[2]));
		} else if (args[3].equals("one")) {
			// only the most probable words
		}

	}

}
