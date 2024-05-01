class Main {
	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary("dictionary.txt");
		Visitor visitor = (node) -> {
			System.out.println(node);
		};

		Finder finder = new Greedy();
		System.out.println(finder.search("myth", "lore", dictionary, visitor));
	}
}
