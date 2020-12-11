import java.util.ArrayList;
import java.util.List;

public class Reader extends User {

	private List<Book> listOfReadingBooks;
	private List<Session> listOfSessions;

	public Reader() {
		listOfReadingBooks = new ArrayList<>();
		listOfSessions = new ArrayList<>();
	}
	
	public List<Book> getListOfReadingBooks() {
		return listOfReadingBooks;
	}

	public List<Session> getListOfSessions() {
		return listOfSessions;
	}

	@Override
	public void viewProfile() {

		StringBuilder sb = new StringBuilder();
		sb.append("\nReader ").append(getName()).append(" profile:\n").append("\tname: ").append(getName())
				.append("\n\temail: ").append(getEmail());
		sb.trimToSize();
		System.out.println(sb.toString());

	}	

}
