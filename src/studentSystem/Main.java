package studentSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import studentSystem.controller.LoginController;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        primaryStage.setTitle("学生管理系统");
        initLoginFrame();
    }

    /**
     * 登陆界面
     * @throws IOException
     */
    private void initLoginFrame() throws IOException {
        // 加载登录界面的fxml文件
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/LoginFrame.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setTitle("登录");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        // 获取登录界面的控制器类
        LoginController loginController = loader.getController();
        // 将stage作为参数传递到控制器中
        loginController.setStage(primaryStage);
        // 展示舞台
        primaryStage.show();
    }

    /**
     * 学生主界面
     * @throws IOException
     */
    public void initStudentMainFrame() throws IOException {
        // 加载主界面
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/student/StudentMainFrame.fxml"));
        AnchorPane root = loader.load();
        // 设置stage舞台的属性
        Stage mainFrameStage = new Stage();
        mainFrameStage.setTitle("学生主界面");
        mainFrameStage.setResizable(true);
        mainFrameStage.setAlwaysOnTop(false);
        mainFrameStage.initModality(Modality.APPLICATION_MODAL);
        mainFrameStage.initOwner(primaryStage);
        Scene scene = new Scene(root, 1000, 600);
        mainFrameStage.setScene(scene);
        mainFrameStage.showAndWait();
    }

    /**
     * 管理员主界面
     * @throws IOException
     */
    public void initAdminMainFrame() throws IOException {
        // 加载主界面
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/admin/AdminMainFrame.fxml"));
        AnchorPane root = loader.load();
        // 设置stage舞台的属性
        Stage mainFrameStage = new Stage();
        mainFrameStage.setTitle("管理员主界面");
        mainFrameStage.setResizable(true);
        mainFrameStage.setAlwaysOnTop(false);
        mainFrameStage.initModality(Modality.APPLICATION_MODAL);
        mainFrameStage.initOwner(primaryStage);
        Scene scene = new Scene(root, 1000, 600);
        mainFrameStage.setScene(scene);
        mainFrameStage.showAndWait();
    }

    /**
     * 教师主界面
     * @throws IOException
     */
    public void initTeacherMainFrame() throws IOException {
        // 加载主界面
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/teacher/TeacherMainFrame.fxml"));
        AnchorPane root = loader.load();
        // 设置stage舞台的属性
        Stage mainFrameStage = new Stage();
        mainFrameStage.setTitle("教师主界面");
        mainFrameStage.setResizable(true);
        mainFrameStage.setAlwaysOnTop(false);
        mainFrameStage.initModality(Modality.APPLICATION_MODAL);
        mainFrameStage.initOwner(primaryStage);
        Scene scene = new Scene(root, 1000, 600);
        mainFrameStage.setScene(scene);
        mainFrameStage.showAndWait();
    }


    /**
     * 返回学生查询排名信息的控件
     * @return
     * @throws IOException
     */
    public AnchorPane initQueryPerRankFrame() throws IOException {
        // 加载FXML布局文件
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/student/QueryPerRankFrame.fxml"));
        return loader.load();
    }


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * 返回查询所有学生的控件
     * @return
     */
    public AnchorPane initQueryAllStudentFrame() throws IOException {
        // 加载FXML布局文件
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/admin/QueryAllStudentFrame.fxml"));
        return loader.load();
    }

    /**
     * 返回查询所有教师的控件
     * @return
     * @throws IOException
     */
    public AnchorPane initQueryAllTeacherFrame() throws IOException {
        // 加载FXML布局文件
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/admin/QueryAllTeacherFrame.fxml"));
        return loader.load();
    }

    /**
     * 添加教师的控件
     * @return
     */
    public AnchorPane initAddTeacherFrame() throws IOException {
        // 加载FXML布局文件
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/admin/AddTeacherFrame.fxml"));
        return loader.load();
    }

    /**
     * 返回查询所有学生成绩的控件
     * @return
     * @throws IOException
     */
    public AnchorPane initQueryAllSubjectFrame() throws IOException {
        // 加载FXML布局文件
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/teacher/QueryAllSubjectFrame.fxml"));
        return loader.load();
    }

    /**
     * 添加学生的控件
     * @return
     */
    public AnchorPane initAddStudentInfoFrame() throws IOException {
        // 加载FXML布局文件
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/teacher/AddStudentInfoFrame.fxml"));
        return loader.load();
    }

    /**
     * 添加学生成绩的控件
     * @return
     */
    public AnchorPane initAddSubjectInfoFrame() throws IOException {
        // 加载FXML布局文件
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/teacher/AddSubjectInfoFrame.fxml"));
        return loader.load();
    }

    public AnchorPane initTeacherQueryStudentFrame() throws IOException {
        // 加载FXML布局文件
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/teacher/TeacherQueryStudentFrame.fxml"));
        return loader.load();
    }
}
