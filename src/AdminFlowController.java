
public class AdminFlowController {

	private static AdminFlowController adminFlowController;
	private Admin currentUser;
	
	private AdminFlowController() {
		
	}
	
	public static AdminFlowController getAdminFlowController() {
		if (adminFlowController == null)
			adminFlowController = new AdminFlowController();
		return adminFlowController;
	}
	
	public void takeControl(String username) {
		setCurrentUser(UserManager.getUserManager().getUsersNameObjectMap().get(username));
		System.out.printf("\nWelcome back %s, You are logged in.%n", currentUser.getName());
		
		showAdminMenu();
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = (Admin)currentUser;
	}

	private void showAdminMenu() {
		String[] menu = {"View profile", "Add book", "List of books", "List of users", "Logout"};
		
		while(true) {
			int choice = HelperMehtod.showReadMenu(menu);
			
			if (choice == 1)
				currentUser.viewProfile();
			else if (choice == 2)
				BookManager.getBookManagerInstance().addBook();
			else if (choice == 3)
				BookManager.getBookManagerInstance().printListBooks();
			else if (choice == 4)
				UserManager.getUserManager().printUsersList();
			else
				break;
		}
	}
	
	
	
}

