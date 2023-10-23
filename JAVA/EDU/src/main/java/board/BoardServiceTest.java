/**
 * 
 */
package board;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import board.beans.Board;
import board.beans.BoardPost;
import board.beans.User;

/**
 * 
 */
class BoardServiceTest {

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
     * 게시글 상세 보기 Test method for {@link board.BoardService#getBoardPost(long)}.
     */
    @Test
    void testGetBoardPost() {
        BoardService boardService = new MariaBoardService();
        long id = 24;
        Board board = new Board(1, "", "", false, null);
        BoardPost boardPost = boardService.getBoardPost(board, id);
        System.out.println(">> boardPost=" + boardPost);
    }

    /**
     * 게시글 전체 보기 Test method for {@link board.BoardService#getAllBoardPosts(java.lang.String)}.
     */
    @Test
    void testGetAllBoardPosts() {
        BoardService boardService = new MariaBoardService();
        HashMap<String, Object> conditionMap = new HashMap<String, Object>();
        // 검색할 boardId 객체 만들기
        Board board = new Board(1, "", "", false, null);
        conditionMap.put("board", board);
        // 검색할 제목 subject 만들기
        String subjectNotNull = "Ditto";
        conditionMap.put("subject", subjectNotNull);

        List<BoardPost> boardPostOne = boardService.getAllBoardPosts(board, conditionMap);

        /*
         * String subject = null; List<BoardPost> boardPosts = boardService.getAllBoardPosts(subject,conditionMap);
         */

        System.out.println(">> boardPostOne=" + boardPostOne);
        // System.out.println(">> boardPosts=" + boardPosts);
    }

    /**
     * 게시글 객체 생성 Test method for {@link board.BoardService#newBoardPost(java.lang.String, java.lang.String, java.lang.String)}.
     */
    @Test
    void testNewBoardPost() {
        BoardService boardService = new MariaBoardService();

        String title = "a Cafela";
        String content = "커피 마셔요옹...";
        String creatorId = "5";

        BoardPost boardPost = boardService.newBoardPost(title, content, creatorId);
        System.out.println(">> boardPost=" + boardPost);
    }

    /**
     * 게시글 작성 Test method for {@link board.BoardService#createBoardPost(board.beans.BoardPost)}.
     */
    @Test
    void testCreateBoardPost() {
        BoardService boardService = new MariaBoardService();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User creator = new User(4, "", "", "", "", 0, null);
        Board board = new Board(1, "", "", true, null);
        BoardPost createBoardPost = new BoardPost(0, "test1", "testContent1", creator, timestamp, board);

        BoardPost boardPost = boardService.createBoardPost(board, createBoardPost);
        System.out.println(">> boardPost=" + boardPost);
    }

    /**
     * 게시판 관리자 확인
     */
    @Test
    void testIdAdmin() {
        BoardService boardService = new MariaBoardService();
        Board board = new Board(1, "", "", true, null);
        User user = new User(5, "", "", "", "", 0, null);

        Boolean check = boardService.isAdmin(board, user);
        System.out.println(">> check=" + check);
    }

    /**
     * 게시판 삭제
     */
    @Test
    void testDeleteBoardPost() {
        BoardService boardService = new MariaBoardService();
        Board board = new Board(1, "", "", true, null);
        User user = new User(5, "", "", "", "", 0, null);
        long id = 30;

        BoardPost boardPost = boardService.deleteBoardPost(board, id, user);
        System.out.println(">> boardPost=" + boardPost);
    }
}
