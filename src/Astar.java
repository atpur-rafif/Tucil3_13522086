import java.util.ArrayList;

class Astar implements Search {
	@Override
	public ArrayList<String> search(String from, String to, Dictionary dictionary, Visitor visitor) {
		return Traverse.find(from, to, dictionary, new Traverser() {
			@Override
			public int calculateCost(Node parentNode, String current) {
				int distance = Heuristic.calculateDistance(current, to);
				if (parentNode == null)
					return distance;
				return parentNode.getDepth() + 1 + distance;
			}

			@Override
			public void onNodeVisit(Node node) {
				visitor.visit(node);
			}
		});
	}
}
