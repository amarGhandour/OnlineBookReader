
public class OnlineBookReaderSite {

	
	public OnlineBookReaderSite() {}
	
	public void run() {
		UserManager.getUserManager().addDummyData();
		BookManager.getBookManagerInstance().addDummyData();
		UserManager.getUserManager().printUsersList();
		BookManager.getBookManagerInstance().printListBooks();
		UserFlowController.getUserFlowController().showMainMenu();
	}
	
	 
	
}
