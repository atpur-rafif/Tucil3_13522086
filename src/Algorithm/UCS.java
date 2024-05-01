package Algorithm;

import java.util.ArrayList;
import Construct.*;

public class UCS implements Finder {
	@Override
	public ArrayList<String> search(String from, String to, Dictionary dictionary, Visitor visitor) {
		return CostSearch.search(from, to, dictionary, new CostSearcher() {
			@Override
			public int calculateCost(Node parentNode, String current) {
				if (parentNode == null)
					return 0;
				return parentNode.getDepth() + 1;
			}

			@Override
			public void onNodeVisit(Node node) {
				visitor.visit(node);
			}
		});
	}
}
