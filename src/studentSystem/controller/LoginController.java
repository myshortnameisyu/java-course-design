package studentSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import studentSystem.Main;
import studentSystem.pojo.Admin;
import studentSystem.pojo.Student;
import studentSystem.pojo.Teacher;
import studentSystem.utils.AdminTool;
import studentSystem.utils.SimpleTools;
import studentSystem.utils.StudentTool;
import studentSystem.utils.TeacherTool;

import java.io.IOException;

/**
 * @author D.hu
 * @date 2020/12/5
 * @desc
 */
public class LoginController {

    @FXML
    private PasswordField password;

    @FXML
    private Label systemName;

    @FXML
    private Label userNameLabel;

    @FXML
    private Button reset;

    @FXML
    private Button login;

    @FXML
    private ComboBox<?> comboBox;

    @FXML
    private TextField username;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label identityLabel;

    private SimpleTools simpleTools = new SimpleTools();

    @FXML
    private Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize() {
        // 给组件添加图标
        Labeled[] labeleds = {systemName, userNameLabel, passwordLabel, login, reset, identityLabel};
        String[] imagePaths = {"src/studentSystem/images/student.png", "src/studentSystem/images/userName.png",
                "src/studentSystem/images/password.png","src/studentSystem/images/login.png", "src/studentSystem/images/reset.png",
                "src/studentSystem/images/name1.png"};
        simpleTools.setLabeledImage(labeleds, imagePaths);
        String[] identity = {"教师", "学生", "管理员"};
        simpleTools.addComboBoxItems(comboBox, identity);
    }

    @FXML
    public void loginEvent(ActionEvent event) throws IOException {
        stage.close();
//        new Main().initAdminMainFrame();
//        new Main().initTeacherMainFrame();
//        new Main().initStudentMainFrame();
        if (comboBox.getValue().equals("学生")){
            Student student = StudentTool.getStudentByUserName(username.getText());
            boolean isOk = simpleTools.isStudentLogin(username.getText(), password.getText(), student);
            if (isOk){
                new Main().initStudentMainFrame();
            }
        }
        if (comboBox.getValue().equals("教师")){
            Teacher teacher = TeacherTool.getTeacherByUserName(username.getText());
            boolean isOk = simpleTools.isTeacherLogin(username.getText(), password.getText(), teacher);
            if (isOk){
                new Main().initTeacherMainFrame();
            }
        }
        if (comboBox.getValue().equals("管理员")){
            Admin admin = AdminTool.getAdminByUsername(username.getText());
            boolean isOk = simpleTools.isAdminLogin(username.getText(), password.getText(), admin);
            if (isOk){
                new Main().initAdminMainFrame();
            }
        }
    }


    @FXML
    public void resetEvent(ActionEvent event) {
        username.setText("");
        password.setText("");
    }

}
