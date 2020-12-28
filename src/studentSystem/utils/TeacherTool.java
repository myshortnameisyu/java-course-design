package studentSystem.utils;

import com.alibaba.fastjson.JSON;
import studentSystem.myException.UserIsExistException;
import studentSystem.myException.UserNotFoundException;
import studentSystem.pojo.Teacher;

import java.io.*;
import java.util.ArrayList;

/**
 * 老师信息操作类
 */
public class TeacherTool {

    // 模拟数据库
    private static String file_path = "/Users/dinghu/Documents/JavaProject/javaHomework/src/studentSystem/db/teacher.txt";

    /**
     * 读文件
     * @return
     * @throws IOException
     */
    private static String readFile() throws IOException {
        File myFile = createFile();
        String content = null;
        // 读文件
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(myFile));
        String s = null;
        while ((s = br.readLine()) != null) {
            result.append(s);
        }
        br.close();
        content = result.toString();
        return content;
    }

    /**
     *  创建文件
     * @return
     */
    private static File createFile() {
        return new File(file_path);
    }

    /**
     * 写文件
     * @param content
     * @throws IOException
     */
    private static void writeFile(String content) throws IOException {
        File file = createFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content);
        writer.flush();
        writer.close();
    }

    /**
     * 将数组对象转化为字符串
     * @param arr
     * @return
     */
    private static String arrToString(ArrayList<Teacher> arr) {
        return JSON.toJSONString(arr);
    }

    /**
     * 将字符串转为数组对象
     * @param content
     * @return
     */
    private static ArrayList<Teacher> strToArray(String content) {
        return (ArrayList<Teacher>) JSON.parseArray(content, Teacher.class);
    }

    /**
     * 从文件中提取数组对象
     * @return
     * @throws IOException
     */
    private static ArrayList<Teacher> fileToArray() throws IOException {
        String file = readFile();
        return strToArray(file);
    }

    /**
     *  将数组文件写入文件
     * @param arr
     * @throws IOException
     */
    private static void arrToFile(ArrayList<Teacher> arr) throws IOException {
        String arrStr = arrToString(arr);
        writeFile(arrStr);
    }

    /**
     * 查询老师是否已经存在
     * @param workNum
     * @return
     * @throws IOException
     */
    private static boolean isTeacherExist(String workNum) throws IOException {
        ArrayList<Teacher> arr = fileToArray();
        for (Teacher value : arr) {
            if (workNum.equals(value.getWorkNum())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 创建老师用户信息文件
     * @throws IOException
     */
    public static void createDataBase() throws IOException {
        File file = createFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        ArrayList<Teacher> arrayList = new ArrayList<>();
        writer.write(JSON.toJSONString(arrayList));
        writer.flush();
        writer.close();
    }


    /**
     *添加一个老师信息
     * @param teacher
     * @throws IOException
     */
    public static boolean addNewTeacher(Teacher teacher) throws IOException, UserIsExistException {
        if (isTeacherExist(teacher.getWorkNum())){
            throw new UserIsExistException("该用户已经存在");
        }
        ArrayList<Teacher> per_arr = fileToArray();
        per_arr.add(teacher);
        arrToFile(per_arr);
        System.out.println("添加老师信息成功....");
        return true;
    }

    /**
     * 查询所有老师信息
     * @return
     * @throws IOException
     */
    public static ArrayList<Teacher> showAllTeacher() throws IOException {
        return fileToArray();
    }

    /**
     * 根据职工号查询老师信息
     * @param workNum
     * @return
     * @throws IOException
     */
    public static Teacher showPerTeacherByNum(String workNum) throws IOException, UserNotFoundException {
        ArrayList<Teacher> arr = fileToArray();
        Teacher teacher = null;
        for (Teacher value : arr) {
            if (workNum.equals(value.getWorkNum())) {
                teacher = value;
                break;
            }
        }
        if (teacher == null){
            throw new UserNotFoundException("该用户不存在！");
        }
        return teacher;

    }

    /**
     * 根据用户名查询老师
     * @param username
     * @return
     * @throws IOException
     */
    public static Teacher getTeacherByUserName(String username) throws IOException {
        ArrayList<Teacher> arr = fileToArray();
        for (Teacher value : arr) {
            if (username.equals(value.getUsername())) {
                return value;
            }
        }
        return null;
    }

    /**
     * 根据职工号删除老师信息
     * @param workNum
     * @return
     * @throws IOException
     */
    public static boolean deleteTeacherByNum(String workNum) throws IOException, UserNotFoundException {
        ArrayList<Teacher> arr = fileToArray();
        int nameIndex = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (workNum.equals(arr.get(i).getWorkNum())) {
                nameIndex = i;
                break;
            }
        }
        if (nameIndex == -1) {
            throw new UserNotFoundException("该用户不存在！");
        } else {
            arr.remove(nameIndex);
            System.out.println("刪除老师信息...");
            arrToFile(arr);
            return true;
        }
    }

    /**
     * 根据学号修改老师信息
     * @param workNum
     * @param teacher
     * @return
     * @throws IOException
     */
    public static boolean updateTeacherByNum(String workNum, Teacher teacher) throws IOException, UserNotFoundException {
        ArrayList<Teacher> per_arr = fileToArray();
        boolean flag = false;
        for (int i = 0; i < per_arr.size(); i++) {
            if (workNum.equals(per_arr.get(i).getWorkNum())) {
                per_arr.set(i, teacher);
                flag = true;
                break;
            }
        }
        if (flag){
            arrToFile(per_arr);
            System.out.println("修改成功....");
            return true;
        }else {
            throw new UserNotFoundException("该用户不存在！");
        }
    }

}
