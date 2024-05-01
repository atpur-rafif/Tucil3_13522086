import CLI.*;

/* (Will it be?)
How to use:
<executable name> <mode> <dictionary path> <algorithm> <start word> <end word>
Mode can be either "cli" or "gui
For gui, don't need to specify more than mode (Only <executable name> gui)
Dictionary path relative from current working directory. Use quotes if directory include space
Start and end word can't contain space

Example:
java Main cli dictionary.txt myth lore"
*/

class Main {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("""
					How to use:
					<executable name> <dictionary path> <algorithm> <start word> <end word>
					Dictionary path relative from current working directory. Use quotes if directory include space
					Start and end word can't contain space

					Example:
					java Main dictionary.txt myth lore""");
			System.exit(1);
		}

		CLI.run(args);
		// String mode = args[0];
		// if (mode.equalsIgnoreCase("cli")) {
		// CLI.run(args);
		// } else {
		// System.out.println("Invalid mode!");
		// }
	}
}
