package board;

import java.util.List;
import java.util.Map;

import board.beans.Board;
import board.beans.BoardPost;
import board.beans.User;

/**
 * 게시판 서비스 인터페이스
 */
public interface BoardService {
    /**
     * 게시글 상세 보기
     * 
     * @param id
     * @return
     */
    BoardPost getBoardPost(Board board, long id);

    /**
     * 게시글 전체보기
     * 
     * @param subject
     * @return
     */
    List<BoardPost> getAllBoardPosts(Board board, Map<String, Object> conditionMap);


    /**
     * boardpost 객체 생성
     * 
     * @param request
     * @param user
     * @return
     */
    BoardPost newBoardPost(String title, String content, String creatorId);

    /**
     * 게시글 작성하기
     * 
     * @param boardPost
     * @return
     */
    BoardPost createBoardPost(Board board, BoardPost boardPost);

    /**
     * 게시판 관리자 정보 확인하기
     * 
     * @param board
     * @param user
     * @return
     */
    boolean isAdmin(Board board, User user);

    /**
     * 게시판 삭제하기
     * 
     * @param board
     * @param id
     * @param user
     * @return
     */
    BoardPost deleteBoardPost(Board board, long id, User user);
}
