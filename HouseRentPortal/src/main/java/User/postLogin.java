package User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class postLogin {
	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();
	static String budget;
	static String locality;
	static boolean found_flag = false;

	public void display_postLogin_menu() {
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
		do {
			postLogin_interface();
		} while (found_flag == false);
	}

	public void postLogin_interface() {
		@SuppressWarnings("resource")
		Scanner user_input = new Scanner(System.in);
		System.out.println("What is your prefered maxmium budget?");
		budget = user_input.nextLine();
		System.out.println("What city are you looking to rent in?");
		locality = user_input.nextLine();
		System.out.println(" ");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		postLogin_searchResults();
	}

	public void postLogin_searchResults() {
		try {
			FileReader fReader = new FileReader("UserData.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			StringBuffer sBuffer = new StringBuffer();
			String data;
			String[] credentials;
			while ((data = bReader.readLine()) != null) {
				credentials = data.split("<>");
				if (Arrays.stream(credentials).anyMatch("OWNER"::equals)) {
					if (Arrays.deepToString(credentials).contains(locality)) {
						if (Integer.parseInt(credentials[9]) <= Integer.parseInt(budget)) {
							System.out.println("NAME OF OWNER : " + credentials[3]);
							System.out.println("EMAIL ID: " + credentials[4]);
							System.out.println("PHONE NO. : " + credentials[5]);
							System.out.println("FLOOR FOOTPRINT : " + credentials[6]);
							System.out.println("CITY : " + credentials[7]);
							System.out.println("NO OF ROOMS : " + credentials[8] + "BHK");
							System.out.println("RENT/MONTH : " + credentials[9]);
							System.out.println("SECURITY DEPOSIT : " + credentials[10]);
							found_flag = true;
						} else {
							System.out.println("+++++++++++++++++++");
							System.out.println("  NO MATCHES FOUND");
							System.out.println("+++++++++++++++++++");
							found_flag = false;
						}
					} else {
						System.out.println("+++++++++++++++++++");
						System.out.println("  NO MATCHES FOUND");
						System.out.println("+++++++++++++++++++");
						found_flag = false;
					}
				} else {
					// do nothing
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		postLogin_interface();
	}

	public void owner_display() {
		System.out.println(" ");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		try {
			FileReader fReader = new FileReader("UserData.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			StringBuffer sBuffer = new StringBuffer();
			String data;
			String[] credentials;
			while ((data = bReader.readLine()) != null) {
				credentials = data.split("<>");
				System.out.println("NAME OF OWNER : " + credentials[3]);
				System.out.println("EMAIL ID: " + credentials[4]);
				System.out.println("PHONE NO. : " + credentials[5]);
				System.out.println("FLOOR FOOTPRINT : " + credentials[6]);
				System.out.println("CITY : " + credentials[7]);
				System.out.println("NO OF ROOMS : " + credentials[8] + "BHK");
				System.out.println("RENT/MONTH : " + credentials[9]);
				System.out.println("SECURITY DEPOSIT : " + credentials[10]);
				found_flag = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		postLogin_interface();
	}
}
