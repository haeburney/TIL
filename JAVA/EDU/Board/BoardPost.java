package net.innofactory.lecture.hkim.board.beans;

import java.sql.Timestamp;

public class BoardPost {
    private long id;
    private String subject;
    private String content;
    private String creatorFullName;
    private Timestamp createDate;
    
    public BoardPost() {
        
    }
    
    public BoardPost(long id, String subject, String content, String creatorFullName, Timestamp createDate) {
        super();
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.creatorFullName = creatorFullName;
        this.createDate = createDate;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getCreatorFullName() {
        return creatorFullName;
    }
    public void setCreatorFullName(String creatorFullName) {
        this.creatorFullName = creatorFullName;
    }
    public Timestamp getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    
    @Override
    public String toString() {
        return "BoardPost [id=" + id + ", subject=" + subject + ", content=" + content + ", creatorFullName=" + creatorFullName
                        + ", createDate=" + createDate + "]";
    }
    
    
}
