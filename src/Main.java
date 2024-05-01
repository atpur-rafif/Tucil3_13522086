import java.util.ArrayList;

class Main {
	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary("dictionary.txt");

		// BFS
		ArrayList<String> result = Traverse.find("myth", "lore", dictionary, new Traverser() {
			@Override
			public int calculateCost(Node parentNode, String current) {
				return parentNode.getDepth() + 1;
			}

			@Override
			public void onNodeVisit(Node node) {
				System.out.println(node);
			}
		});
		System.out.println(result);
	}
}
