import Algorithm.*;
import Construct.*;
import Construct.Node;

class TrackingVisitor implements Visitor {
	int visitedCounter = 0;

	@Override
	public void visit(Node node) {
		System.out.println(node);
		this.visitedCounter += 1;
	}

	public int getVisitedCounter() {
		return this.visitedCounter;
	}
};

class Main {
	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary("dictionary.txt");

		Finder finder = new Astar();
		TrackingVisitor visitor = new TrackingVisitor();
		System.out.println(finder.search("myth", "lore", dictionary, visitor));
		System.out.println("Visited count: " + visitor.getVisitedCounter());
	}
}
