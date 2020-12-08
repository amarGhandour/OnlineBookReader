import java.time.LocalDateTime;

public class Session {
	
	private LocalDateTime lastReadingDate;
	private int lastReadingPage;
	private String name;
	private Book bookReading;
	private Reader reader;

	public Session() {
		lastReadingDate = LocalDateTime.now();
		lastReadingPage = 1;
	}

	public LocalDateTime getLastReadingDate() {
		return lastReadingDate;
	}

	public void setLastReadingDate(LocalDateTime lastReadingDate) {
		this.lastReadingDate = lastReadingDate;
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
		this.lastReadingPage++;
	}

	public void goPreviousPage() {
		this.lastReadingPage--;
	}

	public Book getBookReading() {
		return bookReading;
	}

	public Reader getReader() {
		return reader;
	}

	@Override
	public String toString() {
		return "Session [lastReadingDate=" + lastReadingDate + ", lastReadingPage=" + lastReadingPage + ", bookReading="
				+ bookReading + ", reader=" + reader + "]";
	}

}
