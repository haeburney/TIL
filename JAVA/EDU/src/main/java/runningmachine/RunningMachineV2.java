package runningmachine;

import inherit.Animal;
import inherit.Dog;
import inherit.Human;

// TODO 클래스명을 파일명과 동일하게..
// TODO Inner 클래스 불필요
/**
 * 런닝머신2
 */
public class RunningMachineV2 {
    /** 속도 */
    private int speed;
    /** 달리는 동물 */
    private Animal runner;

    /**
     * 기계 구동하기
     */
    public void play() {
        System.out.println("기계를 구동한다. 이제 달려야 한다.");
        runner.run();
    }

    /**
     * 기계 멈추기
     */
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

    /**
     * RunningMachineV1 클래스를 사용하여 기계 구동, 사람과 강아지 달리기
     * 
     * @param agrs
     */
    public static void main(String[] args) {
        RunningMachineV2 runningMachine = new RunningMachineV2();
        Dog dog = new Dog();
        Human human = new Human();
        
        runningMachine.setRunner(human);
        runningMachine.setSpeed(20);
        runningMachine.play();
        runningMachine.setRunner(dog);
        runningMachine.setSpeed(20);
        runningMachine.play();
    }
}
