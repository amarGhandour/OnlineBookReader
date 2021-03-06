import java.time.LocalDateTime;

public class Session {

	private LocalDateTime lastReadingDate;
	private int lastReadingPage;
	private String name;
	private Book bookReading;

	public Session() {
		this(null, "");
	}
	
	public Session(Book book, String sessionName) {
		setBookReading(book);
		setLastReadingDate();
		setLastReadingPage(1);
		setName(sessionName);
	}

	public LocalDateTime getLastReadingDate() {
		return lastReadingDate;
	}

	public void setLastReadingDate() {
		this.lastReadingDate = LocalDateTime.now();
	}

	public int getLastReadingPage() {
		return lastReadingPage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void goNextPage() {
		if (getBookReading().getPages().size() == lastReadingPage)
			return;
		this.lastReadingPage++;
	
	}

	public void goPreviousPage() {
		if (getLastReadingPage() == 1)
			return;
		this.lastReadingPage--;	
	}

	public void setLastReadingPage(int lastReadingPage) {
		this.lastReadingPage = lastReadingPage;
	}

	public void setBookReading(Book bookReading) {
		this.bookReading = bookReading;
	}

	public Book getBookReading() {
		return bookReading;
	}

	public String getCurrentpageContent() {
		return getBookReading().getPages().get(lastReadingPage - 1);
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName()).append(" session info: \n").append("\tLast page reading: ").append(getLastReadingPage())
				.append("\n\tLast reading date: ").append(getLastReadingDate()).append("\n");
		sb.trimToSize();
		System.out.println(sb.toString());
	}

	@Override
	public String toString() {
		return "Session [lastReadingDate=" + lastReadingDate + ", lastReadingPage=" + lastReadingPage + ", name=" + name
				+ ", bookReading=" + bookReading + "]";
	}

}
