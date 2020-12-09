package studentSystem.dto;

/**
 * @author D.hu
 * @date 2020/12/7
 * @desc
 */
public class TeacherDTO {

    private String workNum;

    private String username;

    private String password;

    private String name;

    private String sex;

    private Integer age;

    private String phone;

    public TeacherDTO(String workNum, String username, String password, String name, String sex, Integer age, String phone) {
        this.workNum = workNum;
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
