import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookManager {
	private List<Book> booksList;
	private Map<Integer, Book> booksIdObjectMap;
	private static BookManager bookManager;

	private BookManager() {
		booksList = new ArrayList<>();
		booksIdObjectMap = new TreeMap<>();
	}

	public static BookManager getBookManagerInstance() {
		if (bookManager == null)
			bookManager = new BookManager();
		return bookManager;
	}

	public List<Book> getBooksList() {
		return booksList;
	}

	public Map<Integer, Book> getBooksIdObjectMap() {
		return booksIdObjectMap;
	}

	public void addBook() {
		Book book = new Book();
		book.read();
		getBooksList().add(book);
		getBooksIdObjectMap().put(book.getId(), book);
	}
	
	public void printListBooks() {
		System.out.println("\nBooks list: ");
		for (Book book: getBooksList())
			System.out.println(book);
	}

	public void addDummyData() {
		Book book1 = new Book();
		book1.setId("1");
		book1.setName("Intro to programming");
		book1.setAuthor("mostafa saad");
		book1.setNumberOfPages("3");
		String[] book1PagesContent = {"Intro", "to", "programming"};
		book1.setPages(book1PagesContent);
	

		Book book2 = new Book();
		book2.setId("2");
		book2.setName("Intro to Algo");
		book2.setAuthor("mohamed shrief");
		book2.setNumberOfPages("3");
		String[] book2PagesContent = {"Intro", "to", "Algo"};
		book2.setPages(book2PagesContent);

		getBooksList().add(book1);
		getBooksList().add(book2);
		getBooksIdObjectMap().put(book1.getId(), book1);
		getBooksIdObjectMap().put(book2.getId(), book2);

	}

}
