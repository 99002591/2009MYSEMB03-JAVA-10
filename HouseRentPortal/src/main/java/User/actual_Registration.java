package User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class actual_Registration implements Registration_common {
	WelcomePage_User WelcomePage_UserObject = new WelcomePage_User();

	/**
	 * @Override methods from interface
	 * Callback function for owner registration
	 */
	@Override
	public void owner_Registration() {
		display_Registration();
		Register_owner();
	}

	/**
	 * @Override method from interface
	 * Callback function for tenant registration
	 */
	@Override
	public void tenant_Registration() {
		display_Registration();
		Register_tenant();

	}

	
	/**
	 * Compares the input to decide whether to register user as owner or tenant
	 * callback to relevant registration functions
	 */
	public void Register() {
		System.out.println(WelcomePage_UserObject.get_flag());
		if (WelcomePage_User.ownerORtenant_flag.equals("OWNER")) {
			owner_Registration();
		} else if (WelcomePage_User.ownerORtenant_flag.equals("TENANT")) {
			tenant_Registration();
		} else {
			System.out.println("SYSTEM HAYWIRE!, Reboot");
		}
	}

	/**
	 * Owner registration function
	 * 1.Asks the user multiple details and store the name in local variables
	 * 2.After all input open the UserData file and write all the collected data in proper format.
	 * 3.Adds the data about whether the user is owner/tenant binded with each entry.
	 * 4.Prompts the user about successful registration
	 */
	public void Register_owner() {
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("");
		System.out.println("          OWNER REGISTRATION");
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("");

		@SuppressWarnings("resource")
		Scanner user_input = new Scanner(System.in);

		System.out.println("Choose a unique username");
		String username = user_input.nextLine();
		System.out.println("Choose a password");
		String password = user_input.nextLine();
		System.out.println("Enter your NAME");
		String Name = user_input.nextLine();
		System.out.println("Enter email ID");
		String email = user_input.nextLine();
		System.out.println("Enter your phone number");
		String phone = user_input.nextLine();
		System.out.println("What is your house size in square feet?");
		String houseSize = user_input.nextLine();
		System.out.println("What locality is the house located in?");
		String houseLocality = user_input.nextLine();
		System.out.println("Enter 1 for 1BHK, 2 for 2BHK, 3 for BHK and so on");
		String bhk = user_input.nextLine();
		System.out.println("What monthly rent do you expect?");
		String rent = user_input.nextLine();
		System.out.println("What is the one time security deposit?");
		String security = user_input.nextLine();
		try {
			FileWriter fWriter = new FileWriter("UserData.txt", true);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			bWriter.write("OWNER<>");
			bWriter.write(username + "<>");
			bWriter.write(password + "<>");
			bWriter.write(Name + "<>");
			bWriter.write(email + "<>");
			bWriter.write(phone + "<>");
			bWriter.write(houseSize + "<>");
			bWriter.write(houseLocality + "<>");
			bWriter.write(bhk + "<>");
			bWriter.write(rent + "<>");
			bWriter.write(security + "<>");
			bWriter.write("\n");
			bWriter.flush();
			bWriter.close();
			fWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("  REGISTRATION SUCCESFUL");
		System.out.println("+++++++++++++++++++++++++++");
	}

	/**
	 * Tenant registration function
	 * 1.Asks the user multiple details and store the name in local variables
	 * 2.After all input open the UserData file and write all the collected data in proper format
	 * 3.Adds the data about whether the user is owner/tenant binded with each entry.
	 * 4.Prompts the user about successful registration
	 */
	public void Register_tenant() {
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("");
		System.out.println("          TENANT REGISTRATION");
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("");

		@SuppressWarnings("resource")
		Scanner user_input = new Scanner(System.in);

		System.out.println("Choose a unique username");
		String username = user_input.nextLine();
		System.out.println("Choose a password");
		String password = user_input.nextLine();
		System.out.println("Enter your NAME");
		String Name = user_input.nextLine();
		System.out.println("Enter email ID");
		String email = user_input.nextLine();
		System.out.println("Enter your phone number");
		Integer phone = user_input.nextInt();

		try {
			FileWriter fWriter = new FileWriter("UserData.txt", true);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			bWriter.write("TENANT<>");
			bWriter.write(username + "<>");
			bWriter.write(password + "<>");
			bWriter.write(Name + "<>");
			bWriter.write(email + "<>");
			bWriter.write(phone + "<>");
			bWriter.write("\r");
			bWriter.flush();
			bWriter.close();
			fWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("  REGISTRATION SUCCESFUL");
		System.out.println("+++++++++++++++++++++++++++");
	}

}
