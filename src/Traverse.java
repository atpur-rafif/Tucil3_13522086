import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

class Traverse {
	public static ArrayList<String> find(String from, String to, Dictionary dictionary, Traverser traverser) {
		PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
			@Override // Reverse priority queue, smaller cost, higher priority
			public int compare(Node o1, Node o2) {
				return (-1) * o1.compareTo(o2);
			}
		});

		HashSet<String> visited = new HashSet<>();

		Node start = new Node(0, from);
		queue.add(start);

		Node end = null;
		while (queue.size() > 0) {
			Node current = queue.remove();
			String currentWord = current.getName();

			if (visited.contains(currentWord))
				continue;
			visited.add(currentWord);

			traverser.onNodeVisit(current);
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

					int cost = traverser.calculateCost(current, newWord);
					Node newNode = new Node(cost, newWord, current);
					queue.add(newNode);
				}
			}
		}

		Node curr = end;
		ArrayList<String> result = new ArrayList<>();
		System.out.println("Result: ");
		while (curr != null) {
			result.addFirst(curr.getName());
			curr = curr.getParent();
		}

		return result;
	}
}
