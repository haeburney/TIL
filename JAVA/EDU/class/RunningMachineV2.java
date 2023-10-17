package work.practice.runningmachine;

public class RunningMachineV2 {
	private int speed; // 속도
	private Animal runner; // 운동하는 사람

	public void play() {
		System.out.println("기계를 구동한다. 이제 달려야 한다.");
		runner.run();
	}

	public void stop() {
		System.out.println("기계를 멈춘다.");
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Animal getRunner() {
		return runner;
	}

	public void setRunner(Animal runner) {
		this.runner = runner;
	}
	
    public static void main(String[] args) {
	        RunningMachineV2 runningMachine = new RunningMachineV2();
	        Animal dog = new Dog();
	        Animal human = new Human();
	        
	        runningMachine.setRunner(human);
	        runningMachine.setSpeed(20);
	        runningMachine.play();
	        runningMachine.setRunner(dog);
	        runningMachine.setSpeed(20);
	        runningMachine.play();
	    }
}
