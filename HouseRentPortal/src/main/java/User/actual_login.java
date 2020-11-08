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
				System.out.println(Arrays.deepToString(credentials));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
			}
			if (Arrays.deepToString(credentials).contains("OWNER")) {
				System.out.println(Arrays.deepToString(credentials).contains("OWNER"));
				if (Arrays.deepToString(credentials).contains(userID)) {
					userID_validity = true;
				} else {
					userID_validity = false;
				}
			} else {
				System.out.println("SYTEM ERROR, RESTART THE PROGRAM");
			}
			
			if (Arrays.deepToString(credentials).contains("OWNER")) {
				if (Arrays.deepToString(credentials).contains(passCode)) {
					passCode_validity = true;
				} else {
					passCode_validity = false;
				}
			} else {
				System.out.println("SYTEM ERROR, RESTART THE PROGRAM");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// VALIDATE LOGIN
		if (userID_validity == true && passCode_validity == true) {
			System.out.println("LOGIN SUCCESSFUL");
			// LOGIN FUNCTION
		} else if (userID_validity == true && passCode_validity == false) {
			System.out.println("++++++++++++++++++++");
			System.out.println("  Incorrect password");
			System.out.println("++++++++++++++++++++");
		} else if (userID_validity == false) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("User not registered, Consider registering before loggin in");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}
	}
}
