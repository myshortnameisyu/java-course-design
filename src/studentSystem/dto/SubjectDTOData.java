package studentSystem.dto;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class SubjectDTOData {

    private SimpleStringProperty name;

    private SimpleStringProperty sex;

    private SimpleStringProperty age;

    private SimpleStringProperty studentNum;

    private SimpleStringProperty Chinese;

    private SimpleStringProperty Math;

    private SimpleStringProperty English;

    private SimpleStringProperty Physics;

    private SimpleStringProperty Chemistry;

    private SimpleStringProperty Biology;

    private SimpleStringProperty sum;

    public SubjectDTOData(String name, String sex, String age, String studentNum, String chinese, String math, String english, String physics, String chemistry, String biology, String sum) {
        this.name = new SimpleStringProperty(name);
        this.sex = new SimpleStringProperty(sex);
        this.age = new SimpleStringProperty(age);
        this.studentNum = new SimpleStringProperty(studentNum);
        this.Chinese = new SimpleStringProperty(chinese);
        this.Math = new SimpleStringProperty(math);
        this.English = new SimpleStringProperty(english);
        this.Physics = new SimpleStringProperty(physics);
        this.Chemistry = new SimpleStringProperty(chemistry);
        this.Biology = new SimpleStringProperty(biology);
        this.sum = new SimpleStringProperty(sum);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSex() {
        return sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getStudentNum() {
        return studentNum.get();
    }

    public SimpleStringProperty studentNumProperty() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum.set(studentNum);
    }

    public String getChinese() {
        return Chinese.get();
    }

    public SimpleStringProperty chineseProperty() {
        return Chinese;
    }

    public void setChinese(String chinese) {
        this.Chinese.set(chinese);
    }

    public String getMath() {
        return Math.get();
    }

    public SimpleStringProperty mathProperty() {
        return Math;
    }

    public void setMath(String math) {
        this.Math.set(math);
    }

    public String getEnglish() {
        return English.get();
    }

    public SimpleStringProperty englishProperty() {
        return English;
    }

    public void setEnglish(String english) {
        this.English.set(english);
    }

    public String getPhysics() {
        return Physics.get();
    }

    public SimpleStringProperty physicsProperty() {
        return Physics;
    }

    public void setPhysics(String physics) {
        this.Physics.set(physics);
    }

    public String getChemistry() {
        return Chemistry.get();
    }

    public SimpleStringProperty chemistryProperty() {
        return Chemistry;
    }

    public void setChemistry(String chemistry) {
        this.Chemistry.set(chemistry);
    }

    public String getBiology() {
        return Biology.get();
    }

    public SimpleStringProperty biologyProperty() {
        return Biology;
    }

    public void setBiology(String biology) {
        this.Biology.set(biology);
    }

    public String getSum() {
        return sum.get();
    }

    public SimpleStringProperty sumProperty() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum.set(sum);
    }
}
