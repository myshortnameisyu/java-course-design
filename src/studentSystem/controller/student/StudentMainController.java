package studentSystem.controller.student;

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
 * @date 2020/12/5
 * @desc
 */
public class StudentMainController {

    private SimpleTools simpleTools = new SimpleTools();

    @FXML
    private MenuItem updatePerInfo;

    @FXML
    private MenuItem queryPerInfo;

    @FXML
    private MenuItem callUs;

    @FXML
    private MenuItem showDesc;

    @FXML
    private MenuItem queryPerRank;

    @FXML
    private MenuItem queryPerSubject;

    @FXML
    private MenuItem exitItem;

    @FXML
    private ImageView backgroundView;

    @FXML
    private AnchorPane mainFrameAnchorPane;

    /**
     * 初始化启动
     */
    public void initialize() {
        MenuItem[] labeleds = {queryPerRank, exitItem, callUs, showDesc};
        String[] imagePaths = {"src/studentSystem/images/rank1.png", "src/studentSystem/images/logout.png",
        "src/studentSystem/images/phone2.png", "src/studentSystem/images/desc.png"};
        simpleTools.setMenuItemImage(labeleds, imagePaths);
        // 设置图片
        backgroundView.setImage(new Image("file:src/studentSystem/images/bg2.png"));
    }


    /**
     * 查询个人排名
     * @param actionEvent
     */
    public void queryPerRankEvent(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = new Main().initQueryPerRankFrame();
        mainFrameAnchorPane.getChildren().clear();
        mainFrameAnchorPane.getChildren().add(pane);
    }


    /**
     * 退出系统
     * @param actionEvent
     */
    public void exitSystem(ActionEvent actionEvent) {
        System.exit(0);
    }
}
