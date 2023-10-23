package runningmachine;

import inherit.Human;

// TODO : RunningMachineV_1 을 파일명과 동일하게 변경. V2, V3 도 모두 동일 적용
// TODO : Inner Class 불필요. setRunner() 위로 메인 메쏘드 이동. V2, V3 도 모두 동일 적용
/**
 * 런닝머신1
 */
public class RunningMachineV1 {
    /** 속도 */
    private int speed;
    /** 달리는 사람 */
    private Human runner;

    /**
     * 기계 구동하기
     */
    public void play() {
        System.out.println("기계를 구동한다. 사람은 이제 달려야 한다.");
        runner.run();
    }

    /**
     * 멈추기
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

    public Human getRunner() {
        return runner;
    }

    public void setRunner(Human runner) {
        this.runner = runner;
    }

    /**
     * RunningMachineV1 클래스를 사용하여 기계 구동, 사람 달리기
     * 
     * @param agrs
     */
    public static void main(String[] agrs) {
        RunningMachineV1 runningMachine = new RunningMachineV1();
        Human people = new Human();
        runningMachine.setRunner(people);
        runningMachine.setSpeed(10);
        runningMachine.play();
    }
}
