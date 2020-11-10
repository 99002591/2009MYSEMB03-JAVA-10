package Menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Menu {

	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();
	public int final_choice = 0;
	
	/**
	 * This function is part of the welcome page setup
	 */
	public void display_menu_header() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		System.out.println("            CHOOSE PORTAL");
		System.out.println(" ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.print("TIME : " + localTime);
		System.out.print("    DATE : " + localDate);
		System.out.println("");
		System.out.println("");
	}
	
	/**
	 * Shows the menu for the user to interact with.
	 * Helps the user choose between regular user mode or admin mode.
	 * @return final_choice integer type return (1 for User Mode, 2 for Admin Mode)
	 * @throws InterruptedException
	 */
	public int display_menu_options() throws InterruptedException {
		Scanner user_input = new Scanner(System.in);
		System.out.println("[1] . Enter 1 for User Portal");
		System.out.println("[2] . Enter 2 for Admin Portal");
		System.out.println(" ");
		boolean user_choice_validity = false;
		do {
			int user_choice = user_input.nextInt();
			if (user_choice == 1) {
				System.out.println("Welcome User, Redirecting to User portal");
				Thread.sleep(1000);
				user_choice_validity = true;
				final_choice = user_choice;
				break;
			}
			else if (user_choice == 2) {
				System.out.println("Welcome Admin, Redirecting to Admin portal");
				Thread.sleep(1000);
				user_choice_validity = true;
				final_choice = user_choice;
				break;
			} else {
				System.out.println("Invalid Input, Please Try Again");
				user_choice_validity = false;
				final_choice = user_choice;
			}
		} while (user_choice_validity == false);
		return final_choice;
	}
}
