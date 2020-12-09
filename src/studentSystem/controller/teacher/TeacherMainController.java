package studentSystem.controller.teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import studentSystem.Main;
import studentSystem.utils.SimpleTools;

import java.io.IOException;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class TeacherMainController {

    @FXML
    private MenuItem queryAllSubject;

    @FXML
    private MenuItem queryStudentByNum;

    @FXML
    private AnchorPane mainFrameAnchorPane;

    @FXML
    private MenuItem queryAllStudent;

    @FXML
    private MenuItem addSubjectInfo;

    @FXML
    private ImageView backgroundView;

    @FXML
    private MenuItem queryTeaInfo;

    @FXML
    private MenuItem addStudentInfo;

    @FXML
    private MenuItem querySubjectByNum;

    @FXML
    private MenuItem updateTeaInfo;

    @FXML
    private MenuItem callUs;

    @FXML
    private MenuItem showDesc;

    @FXML
    private MenuItem exit;

    private SimpleTools simpleTools = new SimpleTools();

    public void initialize() {
        MenuItem[] labeleds = {queryAllStudent, queryAllSubject, addStudentInfo, addSubjectInfo, exit, callUs, showDesc};
        String[] imagePaths = {"src/studentSystem/images/fly1.png", "src/studentSystem/images/fly2.png",
                "src/studentSystem/images/add1.png", "src/studentSystem/images/add2.png",
                "src/studentSystem/images/logout.png","src/studentSystem/images/phone2.png", "src/studentSystem/images/desc.png"};
        simpleTools.setMenuItemImage(labeleds, imagePaths);
        // 设置图片
        backgroundView.setImage(new Image("file:src/studentSystem/images/bg2.png"));
    }

    public void teacherQueryStudent(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = new Main().initTeacherQueryStudentFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }

    public void queryAllSubjectEvent(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = new Main().initQueryAllSubjectFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }

    public void addStudentInfoEvent(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = new Main().initAddStudentInfoFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }

    public void addSunbjectInfoEvent(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = new Main().initAddSubjectInfoFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }

//    public void queryTeaInfoEvent(ActionEvent actionEvent) throws IOException {
//        AnchorPane pane = new Main().initQueryTeaInfoFrame();
//        mainFrameAnchorPane.getChildren().clear();
//        mainFrameAnchorPane.getChildren().add(pane);
//    }
//
//    public void updateTeaInfo(ActionEvent actionEvent) throws IOException {
//        AnchorPane pane = new Main().initUpdateTeaInfoFrame();
//        mainFrameAnchorPane.getChildren().clear();
//        mainFrameAnchorPane.getChildren().add(pane);
//    }

    public void exitSystem(ActionEvent actionEvent) {
        System.exit(0);
    }
}
