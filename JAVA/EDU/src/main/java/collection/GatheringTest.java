package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.beans.User;

/**
 * 나이가 동일한 사람들끼리 Map 형태로 묶기
 */
public class GatheringTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>(Arrays.asList(new User[] {new User("user1", 19), new User("user2", 19),
                        new User("user3", 20), new User("user4", 18), new User("user5", 20)}));
        
        Map<Integer, List<User>> ageUsersMap = new HashMap<Integer, List<User>>();

        for (User user : users) {
            Integer userAge = user.getAge();
            System.out.println("나이 : "+ userAge);
            System.out.println(ageUsersMap.containsKey(userAge));
            if(!ageUsersMap.containsKey(userAge)) {
                System.out.println(userAge+" 하이");
                ageUsersMap.put(userAge, new ArrayList<User>());
            }
            ageUsersMap.get(userAge).add(user);
        }

        for(Map.Entry<Integer, List<User>> entry : ageUsersMap.entrySet()) {
            Integer age = entry.getKey();
            List<User> usersList = entry.getValue();
            
            System.out.println(age);
            for(User user : usersList) {
               System.out.println(user.getName() + " " +user.getAge());
            }
        }
    }
}
