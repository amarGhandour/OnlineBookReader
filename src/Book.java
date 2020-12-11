import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Book {
	private int id;
	private String name;
	private String author;
	private int numberOfPages;
	private String[] pages;
	private List<Session> readingSessions;
	private List<Reader> readers;

	private static Scanner input = new Scanner(System.in);

	public Book() {
		id = 0;
		name = "";
		author = "";
		numberOfPages = 0;
		pages = null;
		readingSessions = new ArrayList<>();
		readers = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(String numberOfPages) {
		this.numberOfPages = Integer.parseInt(numberOfPages);
	}

	public void setPages(String[] pages) {
		this.pages = pages;
	}

	public String[] getPages() {
		return pages;
	}

	public String getPageContent(int pageNumber) {
		return pages[pageNumber];
	}

	public List<Session> getReadingSessions() {
		return readingSessions;
	}

	public List<Reader> getReaders() {
		return readers;
	}

	public void read() {

		while (true) {
			System.out.println("Enter book id: ");
			setId(input.nextLine());

			if (!BookManager.getBookManagerInstance().getBooksIdObjectMap().containsKey(getId())) {
				break;
			}
			System.out.println("Id already exist...Try other id");
		}

		System.out.println("Enter book name: ");
		setName(input.nextLine());

		System.out.println("Enter author name: ");
		setAuthor(input.nextLine());

		System.out.println("Enter number of pages: ");
		setNumberOfPages(input.nextLine());

		pages = new String[numberOfPages];
		for (int pageNumber = 0; pageNumber < getPages().length; pageNumber++) {
			System.out.printf("Enter content of  page #%d: ", pageNumber + 1);
			getPages()[pageNumber] = input.nextLine();
		}

	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", numberOfPages=" + numberOfPages
				+ ", pages=" + Arrays.toString(pages) + "]";
	}

}
