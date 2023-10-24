package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.beans.User;

/**
 * 나이가 동일한 사람들끼리 Count해서 출력
 * 
 *
 */
public class GatheringTest {
	public static void main(String[] args) {
		List<User> users = new ArrayList<User>(Arrays.asList(new User[] { new User("user1", 19), new User("user2", 19),
				new User("user3", 20), new User("user4", 18), new User("user5", 20) }));

		Map<Integer, List<User>> ageUsersMap = new HashMap<Integer, List<User>>();

		for (User user : users) {
			int age = user.getAge();
			if (ageUsersMap.containsKey(age)) {
				ageUsersMap.get(age).add(user);
			} else {
				List<User> usersWithSameAge = new ArrayList<User>();
				usersWithSameAge.add(user);
				ageUsersMap.put(age, usersWithSameAge);
			}
		}

		for (Map.Entry<Integer, List<User>> entry : ageUsersMap.entrySet()) {
			int age = entry.getKey();
			List<User> usersWithSameAge = entry.getValue();
			System.out.println("Age " + age + " : " + usersWithSameAge.size());

		}
	}
}
