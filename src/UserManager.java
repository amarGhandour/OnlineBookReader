import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserManager {

	private List<User> users;
	private Map<String, User> usersNameObjectMap;
	private static UserManager userManager;

	private UserManager() {
		users = new ArrayList<>();
		usersNameObjectMap = new TreeMap<>();
	}

	public static UserManager getUserManager() {
		if (userManager == null)
			userManager = new UserManager();
		return userManager;
	}

	public boolean isValidLogin(String username, String password) {

		return (usersNameObjectMap.containsKey(username)
				&& usersNameObjectMap.get(username).getPassword().equals(password));

	}

	public List<User> getUsers() {
		return users;
	}

	public Map<String, User> getUsersNameObjectMap() {
		return usersNameObjectMap;
	}

	public void addUser() {
		User user = new Reader();
		user.read();
		getUsers().add(user);
		getUsersNameObjectMap().put(user.getUsername(), user);
	}

	public void printUsersList() {
		for (User user : users)
			System.out.println(user.toString());
	}

	public void addDummyData() {
		User user = new Reader();
		user.setName("amarx ghandour");
		user.setUsername("amar");
		user.setPassword("111");
		user.setEmail("amar@gmail.com");
		getUsers().add(user);
		getUsersNameObjectMap().put(user.getUsername(), user);

		User user2 = new Admin();
		user2.setName("amar ghandour");
		user2.setEmail("amar@gmail.com");
		user2.setUsername("amar2");
		user2.setPassword("000");
		getUsers().add(user2);
		getUsersNameObjectMap().put(user2.getUsername(), user2);

	}
}
