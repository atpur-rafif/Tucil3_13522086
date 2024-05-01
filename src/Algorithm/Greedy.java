package Algorithm;

import java.util.ArrayList;
import Construct.*;

public class Greedy implements Finder {
	@Override
	public ArrayList<String> search(String from, String to, Dictionary dictionary, Visitor visitor) {
		return Traverse.find(from, to, dictionary, new Traverser() {
			@Override
			public int calculateCost(Node parentNode, String current) {
				int distance = Heuristic.calculateDistance(current, to);
				if (parentNode == null)
					return distance;
				return distance;
			}

			@Override
			public void onNodeVisit(Node node) {
				visitor.visit(node);
			}
		});
	}
}
