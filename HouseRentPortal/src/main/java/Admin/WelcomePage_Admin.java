package Admin;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class WelcomePage_Admin {
	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();

	public void display_admin_menu() {
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		System.out.println("Welcome Admin, Restricted Access");
		System.out.println(" ");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.print("TIME : " + localTime);
		System.out.print("    DATE : " + localDate);
		System.out.println(" ");
		System.out.println("");
		System.out.println("Enter Password to proceed");
		System.out.println(" ");
		System.out.println("");
	}

	private boolean admin_password() {
		Scanner user_input = new Scanner(System.in);
		boolean admin_access_status = false;
		String admin_password = "somerandompassword";
		String admin_password_input = user_input.nextLine();
		while (admin_access_status == false) {
			if (admin_password_input.equals(admin_password)) {
				System.out.println("Login Succcessful");
				admin_access_status = true;
			} else {
				System.out.println("Invalid Password");
				admin_access_status = false;
			}
		}
		return admin_access_status;
	}

	public void display_admin_actual_menu() {
		while (admin_password()) {
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println(" ");
			System.out.println("Welcome Admin");
			System.out.println(" ");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.print("TIME : " + localTime);
			System.out.print("    DATE : " + localDate);
			System.out.println(" ");
			System.out.println("");
			System.out.println("[1] . Enter 1 to view all registered sellers");
			System.out.println("[2] . Enter 2 to view all registered buyers");
			System.out.println("[3] . Enter 3 to manage sellers");
			System.out.println("[4] . Enter 4 to manage buyers");
		}
	}
}
