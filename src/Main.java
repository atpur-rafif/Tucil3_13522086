class Main {
	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary("dictionary.txt");
		Visitor visitor = (node) -> {
			System.out.println(node);
		};

		Search bfs = new BFS();
		System.out.println(bfs.search("myth", "lore", dictionary, visitor));
	}
}
