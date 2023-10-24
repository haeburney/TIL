package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import board.beans.User;

/**
 * List 요소 제거하기
 *
 */
public class RemovingTest {
	public static void main(String[] agrs) {
		List<User> users = new ArrayList<User>(Arrays.asList(new User[] { new User("user1", 19), new User("user2", 19),
				new User("user3", 20), new User("user4", 18), new User("user5", 20) }));
		for (User user : users) {
			if (user.getAge() < 20) {

			}
		}

		users.removeIf(user -> user.getAge() < 20);

		/*
		 * Iterator<User> iterator = users.iterator(); while (iterator.hasNext()) { if
		 * (iterator.next().getAge() < 20) { iterator.remove(); } }
		 */

		for (User user : users) {
			System.out.println("Age :" + user.getAge() + ", Name :" + user.getName());
		}
	}
}
