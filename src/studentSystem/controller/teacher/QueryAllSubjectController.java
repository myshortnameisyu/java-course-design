package studentSystem.controller.teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import studentSystem.myException.SubjectNotFoundException;
import studentSystem.dto.SubjectDTOData;
import studentSystem.pojo.Subject;
import studentSystem.utils.SimpleTools;
import studentSystem.utils.SubjectTool;

import java.io.IOException;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class QueryAllSubjectController {

    @FXML
    private TextField inputStudentNum;

    @FXML
    private Label rankLabel;

    @FXML
    private TableColumn<SubjectDTOData, String> nameTableColumn;

    @FXML
    private TextField formAge;

    @FXML
    private Label englishLabel;

    @FXML
    private Label chemistryLabel;

    @FXML
    private TableColumn<SubjectDTOData, String> sumTableColumn;

    @FXML
    private TextField formChinese;

    @FXML
    private TextField inputName;

    @FXML
    private TextField formChemistry;

    @FXML
    private Label mathLabel;

    @FXML
    private TableColumn<SubjectDTOData, String> chineseTableColumn;

    @FXML
    private TableColumn<SubjectDTOData, String> mathTableColumn;

    @FXML
    private TextField formMath;

    @FXML
    private Label sumLabel;

    @FXML
    private Label biologyLabel;

    @FXML
    private TextField formName;

    @FXML
    private Label chineseLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private TextField formStudentNum;

    @FXML
    private TableColumn<SubjectDTOData, String> studentNumTableColumn;

    @FXML
    private TableColumn<SubjectDTOData, String> sexTableColumn;

    @FXML
    private Label nameLabel;

    @FXML
    private TableColumn<SubjectDTOData, String> englishTableColumn;

    @FXML
    private TableColumn<SubjectDTOData, String> ageTableColumn;

    @FXML
    private RadioButton formMan;

    @FXML
    private TableColumn<SubjectDTOData, String> physicsTableColumn;

    @FXML
    private TableColumn<SubjectDTOData, String> chemistryTableColumn;

    @FXML
    private Label sexLabel;

    @FXML
    private TableColumn<SubjectDTOData, String> biologyTableColumn;

    @FXML
    private TableView<SubjectDTOData> studentSubjectTableView;

    @FXML
    private RadioButton formWoman;

    @FXML
    private TextField formSum;

    @FXML
    private TextField formPhysics;

    @FXML
    private Label studentNumLabel;

    @FXML
    private TextField formBiology;

    @FXML
    private TextField formEnglish;

    @FXML
    private Label physicsLabel;

    @FXML
    private Label queryNameLabel;

    @FXML
    private Label queryStudentNumLabel;

    private SimpleTools simpleTools = new SimpleTools();

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

    @FXML
    private Button upSortButton;

    @FXML
    private Button dowmSortButton;

    public void initialize() throws IOException {
        Labeled[] labeleds = {rankLabel, studentNumLabel, nameLabel, sexLabel, ageLabel, chineseLabel, mathLabel, englishLabel,
        physicsLabel, chemistryLabel, biologyLabel, sumLabel, queryNameLabel, queryStudentNumLabel, queryButton,
        resetQueryButton, updateButton, deleteButton, resetUpdateButton, upSortButton, dowmSortButton};
        String[] imagePaths = {"src/studentSystem/images/rank.png", "src/studentSystem/images/workNum1.png",
                "src/studentSystem/images/name1.png", "src/studentSystem/images/sex1.png",
                "src/studentSystem/images/age1.png", "src/studentSystem/images/chinese.png",
                "src/studentSystem/images/math.png", "src/studentSystem/images/english.png",
                "src/studentSystem/images/physics.png", "src/studentSystem/images/chemistry.png",
                "src/studentSystem/images/biology.png", "src/studentSystem/images/sum.png",
                "src/studentSystem/images/name1.png", "src/studentSystem/images/workNum1.png",
                "src/studentSystem/images/search.png", "src/studentSystem/images/reset.png",
                "src/studentSystem/images/update.png", "src/studentSystem/images/delete.png",
                "src/studentSystem/images/reset.png", "src/studentSystem/images/up.png",
                "src/studentSystem/images/down.png"};
        simpleTools.setLabeledImage(labeleds, imagePaths);
        formStudentNum.setDisable(true);
        formName.setDisable(true);
        formAge.setDisable(true);
        formWoman.setDisable(true);
        formMan.setDisable(true);
        formSum.setDisable(true);
        simpleTools.setSubjectTableViewData(studentSubjectTableView, simpleTools.getSubjectTableViewData(true),
                nameTableColumn, sexTableColumn, ageTableColumn, studentNumTableColumn, chineseTableColumn,
                mathTableColumn, englishTableColumn, physicsTableColumn, chemistryTableColumn, biologyTableColumn, sumTableColumn);
        studentSubjectTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) ->  {
                    if (studentSubjectTableView.getSelectionModel().getSelectedIndex() >= 0){
                        showStudentDetail(newValue);
                    }
                }
        );
    }


    public void queryInfo(ActionEvent actionEvent) throws IOException {
        resetUpdate(null);
        simpleTools.setSubjectTableViewData(studentSubjectTableView, simpleTools.getSubjectTableViewData(inputName.getText(), inputStudentNum.getText()),
                nameTableColumn, sexTableColumn, ageTableColumn, studentNumTableColumn, chineseTableColumn,
                mathTableColumn, englishTableColumn, physicsTableColumn, chemistryTableColumn, biologyTableColumn, sumTableColumn);
    }

    public void resetQuery(ActionEvent actionEvent) {
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

    private void showStudentDetail(SubjectDTOData subjectDTOData) {
        if (studentSubjectTableView.getSelectionModel().getFocusedIndex() < 0){
            return;
        }else {
            formStudentNum.setText(subjectDTOData.getStudentNum());
            formName.setText(subjectDTOData.getName());
            formAge.setText(subjectDTOData.getAge());
            if (subjectDTOData.getSex().equals("男")){
                formMan.setSelected(true);
                formWoman.setSelected(false);
            }else {
                formWoman.setSelected(true);
                formMan.setSelected(false);
            }
            formChinese.setText(subjectDTOData.getChinese());
            formMath.setText(subjectDTOData.getMath());
            formEnglish.setText(subjectDTOData.getEnglish());
            formPhysics.setText(subjectDTOData.getPhysics());
            formChemistry.setText(subjectDTOData.getChemistry());
            formBiology.setText(subjectDTOData.getBiology());
            formSum.setText(subjectDTOData.getSum());
        }
    }

    public void resetUpdate(ActionEvent actionEvent) {
        simpleTools.clearTextField(formStudentNum, formName, formAge, formChinese, formMath, formEnglish, formPhysics, formChemistry, formBiology, formSum);
        simpleTools.clearSelectedRadioButton(formMan, formWoman);
    }

    public void updateSubject(ActionEvent actionEvent) throws IOException, SubjectNotFoundException {
        String studentNum = formStudentNum.getText();
        String chinese = formChinese.getText();
        String math = formMath.getText();
        String english = formEnglish.getText();
        String physics = formPhysics.getText();
        String chemistry = formChemistry.getText();
        String biology = formBiology.getText();
        Subject subject = new Subject(studentNum, Integer.parseInt(chinese), Integer.parseInt(math), Integer.parseInt(english), Integer.parseInt(physics),
                Integer.parseInt(chemistry), Integer.parseInt(biology));
        boolean isOk = SubjectTool.updateStudentByNum(studentNum, subject);
        if (isOk){
            initialize();
            resetUpdate(null);
            simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "修改成功！");
        }else {
            simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "修改失败！");
        }
    }

    public void deleteSubject(ActionEvent actionEvent) throws IOException, SubjectNotFoundException {
        String studentNum = formStudentNum.getText();
        boolean isOk = SubjectTool.deleteSubjectByNum(studentNum);
        if (isOk){
            initialize();
            resetUpdate(null);
            simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "删除成功！");
        }else {
            simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "删除失败！");
        }
    }
}
