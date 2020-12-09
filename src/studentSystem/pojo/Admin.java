package studentSystem.pojo;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class Admin extends User {

    private String workNum;

    public Admin(Integer id, String username, String password, Integer identity, String name, String sex, Integer age, String phone, String workNum) {
        super(id, username, password, identity, name, sex, age, phone);
        this.workNum = workNum;
    }

    public Admin() {
    }

    public Admin(String workNum) {
        this.workNum = workNum;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

}
