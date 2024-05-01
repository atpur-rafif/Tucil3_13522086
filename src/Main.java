import CLI.*;

class Main {
	public static void main(String[] args) {
		String mode = args[0];
		if (mode.equalsIgnoreCase("cli")) {
			CLI.run(args);
		} else {
			System.out.println("Invalid mode!");
		}
	}
}
