package inherit;

import runningmachine.Runner;

/**
 * 사람 클래스, 동물 상속
 */
public class Human extends Animal {
    /** 혈액형 */
    private String bloodType;

    /**
     * 사람이 달린다
     */
    @Override
    public void run() {
        System.out.println("사람이 뛴다.");
    }

    /**
     * 사람이 말한다
     * 
     * @param word
     */
    public void say(String word) {
        System.out.println(word);
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}

