import java.util.Scanner;

public class Book {
	private int id;
	private String name;
	private String author;

	private Scanner input = new Scanner(System.in);

	public Book() {
		id = 0;
		name = "";
		author = "";
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

	public void read() {
		
		while(true) {
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
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	

}
