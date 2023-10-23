package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.beans.User;

public class MariaUserService extends ServiceManager implements UserService {

    /**
     * 로그인 하기
     * 
     * @param request
     * @return
     */
    public User getUser(String userName, String userPassword) {

        Connection connection = getConnection();
        String query = "select * from user2 where name like ?";

        User user = new User();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, userName);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String password = rs.getString(4);

                if (userPassword.equals(password)) {
                    System.out.println("비밀번호 일치 " + password);
                    user.setId(rs.getInt(1));
                    user.setName(rs.getString(2));
                    user.setFullName(rs.getString(3));
                    user.setPassword(rs.getString(4));
                    user.setEmail(rs.getString(5));
                    user.setAge(rs.getInt(6));
                    user.setCreateDate(rs.getTimestamp(7));
                }
            } else {
                user = null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


    /**
     * 회원 정보 가져오기 
     */
    public User getUserInfo(long userId) {
        Connection connection = getConnection();

        String query = "select * from user2 where id like ?";

        User user = new User();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setLong(1, userId);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setFullName(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setAge(rs.getInt(6));
                user.setCreateDate(rs.getTimestamp(7));
            } else {
                return null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return user;
    }
}
