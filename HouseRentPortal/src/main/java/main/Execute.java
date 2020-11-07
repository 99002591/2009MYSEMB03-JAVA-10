package main;

import Admin.WelcomePage_Admin;
import Menu.Menu;
import User.WelcomePage_User;
import User.actual_Registration;

public class Execute {
	static int welcome_choice = 0;
	static int typeOfUser_choice = 0;
	
	public static void main(String[] args) throws InterruptedException{
		
		Menu MenuObject = new Menu();
		WelcomePage_User WelcomePageObject = new WelcomePage_User();
		WelcomePage_Admin adminWelcomeObject = new WelcomePage_Admin();
		actual_Registration actual_RegistrationOnject = new actual_Registration();
		
//		MenuObject.display_menu_header();
//		welcome_choice = MenuObject.display_menu_options();
//		WelcomePageObject.display_user_menu();
//		typeOfUser_choice = WelcomePageObject.kindOfUser();
//		adminWelcomeObject.display_admin_menu();
		actual_RegistrationOnject.owner_Registration();

	}
}
