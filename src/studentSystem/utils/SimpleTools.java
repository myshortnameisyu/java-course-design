package studentSystem.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import studentSystem.dto.*;
import studentSystem.pojo.Admin;
import studentSystem.pojo.Student;
import studentSystem.pojo.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class SimpleTools {

    /**
     * 操作结果：JavaFX设置按钮、标签等组件的图标
     *
     * @param labeleds   需要设置图标的按钮
     * @param imagePaths 图标的路径
     */
    public void setLabeledImage(Labeled[] labeleds, String[] imagePaths) {
        for (int i = 0; i < labeleds.length; i++) {
            labeleds[i].setGraphic(new ImageView(new Image("file:" + imagePaths[i])));
        }
    }

    /**
     * 操作结果：清空文本框组件的内容
     *
     * @param inputControls 文本框或文本域组等
     */
    public void clearTextField(TextInputControl... inputControls) {
        for (int i = 0; i < inputControls.length; i++) {
            inputControls[i].setText("");
        }
    }

    /**
     * 操作结果：取消所有单选按钮选择
     *
     * @param toggleButtons 单选按钮组
     */
    public void clearSelectedRadioButton(ToggleButton... toggleButtons) {
        for (int i = 0; i < toggleButtons.length; i++) {
            toggleButtons[i].setSelected(false);
        }
    }

    /**
     * 操作结果：取消所有下拉列表框选择
     *
     * @param comboBoxes 下拉列表框组
     */
    public void clearSelectedComboBox(ComboBox... comboBoxes) {
        for (int i = 0; i < comboBoxes.length; i++) {
            comboBoxes[i].getSelectionModel().select(-1);// 设置选择的索引为-1，就不会选择任何选择选项了。
        }
    }

    /**
     * 操作结果：JavaFX设置菜单项组件的图标
     *
     * @param menuItems  菜单项
     * @param imagePaths 图标的路径
     */
    public void setMenuItemImage(MenuItem[] menuItems, String[] imagePaths) {
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i].setGraphic(new ImageView(new Image("file:" + imagePaths[i])));
        }
    }

    /**
     * 操作结果：JavaFX判断是否为空
     *
     * @param str 文本
     * @return boolean 如果不为空返回true，否则返回false
     */
    public boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 操作结果：自定义一个JavaFX的对话框
     *
     * @param alterType 对话框类型
     * @param title     对话框标题
     * @param header    对话框头信息
     * @param message   对话框显示内容
     * @return boolean 如果点击了”确定“那么就返回true，否则返回false
     */
    public boolean informationDialog(Alert.AlertType alterType, String title, String header, String message) {
        // 按钮部分可以使用预设的也可以像这样自己 new 一个
        Alert alert = new Alert(alterType, message, new ButtonType("取消", ButtonBar.ButtonData.CANCEL_CLOSE), new ButtonType("确定", ButtonBar.ButtonData.YES));
        // 设置对话框的标题
        alert.setTitle(title);
        alert.setHeaderText(header);
        // showAndWait() 将在对话框消失以前不会执行之后的代码
        Optional<ButtonType> buttonType = alert.showAndWait();
        // 根据点击结果返回
        if (buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)) {
            return true;// 如果点击了“确定”就返回true
        } else {
            return false;
        }
    }

    /**
     * 操作结果：JavaFX判断是否登录成功
     *
     * @param userNameTextField 用户名文本框
     * @param passwordTextField 密码文本框
     * @param userName          正确用户名
     * @param password          正确密码
     * @return boolean 如果登录成功返回true，否则返回false
     */
    public boolean isLogIn(TextInputControl userNameTextField, TextInputControl passwordTextField, String userName, String password) {
        SimpleTools simpleTools = new SimpleTools();
        if (simpleTools.isEmpty(userNameTextField.getText())) {
            simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "用户名不能为空！");
            return false;
        }
        if (simpleTools.isEmpty(passwordTextField.getText())) {
            simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "密码不能为空！");
            return false;
        }
        if (!userNameTextField.getText().equals(userName) || !passwordTextField.getText().equals(password)) {
            simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "用户名或密码不正确！");
            return false;
        }
        if (userNameTextField.getText().equals(userName) && passwordTextField.getText().equals(password)) {
            boolean isOK = simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "登录成功！");
            return isOK;
        }
        return false;
    }

    /**
     * 学生登陆
     * @param username
     * @param password
     * @param student
     * @return
     */
    public boolean isStudentLogin(String username, String password, Student student){
        SimpleTools simpleTools = new SimpleTools();
        if (student == null){
            simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "该用户不存在！");
            return false;
        }
        if (!username.equals(student.getUsername()) || !password.equals(student.getPassword())) {
            simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "用户名或密码不正确！");
            return false;
        }
        if (username.equals(student.getUsername()) && password.equals(student.getPassword())) {
            return simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "登录成功！");
        }
        return false;
    }

    /**
     * 老师登陆
     * @param username
     * @param password
     * @param teacher
     * @return
     */
    public boolean isTeacherLogin(String username, String password, Teacher teacher){
        SimpleTools simpleTools = new SimpleTools();
        if (teacher == null){
            simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "该用户不存在！");
            return false;
        }
        if (!username.equals(teacher.getUsername()) || !password.equals(teacher.getPassword())) {
            simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "用户名或密码不正确！");
            return false;
        }
        if (username.equals(teacher.getUsername()) && password.equals(teacher.getPassword())) {
            return simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "登录成功！");
        }
        return false;
    }

    /**
     * 管理员登陆
     * @param username
     * @param password
     * @param admin
     * @return
     */
    public boolean isAdminLogin(String username, String password, Admin admin){
        SimpleTools simpleTools = new SimpleTools();
        if (admin == null){
            simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "该用户不存在！");
            return false;
        }
        if (!username.equals(admin.getUsername()) || !password.equals(admin.getPassword())) {
            simpleTools.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "用户名或密码不正确！");
            return false;
        }
        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            return simpleTools.informationDialog(Alert.AlertType.INFORMATION, "提示", "信息", "登录成功！");
        }
        return false;
    }

    /**
     * 操作结果：向下拉列表框中添加列表项
     *
     * @param comboBox 下拉列表框
     * @param items    列表项
     */
    public void addComboBoxItems(ComboBox comboBox, Object[] items) {
        comboBox.getItems().clear();// 清除下列列表框中的所有选项
        ObservableList options = FXCollections.observableArrayList(items);
        comboBox.setItems(options);// 添加下拉列表项
    }

    /**
     * 获取成绩信息
     * @return
     * @throws IOException
     */
    public ObservableList<SubjectDTOData> getSubjectTableViewData(boolean isDown) throws IOException {
        SimpleTools simpleTools = new SimpleTools();
        ObservableList<SubjectDTOData> data =FXCollections.observableArrayList();
        ArrayList<SubjectDTO> list = new ArrayList<>();
        if (isDown){
            list = QueryTool.queryStudentSubjectDwon();
        }else {
            list = QueryTool.queryStudentSubjectUp();
        }
        for (SubjectDTO dto : list){
            SubjectDTOData dtoData = new SubjectDTOData(dto.getName(), dto.getSex(), String.valueOf(dto.getAge()), dto.getStudentNum(),
                    String.valueOf(dto.getChinese()), String.valueOf(dto.getMath()), String.valueOf(dto.getEnglish()), String.valueOf(dto.getPhysics()),
                    String.valueOf(dto.getChemistry()), String.valueOf(dto.getBiology()), String.valueOf(dto.getSum()));
            data.add(dtoData);
        }
        return data;
    }

    /**
     * 根据姓名和学号获取成绩
     * @param name
     * @param studentNum
     * @return
     * @throws IOException
     */
    public ObservableList<SubjectDTOData> getSubjectTableViewData(String name, String studentNum) throws IOException {
        ObservableList<SubjectDTOData> data =FXCollections.observableArrayList();
        ArrayList<SubjectDTO> list = QueryTool.querySubjectByName(name, studentNum);
        for (SubjectDTO dto : list){
            SubjectDTOData dtoData = new SubjectDTOData(dto.getName(), dto.getSex(), String.valueOf(dto.getAge()), dto.getStudentNum(),
                    String.valueOf(dto.getChinese()), String.valueOf(dto.getMath()), String.valueOf(dto.getEnglish()), String.valueOf(dto.getPhysics()),
                    String.valueOf(dto.getChemistry()), String.valueOf(dto.getBiology()), String.valueOf(dto.getSum()));
            data.add(dtoData);
        }
        return data;
    }

    /**
     * 设置查询成绩表
     * @param tableView
     * @param data
     * @param nameTableColumn
     * @param sexTableColumn
     * @param ageTableColumn
     * @param studentNumTableColumn
     * @param chineseTableColumn
     * @param mathTableColumn
     * @param englishTableColumn
     * @param physicsTableColumn
     * @param chemistryTableColumn
     * @param biologyTableColumn
     * @param sumTableColumn
     */
    public void setSubjectTableViewData(TableView tableView, ObservableList data, TableColumn<SubjectDTOData, String> nameTableColumn,
                                        TableColumn<SubjectDTOData, String> sexTableColumn, TableColumn<SubjectDTOData, String> ageTableColumn, TableColumn<SubjectDTOData, String> studentNumTableColumn,
                                        TableColumn<SubjectDTOData, String> chineseTableColumn, TableColumn<SubjectDTOData, String> mathTableColumn, TableColumn<SubjectDTOData, String> englishTableColumn,
                                        TableColumn<SubjectDTOData, String> physicsTableColumn, TableColumn<SubjectDTOData, String> chemistryTableColumn, TableColumn<SubjectDTOData, String> biologyTableColumn,
                                        TableColumn<SubjectDTOData, String> sumTableColumn){
        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        sexTableColumn.setCellValueFactory(cellData -> cellData.getValue().sexProperty());
        ageTableColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        studentNumTableColumn.setCellValueFactory(cellData -> cellData.getValue().studentNumProperty());
        chineseTableColumn.setCellValueFactory(cellData -> cellData.getValue().chineseProperty());
        mathTableColumn.setCellValueFactory(cellData -> cellData.getValue().mathProperty());
        englishTableColumn.setCellValueFactory(cellData -> cellData.getValue().englishProperty());
        physicsTableColumn.setCellValueFactory(cellData -> cellData.getValue().physicsProperty());
        chemistryTableColumn.setCellValueFactory(cellData -> cellData.getValue().chemistryProperty());
        biologyTableColumn.setCellValueFactory(cellData -> cellData.getValue().biologyProperty());
        sumTableColumn.setCellValueFactory(cellData -> cellData.getValue().sumProperty());
        tableView.setItems(data);
    }

    /**
     * 获取学生信息
     * @return
     * @throws IOException
     */
    public ObservableList<StudentDTOData> getStudentTableViewData() throws IOException {
        ObservableList<StudentDTOData> data = FXCollections.observableArrayList();
        ArrayList<StudentDTO> list = QueryTool.getStudentByQuery();
        for (StudentDTO dto : list){
            StudentDTOData dtoData = new StudentDTOData(dto.getUsername(), dto.getPassword(),
                    String.valueOf(dto.getIdentity()), dto.getName(), dto.getSex(), String.valueOf(dto.getAge()), dto.getPhone(), dto.getStudentNum());
            data.add(dtoData);
        }
        return data;
    }

    public ObservableList<StudentDTOData> getStudentTableViewData(String name, String studentNum) throws IOException {
        ObservableList<StudentDTOData> data = FXCollections.observableArrayList();
        ArrayList<StudentDTO> list = QueryTool.getStudentByQuery(name, studentNum);
        for (StudentDTO dto : list){
            StudentDTOData dtoData = new StudentDTOData(dto.getUsername(), dto.getPassword(),
                    String.valueOf(dto.getIdentity()), dto.getName(), dto.getSex(), String.valueOf(dto.getAge()), dto.getPhone(), dto.getStudentNum());
            data.add(dtoData);
        }
        return data;
    }

    /**
     * 设置表格内容
     * @param tableView
     * @param data
     * @param usernameTableColumn
     * @param passwordTableColumn
     * @param nameTableColumn
     * @param sexTableColumn
     * @param ageTableColumn
     * @param phoneTableColumn
     * @param studentNumTableColumn
     */
    public void setStudentTableViewData(TableView tableView, ObservableList data, TableColumn<StudentDTOData, String> usernameTableColumn,
                                               TableColumn<StudentDTOData, String> passwordTableColumn, TableColumn<StudentDTOData, String> nameTableColumn,
                                               TableColumn<StudentDTOData, String> sexTableColumn, TableColumn<StudentDTOData, String> ageTableColumn,
                                               TableColumn<StudentDTOData, String> phoneTableColumn, TableColumn<StudentDTOData, String> studentNumTableColumn){
        usernameTableColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        passwordTableColumn.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        sexTableColumn.setCellValueFactory(cellData -> cellData.getValue().sexProperty());
        ageTableColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        phoneTableColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        studentNumTableColumn.setCellValueFactory(cellData -> cellData.getValue().studentNumProperty());
        tableView.setItems(data);
    }

    /**
     * 查询老师
     * @return
     * @throws IOException
     */
    public ObservableList<TeacherDTOData> getTeacherTableViewData() throws IOException {
        ObservableList<TeacherDTOData> data = FXCollections.observableArrayList();
        ArrayList<TeacherDTO> list = QueryTool.getTeacherByQuery();
        for (TeacherDTO teacher : list){
            TeacherDTOData dtoData = new TeacherDTOData(teacher.getWorkNum(), teacher.getUsername(), teacher.getPassword(), teacher.getName(),
                    teacher.getSex(), String.valueOf(teacher.getAge()), teacher.getPhone());
            data.add(dtoData);
        }
        return data;
    }

    public ObservableList<TeacherDTOData> getTeacherTableViewData(String name, String workNum) throws IOException {
        ObservableList<TeacherDTOData> data = FXCollections.observableArrayList();
        ArrayList<TeacherDTO> list = QueryTool.getTeacherByQuery(name, workNum);
        for (TeacherDTO teacher : list){
            TeacherDTOData dtoData = new TeacherDTOData(teacher.getWorkNum(), teacher.getUsername(), teacher.getPassword(), teacher.getName(),
                    teacher.getSex(), String.valueOf(teacher.getAge()), teacher.getPhone());
            data.add(dtoData);
        }
        return data;
    }

    public void setTeacherTableViewData(TableView tableView, ObservableList data, TableColumn<TeacherDTOData, String> workNumTableColumn,
                                        TableColumn<TeacherDTOData, String> usernameTableColumn, TableColumn<TeacherDTOData, String> passwordTableColumn,
                                        TableColumn<TeacherDTOData, String> nameTableColumn, TableColumn<TeacherDTOData, String> sexTableColumn,
                                        TableColumn<TeacherDTOData, String> ageTableColumn, TableColumn<TeacherDTOData, String> phoneTableColumn){
        workNumTableColumn.setCellValueFactory(cellData -> cellData.getValue().workNumProperty());
        usernameTableColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        passwordTableColumn.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        sexTableColumn.setCellValueFactory(cellData -> cellData.getValue().sexProperty());
        ageTableColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty());
        phoneTableColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        tableView.setItems(data);
    }

}
