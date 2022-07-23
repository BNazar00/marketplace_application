import java.util.ArrayList;
import java.util.List;


public class Users {
	private List<User> userList;


	public Users() {
		userList = new ArrayList<>();
	}

	public void addUser(User user) {
		userList.add(user);
	}

	public void displayUsers() {
		userList.forEach(user -> System.out.println(user.toString()));
	}

	public boolean checkId(int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public User findUser(int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	public void removeUser(User user){
		userList.remove(user);
	}
}

