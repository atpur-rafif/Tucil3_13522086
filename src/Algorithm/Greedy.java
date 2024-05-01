package Algorithm;

import java.util.ArrayList;
import java.util.HashSet;

import Construct.*;

public class Greedy implements Finder {
	@Override
	public ArrayList<String> search(String from, String to, Dictionary dictionary, Visitor visitor) {
		Node current = new Node(Heuristic.calculateDistance(from, to), from);
		HashSet<String> visited = new HashSet<>();

		while (true) {
			visitor.visit(current);

			String currentWord = current.getName();
			if (currentWord.equalsIgnoreCase(to))
				break;

			int minCost = Integer.MAX_VALUE;
			String minWord = null;
			for (int i = 0; i < currentWord.length(); ++i) {
				for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
					if (currentWord.charAt(i) == alphabet)
						continue;

					StringBuilder builder = new StringBuilder(currentWord);
					builder.setCharAt(i, alphabet);
					String newWord = builder.toString();
					if (!dictionary.checkWord(newWord))
						continue;

					if (visited.contains(newWord)) {
						continue;
					}
					visited.add(newWord);

					int cost = Heuristic.calculateDistance(newWord, to);
					if (cost < minCost) {
						minCost = cost;
						minWord = newWord;
					}
				}
			}

			if (minWord == null) {
				current = null;
				break;
			}

			current = new Node(minCost, minWord, current);
		}

		return Node.listPath(current);
	}
}
