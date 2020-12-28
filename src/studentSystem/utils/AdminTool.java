package studentSystem.utils;

import com.alibaba.fastjson.JSON;
import studentSystem.pojo.Admin;

import java.io.*;
import java.util.ArrayList;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class AdminTool {

    // 模拟数据库
    private static String file_path = "D:\\intellij IDEA\\java-course-design\\src\\studentSystem\\db\\admin.txt";

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
    private static String arrToString(ArrayList<Admin> arr) {
        return JSON.toJSONString(arr);
    }

    /**
     * 将字符串转为数组对象
     * @param content
     * @return
     */
    private static ArrayList<Admin> strToArray(String content) {
        return (ArrayList<Admin>) JSON.parseArray(content, Admin.class);
    }

    /**
     * 从文件中提取数组对象
     * @return
     * @throws IOException
     */
    private static ArrayList<Admin> fileToArray() throws IOException {
        String file = readFile();
        return strToArray(file);
    }

    /**
     *  将数组文件写入文件
     * @param arr
     * @throws IOException
     */
    private static void arrToFile(ArrayList<Admin> arr) throws IOException {
        String arrStr = arrToString(arr);
        writeFile(arrStr);
    }

    /**
     * 创建管理员用户信息文件
     * @throws IOException
     */
    public static void createDataBase() throws IOException {
        File file = createFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        ArrayList<Admin> arrayList = new ArrayList<>();
        writer.write(JSON.toJSONString(arrayList));
        writer.flush();
        writer.close();
    }

    /**
     * 添加管理员
     * @param per
     * @throws IOException
     */
    public static void addNewPer(Admin per) throws IOException {
        ArrayList<Admin> per_arr = fileToArray();
        per_arr.add(per);
        arrToFile(per_arr);
        System.out.println("添加管理员成功....");
    }

    /**
     * 根据用户名查询管理员
     * @param username
     * @return
     * @throws IOException
     */
    public static Admin getAdminByUsername(String username) throws IOException {
        ArrayList<Admin> arr = fileToArray();
        for (Admin admin : arr){
            if (username.equals(admin.getUsername())){
                return admin;
            }
        }
        return null;
    }

}
