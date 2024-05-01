package Construct;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.HashSet;

public class Dictionary {
	private HashSet<String> words = new HashSet<>();

	public Dictionary(String filepath) throws Exception {
		FileReader fileReader = new FileReader(filepath);
		BufferedReader reader = new BufferedReader(fileReader);

		String word = reader.readLine();
		while (word != null) {
			this.words.add(word);
			word = reader.readLine();
		}

		fileReader.close();
	}

	public boolean checkWord(String word) {
		return this.words.contains(word);
	}
}
