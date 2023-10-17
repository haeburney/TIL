package work.practice.runningmachine;

public class Animal {
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
