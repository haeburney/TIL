package work.practice.runningmachine;

import work.practice.runningmachine.Runner;

public class Human extends Animal implements Runner {
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
