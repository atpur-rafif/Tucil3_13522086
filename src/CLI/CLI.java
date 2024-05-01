package CLI;

import java.util.ArrayList;

import Algorithm.*;
import Construct.*;

public class CLI {
	public static Finder getAlgorithm(Algorithm algorithm) {
		switch (algorithm) {
			case Greedy:
				return new Greedy();
			case UCS:
				return new UCS();
			case Astar:
			default:
				return new Astar();
		}
	}

	public static String algorithmToString(Algorithm algorithm) {
		switch (algorithm) {
			case Greedy:
				return "Greedy";
			case UCS:
				return "UCS";
			case Astar:
			default:
				return "A*";
		}
	}

	public static void search(Dictionary dictionary, String from, String to, Algorithm algorithm) {
		Finder finder = CLI.getAlgorithm(algorithm);
		var lambdaCapture = new Object() {
			int count = 0;
		};

		long startTime = System.nanoTime();
		ArrayList<String> result = finder.search(from, to, dictionary, (node) -> {
			// System.out.println(node);
			lambdaCapture.count += 1;
		});
		long endTime = System.nanoTime();
		double totalTime = (endTime - startTime) / 1e6;

		if (result.size() == 0) {
			System.out.println("No path found");
			return;
		}

		System.out.println("=====[ Result " + CLI.algorithmToString(algorithm) + " (" + from + " -> " + to + ") ]=====");
		for (int i = 0; i < result.size(); ++i) {
			System.out.println((i + 1) + ". " + result.get(i));
		}
		System.out.println("Step taken: " + (result.size() - 1));
		System.out.println("Word generated count: " + lambdaCapture.count);
		System.out.println("Time taken: " + totalTime + "ms");
	}

	public static void run(String[] args) {
		String dictionaryPath = args[0];
		Dictionary dictionary = null;
		try {
			dictionary = new Dictionary(dictionaryPath);
		} catch (Exception e) {
			System.err.println("Error when reading file " + dictionaryPath + " for dictionary");
			System.exit(1);
		}

		String rawAlgorithm = args[1];
		Algorithm algorithm = null;

		if (rawAlgorithm.equalsIgnoreCase("greedy"))
			algorithm = Algorithm.Greedy;
		else if (rawAlgorithm.equalsIgnoreCase("ucs"))
			algorithm = Algorithm.UCS;
		else if (rawAlgorithm.equalsIgnoreCase("astar"))
			algorithm = Algorithm.Astar;
		else {
			System.err.println("Algoritm " + rawAlgorithm + " is not valid");
			System.exit(1);
		}

		String from = args[2];
		String to = args[3];
		boolean error = false;
		if (!dictionary.checkWord(from)) {
			System.err.println("Start word \"" + from + "\" is not in dictionary");
			error = true;
		}

		if (!dictionary.checkWord(to)) {
			System.err.println("End word \"" + to + "\" is not in dictionary");
			error = true;
		}

		if (error) {
			System.exit(1);
		}

		CLI.search(dictionary, from, to, algorithm);
	}
}
