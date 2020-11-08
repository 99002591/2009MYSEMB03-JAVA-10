package User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class login extends actual_login{
	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();

	public void login_menu() throws IOException {
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		System.out.println("           USER LOGIN PORTAL");
		System.out.println(" ");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.print("TIME : " + localTime);
		System.out.print("    DATE : " + localDate);
		System.out.println(" ");
		System.out.println("");
		System.out.println("[1] . Press 1 to Login as Tenant");
		System.out.println("[2] . Press 2 to Login as Owner");
		System.out.println(" ");
		System.out.println("");
		login_choice();
	}

	public void login_choice(){
		Scanner user_input = new Scanner(System.in);
		int login_choice_input;
		boolean login_choice_validity = false;
		do {
			login_choice_input = user_input.nextInt();
			if (login_choice_input == 1) {
				try {
					tenant_login();
				} catch (IOException e) {

					e.printStackTrace();
				}
				login_choice_validity = true;
			} else if (login_choice_input == 2) {
				try {
					owner_login();
				} catch (IOException e) {
					e.printStackTrace();
				}
				login_choice_validity = true;
			} else {
				System.out.println("Invalid input, please try again");
				login_choice_validity = false;
			}
		} while (login_choice_validity == false);
	}

}
