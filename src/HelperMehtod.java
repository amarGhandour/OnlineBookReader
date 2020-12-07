import java.util.InputMismatchException;
import java.util.Scanner;

public class HelperMehtod {

	private static Scanner input = new Scanner(System.in);
	
	private HelperMehtod() {
		
	}
	

	public static int showReadMenu(String[] menu) {
		System.out.println("\nMenu: ");
		for (int itemNumber = 0; itemNumber < menu.length; itemNumber++) {
			System.out.printf("\t%d)%s.%n", itemNumber + 1, menu[itemNumber]);
		}

		System.out.println();

		return readInt(1, menu.length);
	}

	public static int readInt(int low, int high) {

		int choice = -1;

		while (true) {
			try {
				System.out.printf("Enter number in range[%d - %d]: ", low, high);
				choice = input.nextInt();

				if ((choice >= low && choice <= high))
					break;

				System.out.println("Invalid range input..Try again.");
			} catch (InputMismatchException e) {
				System.out.println("Invalid input..please enter integer number.");
				input.nextLine();
			}
		}

		return choice;
	}
}
