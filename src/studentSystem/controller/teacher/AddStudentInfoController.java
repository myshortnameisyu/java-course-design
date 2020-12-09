package studentSystem.controller.teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import studentSystem.MyException.UserIsExistException;
import studentSystem.pojo.Student;
import studentSystem.pojo.Teacher;
import studentSystem.utils.SimpleTools;
import studentSystem.utils.StudentTool;
import studentSystem.utils.TeacherTool;

import java.io.IOException;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class AddStudentInfoController {

    @FXML
    private TextField inputStudentNum;

    @FXML
    private TextField inputPhone;

    @FXML
    private Label usernameLabel;

    @FXML
    private RadioButton inputWoman;

    @FXML
    private TextField inputName;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label sexLabel;

    @FXML
    private Label infoLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private TextField inputUsername;

    @FXML
    private Label studentNumLabel;

    @FXML
    private TextField inputAge;

    @FXML
    private Label ageLabel;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private RadioButton inputMan;

    @FXML
    private Label nameLabel;

    @FXML
    private Button addButton;

    @FXML
    private Button resetButton;

    private SimpleTools simpleTools = new SimpleTools();

    public void initialize() {
        Labeled[] labeleds = {infoLabel, studentNumLabel, usernameLabel, passwordLabel, nameLabel, sexLabel, ageLabel, phoneLabel,
        addButton, resetButton};
        String[] imagePaths = {"src/studentSystem/images/teacher2.png", "src/studentSystem/images/workNum1.png",
                "src/studentSystem/images/userName.png", "src/studentSystem/images/password.png",
                "src/studentSystem/images/name1.png", "src/studentSystem/images/sex1.png",
                "src/studentSystem/images/age1.png", "src/studentSystem/images/phone1.png",
                "src/studentSystem/images/add1.png", "src/studentSystem/images/reset.png"};
        simpleTools.setLabeledImage(labeleds, imagePaths);
    }

    public void addStudent(ActionEvent actionEvent) throws IOException, UserIsExistException {
        String studentNum = inputStudentNum.getText();
        String username = inputUsername.getText();
        String password = inputPassword.getText();
        String name = inputName.getText();
        String age = inputAge.getText();
        String phone = inputPhone.getText();
        String sex = null;
        if (inputMan.isSelected()){
            sex = inputMan.getText();
        }else if (inputWoman.isSelected()){
            sex = inputWoman.getText();
        }
        Student student = new Student(Student.idCount, username, password, 2, name, sex, Integer.parseInt(age), phone, studentNum);
        boolean isOk = StudentTool.addNewPer(student);
        if (isOk){
            reset();
            simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "添加成功！");
        }else {
            simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "添加失败！");
        }
    }

    public void reset() {
        simpleTools.clearTextField(inputStudentNum, inputUsername, inputPassword, inputName, inputAge, inputPhone);
        simpleTools.clearSelectedRadioButton(inputMan, inputWoman);
    }

    public void clickMan(ActionEvent actionEvent) {
        inputWoman.setSelected(false);
    }

    public void clickWoman(ActionEvent actionEvent) {
        inputMan.setSelected(false);
    }

}
