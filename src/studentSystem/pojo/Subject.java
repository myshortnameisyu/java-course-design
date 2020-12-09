package studentSystem.pojo;

import java.io.Serializable;

/**
 * 成绩实体类
 */
public class Subject implements Serializable, Comparable<Subject>{

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    private String studentNum;

    /**
     * 语文
     */
    private Integer Chinese;

    /**
     * 数学
     */
    private Integer Math;

    /**
     * 英语
     */
    private Integer English;

    /**
     * 物理
     */
    private Integer Physics;

    /**
     * 化学
     */
    private Integer Chemistry;

    /**
     * 生物
     */
    private Integer Biology;

    /**
     * 总分
     */
    private Integer sum;

    public Subject() {
    }

    public Subject(String studentNum, Integer chinese, Integer math, Integer english, Integer physics, Integer chemistry, Integer biology) {
        this.studentNum = studentNum;
        Chinese = chinese;
        Math = math;
        English = english;
        Physics = physics;
        Chemistry = chemistry;
        Biology = biology;
        this.sum = chinese + math + english + physics + chemistry + biology;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getChinese() {
        return Chinese;
    }

    public void setChinese(Integer chinese) {
        Chinese = chinese;
    }

    public Integer getMath() {
        return Math;
    }

    public void setMath(Integer math) {
        Math = math;
    }

    public Integer getEnglish() {
        return English;
    }

    public void setEnglish(Integer english) {
        English = english;
    }

    public Integer getPhysics() {
        return Physics;
    }

    public void setPhysics(Integer physics) {
        Physics = physics;
    }

    public Integer getChemistry() {
        return Chemistry;
    }

    public void setChemistry(Integer chemistry) {
        Chemistry = chemistry;
    }

    public Integer getBiology() {
        return Biology;
    }

    public void setBiology(Integer biology) {
        Biology = biology;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String subject = "成绩：" + "Chinese: " + this.getChinese() + ", Math: " + this.getMath()
                + ", English: " + this.getEnglish() + ", Physics: " + this.getPhysics()
                + ", Chemistry: " + this.getChemistry() + ", Biology: " + this.getBiology()
                + ", sum: " + this.getSum();
        stringBuffer.append(subject);
        return stringBuffer.toString();
    }

    @Override
    public int compareTo(Subject o) {
        return this.sum.compareTo(o.getSum());
    }
}
