package studentSystem.dto;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class StudentDTOData {

    private SimpleStringProperty username;

    private SimpleStringProperty password;

    private SimpleStringProperty identity;

    private SimpleStringProperty name;

    private SimpleStringProperty sex;

    private SimpleStringProperty age;

    private SimpleStringProperty phone;

    private SimpleStringProperty studentNum;

    public StudentDTOData(String username, String password, String identity, String name, String sex, String age, String phone, String studentNum) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.identity = new SimpleStringProperty(identity);
        this.name = new SimpleStringProperty(name);
        this.sex = new SimpleStringProperty(sex);
        this.age = new SimpleStringProperty(age);
        this.phone = new SimpleStringProperty(phone);
        this.studentNum = new SimpleStringProperty(studentNum);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getIdentity() {
        return identity.get();
    }

    public SimpleStringProperty identityProperty() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity.set(identity);
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

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
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
}
