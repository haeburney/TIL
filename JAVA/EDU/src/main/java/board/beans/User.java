package board.beans;

import java.sql.Timestamp;

/**
 * 사용자
 */
public class User {
    /** 사용자 고유 ID */
    private long id;
    /** 영어 이름 */
    private String name;
    /** 한국어 이름 */
    private String fullName;
    /** 비밀번호 */
    private String password;
    /** 이메일 */
    private String email;
    /** 나이 */
    private int age;
    /** 가입 날짜 */
    private Timestamp createDate;

    /**
     * 생성자
     */
    public User() {
        // Do nothing
    }

    /**
     * 생성자
     * 
     * @param name
     * @param age
     */
    public User(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    /**
     * 생성자
     * 
     * @param id
     * @param name
     * @param fullName
     * @param password
     * @param email
     * @param age
     * @param createDate
     */
    public User(long id, String name, String fullName, String password, String email, int age, Timestamp createDate) {
        super();
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.age = age;
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
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
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
        return "User [id=" + id + ", name=" + name + ", fullName=" + fullName + ", password=" + password + ", email=" + email
                        + ", age=" + age + ", createDate=" + createDate + "]";
    }

    
}
