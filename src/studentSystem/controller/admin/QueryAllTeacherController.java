package studentSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import studentSystem.myException.UserIsExistException;
import studentSystem.myException.UserNotFoundException;
import studentSystem.dto.TeacherDTOData;
import studentSystem.pojo.Teacher;
import studentSystem.utils.SimpleTools;
import studentSystem.utils.TeacherTool;

import java.io.IOException;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class QueryAllTeacherController {

    @FXML
    private TextField formWorkNum;

    @FXML
    private TableColumn<TeacherDTOData, String> nameTableColumn;

    @FXML
    private TableColumn<TeacherDTOData, String> ageTableColumn;

    @FXML
    private TextField formAge;

    @FXML
    private RadioButton formMan;

    @FXML
    private Label teacherLabel;

    @FXML
    private TableColumn<TeacherDTOData, String> workNumTableColumn;

    @FXML
    private TextField inputName;

    @FXML
    private TextField formPhone;

    @FXML
    private TextField formPassword;

    @FXML
    private TableColumn<TeacherDTOData, String> usernameTableColumn;

    @FXML
    private TableView<TeacherDTOData> teacherTableView;

    @FXML
    private RadioButton formWoman;

    @FXML
    private TextField formUsername;

    @FXML
    private TextField formName;

    @FXML
    private TextField inputWorkNum;

    @FXML
    private TableColumn<TeacherDTOData, String> phoneTableColumn;

    @FXML
    private TableColumn<TeacherDTOData, String> passwordTableColumn;

    @FXML
    private TableColumn<TeacherDTOData, String> sexTableColumn;

    private SimpleTools simpleTools = new SimpleTools();

    @FXML
    private Label workNumLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label sexLabel;

    @FXML
    private Label queryNameLabel;

    @FXML
    private Label queryTeacherNumLabel;

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

    public void initialize() throws IOException {
        Labeled[] labeleds = {teacherLabel, workNumLabel, passwordLabel, phoneLabel, ageLabel, nameLabel, usernameLabel, sexLabel,
        queryNameLabel, queryTeacherNumLabel, queryButton, resetQueryButton, updateButton, deleteButton, resetUpdateButton};
        String[] imagePaths = {"src/studentSystem/images/teacher1.png", "src/studentSystem/images/workNum1.png",
                "src/studentSystem/images/password.png", "src/studentSystem/images/phone1.png",
                "src/studentSystem/images/age1.png", "src/studentSystem/images/name1.png",
                "src/studentSystem/images/userName.png", "src/studentSystem/images/sex1.png",
                "src/studentSystem/images/name1.png", "src/studentSystem/images/workNum1.png",
                "src/studentSystem/images/search.png", "src/studentSystem/images/reset.png",
                "src/studentSystem/images/update.png", "src/studentSystem/images/delete.png",
                "src/studentSystem/images/reset.png"};
        simpleTools.setLabeledImage(labeleds, imagePaths);
        formWorkNum.setDisable(true);
        simpleTools.setTeacherTableViewData(teacherTableView, simpleTools.getTeacherTableViewData(), workNumTableColumn, usernameTableColumn,
                passwordTableColumn, nameTableColumn, sexTableColumn, ageTableColumn, phoneTableColumn);
        teacherTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) ->  {
                    if (teacherTableView.getSelectionModel().getSelectedIndex() >= 0){
                        showTeacherDetail(newValue);
                    }
                }
        );
    }


    public void queryTeacher(ActionEvent actionEvent) throws IOException {
        simpleTools.setTeacherTableViewData(teacherTableView, simpleTools.getTeacherTableViewData(inputName.getText(), inputWorkNum.getText()), workNumTableColumn, usernameTableColumn,
                passwordTableColumn, nameTableColumn, sexTableColumn, ageTableColumn, phoneTableColumn);
    }

    public void resetQuery(ActionEvent actionEvent) {
        simpleTools.clearTextField(inputName, inputWorkNum);
    }

    public void showTeacherDetail(TeacherDTOData teacherDTOData){
        if (teacherTableView.getSelectionModel().getFocusedIndex() < 0){
            return;
        }else {
            formWorkNum.setText(teacherDTOData.getWorkNum());
            formUsername.setText(teacherDTOData.getUsername());
            formPassword.setText(teacherDTOData.getPassword());
            formName.setText(teacherDTOData.getName());
            if (teacherDTOData.getSex().equals("男")){
                formMan.setSelected(true);
                formWoman.setSelected(false);
            }else {
                formWoman.setSelected(true);
                formMan.setSelected(false);
            }
            formAge.setText(teacherDTOData.getAge());
            formPhone.setText(teacherDTOData.getPhone());
        }
    }

    public void resetUpdate(ActionEvent actionEvent) {
        simpleTools.clearTextField(formWorkNum, formUsername, formPassword, formName, formAge, formPhone);
        simpleTools.clearSelectedRadioButton(formMan, formWoman);
    }

    public void updateTeacher(ActionEvent actionEvent) throws IOException, UserIsExistException, UserNotFoundException {
        String workNum = formWorkNum.getText();
        String username = formUsername.getText();
        String password = formPassword.getText();
        String name = formName.getText();
        String sex = null;
        if (formMan.isSelected()){
            sex = formMan.getText();
        }else if (formWoman.isSelected()){
            sex = formWoman.getText();
        }
        String age = formAge.getText();
        String phone = formPhone.getText();
        Teacher teacher = new Teacher(Teacher.idCount, username, password, 2, name, sex, Integer.parseInt(age),
                phone, workNum);
        boolean isOk = TeacherTool.updateTeacherByNum(teacher.getWorkNum(), teacher);
        if (isOk){
            initialize();
            resetUpdate(null);
            simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "修改成功！");
        }else {
            simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "修改失败！");
        }
    }

    public void deleteTeacher(ActionEvent actionEvent) throws IOException, UserNotFoundException {
        String workNum = formWorkNum.getText();
        boolean isOk = TeacherTool.deleteTeacherByNum(workNum);
        if (isOk){
            initialize();
            resetUpdate(null);
            simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "删除成功！");
        }else {
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
