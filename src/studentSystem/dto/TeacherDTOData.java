package studentSystem.dto;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author D.hu
 * @date 2020/12/7
 * @desc
 */
public class TeacherDTOData {

    private SimpleStringProperty workNum;

    private SimpleStringProperty username;

    private SimpleStringProperty password;

    private SimpleStringProperty name;

    private SimpleStringProperty sex;

    private SimpleStringProperty age;

    private SimpleStringProperty phone;

    public TeacherDTOData(String workNum, String username, String password, String name, String sex, String age, String phone) {
        this.workNum = new SimpleStringProperty(workNum);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.name = new SimpleStringProperty(name);
        this.sex = new SimpleStringProperty(sex);
        this.age = new SimpleStringProperty(age);
        this.phone = new SimpleStringProperty(phone);
    }

    public String getWorkNum() {
        return workNum.get();
    }

    public SimpleStringProperty workNumProperty() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum.set(workNum);
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
}
