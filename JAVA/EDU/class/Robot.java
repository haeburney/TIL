package inherit;

import runningmachine.Runner;

/**
 * 로봇 클래스
 */
public class Robot implements Runner {
    /** 무게 */
    private int weight;
    /** 건전지 개수 */
    private int batteryCount;

    /**
     * 로봇이 달린다
     */
    public void run() {
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

