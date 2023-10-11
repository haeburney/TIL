package net.innofactory.lecture.hkim;

class Person1 {
    private String name; // 이름
    private String gender; // 성별
    private int age; // 나이

    public Person1() {

    }

    public Person1(String name, String gender, int age) {
        super();
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 걷기
    void work() {
        System.out.println("걷는다.");
    }

    // 말하기
    void say(String word) {
        System.out.println(word);
    }
}


public class Person {
    public static void main(String[] args) {
        Person1 hong = new Person1("홍길동", "남자", 18);

        if (args.length > 0 && args[0].equals("walk")) {
            hong.work();
        } else {
            hong.say(hong.getName() + "(이)가 말한다.");
        }

    }

}
