package person;

// TODO : 파일명과 동일하게
// TODO : Inner 클래스 불필요
/**
 * 사람 클래스 : 걷기, 말하기
 */
public class Person {
    /** 이름 */
    private String name;
    /** 성별 */
    private String gender;
    /** 나이 */
    private int age;

    /**
     * 생성자
     */
    public Person() {
        // Do nothing
    }

    /**
     * 생성자
     * 
     * @param name
     * @param gender
     * @param age
     */
    public Person(String name, String gender, int age) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
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
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * 걷는다
     */
    void work() {
        System.out.println("걷는다.");
    }

    /**
     * 달린다
     * 
     * @param word
     */
    void say(String word) {
        System.out.println(word);
    }

    /**
     * 사용자 입력에 따라 걷기 또는 말하기 동작 실행 Usage : java Person walk
     * 
     * @param args
     */
    public static void main(String[] args) {
        Person hong = new Person("홍길동", "남자", 18);

        if (args.length > 0 && args[0].equals("walk")) {
            hong.work();
        } else {
            hong.say(hong.getName() + "(이)가 말한다.");
        }

    }

}
