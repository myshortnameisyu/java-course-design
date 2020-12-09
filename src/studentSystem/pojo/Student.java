package studentSystem.pojo;

import java.io.Serializable;

/**
 * 学生实体类
 */
public class Student extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static int idCount = 1;

    /**
     * 学号
     */
    private String studentNum;


    public Student(Integer id, String username, String password, Integer identity, String name, String sex, Integer age, String phone, String studentNum) {
        super(id, username, password, identity, name, sex, age, phone);
        this.studentNum = studentNum;
        idCount++;
    }

    public Student(String studentNum) {
        this.studentNum = studentNum;
    }

    public Student() {
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String user = "ID: " + this.getId() + ", 用户名: " + this.getUsername() + ", 密码: " + this.getPassword()
                + ", 身份: " + this.getIdentity() + ", 姓名: " + this.getName() + ", 性别: " + this.getSex()
                + ", 年龄: " + this.getAge() + ", 联系方式: " + this.getPhone();
        String student = "学号: " + this.getStudentNum();
        stringBuffer.append(user);
        stringBuffer.append(", ");
        stringBuffer.append(student);
        return stringBuffer.toString();
    }
}
