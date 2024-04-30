import java.util.HashSet;
import java.util.PriorityQueue;

class Main {
	public static void test(String from, String to, Dictionary dictionary) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		HashSet<String> visited = new HashSet<>();

		Node start = new Node(0, from);
		queue.add(start);

		System.out.println(queue);

		Node end = null;
		while (queue.size() > 0) {
			Node current = queue.remove();
			String currentWord = current.getName();

			if (visited.contains(currentWord))
				continue;
			visited.add(currentWord);

			System.out.println(current);
			if (currentWord.equals(to)) {
				end = current;
				break;
			}

			for (int i = 0; i < currentWord.length(); ++i) {
				for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
					if (currentWord.charAt(i) == alphabet)
						continue;

					StringBuilder builder = new StringBuilder(currentWord);
					builder.setCharAt(i, alphabet);
					String newWord = builder.toString();
					if (!dictionary.checkWord(newWord))
						continue;

					Node newNode = new Node(-current.getDepth(), newWord, current);
					queue.add(newNode);
				}
			}
		}

		Node curr = end;
		System.out.println("Result: ");
		while (curr != null) {
			System.out.println(curr.getName() + " " + curr.getDepth());
			curr = curr.getParent();
		}
	}

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary("dictionary.txt");
		Main.test("myth", "lore", dictionary);
	}
}
