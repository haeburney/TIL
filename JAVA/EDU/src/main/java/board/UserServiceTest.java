/**
 * 
 */
package board;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import board.beans.User;

/**
 * 
 */
class UserServiceTest {

    /**
     * @throws java.lang.Exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {}

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {}

    /**
     * Test method for {@link board.UserService#getUser(java.lang.String, java.lang.String)}.
     */
    @Test
    void testGetUser() {
        UserService userService = new MariaUserService();
        String name = "minhyun";
        String password = "1234";

        User loginUser = userService.getUser(name, password);
        System.out.println(">> loginUser=" + loginUser);

    }

}
