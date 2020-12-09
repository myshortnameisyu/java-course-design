package studentSystem.dto;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc 返回学生成绩出参
 */
public class SubjectDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

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

    public SubjectDTO(Integer id, String name, String sex, Integer age, String studentNum, Integer chinese, Integer math, Integer english, Integer physics, Integer chemistry, Integer biology, Integer sum) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.studentNum = studentNum;
        Chinese = chinese;
        Math = math;
        English = english;
        Physics = physics;
        Chemistry = chemistry;
        Biology = biology;
        this.sum = sum;
    }

    public SubjectDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}
