
class Animal { // 동물
    private int weight; // 체중

    public void run() { // 뛰기
        System.out.println("동물이 뛴다.");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}


class Dog extends Animal implements Runner { // 개
    private String kind; // 품종

    @Override
    public void run() { // 뛰기
        System.out.println("강아지가 뛴다.");
    }

    public void bark() { // 짖기
        System.out.println("강아지가 짖는다");
    }
    
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
    
}


class Human extends Animal { // 사람
    private String bloodType; // 혈액형

    @Override
    public void run() { // 뛴다
        System.out.println("사람이 뛴다.");
    }

    public void say(String word) { // 말하기
        System.out.println(word);
    }
    
    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}


class Robot implements Runner { // 로봇
    private int weight; // 무게
    private int batteryCount; // 건전지갯수

    public void run() { // 뛴다
        System.out.println("로봇이 뛴다.");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBatteryCount() {
        return batteryCount;
    }

    public void setBatteryCount(int batteryCount) {
        this.batteryCount = batteryCount;
    }
}


public class Inheritance {
    public static void main(String[] args) {

    }

}
