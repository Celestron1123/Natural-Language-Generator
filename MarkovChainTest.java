package comprehensive;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MarkovChainTest {
	Random rand;

	@BeforeEach
	void setUp() throws Exception {
		rand = new Random();
	}

	@Test
	void testMarkovChain() {
		try {
			HashMap<String, ArrayList<String>> map = MarkovChain
					.generateText("C:/Users/epot1/eclipse-workspace/CS 2420/src/comprehensive/bingus.txt", 4);
			assertEquals("[like, and, i, is, because, good, cheese]", map.keySet().toString());
			assertEquals("[[cheese, good], [i], [like, like], [good], [cheese], [and, things], [because, is]]",
					map.values().toString());
			assertEquals("[cheese, good]", map.get("like").toString());
			assertEquals(2, map.get("like").size());
			int randIndex = rand.nextInt(2);
			System.out.println(map.get("like").get(randIndex));
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void testMarkovChainHighProb() {
		try {
			HashMap<String, HashMap<String, Integer>> probMap = MarkovChain
					.generateHighProbText("src/comprehensive/bingus.txt", 4);
			assertEquals("[like, and, i, is, because, good, cheese]", probMap.keySet().toString());
			assertEquals("[{good=1, cheese=1}, {i=1}, {like=2}, {good=1}, {cheese=1}, {and=1, things=1}, {is=1, because=1}]",
					probMap.values().toString());
		} catch (FileNotFoundException e) {

		}
	}
