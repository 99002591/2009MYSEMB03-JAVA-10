package User;

public class actual_Registration implements Registration_common{
	WelcomePage_User WelcomePage_UserObject = new WelcomePage_User();
	
	@Override
	public void owner_Registration() {
		display_Registration();
	}
	@Override
	public void tenant_Registration() {
		display_Registration();
		System.out.println("OWNER");
	}
	
	public void Register() {
		if(WelcomePage_UserObject.equals("OWNER")) {
			owner_Registration();
		}
		else if(WelcomePage_UserObject.equals("TENANT")){
			tenant_Registration();
		}
		else {
			System.out.println("SYSTEM HAYWIRE!, Reboot");
		}
	}
	
	public void Register_owner() {
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("");
		System.out.println("          OWNER REGISTRATION");
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("");
		
		
	}
	
	public void Register_tenant() {
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("");
		System.out.println("          TENANT REGISTRATION");
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++");
		System.out.println("");
		
		
	}

}
