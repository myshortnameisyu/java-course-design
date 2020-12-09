package studentSystem.pojo;

import java.io.Serializable;

/**
 * 教师实体类
 */
public class Teacher extends User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static int idCount = 0;

    private String workNum;

    public Teacher(Integer id, String username, String password, Integer identity, String name, String sex, Integer age, String phone, String workNum) {
        super(id, username, password, identity, name, sex, age, phone);
        this.workNum = workNum;
        idCount++;
    }

    public Teacher() {
    }

    public Teacher(String workNum) {
        this.workNum = workNum;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String user = "ID: " + this.getId() + ", 用户名: " + this.getUsername() + ", 密码: " + this.getPassword()
                + ", 身份: " + this.getIdentity() + ", 姓名: " + this.getName() + ", 性别: " + this.getSex()
                + ", 年龄: " + this.getAge() + ", 联系方式: " + this.getPhone();
        String teacher = "职工号: " + this.getWorkNum();
        stringBuffer.append(user);
        stringBuffer.append(", ");
        stringBuffer.append(teacher);
        return stringBuffer.toString();
    }
}
