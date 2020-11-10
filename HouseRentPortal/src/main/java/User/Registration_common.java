package User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public interface Registration_common {
	LocalDate localDate = LocalDate.now();
	LocalTime localTime = LocalTime.now();
	/**
	 * This is a UI component that has been reused by multiple other classes
	 */
	public default void display_Registration() {
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println(" ");
		System.out.println("         Registration Portal");
		System.out.println(" ");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.print("TIME : " + localTime);
		System.out.print("    DATE : " + localDate);
		System.out.println(" ");
		System.out.println("");
		System.out.println("Hello new user, it'll take a moment for us to register you into our portal");
		System.out.println("bridging the gap between the owners and the prospective tenants.");
		System.out.println(" ");
		System.out.println("");
	}
	
	/**
	 * interface method
	 */
	public void owner_Registration();
	/**
	 * interface method
	 */
	public void tenant_Registration();
}
