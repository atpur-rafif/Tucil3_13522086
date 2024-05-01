package Algorithm;

import java.util.ArrayList;
import Construct.*;

public class Astar implements Finder {
	@Override
	public ArrayList<String> search(String from, String to, Dictionary dictionary, Visitor visitor) {
		return CostSearch.search(from, to, dictionary, new CostSearcher() {
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
