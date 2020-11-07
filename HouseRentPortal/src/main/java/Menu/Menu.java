package Menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Menu {

	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();
	public int final_choice = 0;
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
		try {
			display_menu_options();
		} catch (Exception e) {
			System.out.println("Unexpected Error, Please restart the program");
		}
	}

	@SuppressWarnings("resource")
	public int display_menu_options() throws InterruptedException {
		Scanner user_input = new Scanner(System.in);
		System.out.println("[1] . Enter 1 for User Portal");
		System.out.println("[2] . Enter 2 for Admin Portal");
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
			if (user_choice == 2) {
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
		user_input.close();
		return final_choice;
	}
}
