class RunningMachineV_1{
    private int speed;    // 속도
    private Human runner; // 운동하는 사람
    
    public void play() {
        System.out.println("기계를 구동한다. 사람은 이제 달려야 한다.");
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

    public Human getRunner() {
        return runner;
    }

    public void setRunner(Human runner) {
        this.runner = runner;
    }
    
}

public class RunningMachineV1 {
    public static void main(String[] agrs) {
        RunningMachineV_1 runningMachine=new RunningMachineV_1();
        Human people = new Human();
        runningMachine.setRunner(people);
        runningMachine.setSpeed(10);
        runningMachine.play();
    }
}
