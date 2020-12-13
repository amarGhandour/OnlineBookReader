import java.util.ArrayList;
import java.util.List;

public class Reader extends User {

	private List<Session> listOfSessions;

	public Reader() {
		listOfSessions = new ArrayList<>();
	}
	
	public List<Session> getListOfSessions() {
		return listOfSessions;
	}
	
	public Session addSession(Book book, String sessionName) {
		Session session = new Session(book, sessionName);
		getListOfSessions().add(session);
		return session;
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
