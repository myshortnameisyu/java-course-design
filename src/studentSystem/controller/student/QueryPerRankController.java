package studentSystem.controller.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import studentSystem.dto.SubjectDTOData;
import studentSystem.utils.SimpleTools;

import java.io.IOException;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class QueryPerRankController {

    @FXML
    private TableColumn<SubjectDTOData, String> englishTableColumn;

    @FXML
    private TextField inputStudentNum;

    @FXML
    private TableColumn<SubjectDTOData, String> nameTableColumn;

    @FXML
    private TableColumn<SubjectDTOData, String> ageTableColumn;

    @FXML
    private TableColumn<SubjectDTOData, String> sumTableColumn;

    @FXML
    private TableColumn<SubjectDTOData, String> physicsTableColumn;

    @FXML
    private TableColumn<SubjectDTOData, String> chemistryTableColumn;

    @FXML
    private TextField inputName;

    @FXML
    private Label rankLabel;

    @FXML
    private TableColumn<SubjectDTOData, String> biologyTableColumn;

    @FXML
    private TableColumn<SubjectDTOData, String> chineseTableColumn;

    @FXML
    private TableView<SubjectDTOData> studentSubjectTableView;

    @FXML
    private TableColumn<SubjectDTOData, String> mathTableColumn;

    @FXML
    private TableColumn<SubjectDTOData, String> sexTableColumn;

    @FXML
    private TableColumn<SubjectDTOData, String> studentNumTableColumn;

    private SimpleTools simpleTools = new SimpleTools();

    @FXML
    private Label queryNameLabel;

    @FXML
    private Label queryStudentNumLabel;

    @FXML
    private Button queryButton;

    @FXML
    private Button resetQueryButton;

    @FXML
    private Button upSortButton;

    @FXML
    private Button dowmSortButton;


    public void initialize() throws IOException {
        Labeled[] labeleds = {rankLabel, queryNameLabel, queryStudentNumLabel, queryButton, resetQueryButton,
        upSortButton, dowmSortButton};
        String[] imagePaths = {"src/studentSystem/images/rank.png", "src/studentSystem/images/name1.png", "src/studentSystem/images/workNum1.png",
                "src/studentSystem/images/search.png", "src/studentSystem/images/reset.png","src/studentSystem/images/up.png",
                "src/studentSystem/images/down.png"};
        simpleTools.setLabeledImage(labeleds, imagePaths);
        simpleTools.setSubjectTableViewData(studentSubjectTableView, simpleTools.getSubjectTableViewData(true),
                nameTableColumn, sexTableColumn, ageTableColumn, studentNumTableColumn, chineseTableColumn,
                mathTableColumn, englishTableColumn, physicsTableColumn, chemistryTableColumn, biologyTableColumn, sumTableColumn);
    }


    public void queryInfo(ActionEvent actionEvent) throws IOException {
        simpleTools.setSubjectTableViewData(studentSubjectTableView, simpleTools.getSubjectTableViewData(inputName.getText(), inputStudentNum.getText()),
                nameTableColumn, sexTableColumn, ageTableColumn, studentNumTableColumn, chineseTableColumn,
                mathTableColumn, englishTableColumn, physicsTableColumn, chemistryTableColumn, biologyTableColumn, sumTableColumn);
    }

    public void reset(ActionEvent actionEvent) {
        simpleTools.clearTextField(inputName, inputStudentNum);
    }

    public void upSortSubject(ActionEvent actionEvent) throws IOException {
        simpleTools.setSubjectTableViewData(studentSubjectTableView, simpleTools.getSubjectTableViewData(true),
                nameTableColumn, sexTableColumn, ageTableColumn, studentNumTableColumn, chineseTableColumn,
                mathTableColumn, englishTableColumn, physicsTableColumn, chemistryTableColumn, biologyTableColumn, sumTableColumn);
    }

    public void dwonSort(ActionEvent actionEvent) throws IOException {
        simpleTools.setSubjectTableViewData(studentSubjectTableView, simpleTools.getSubjectTableViewData(false),
                nameTableColumn, sexTableColumn, ageTableColumn, studentNumTableColumn, chineseTableColumn,
                mathTableColumn, englishTableColumn, physicsTableColumn, chemistryTableColumn, biologyTableColumn, sumTableColumn);
    }
}
