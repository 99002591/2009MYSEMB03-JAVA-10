package User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class WelcomePage_User {
	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();
	public String ownerORtenant_flag;
	
	public void display_user_menu() {
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		System.out.println("Welcome User");
		System.out.println(" ");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.print("TIME : " + localTime);
		System.out.print("    DATE : " + localDate);
		System.out.println(" ");
		System.out.println("");
		System.out.println("[1] . New User? Enter 1 for Registration");
		System.out.println("[2] . Already an user? Enter 2  to login");
	}

	public int kindOfUser() {
		Scanner user_input = new Scanner(System.in);
		int kindOfUser_choice = 0;
		boolean kindOfUser_choice_validity = false;
		do {
			kindOfUser_choice = user_input.nextInt();
			if (kindOfUser_choice == 1) {
				System.out.println("Handing you over to User Registration Portal");
				int ownerORtenant = user_input.nextInt();
				System.out.println("Choose if you are the OWNER or TENANT");
				System.out.println("[1] . Enter 1 for OWNER");
				System.out.println("[2] . Enter 2 for TENANT");
				if (ownerORtenant == 1) {
					ownerORtenant_flag = "OWNER";
					break;
				}
				if (ownerORtenant == 2) {
					ownerORtenant_flag = "TENANT";
					break;
				}
				else {
					System.out.println("Invalid Entry, Restart the program");
				}
				kindOfUser_choice_validity = true;
			} else if (kindOfUser_choice == 2) {
				System.out.println("Welcome Back, redirecting to User Login Portal");
				kindOfUser_choice_validity = true;
			} else {
				System.out.println("Invalid Choice, Please try again");
				kindOfUser_choice_validity = false;
			}
		} while (kindOfUser_choice_validity == false);
		return kindOfUser_choice;
	}
}
