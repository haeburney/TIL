package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import board.beans.Board;
import board.beans.BoardPost;
import board.beans.User;

public class MariaBoardService extends ServiceManager implements BoardService {

    private BoardInfoService boardInfoService = new MariaBoardInfoService();

    /**
     * 게시글 상세 보기
     * 
     * @param id
     * @return
     */
    public BoardPost getBoardPost(Board board, long id) {
        Connection connection = getConnection();
        if (connection == null) {
            return null;
        }
        BoardPost boardpost = null;
        // BoardPost returnBoardPost = null;
        String sql = "SELECT a.id, a.subject, a.content, a.createDate, b.id AS creatorId, b.name AS creatorName, b.fullName AS creatorFullName, a.boardId "
                        + " FROM boardpost a, user2 b " + "WHERE a.id LIKE ? AND a.creatorId=b.id; ";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        System.out.println("하이");
        try {
            // TODO 파라메터 바인딩
            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            // pstmt.setLong(0, id);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                User creator = new User();
                long id2 = rs.getLong(1);
                String postSubject = rs.getString(2);
                String content = rs.getString(3);
                Timestamp dateString = rs.getTimestamp(4);

                creator.setId(rs.getLong(5));
                creator.setName(rs.getString(6));
                creator.setFullName(rs.getString(7));
                board.setId(rs.getLong(8));

                boardpost = new BoardPost(id2, postSubject, content, creator, dateString, board);
                System.out.println("boardPost" + boardpost);
            } else {

                System.out.println("검색항목 없음");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // TODO 중괄호는 생략 안함
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

        return boardpost;
    }

    /**
     * 게시글 전체보기
     * 
     * @param subject
     * @return
     */
    // TODO getAllBoardPosts()
    public List<BoardPost> getAllBoardPosts(Board board, Map<String, Object> conditionMap) {
        List<BoardPost> boardPosts = new ArrayList<BoardPost>();
        String query = "";
        String escapedSubject = "";

        String subject = String.valueOf(conditionMap.get("subject"));
        // System.out.println("subject :" + subject);
        System.out.println(board.getId());

        // subject에 값이 있다면 결과값 보여주기 / 아니라면 전체 목록 보여주기
        if (subject == null || subject.equals("") || subject.equals("null")) {
            if (board.getId() != 0) {
                query = "SELECT a.id, a.subject, a.content, a.createDate, b.id AS creatorId, b.name AS creatorName, b.fullName AS creatorFullName, a.boardId"
                                + " FROM boardpost a, user2 b " + " WHERE a.creatorId = b.id and a.boardId = ? ";
            } else {
                query = "SELECT a.id, a.subject, a.content, a.createDate, b.id AS creatorId, b.name AS creatorName, b.fullName AS creatorFullName, a.boardId"
                                + " FROM boardpost a, user2 b " + " WHERE a.creatorId = b.id ";
            }


        } else {
            query = "SELECT a.id, a.subject, a.content, a.createDate, b.id AS creatorId, b.name AS creatorName, b.fullName AS creatorFullName, a.boardId "
                            + " FROM boardpost a, user2 b " + " WHERE a.subject like ? and a.creatorId = b.id ";
            escapedSubject = (subject.contains("%") ? subject.replace("%", "\\%") : subject);
        }

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        System.out.println(query);

        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(query);

            if (board.getId() != 0) {
                pstmt.setLong(1, board.getId());
            } else if (subject != null) {
                pstmt.setString(1, "%" + escapedSubject + "%");
            }

            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                User creator = new User();
                long id = resultSet.getLong(1);
                String postSubject = resultSet.getString(2);
                String content = resultSet.getString(3);
                Timestamp dateString = resultSet.getTimestamp(4);

                creator.setId(resultSet.getLong(5));
                creator.setName(resultSet.getString(6));
                creator.setFullName(resultSet.getString(7));

                Board board2 = boardInfoService.getBoard(resultSet.getLong(8));

                BoardPost addBoardPost = new BoardPost(id, postSubject, content, creator, dateString, board2);
                boardPosts.add(addBoardPost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return boardPosts;
    }


    /**
     * boardpost 객체 생성
     * 
     * @param request
     * @param user
     * @return
     */
    public BoardPost newBoardPost(String title, String content, String creatorId) {
        BoardPost boardPost = new BoardPost();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        boardPost.setSubject(title);
        boardPost.setContent(content);
        boardPost.setCreateDate(timestamp);
        boardPost.setCreator(new User(Long.valueOf(creatorId), null, null, null, null, 0, null));
        System.out.println(boardPost);
        return boardPost;
    }

    /**
     * 게시글 작성하기
     * 
     * @param boardPost
     * @return
     */
    public BoardPost createBoardPost(Board board, BoardPost boardPost) {
        Connection connection = getConnection();

        if (connection == null) {
            return null;
        }

        String insertQuery = "INSERT INTO boardpost (subject, content, creatorId, createDate, boardId) VALUES(?, ?, ?, ?, ?)";
        // String selectQuery = "select * from boardpost where id = LAST_INSERT_ID()";

        PreparedStatement pstmt = null;
        PreparedStatement selectedStatement = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(insertQuery);
            pstmt.setString(1, boardPost.getSubject());
            pstmt.setString(2, boardPost.getContent());
            pstmt.setLong(3, boardPost.getCreator().getId());
            pstmt.setTimestamp(4, boardPost.getCreateDate());
            // pstmt.setLong(5, boardPost.getBoard().getId());
            pstmt.setLong(5, board.getId());

            int num = pstmt.executeUpdate();
            System.out.println(num);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (selectedStatement != null)
                    selectedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return boardPost;
    }

    /**
     * 게시판 관리자 정보 확인
     */
    public boolean isAdmin(Board board, User user) {
        Connection connection = getConnection();

        if (connection == null) {
            return false;
        }

        String query = "select * from boardadminlink where boardId = ? and adminId = ?";

        PreparedStatement pstmt = null;
        PreparedStatement selectedStatement = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setLong(1, board.getId());
            pstmt.setLong(2, user.getId());;

            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (selectedStatement != null)
                    selectedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * 게시판 삭제하기
     */
    public BoardPost deleteBoardPost(Board board, long id, User user) {
        Connection connection = getConnection();
        BoardPost boardPost = new BoardPost();

        if (connection == null) {
            return null;
        }

        String query = "delete from boardpost where id = ? ";

        PreparedStatement pstmt = null;
        PreparedStatement selectedStatement = null;
        ResultSet rs = null;
        System.out.println(board);
        System.out.println(id);
        System.out.println(user);
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setLong(1, id);

            int num = pstmt.executeUpdate();
            if(num > 0) {
                boardPost.setId(id);
                System.out.println("삭제완");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (selectedStatement != null)
                    selectedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return boardPost;
    }
}
