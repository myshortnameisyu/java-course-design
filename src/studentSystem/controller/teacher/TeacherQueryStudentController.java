package studentSystem.controller.teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import studentSystem.MyException.UserIsExistException;
import studentSystem.MyException.UserNotFoundException;
import studentSystem.dto.StudentDTOData;
import studentSystem.pojo.Student;
import studentSystem.pojo.Teacher;
import studentSystem.utils.SimpleTools;
import studentSystem.utils.StudentTool;
import studentSystem.utils.TeacherTool;

import java.io.IOException;

/**
 * @author D.hu
 * @date 2020/12/7
 * @desc
 */
public class TeacherQueryStudentController {

    @FXML
    private TextField inputStudentNum;

    @FXML
    private TableColumn<StudentDTOData, String> nameTableColumn;

    @FXML
    private TextField formAge;

    @FXML
    private TextField inputName;

    @FXML
    private TextField formPhone;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private TextField formPassword;

    @FXML
    private TableColumn<StudentDTOData, String> usernameTableColumn;

    @FXML
    private TableView<StudentDTOData> studentTableView;

    @FXML
    private TextField formName;

    @FXML
    private Label ageLabel;

    @FXML
    private TextField formStudentNum;

    @FXML
    private TableColumn<StudentDTOData, String> studentNumTableColumn;

    @FXML
    private TableColumn<StudentDTOData, String> sexTableColumn;

    @FXML
    private Label nameLabel;

    @FXML
    private TableColumn<StudentDTOData, String> ageTableColumn;

    @FXML
    private RadioButton formMan;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label sexLabel;

    @FXML
    private Label infoLabel;

    @FXML
    private RadioButton formWoman;

    @FXML
    private TextField formUsername;

    @FXML
    private Label studentNumLabel;

    @FXML
    private TableColumn<StudentDTOData, String> phoneTableColumn;

    @FXML
    private TableColumn<StudentDTOData, String> passwordTableColumn;

    @FXML
    private Label queryNameLabel;

    @FXML
    private Label queryStudentNumLabel;

    @FXML
    private Button queryButton;

    @FXML
    private Button resetQueryButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button resetUpdateButton;

    private SimpleTools simpleTools = new SimpleTools();

    public void initialize() throws IOException {
        Labeled[] labeleds = {infoLabel, studentNumLabel, passwordLabel, phoneLabel, ageLabel, nameLabel, usernameLabel, sexLabel, queryNameLabel,
                queryStudentNumLabel, queryButton, resetQueryButton, updateButton, deleteButton, resetUpdateButton};
        String[] imagePaths = {"src/studentSystem/images/stu1.png", "src/studentSystem/images/workNum1.png",
                "src/studentSystem/images/password.png", "src/studentSystem/images/phone1.png",
                "src/studentSystem/images/age1.png", "src/studentSystem/images/name1.png",
                "src/studentSystem/images/userName.png", "src/studentSystem/images/sex1.png",
                "src/studentSystem/images/name1.png", "src/studentSystem/images/workNum1.png",
                "src/studentSystem/images/search.png", "src/studentSystem/images/reset.png",
                "src/studentSystem/images/update.png", "src/studentSystem/images/delete.png",
                "src/studentSystem/images/reset.png"};
        simpleTools.setLabeledImage(labeleds, imagePaths);
        formStudentNum.setDisable(true);
        simpleTools.setStudentTableViewData(studentTableView, simpleTools.getStudentTableViewData(), usernameTableColumn, passwordTableColumn,
                nameTableColumn, sexTableColumn, ageTableColumn, phoneTableColumn, studentNumTableColumn);
        studentTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStudentDetail(newValue)
        );
    }

    public void queryStudent(ActionEvent actionEvent) throws IOException {
        simpleTools.setStudentTableViewData(studentTableView, simpleTools.getStudentTableViewData(inputName.getText(), inputStudentNum.getText()),
                usernameTableColumn, passwordTableColumn, nameTableColumn, sexTableColumn, ageTableColumn, phoneTableColumn,
                studentNumTableColumn);
        resetUpdate(null);
    }

    public void resetQuery(ActionEvent actionEvent) {
        simpleTools.clearTextField(inputName, inputStudentNum);
    }

    private void showStudentDetail(StudentDTOData studentDTOData) {
        if (studentTableView.getSelectionModel().getFocusedIndex() < 0) {
            return;
        } else {
            formStudentNum.setText(studentDTOData.getStudentNum());
            formUsername.setText(studentDTOData.getUsername());
            formPassword.setText(studentDTOData.getPassword());
            formName.setText(studentDTOData.getName());
            if (studentDTOData.getSex().equals("男")) {
                formMan.setSelected(true);
                formWoman.setSelected(false);
            } else {
                formWoman.setSelected(true);
                formMan.setSelected(false);
            }
            formAge.setText(studentDTOData.getAge());
            formPhone.setText(studentDTOData.getPhone());
        }
    }

    public void resetUpdate(ActionEvent actionEvent) {
        simpleTools.clearTextField(formStudentNum, formUsername, formPassword, formName, formAge, formPhone);
        simpleTools.clearSelectedRadioButton(formMan, formWoman);
    }

    public void updateStudent(ActionEvent actionEvent) throws IOException, UserIsExistException, UserNotFoundException {
        String studentNum = formStudentNum.getText();
        String username = formUsername.getText();
        String password = formPassword.getText();
        String name = formName.getText();
        String sex = null;
        if (formMan.isSelected()) {
            sex = formMan.getText();
        } else if (formWoman.isSelected()) {
            sex = formWoman.getText();
        }
        String age = formAge.getText();
        String phone = formPhone.getText();
        Student student = new Student(Student.idCount, username, password, 1, name, sex, Integer.parseInt(age), phone, studentNum);
        boolean isOk = StudentTool.updateStudentByNum(student.getStudentNum(), student);
        if (isOk) {
            initialize();
            resetUpdate(null);
            simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "修改成功！");
        } else {
            simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "修改失败！");
        }
    }

    public void deleteTeacher(ActionEvent actionEvent) throws IOException, UserNotFoundException {
        String studentNum = formStudentNum.getText();
        boolean isOk = StudentTool.deleteStudentByNum(studentNum);
        if (isOk) {
            initialize();
            resetUpdate(null);
            simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "删除成功！");
        } else {
            simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "删除失败！");
        }
    }

    public void clickMan(ActionEvent actionEvent) {
        formWoman.setSelected(false);
    }

    public void clickWoman(ActionEvent actionEvent) {
        formMan.setSelected(false);
    }

}
