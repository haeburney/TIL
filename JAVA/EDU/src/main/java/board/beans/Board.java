package board.beans;

import java.sql.Timestamp;

/**
 * 게시판 정보를 저장
 */
public class Board {
    /** 게시판 정보 ID */
    private long id;
    /** 게시판 영문명 */
    private String name;
    /** 게시판 한글명 */
    private String title;
    /** 댓글 지원 여부 */
    private boolean commentEnabled;
    /** 등록 여부 */
    private Timestamp createDate;

    /**
     * 생성자
     */
    public Board() {
        // Do Nothing
    }

    /**
     * 생성자
     * 
     * @param id
     * @param name
     * @param title
     * @param commentEnabled
     * @param createDate
     */
    public Board(long id, String name, String title, boolean commentEnabled, Timestamp createDate) {
        super();
        this.id = id;
        this.name = name;
        this.title = title;
        this.commentEnabled = commentEnabled;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the commentEnabled
     */
    public boolean isCommentEnabled() {
        return commentEnabled;
    }

    /**
     * @param commentEnabled the commentEnabled to set
     */
    public void setCommentEnabled(boolean commentEnabled) {
        this.commentEnabled = commentEnabled;
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
        return "Board [id=" + id + ", name=" + name + ", title=" + title + ", commentEnabled=" + commentEnabled + ", createDate="
                        + createDate + "]";
    }


}
