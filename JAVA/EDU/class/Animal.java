package inherit;

import runningmachine.Runner;

/**
 * 동물 클래스
 */
public class Animal implements Runner {
    /** 체중 */
    private int weight;

    /**
     * 동물이 달린다
     */
    public void run() {
        System.out.println("동물이 뛴다.");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
