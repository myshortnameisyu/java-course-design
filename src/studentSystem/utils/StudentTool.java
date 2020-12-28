package studentSystem.utils;

import com.alibaba.fastjson.JSON;
import studentSystem.myException.UserIsExistException;
import studentSystem.myException.UserNotFoundException;
import studentSystem.pojo.Student;

import java.io.*;
import java.util.ArrayList;

/**
 * 学生信息操作类
 */
public class StudentTool {

    // 模拟数据库
    private static String file_path = "/Users/dinghu/Documents/JavaProject/javaHomework/src/studentSystem/db/student.txt";

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
    private static String arrToString(ArrayList<Student> arr) {
        return JSON.toJSONString(arr);
    }

    /**
     * 将字符串转为数组对象
     * @param content
     * @return
     */
    private static ArrayList<Student> strToArray(String content) {
        return (ArrayList<Student>) JSON.parseArray(content, Student.class);
    }

    /**
     * 从文件中提取数组对象
     * @return
     * @throws IOException
     */
    private static ArrayList<Student> fileToArray() throws IOException {
        String file = readFile();
        return strToArray(file);
    }

    /**
     *  将数组文件写入文件
     * @param arr
     * @throws IOException
     */
    private static void arrToFile(ArrayList<Student> arr) throws IOException {
        String arrStr = arrToString(arr);
        writeFile(arrStr);
    }

    /**
     * 判断数据库中是否有该学号的学生
     * @param studentNum
     * @return
     * @throws IOException
     */
    private static boolean isStudentExist(String studentNum) throws IOException {
        ArrayList<Student> arr = fileToArray();
        for (Student value : arr) {
            if (studentNum.equals(value.getStudentNum())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据用户名查询学生
     * @param username
     * @return
     * @throws IOException
     */
    public static Student getStudentByUserName(String username) throws IOException {
        ArrayList<Student> arr = fileToArray();
        for (Student value : arr) {
            if (username.equals(value.getUsername())) {
                return value;
            }
        }
        return null;
    }

    /**
     * 创建学生用户信息文件
     * @throws IOException
     */
    public static void createDataBase() throws IOException {
        File file = createFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        ArrayList<Student> arrayList = new ArrayList<>();
        writer.write(JSON.toJSONString(arrayList));
        writer.flush();
        writer.close();
    }

    /**
     * 添加学生
     * @param per
     * @throws IOException
     */
    public static boolean addNewPer(Student per) throws IOException, UserIsExistException {
        if (isStudentExist(per.getStudentNum())){
            throw new UserIsExistException("该用户已经存在");
        }
        ArrayList<Student> per_arr = fileToArray();
        per_arr.add(per);
        arrToFile(per_arr);
        System.out.println("添加学生成功....");
        return true;
    }

    /**
     * 查询所有学生
     * @return
     * @throws IOException
     */
    public static ArrayList<Student> showAllStudent() throws IOException {
        return fileToArray();
    }

    /**
     * 查询单个学生(根据学号查询)
     * @param studentNum
     * @return
     * @throws IOException
     */
    public static Student showPerStudentByNum(String studentNum) throws IOException, UserNotFoundException {
        ArrayList<Student> arr = fileToArray();
        Student student = null;
        for (Student value : arr) {
            if (studentNum.equals(value.getStudentNum())) {
                student = value;
                break;
            }
        }
        if (student == null){
            throw new UserNotFoundException("该用户不存在！");
        }
        return student;
    }

    /**
     * 根据学号删除学生
     * @param studentNum
     * @return
     * @throws IOException
     */
    public static boolean deleteStudentByNum(String studentNum) throws IOException, UserNotFoundException {
        ArrayList<Student> arr = fileToArray();
        int nameIndex = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (studentNum.equals(arr.get(i).getStudentNum())) {
                nameIndex = i;
                break;
            }
        }
        if (nameIndex == -1) {
            throw new UserNotFoundException("该用户不存在！");
        } else {
            arr.remove(nameIndex);
            System.out.println("刪除成功...");
            arrToFile(arr);
            return true;
        }
    }

    /**
     * 根据学号修改学生信息
     * @param studentNum
     * @param student
     * @return
     * @throws IOException
     */
    public static boolean updateStudentByNum(String studentNum, Student student) throws IOException, UserNotFoundException {
        ArrayList<Student> per_arr = fileToArray();
        boolean flag = false;
        for (int i = 0; i < per_arr.size(); i++) {
            if (studentNum.equals(per_arr.get(i).getStudentNum())) {
                per_arr.set(i, student);
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
