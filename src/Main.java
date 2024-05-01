class Main {
	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary("dictionary.txt");

		// BFS
		Traverse.find("myth", "lore", dictionary, new Traverser() {
			@Override
			public int calculateCost(Node parentNode, String current) {
				return parentNode.getDepth() + 1;
			}
		});
	}
}
