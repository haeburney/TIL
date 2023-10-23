package board.beans;

import java.sql.Timestamp;

/**
 * 게시판 관리자
 */
public class BoardAdminLink {
    /** id 식별자 */
    private long id;
    /** 게시판 정보 */
    private Board board;
    /** 관리자 */
    private User admin;
    /** 등록일 */
    private Timestamp createDate;

    /**
     * 생성자
     */
    public BoardAdminLink() {

    }

    /**
     * 생성자
     * 
     * @param id
     * @param board
     * @param admin
     * @param createDate
     */
    public BoardAdminLink(long id, Board board, User admin, Timestamp createDate) {
        super();
        this.id = id;
        this.board = board;
        this.admin = admin;
        this.createDate = createDate;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        if (this.board == null) {
            this.board = new Board();
        }
        return this.board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return the admin
     */
    public User getAdmin() {
        if (this.admin == null) {
            this.admin = new User();
        }
        return this.admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(User admin) {
        this.admin = admin;
    }

    /**
     * @return the createDate
     */
    public Timestamp getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "BoardAdminLink [id=" + id + ", board=" + board + ", admin=" + admin + ", createDate=" + createDate + "]";
    }


}
