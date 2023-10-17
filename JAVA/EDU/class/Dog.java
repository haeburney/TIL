package work.practice.runningmachine;

import work.practice.runningmachine.Runner;

public class Dog extends Animal implements Runner {
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
