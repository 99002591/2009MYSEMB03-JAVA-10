package User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class actual_login {
	static boolean userID_validity;
	static boolean passCode_validity;
	String Array_cred[] = null;
	postLogin postLoginObject = new postLogin();
	
	/**
	 * This method has the following functions for the tenant login
	 * 1.Take as input the username
	 * 2.Take as input the password
	 * 3.Read the file containing all userdata and store them in a iterable list
	 * 4.Iterate through the list to check for valid credentials
	 * 5.Redirect user to search for property page incase of success
	 * 6.Redirect user to enter credentials again incase of incorect credentials
	 * @throws IOException
	 */
	public void tenant_login() throws IOException {
		Scanner user_input = new Scanner(System.in);
		System.out.println("");
		System.out.println("ENTER YOUR USERNAME");
		String userID = user_input.nextLine();
		System.out.println("");
		System.out.println("ENTER YOUR PASSWORD");
		String passCode = user_input.nextLine();
		System.out.println("");
		System.out.println("");
		try {
			FileReader fReader = new FileReader("UserData.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			StringBuffer sBuffer = new StringBuffer();
			String data;
			String[] credentials;
			while ((data = bReader.readLine()) != null) {
				credentials = data.split("<>");
				if (Arrays.stream(credentials).anyMatch("TENANT"::equals)) {
					if (Arrays.stream(credentials).anyMatch(userID::equals)) {
						userID_validity = true;
						if (Arrays.stream(credentials).anyMatch(passCode::equals)) {
							passCode_validity = true;
						} else {
							passCode_validity = false;
						}
						break;
					} else {
						userID_validity = false;
					}
				} else {
					System.out.println("SYSTEM ERROR, RESTART THE PROGRAM");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// VALIDATE LOGIN
		if (userID_validity == true && passCode_validity == true) {
			System.out.println("++++++++++++++++++++");
			System.out.println("   LOGIN SUCCESSFUL");
			System.out.println("++++++++++++++++++++");
			postLoginObject.display_postLogin_menu();
		} else if (userID_validity == true && passCode_validity == false) {
			System.out.println("++++++++++++++++++++");
			System.out.println("  Incorrect password");
			System.out.println("++++++++++++++++++++");
			tenant_login();
		} else if (userID_validity == false) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("User not registered, Consider registering before loggin in");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			tenant_login();
		}
	}

	/**
	 * This method has the following functions for the owner login
	 * 1.Take as input the username
	 * 2.Take as input the password
	 * 3.Read the file containing all userdata and store them in a iterable list
	 * 4.Iterate through the list to check for valid credentials
	 * 5.Redirect user to next page
	 * 6.Redirect user to enter credentials again incase of incorect credentials
	 * @throws IOException
	 */
	public void owner_login() throws IOException {
		String[] credentials = null;
		Scanner user_input = new Scanner(System.in);
		System.out.println("");
		System.out.println("ENTER YOUR USERNAME");
		String userID = user_input.nextLine();
		System.out.println("");
		System.out.println("ENTER YOUR PASSWORD");
		String passCode = user_input.nextLine();
		System.out.println("");
		System.out.println("");
		try {
			FileReader fReader = new FileReader("UserData.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			StringBuffer sBuffer = new StringBuffer();
			String data;
			while ((data = bReader.readLine()) != null) {
				credentials = data.split("<>");
				if (Arrays.stream(credentials).anyMatch("OWNER"::equals)) {
					if (Arrays.stream(credentials).anyMatch(userID::equals)) {
						userID_validity = true;
						if (Arrays.stream(credentials).anyMatch(passCode::equals)) {
							passCode_validity = true;
						} else {
							passCode_validity = false;
						}
						break;
					} else {
						userID_validity = false;
					}
				} else {
					System.out.println("SYSTEM ERROR, RESTART THE PROGRAM");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// VALIDATE LOGIN
		if (userID_validity == true && passCode_validity == true) {
			System.out.println("++++++++++++++++++++");
			System.out.println("   LOGIN SUCCESSFUL");
			System.out.println("++++++++++++++++++++");
			postLoginObject.owner_display(userID);
		} else if (userID_validity == true && passCode_validity == false) {
			System.out.println("++++++++++++++++++++");
			System.out.println("  Incorrect password");
			System.out.println("++++++++++++++++++++");
			owner_login();
		} else if (userID_validity == false) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("User not registered, Consider registering before loggin in");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			owner_login();
		}
	}
}
