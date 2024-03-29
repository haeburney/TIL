package work.practice.runningmachine;

public class RunningMachineV3 {
	private int speed; // 속도
	private Runner runner;

	public void play() {
		System.out.println("기계를 구동한다. 이제 달려야 한다.");
		this.runner.run();
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Runner getRunner() {
		return runner;
	}

	public void setRunner(Runner runner) {
		this.runner = runner;
	}

	public static void main(String[] args) {
		RunningMachineV3 runningMachine = new RunningMachineV3();
		Dog myDog = new Dog();
		runningMachine.setRunner(myDog);
		runningMachine.play();
/*
		Runner myRobot = new Robot();
		runningMachine.setRunner(myRobot);
		runningMachine.play();
		
		Human human = new Human();
		runningMachine.setRunner(human);
		runningMachine.play();
		*/
	}
}
