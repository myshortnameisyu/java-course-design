package studentSystem.utils;

import com.alibaba.fastjson.JSON;
import studentSystem.myException.SubjectNotFoundException;
import studentSystem.pojo.Subject;

import java.io.*;
import java.util.ArrayList;

/**
 * 成绩信息操作工具类
 */
public class SubjectTool {

    // 模拟数据库
    private static String file_path = "/Users/dinghu/Documents/JavaProject/javaHomework/src/studentSystem/db/subject.txt";

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
    private static String arrToString(ArrayList<Subject> arr) {
        return JSON.toJSONString(arr);
    }

    /**
     * 将字符串转为数组对象
     * @param content
     * @return
     */
    private static ArrayList<Subject> strToArray(String content) {
        return (ArrayList<Subject>) JSON.parseArray(content, Subject.class);
    }

    /**
     * 从文件中提取数组对象
     * @return
     * @throws IOException
     */
    private static ArrayList<Subject> fileToArray() throws IOException {
        String file = readFile();
        return strToArray(file);
    }

    /**
     *  将数组文件写入文件
     * @param arr
     * @throws IOException
     */
    private static void arrToFile(ArrayList<Subject> arr) throws IOException {
        String arrStr = arrToString(arr);
        writeFile(arrStr);
    }

    /**
     * 判断学生成绩信息是否已经存在
     * @param studentNum
     * @return
     * @throws IOException
     */
    private static boolean isSubjectExist(String studentNum) throws IOException {
        ArrayList<Subject> arr = fileToArray();
        for (Subject value : arr) {
            if (studentNum.equals(value.getStudentNum())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 创建成绩信息文件
     * @throws IOException
     */
    public static void createDataBase() throws IOException {
        File file = createFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        ArrayList<Subject> arrayList = new ArrayList<>();
        writer.write(JSON.toJSONString(arrayList));
        writer.flush();
        writer.close();
    }

    /**
     *添加一个成绩
     * @param subject
     * @throws IOException
     */
    public static boolean addNewSub(Subject subject) throws IOException, SubjectNotFoundException {
        if (isSubjectExist(subject.getStudentNum())){
            throw new SubjectNotFoundException("学生成绩信息已存在！");
        }
        ArrayList<Subject> per_arr = fileToArray();
        per_arr.add(subject);
        arrToFile(per_arr);
        System.out.println("添加成绩成功....");
        return true;
    }

    /**
     * 查询所有成绩
     * @return
     * @throws IOException
     */
    public static ArrayList<Subject> showAllSubject() throws IOException {
        return fileToArray();
    }

    /**
     * 根据学号查成绩
     * @param studentNum
     * @return
     * @throws IOException
     */
    public static Subject showPerSubjectByNum(String studentNum) throws IOException, SubjectNotFoundException {
        ArrayList<Subject> arr = fileToArray();
        Subject subject = null;
        for (Subject value : arr) {
            if (studentNum.equals(value.getStudentNum())) {
                subject = value;
                break;
            }
        }
        if (subject != null){
            System.out.println("查询成功.....");
            throw new SubjectNotFoundException("该学生成绩信息未找到");
        }
        return subject;
    }

    /**
     * 根据学号删除学生成绩
     * @param studentNum
     * @return
     * @throws IOException
     */
    public static boolean deleteSubjectByNum(String studentNum) throws IOException, SubjectNotFoundException {
        ArrayList<Subject> arr = fileToArray();
        int nameIndex = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (studentNum.equals(arr.get(i).getStudentNum())) {
                nameIndex = i;
                break;
            }
        }
        if (nameIndex == -1) {
            throw new SubjectNotFoundException("该学生成绩信息未找到");
        } else {
            arr.remove(nameIndex);
            System.out.println("刪除成绩成功...");
            arrToFile(arr);
            return true;
        }
    }

    /**
     * 根据学号修改学生成绩
     * @param studentNum
     * @param subject
     * @return
     * @throws IOException
     */
    public static boolean updateStudentByNum(String studentNum, Subject subject) throws IOException, SubjectNotFoundException {
        ArrayList<Subject> per_arr = fileToArray();
        boolean flag = false;
        for (int i = 0; i < per_arr.size(); i++) {
            if (studentNum.equals(per_arr.get(i).getStudentNum())) {
                per_arr.set(i, subject);
                flag = true;
                break;
            }
        }
        if (flag){
            arrToFile(per_arr);
            System.out.println("修改成功....");
            return true;
        }else {
            throw new SubjectNotFoundException("该学生成绩信息未找到");
        }
    }

}
