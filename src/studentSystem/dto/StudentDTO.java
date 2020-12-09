package studentSystem.dto;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class StudentDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份（1 学生 2 老师）
     */
    private Integer identity;

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
     * 联系方式
     */
    private String phone;

    /**
     * 学号
     */
    private String studentNum;

    public StudentDTO(String username, String password, Integer identity, String name, String sex, Integer age, String phone, String studentNum) {
        this.username = username;
        this.password = password;
        this.identity = identity;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.studentNum = studentNum;
    }

    public StudentDTO() {
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

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
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

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }
}
