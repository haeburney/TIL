package board.beans;

import java.sql.Timestamp;

/**
 * 게시판
 */
public class BoardPost {
    /** 글번호 */
    private long id;
    /** 제목 */
    private String subject;
    /** 내용 */
    private String content;
    /** 사용자 */
    private User creator;
    /** 작성 날짜 */
    private Timestamp createDate;
    /** 게시판 정보 */
    private Board board;

    /**
     * 생성자
     */
    public BoardPost() {
        // Do nothing
    }

    /**
     * 
     * 생성자
     * 
     * @param id
     * @param subject
     * @param content
     * @param creator
     * @param createDate
     * @param board
     */
    public BoardPost(long id, String subject, String content, User creator, Timestamp createDate, Board board) {
        super();
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.creator = creator;
        this.createDate = createDate;
        this.board = board;
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
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the creator
     */
    public User getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(User creator) {
        this.creator = creator;
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

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "BoardPost [id=" + id + ", subject=" + subject + ", content=" + content + ", creator=" + creator + ", createDate="
                        + createDate + ", board=" + board + "]";
    }



}
