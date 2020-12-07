import java.util.Scanner;

public class UserFlowController {

	private static UserFlowController userFlowController;
	private User currentUser;
	private static Scanner input = new Scanner(System.in);
	private UserFlowController() {
		
	}
	
	public static UserFlowController getUserFlowController() {
		if (userFlowController == null)
			userFlowController = new UserFlowController();
		return userFlowController;
	}
	
	public void showMainMenu() {
			
		String[] menu = {"Login", "SignUp", "ShutDown"};
		
		while(true) {
			int choice = HelperMehtod.showReadMenu(menu);
			
			if (choice == 1)
				doLogin();
			else if (choice == 2)
				doSignUp();
			else
				break;
			
		}
	}

	private void doLogin() {
		while(true) {
			System.out.print("Enter username: ");
			String username = input.nextLine();
			
			System.out.print("Enter password: ");
			String password = input.nextLine();
			
			if (UserManager.getUserManager().isValidLogin(username, password)) {
				currentUser = UserManager.getUserManager().getUsersNameObjectMap().get(username);
				
				if (currentUser instanceof Admin)
					AdminFlowController.getAdminFlowController().takeControl(username);
				else
					ReaderFlowController.getReaderFlowController().takeControl(username);
				break;
			}else
				System.out.println("Invalid username or passwrod..Try again.");
		}
		
	}
	
	private void doSignUp() {
		UserManager.getUserManager().addUser();
	}
	
	
	
}
