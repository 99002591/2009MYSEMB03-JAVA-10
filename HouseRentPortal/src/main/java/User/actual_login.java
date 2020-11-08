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
			// LOGIN FUNCTION // SEARCH FUNCTION
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
			// LOGIN FUNCTION // JUST DISPLAY HIS INFO IN GOOD FORMAT
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
