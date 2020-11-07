package main;

import Admin.WelcomePage_Admin;
import Menu.Menu;
import User.WelcomePage_User;
import User.actual_Registration;

public class Execute {
	static int welcome_choice = 0;

	public static void main(String[] args) throws InterruptedException {
		boolean status;
		Menu MenuObject = new Menu();
		WelcomePage_User WelcomePageObject = new WelcomePage_User();
		WelcomePage_Admin adminWelcomeObject = new WelcomePage_Admin();
		actual_Registration actual_RegistrationOnject = new actual_Registration();

		MenuObject.display_menu_header();
		welcome_choice = MenuObject.display_menu_options();
		if (welcome_choice == 1) {
			WelcomePageObject.display_user_menu();
			if (WelcomePageObject.kindOfUser() == 1) {
				actual_RegistrationOnject.Register();
				status = true;
			} else if (WelcomePageObject.kindOfUser() == 2) {
				//LOGIN
				status = true;
			} else {
				status = false;
			}
		} else if (welcome_choice == 2) {
			adminWelcomeObject.display_admin_menu();
			status = true;
		} else {
			status = false;
		}

	}
}
