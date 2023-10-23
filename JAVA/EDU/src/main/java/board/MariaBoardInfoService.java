package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.beans.Board;

public class MariaBoardInfoService extends ServiceManager implements BoardInfoService {

    /**
     * 게시판 정보 조회
     * 
     * @param id
     * @return
     */
    public Board getBoard(long id) {
        Connection connection = getConnection();
        Board board = null;

        String sql = "SELECT * FROM board WHERE id LIKE ? ;";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                board = new Board(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getTimestamp(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return board;
    }

    /**
     * 게시판 name에 해당하는 게시판 정보를 조회, 찾지 못하면 null return
     * 
     * @param name
     */
    public Board getBoardByName(String name) {
        Board board = null;
        Connection connection = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM board WHERE NAME LIKE ? ;";

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                board = new Board(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getTimestamp(5));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return board;
    }

    /**
     * 게시판 전체 정보 조회
     * 
     * @return
     */
    public List<Board> getAllBoard() {
        List<Board> boardList = new ArrayList<>();
        Connection connection = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM board;";
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                boardList.add(new Board(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getTimestamp(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return boardList;
    }
}
