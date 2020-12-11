import java.util.List;
import java.util.Scanner;

public class ReaderFlowController {

	private static ReaderFlowController readerFlowController;
	private Reader currentReader;
	private Book currentBook;
	private Session currentSession;
	
	private static Scanner input = new Scanner(System.in); 

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
		this.currentReader = (Reader) currentReader;
	}

	public void takeControl(String username) {
		setCurrentReader(UserManager.getUserManager().getUsersNameObjectMap().get(username));
		System.out.printf("%nWelcome back %s, You are logged in.%n", currentReader.getName());

		showReaderMenu();
	}

	private void showReaderMenu() {

		String[] menu = { "View profile", "list of current books system", "view current session", "make new session",
				"Logout" };

		while (true) {
			int choice = HelperMehtod.showReadMenu(menu);

			if (choice == 1)
				currentReader.viewProfile();
			else if (choice == 2)
				showBookList();
			else if (choice == 3)
				viewCurrentSessions();
			else if (choice == 4)
				makeNewSession();
			else
				break;
		}

	}

	private void makeNewSession() {
		showBookList();
		
		int choice = HelperMehtod.readInt(1, BookManager.getBookManagerInstance().getBooksList().size()) - 1;
		currentBook = BookManager.getBookManagerInstance().getBooksList().get(choice);
		Session session = new Session();
		System.out.println("Enter session name: ");
		session.setName(input.nextLine());
		session.setBookReading(currentBook);
		session.setReader(currentReader);
		
		currentBook.getReadingSessions().add(session);
		currentReader.getListOfReadingBooks().add(currentBook);
		currentReader.getListOfSessions().add(session);
		
	}

	private void viewCurrentSessions() {
		showSessionList();

		int choice = HelperMehtod.readInt(1, currentReader.getListOfSessions().size()) - 1;
		currentSession = currentReader.getListOfSessions().get(choice);
		currentBook = currentSession.getBookReading();

		showSessionMenu();

	}

	private void showSessionMenu() {
		String[] menu = { "Go to next page.", "Go to previous page", "Stop reading." };

		while (true) {
			currentSession.print();
			System.out.println("\tContent: "+currentBook.getPageContent(currentSession.getLastReadingPage() - 1));
			
			int choice = HelperMehtod.showReadMenu(menu);
			if (choice == 1)
				currentSession.goNextPage();
			else if (choice == 2)
				currentSession.goPreviousPage();
			else
				break;
		}

	}

	private void showSessionList() {

		List<Session> sessionList = currentReader.getListOfSessions();

		System.out.println("\nSessions list:");
		for (int sessionNumber = 0; sessionNumber < sessionList.size(); sessionNumber++) {
			System.out.printf("%d)%s.%n", sessionNumber + 1, sessionList.get(sessionNumber).getName());
		}

	}

	private void showBookList() {

		List<Book> booksList = BookManager.getBookManagerInstance().getBooksList();
		System.out.println("\nBooks list of system:");

		for (int i = 0; i < booksList.size(); i++) {
			System.out.printf("%d)%s.%n", i + 1, booksList.get(i).getName());
		}

	}

}
