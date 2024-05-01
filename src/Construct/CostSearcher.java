package Construct;

public interface CostSearcher {
	public int calculateCost(Node parentNode, String current);

	default public void onNodeVisit(Node node) {
	};
}
