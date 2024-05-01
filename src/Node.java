class Node implements Comparable<Node> {
	private int cost;
	private int depth = -1;
	private String name;
	private Node parent;

	public Node(String start) {
		this(0, start);
	}

	public Node(String current, Node parent) {
		this(0, current, parent);
	}

	public Node(int cost, String start) {
		this(cost, start, null);
	}

	public Node(int cost, String current, Node parent) {
		this.cost = cost;
		this.parent = parent;
		this.name = current;
	}

	public int compareTo(Node other) {
		return other.cost - this.cost;
	}

	public String toString() {
		return String.format("(%s) %s", this.cost, this.name);
	}

	public String getName() {
		return this.name;
	}

	public Node getParent() {
		return this.parent;
	}

	public int getCost() {
		return this.cost;
	}

	public int getDepth() {
		if (this.depth == -1) {
			if (this.parent == null)
				this.depth = 0;
			else
				this.depth = this.getParent().getDepth() + 1;
		}
		return this.depth;
	}
}
