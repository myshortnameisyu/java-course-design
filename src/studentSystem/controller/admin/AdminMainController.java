package studentSystem.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
public class AdminMainController {

    private SimpleTools simpleTools = new SimpleTools();

    @FXML
    private MenuItem queryAllTeacher;

    @FXML
    private AnchorPane mainFrameAnchorPane;

    @FXML
    private MenuItem queryAllStudent;

    @FXML
    private ImageView backgroundView;

    @FXML
    private MenuItem addTeacher;

    @FXML
    private MenuItem exitSys;

    @FXML
    private MenuItem callUs;

    @FXML
    private MenuItem showDesc;

    public void initialize() {
        MenuItem[] labeleds = {queryAllStudent, queryAllTeacher, addTeacher, exitSys, callUs, showDesc};
        String[] imagePaths = {"src/studentSystem/images/fly1.png", "src/studentSystem/images/fly2.png",
                "src/studentSystem/images/add1.png", "src/studentSystem/images/logout.png","src/studentSystem/images/phone2.png", "src/studentSystem/images/desc.png"};
        simpleTools.setMenuItemImage(labeleds, imagePaths);
        // 设置图片
        backgroundView.setImage(new Image("file:src/studentSystem/images/bg2.png"));
    }

    public void queryAllStudentEvent(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = new Main().initQueryAllStudentFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }

    public void queryAllTeacherEvent(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = new Main().initQueryAllTeacherFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }

    public void addTeacherEvent(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = new Main().initAddTeacherFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }

    public void exitSystem(ActionEvent actionEvent) {
        System.exit(0);
    }

}
