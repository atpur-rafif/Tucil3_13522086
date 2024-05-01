package GUI;

import javax.swing.*;

public class GUI {
	public static void main(String[] args) {
		JFrame window = new JFrame();

		var input = new JTextField();
		window.add(input);

		var label = new JLabel("Hello, world!");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		window.add(label);
		window.pack();

		window.setTitle("Word Ladder Solver");
		window.setSize(300, 300);
		window.setVisible(true);
	}
}
