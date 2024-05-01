interface Traverser {
	public int calculateCost(Node parentNode, String current);

	default public void onNodeVisit(Node node) {
	};
}
