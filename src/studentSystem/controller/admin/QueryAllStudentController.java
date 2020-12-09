package studentSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import studentSystem.dto.StudentDTOData;
import studentSystem.utils.SimpleTools;

import java.io.IOException;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class QueryAllStudentController {

    @FXML
    private TextField inputStudentNum;


    @FXML
    private TableColumn<StudentDTOData, String> nameTableColumn;

    @FXML
    private TableColumn<StudentDTOData, String> usernameTableColumn;

    @FXML
    private TableColumn<StudentDTOData, String> ageTableColumn;

    @FXML
    private TableColumn<StudentDTOData, String> phoneTableColumn;

    @FXML
    private TextField inputName;

    @FXML
    private TableColumn<StudentDTOData, String> passwordTableColumn;

    @FXML
    private TableColumn<StudentDTOData, String> sexTableColumn;

    @FXML
    private TableColumn<StudentDTOData, String> studentNumTableColumn;

    @FXML
    private Label infoLabel;

    @FXML
    private TableView<StudentDTOData> studentTableView;

    @FXML
    private Label queryNameLabel;

    @FXML
    private Label queryStudentNumLabel;

    private SimpleTools simpleTools = new SimpleTools();

    @FXML
    private Button queryButton;

    @FXML
    private Button resetQueryButton;

    public void initialize() throws IOException {
        Labeled[] labeleds = {infoLabel, queryNameLabel, queryStudentNumLabel, queryButton, resetQueryButton};
        String[] imagePaths = {"src/studentSystem/images/stu1.png", "src/studentSystem/images/name1.png", "src/studentSystem/images/workNum1.png",
                "src/studentSystem/images/search.png", "src/studentSystem/images/reset.png"};
        simpleTools.setLabeledImage(labeleds, imagePaths);
        simpleTools.setStudentTableViewData(studentTableView, simpleTools.getStudentTableViewData(), usernameTableColumn, passwordTableColumn,
                nameTableColumn, sexTableColumn, ageTableColumn, phoneTableColumn, studentNumTableColumn);
    }


    public void queryStudent(ActionEvent actionEvent) throws IOException {
        simpleTools.setStudentTableViewData(studentTableView, simpleTools.getStudentTableViewData(inputName.getText(), inputStudentNum.getText()),
                usernameTableColumn, passwordTableColumn, nameTableColumn, sexTableColumn, ageTableColumn, phoneTableColumn,
                studentNumTableColumn);
    }

    public void reset(ActionEvent actionEvent) {
        simpleTools.clearTextField(inputName, inputStudentNum);
    }
}
