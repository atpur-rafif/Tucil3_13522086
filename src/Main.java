import java.util.PriorityQueue;

class Main {
	public static void test(String from, String to, Dictionary dictionary) {
		PriorityQueue<Node> queue = new PriorityQueue<>();

		Node a = new Node(1, "A");
		Node b = new Node(2, "B");

		queue.add(a);
		queue.add(b);

		System.out.println(queue);
	}

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary("dictionary.txt");
		Main.test("base", "root", dictionary);
	}
}
