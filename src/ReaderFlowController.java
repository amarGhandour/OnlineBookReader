
/// next time work......

public class ReaderFlowController {

	private static ReaderFlowController readerFlowController;
	private Reader currentReader;
	
	private ReaderFlowController() {
		
	}
	
	public static ReaderFlowController getReaderFlowController() {
		if (readerFlowController == null)
			readerFlowController = new ReaderFlowController();
		return readerFlowController;
	}
	
	
	public Reader getCurrentReader() {
		return currentReader;
	}

	public void setCurrentReader(User currentReader) {
		this.currentReader = (Reader)currentReader;
	}

	public void takeControl(String username) {
		setCurrentReader(UserManager.getUserManager().getUsersNameObjectMap().get(username));
		System.out.printf("\nWelcome back %s, You are logged in.%n", currentReader.getName());
		
		showReaderMenu();
	}

	private void showReaderMenu() {
		
		
	}

	
	
}
