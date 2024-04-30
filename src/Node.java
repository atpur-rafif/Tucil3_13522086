import java.util.ArrayList;

class Node implements Comparable<Node> {
	private int cost;
	private ArrayList<String> path;

	public Node(String start) {
		this(0, start);
	}

	public Node(int cost, String start) {
		this.cost = cost;
		this.path = new ArrayList<String>();
		this.path.addLast(start);
	}

	public Node(ArrayList<String> path) {
		this(0, path);
	}

	public Node(ArrayList<String> path, String next) {
		this(0, path, next);
	}

	public Node(int cost, ArrayList<String> path, String next) {
		this(cost, path);
		this.path.addLast(next);
	}

	public Node(int cost, ArrayList<String> path) {
		this.cost = cost;
		this.path = path;
	}

	public int compareTo(Node other) {
		return other.cost - this.cost;
	}

	public String toString() {
		return String.format("(%s) %s", this.cost, String.join(", ", this.path));
	}

	public String getCurrent() {
		return this.path.getLast();
	}
}
