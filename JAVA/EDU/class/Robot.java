package work.practice.runningmachine;

import work.practice.runningmachine.Runner;

public class Robot implements Runner {
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
