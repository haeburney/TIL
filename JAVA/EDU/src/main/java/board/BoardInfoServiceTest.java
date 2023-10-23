/**
 * 
 */
package board;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import board.beans.Board;

/**
 * 
 */
class BoardInfoServiceTest {

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
     * Test method for {@link board.BoardInfoService#getBoard(long)}.
     */
    @Test
    void testGetBoard() {
        long id = 1;
        BoardInfoService boardInfoService = new MariaBoardInfoService();
        
        Board board = boardInfoService.getBoard(id);
        System.out.println(">> board=" + board);
    }

    /**
     * Test method for {@link board.BoardInfoService#getBoardByName(java.lang.String)}.
     */
    @Test
    void testGetBoardByName() {
        BoardInfoService boardInfoService = new MariaBoardInfoService();
        String name = "notice";
        Board board = boardInfoService.getBoardByName(name);
        System.out.println(">> board=" + board);
    }

    /**
     * Test method for {@link board.BoardInfoService#getAllBoard()}.
     */
    @Test
    void testGetAllBoard() {
        BoardInfoService boardInfoService = new MariaBoardInfoService();
        List<Board> BoardList = boardInfoService.getAllBoard();
        System.out.println(">> BoardList=" + BoardList);
    }

}
