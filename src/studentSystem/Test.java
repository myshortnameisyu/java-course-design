package studentSystem;

import studentSystem.MyException.SubjectNotFoundException;
import studentSystem.MyException.UserIsExistException;
import studentSystem.MyException.UserNotFoundException;
import studentSystem.dto.StudentDTO;
import studentSystem.dto.SubjectDTO;
import studentSystem.pojo.Admin;
import studentSystem.pojo.Student;
import studentSystem.pojo.Subject;
import studentSystem.pojo.Teacher;
import studentSystem.utils.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 测试文件
 */
public class Test {

    public static void main(String[] args) throws IOException, UserIsExistException, UserNotFoundException, SubjectNotFoundException {
//        Student student1 = new Student(1, "dinghu1", "dh100406", 1, "丁虎1", "男", 21, "17330934981", "20180001");
//        System.out.println(Student.idCount);
//        Student student2 = new Student(2, "dinghu2", "dh1006", 1, "丁虎2", "女", 20, "17330934982", "20180002");
//        System.out.println(Student.idCount);
//        Student student3 = new Student(3, "dinghu3", "dh100406", 1, "丁虎3", "男", 22, "17330934983", "20180003");
//        System.out.println(Student.idCount);
//        Student student4 = new Student(4, "dinghu4", "dh1006", 1, "丁虎4", "男", 11, "17330934984", "20180004");
//        System.out.println(Student.idCount);
//        ArrayList<Student> list = new ArrayList<>();
//        list.add(student1);
//        list.add(student2);
//        list.add(student3);
//        list.add(student4);
//        StudentTool.arrToFile(list);
//        StudentTool.createDataBase();
//        Student student = null;
//        try {
//            student = StudentTool.showPerStudentByNum("20180004");
//            System.out.println(student.toString());
//        } catch (UserNotFoundException e) {
//            e.printStackTrace();
//        }

//        ArrayList<Student> list = StudentTool.showAllStudent();
//        for (Student student : list){
//            System.out.println(student.toString());
//        }
//        StudentTool.addNewPer(student1);
//        StudentTool.addNewPer(student2);
//        StudentTool.addNewPer(student3);
//        StudentTool.addNewPer(student4);

//        Student student = StudentTool.showPerStudentByNum("20180002");
//        System.out.println(student.toString());
//        System.out.println(StudentTool.deleteStudentByNum("20180001"));
//        System.out.println(StudentTool.updateStudentByNum("20180006", student1));
//        Subject subject1 = new Subject("20180001", 11, 12, 21, 99, 45, 50);
//        Subject subject2 = new Subject("20180002", 40, 43, 88, 88, 34, 83);
//        Subject subject3 = new Subject("20180003", 32, 22, 44, 55, 32, 84);
//        Subject subject4 = new Subject("20180004", 10, 9, 8, 7, 6, 5);
//        ArrayList<Subject> list = SubjectTool.showAllSubject();
//        for (Subject subject : list){
//            System.out.println(subject.getStudentNum() + "-->" +subject.toString());
//        }
//        System.out.println("-------------------------------");
//        list.add(subject1);
//        list.add(subject2);
//        list.add(subject3);
//        SubjectTool.createDataBase();
//        SubjectTool.addNewSub(subject1);
//        SubjectTool.addNewSub(subject2);
//        SubjectTool.addNewSub(subject3);
//        SubjectTool.addNewSub(subject4);
//        ArrayList<Subject> list1 = QueryTool.queryUpSortBySum();
//        for (Subject subject : list1){
//            System.out.println(subject.getStudentNum() + "-->" +subject.toString());
//        }
//        System.out.println("-------------------------------");
//        ArrayList<Subject> list2 = QueryTool.queryDwonSortBySum();
//        for (Subject subject : list2){
//            System.out.println(subject.getStudentNum() + "-->" +subject.toString());
//        }

//        Subject subject = SubjectTool.showPerSubjectByNum("20180004");
//        System.out.println(subject.toString());
//        System.out.println(SubjectTool.deleteSubjectByNum("20180001"));
//        System.out.println(SubjectTool.updateStudentByNum("20180002", subject4));

//        Teacher teacher1 = new Teacher(1, "dinghu", "fgsdvds", 1, "丁虎", "女", 22, "17330934981", "916321");
//        Teacher teacher2 = new Teacher(2, "dinghu2", "12344", 1, "张三", "女", 60, "17330934988", "916322");
//        Teacher teacher3 = new Teacher(3, "dinghu3", "sdfsefv", 2, "李四", "男", 40, "17330934980", "916323");
//        TeacherTool.addNewTeacher(teacher1);
//        TeacherTool.addNewTeacher(teacher2);
//        TeacherTool.addNewTeacher(teacher3);
//        ArrayList<Teacher> list = new ArrayList<>();
//        list.add(teacher1);
//        list.add(teacher2);
//        list.add(teacher3);
//        ArrayList<Teacher> list = TeacherTool.showAllTeacher();
//        for (Teacher teacher : list){
//            System.out.println(teacher.toString());
//        }
//        System.out.println(StudentTool.getStudentByUserName("dinghu1").toString());

//        TeacherTool.createDataBase();
//        TeacherTool.addNewTeacher(teacher2);
//        Teacher teacher = TeacherTool.showPerTeacherByNum("916321");
//        System.out.println(teacher.toString());
//        System.out.println(TeacherTool.updateStudentByNum("916324", teacher1));
//        System.out.println(TeacherTool.deleteTeacherByNum("916322"));

//        AdminTool.createDataBase();

//        Admin admin = new Admin(1, "王五", "12345", 2, "丁虎1", "女", 22, "17500934981", "916311");
//        AdminTool.addNewPer(admin);
//        System.out.println(AdminTool.getAdminByUsername("王五").getWorkNum());

//        ArrayList<SubjectDTO> list = QueryTool.queryStudentSubjectDwon();
//        for (SubjectDTO dto : list){
//            System.out.println(dto.getStudentNum() + "->" + dto.getSum());
//        }

    }

}
