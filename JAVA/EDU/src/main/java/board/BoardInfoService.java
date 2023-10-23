package board;

import java.util.List;

import board.beans.Board;

/**
 * 게시판 정보 인터페이스
 */
public interface BoardInfoService {
    /**
     * 게시판 정보 조회
     * 
     * @param id
     * @return
     */
    public Board getBoard(long id);

    /**
     * 게시판 name에 해당하는 게시판 정보를 조회, 찾지 못하면 null return
     * 
     * @param name
     */
    public Board getBoardByName(String name);

    /**
     * 게시판 전체 정보 조회
     * 
     * @return
     */
    public List<Board> getAllBoard();
}
