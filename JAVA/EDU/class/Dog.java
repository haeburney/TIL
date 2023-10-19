package inherit;

import runningmachine.Runner;

/**
 * 강아지 클래스, 동물 상속
 */
public class Dog extends Animal {
    /** 품종 */
    private String kind;

    /**
     * 강아지가 달린다
     */
    @Override
    public void run() {
        System.out.println("강아지가 뛴다.");
    }

    /**
     * 짖는다
     */
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
