import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {
	private int id;
	private String name;
	private String author;
	private int numberOfPages;
	private List<String> pages;

	private static Scanner input = new Scanner(System.in);

	public Book() {
		id = 0;
		name = "";
		author = "";
		numberOfPages = 0;
		pages = new ArrayList<>();
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

	public List<String> getPages() {
		return pages;
	}

	public void setPages(List<String> pages) {
		this.pages = pages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
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

		for (int pageNumber = 0; pageNumber < getNumberOfPages(); pageNumber++) {
			System.out.printf("Enter content of  page #%d: ", pageNumber + 1);
			getPages().add(input.nextLine());
		}

	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", numberOfPages=" + numberOfPages
				+ ", pages=" + pages + "]";
	}

}
