package studentSystem.controller.teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import studentSystem.MyException.SubjectNotFoundException;
import studentSystem.pojo.Subject;
import studentSystem.utils.SimpleTools;
import studentSystem.utils.SubjectTool;

import java.io.IOException;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class AddSubjectInfoController {

    @FXML
    private TextField inputStudentNum;

    @FXML
    private TextField inputChinese;

    @FXML
    private Label englishLabel;

    @FXML
    private TextField inputPhysics;

    @FXML
    private Label chemistryLabel;

    @FXML
    private TextField inputMath;

    @FXML
    private Label mathLabel;

    @FXML
    private Label infoLabel;

    @FXML
    private TextField inputEnglish;

    @FXML
    private Label biologyLabel;

    @FXML
    private Label studentNumLabel;

    @FXML
    private TextField inputChemistry;

    @FXML
    private TextField inputBiology;

    @FXML
    private Label chineseLabel;

    @FXML
    private Label physicsLabel;

    private SimpleTools simpleTools = new SimpleTools();

    @FXML
    private Button addButton;

    @FXML
    private Button resetButton;

    public void initialize() {
        Labeled[] labeleds = {infoLabel, studentNumLabel, chineseLabel, mathLabel, englishLabel, physicsLabel, chemistryLabel,
        biologyLabel, addButton, resetButton};
        String[] imagePaths = {"src/studentSystem/images/subject.png", "src/studentSystem/images/workNum1.png",
                "src/studentSystem/images/chinese.png", "src/studentSystem/images/math.png",
                "src/studentSystem/images/english.png", "src/studentSystem/images/physics.png",
                "src/studentSystem/images/chemistry.png", "src/studentSystem/images/biology.png",
                "src/studentSystem/images/add1.png", "src/studentSystem/images/reset.png"};
        simpleTools.setLabeledImage(labeleds, imagePaths);
    }


    public void addSubject(ActionEvent actionEvent) throws IOException, SubjectNotFoundException {
        String studentNum = inputStudentNum.getText();
        String chinese = inputChinese.getText();
        String math = inputMath.getText();
        String english = inputEnglish.getText();
        String physics = inputPhysics.getText();
        String chemistry = inputChemistry.getText();
        String biology = inputBiology.getText();
        Subject subject = new Subject(studentNum, Integer.parseInt(chinese), Integer.parseInt(math), Integer.parseInt(english),
                Integer.parseInt(physics), Integer.parseInt(chemistry), Integer.parseInt(biology));
        boolean isOk = SubjectTool.addNewSub(subject);
        if (isOk){
            reset();
            simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "添加成功！");
        }else {
            simpleTools.informationDialog(Alert.AlertType.ERROR, "提示", "错误", "添加失败！");
        }

    }

    public void reset() {
        simpleTools.clearTextField(inputStudentNum, inputChinese, inputMath, inputEnglish, inputPhysics,
                inputChemistry, inputBiology);
    }
}
