import java.util.Scanner;

public abstract class User {
	private String name;
	private String username;
	private String email;
	private String password;
	public static Scanner input = new Scanner(System.in);

	public User() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public final void read() {

		while (true) {
			System.out.println("Enter username: ");
			setUsername(input.nextLine());

			if (!UserManager.getUserManager().getUsersNameObjectMap().containsKey(getUsername()))
				break;

			System.out.println("\nusername already used...try with other one.\n");
		}

		System.out.print("Enter name: ");
		setName(input.nextLine());

		System.out.println("Enter password: ");
		setPassword(input.nextLine());

		System.out.println("Enter email: ");
		setEmail(input.nextLine());
	}

	public abstract void viewProfile();

	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}

}
