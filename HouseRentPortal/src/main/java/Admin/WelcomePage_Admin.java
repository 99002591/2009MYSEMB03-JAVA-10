package Admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class WelcomePage_Admin {
	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();

	/**
	 * This serves the purpose of keeping the UI uniform across pages
	 */
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
		admin_password();
	}

	/**
	 * Checks if the admin access password is correct
	 * Incase of a correct password, forwards the admin into restricted area
	 * Iterates over to ask user for password again, incase of wrong password
	 * @return boolean Status of password entered
	 */
	private boolean admin_password() {
		Scanner user_input = new Scanner(System.in);
		boolean admin_access_status = false;
		String admin_password = "somerandompassword";
		do {
			String admin_password_input = user_input.nextLine();
			if (admin_password_input.equals(admin_password)) {
				System.out.println("Login Succcessful");
				display_admin_actual_menu();
				admin_access_status = true;
			} else {
				System.out.println("Invalid Password");
				admin_access_status = false;
			}
		} while (admin_access_status == false);
		return admin_access_status;
	}

	/**
	 * This methods is the UI placeholder, invoked after successful admin login
	 */
	public void display_admin_actual_menu() {
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		System.out.println("             Welcome Admin");
		System.out.println(" ");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.print("TIME : " + localTime);
		System.out.print("    DATE : " + localDate);
		System.out.println(" ");
		System.out.println("");
		System.out.println("[1] . Enter 1 to view all registered owners");
		System.out.println("[2] . Enter 2 to view all registered tenants");
		info();
	}

	/**
	 * Provides the admin with actionable choices
	 * Reads from the userdata file to display details to the admin
	 * when asked for
	 * Coverts the read data into user interpretable format
	 */
	public void info() {
		Scanner user_input = new Scanner(System.in);
		int choice = user_input.nextInt();
		try {
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			FileReader fReader = new FileReader("UserData.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			StringBuffer sBuffer = new StringBuffer();
			String data;
			String[] credentials;
			while ((data = bReader.readLine()) != null) {
				credentials = data.split("<>");
				if (choice == 1) {
					if (Arrays.stream(credentials).anyMatch("OWNER"::equals)) {
						System.out.println(Arrays.deepToString(credentials));
					} else {
						;
					}
				} else if (choice == 2) {
					if (Arrays.stream(credentials).anyMatch("TENANT"::equals)) {
						System.out.println(Arrays.deepToString(credentials));
					} else {
						;
					}
				}else {
					System.out.println("Invalid choice, please restart");
				}

			}
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			display_admin_actual_menu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
