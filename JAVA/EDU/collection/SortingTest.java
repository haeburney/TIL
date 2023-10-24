package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import board.beans.User;

/**
 * List 나이순으로 정렬하기
 *
 */
public class SortingTest {

	public static void main(String[] agrs) {
		List<User> users = new ArrayList<User>(Arrays.asList(new User[] { new User("user1", 19), new User("user2", 19),
				new User("user3", 20), new User("user4", 18), new User("user5", 20) }));

		Collections.sort(users, (user1, user2) -> Integer.compare(user2.getAge(), user1.getAge()));

		for (User user : users) {
			System.out.println("Age :" + user.getAge() + ", Name :" + user.getName());
		}

	}
}
