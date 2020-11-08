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
	static String bhk;
	static String locality;
	
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
		postLogin_interface();
	}
	
	public void postLogin_interface() {
		@SuppressWarnings("resource")
		Scanner user_input = new Scanner(System.in);
		System.out.println("What is your prefered maxmium budget?");
		budget = user_input.nextLine();
		System.out.println("What kind of house are you looking for?");
		System.out.println("Enter 1 for BHK, 2 for 2 BHK and so on...");
		bhk = user_input.nextLine();
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
				System.out.println(Arrays.deepToString(credentials));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
