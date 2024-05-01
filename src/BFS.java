import java.util.ArrayList;

class BFS implements Search {
	@Override
	public ArrayList<String> search(String from, String to, Dictionary dictionary, Visitor visitor) {
		return Traverse.find(from, to, dictionary, new Traverser() {
			@Override
			public int calculateCost(Node parentNode, String current) {
				return parentNode.getDepth() + 1;
			}

			@Override
			public void onNodeVisit(Node node) {
				visitor.visit(node);
			}
		});
	}
}
