package runningmachine;

import inherit.Dog;
import inherit.Human;
import inherit.Robot;

// TODO 클래스명을 파일명과 동일하게..
// TODO Inner 클래스 불필요
/**
 * 런닝머신3
 */
public class RunningMachineV3 {
    /** 속도 */
    private int speed; // 속도
    /** 인터페이스 달리다 */
    private Runner runner;

    /**
     * 기계 구동하기
     */
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

    /**
     * RunningMachineV3 클래스를 사용하여 기계 구동, 강아지와 로봇과 사람 달리기
     * 
     * @param agrs
     */
    public static void main(String[] args) {
        RunningMachineV3 runningMachine = new RunningMachineV3();
        Dog myDog = new Dog();
        runningMachine.setRunner(myDog);
        runningMachine.play();

        Runner myRobot = new Robot();
        runningMachine.setRunner(myRobot);
        runningMachine.play();

        Human human = new Human();
        runningMachine.setRunner(human);
        runningMachine.play();
    }
}
