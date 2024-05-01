package Construct;

import java.util.ArrayList;

public interface Finder {
	public ArrayList<String> search(String from, String to, Dictionary dictionary, Visitor visitor);

	default public ArrayList<String> search(String from, String to, Dictionary dictionary) {
		return this.search(from, to, dictionary, new Visitor() {
			@Override
			public void visit(Node node) {
			}
		});
	};
}
