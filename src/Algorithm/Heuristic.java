package Algorithm;

public class Heuristic {
	public static int calculateDistance(String from, String to) {
		if (from.length() != to.length())
			return Integer.MAX_VALUE;

		int size = from.length();
		int distance = 0;
		for (int i = 0; i < size; ++i) {
			if (from.charAt(i) != to.charAt(i))
				distance += 1;
		}

		return distance;
	}
}
