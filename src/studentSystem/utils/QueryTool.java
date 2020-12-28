package studentSystem.utils;

import studentSystem.dto.StudentDTO;
import studentSystem.dto.SubjectDTO;
import studentSystem.dto.TeacherDTO;
import studentSystem.pojo.Student;
import studentSystem.pojo.Subject;
import studentSystem.pojo.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author D.hu
 * @date 2020/12/6
 * @desc
 */
public class QueryTool {

    private static SimpleTools simpleTools = new SimpleTools();

    /**
     * 根据成绩的升序排列
     *
     * @return
     * @throws IOException
     */
    public static ArrayList<Subject> queryUpSortBySum() throws IOException {
        ArrayList<Subject> subjects = SubjectTool.showAllSubject();
        subjects = (ArrayList<Subject>) subjects.stream().sorted(Comparator.comparing(Subject::getSum)).collect(Collectors.toList());
        return subjects;
    }

    /**
     * 根据成绩的降序排列
     *
     * @return
     * @throws IOException
     */
    public static ArrayList<Subject> queryDwonSortBySum() throws IOException {
        ArrayList<Subject> subjects = SubjectTool.showAllSubject();
        subjects = (ArrayList<Subject>) subjects.stream().sorted(Comparator.comparing(Subject::getSum).reversed()).collect(Collectors.toList());
        return subjects;
    }

    /**
     * 升序
     *
     * @return
     * @throws IOException
     */
    public static ArrayList<SubjectDTO> queryStudentSubjectUp() throws IOException {
        ArrayList<Subject> subjects = queryUpSortBySum();
        ArrayList<Student> students = StudentTool.showAllStudent();
        ArrayList<SubjectDTO> dtos = new ArrayList<>();
        for (Subject subject : subjects) {
            for (Student student : students) {
                if (student.getStudentNum().equals(subject.getStudentNum())) {
                    SubjectDTO dto = new SubjectDTO(student.getId(), student.getName(), student.getSex(), student.getAge(),
                            student.getStudentNum(), subject.getChinese(), subject.getMath(), subject.getEnglish(),
                            subject.getPhysics(), subject.getChemistry(), subject.getBiology(), subject.getSum());
                    dtos.add(dto);
                }
            }
        }
        return dtos;
    }

    /**
     * 降序
     *
     * @return
     * @throws IOException
     */
    public static ArrayList<SubjectDTO> queryStudentSubjectDwon() throws IOException {
        ArrayList<Subject> subjects = queryDwonSortBySum();
        ArrayList<Student> students = StudentTool.showAllStudent();
        ArrayList<SubjectDTO> dtos = new ArrayList<>();
        for (Subject subject : subjects) {
            for (Student student : students) {
                if (student.getStudentNum().equals(subject.getStudentNum())) {
                    SubjectDTO dto = new SubjectDTO(student.getId(), student.getName(), student.getSex(), student.getAge(),
                            student.getStudentNum(), subject.getChinese(), subject.getMath(), subject.getEnglish(),
                            subject.getPhysics(), subject.getChemistry(), subject.getBiology(), subject.getSum());
                    dtos.add(dto);
                }
            }
        }
        return dtos;
    }

    /**
     * 根据姓名和学号
     *
     * @param name
     * @return
     * @throws IOException
     */
    public static ArrayList<SubjectDTO> querySubjectByName(String name, String studentNum) throws IOException {
        ArrayList<Subject> subjects = queryDwonSortBySum();
        ArrayList<Student> students = StudentTool.showAllStudent();
        ArrayList<SubjectDTO> dtos = new ArrayList<>();
        if (!simpleTools.isEmpty(name) && simpleTools.isEmpty(studentNum)) {
            for (Subject subject : subjects) {
                for (Student student : students) {
                    if (student.getStudentNum().equals(subject.getStudentNum()) && name.equals(student.getName())) {
                        SubjectDTO dto = new SubjectDTO(student.getId(), student.getName(), student.getSex(), student.getAge(),
                                student.getStudentNum(), subject.getChinese(), subject.getMath(), subject.getEnglish(),
                                subject.getPhysics(), subject.getChemistry(), subject.getBiology(), subject.getSum());
                        dtos.add(dto);
                    }
                }
            }
        }
        if (simpleTools.isEmpty(name) && !simpleTools.isEmpty(studentNum)) {
            for (Subject subject : subjects) {
                for (Student student : students) {
                    if (student.getStudentNum().equals(subject.getStudentNum()) && studentNum.equals(student.getStudentNum())) {
                        SubjectDTO dto = new SubjectDTO(student.getId(), student.getName(), student.getSex(), student.getAge(),
                                student.getStudentNum(), subject.getChinese(), subject.getMath(), subject.getEnglish(),
                                subject.getPhysics(), subject.getChemistry(), subject.getBiology(), subject.getSum());
                        dtos.add(dto);
                    }
                }
            }
        }
        if (!simpleTools.isEmpty(name) && !simpleTools.isEmpty(studentNum)) {
            for (Subject subject : subjects) {
                for (Student student : students) {
                    if (student.getStudentNum().equals(subject.getStudentNum()) && name.equals(student.getName()) && studentNum.equals(student.getStudentNum())) {
                        SubjectDTO dto = new SubjectDTO(student.getId(), student.getName(), student.getSex(), student.getAge(),
                                student.getStudentNum(), subject.getChinese(), subject.getMath(), subject.getEnglish(),
                                subject.getPhysics(), subject.getChemistry(), subject.getBiology(), subject.getSum());
                        dtos.add(dto);
                    }
                }
            }
        }
        if (simpleTools.isEmpty(name) && simpleTools.isEmpty(studentNum)){
            for (Subject subject : subjects) {
                for (Student student : students) {
                    if (student.getStudentNum().equals(subject.getStudentNum())) {
                        SubjectDTO dto = new SubjectDTO(student.getId(), student.getName(), student.getSex(), student.getAge(),
                                student.getStudentNum(), subject.getChinese(), subject.getMath(), subject.getEnglish(),
                                subject.getPhysics(), subject.getChemistry(), subject.getBiology(), subject.getSum());
                        dtos.add(dto);
                    }
                }
            }
        }

        return dtos;
    }

    /**
     * 查询学生信息
     * @return
     * @throws IOException
     */
    public static ArrayList<StudentDTO> getStudentByQuery() throws IOException {
        ArrayList<Student> list = StudentTool.showAllStudent();
        ArrayList<StudentDTO> dtos = new ArrayList<>();
        for (Student student : list){
            StudentDTO dto = new StudentDTO(student.getUsername(), student.getPassword(), student.getIdentity(),
                    student.getName(), student.getSex(), student.getAge(), student.getPhone(), student.getStudentNum());
            dtos.add(dto);
        }
        return dtos;
    }

    public static ArrayList<StudentDTO> getStudentByQuery(String name, String studentNum) throws IOException {
        ArrayList<Student> list = StudentTool.showAllStudent();
        ArrayList<StudentDTO> dtos = new ArrayList<>();
        if (!simpleTools.isEmpty(name) && simpleTools.isEmpty(studentNum)) {
            for (Student student : list){
                if (name.equals(student.getName())){
                    StudentDTO dto = new StudentDTO(student.getUsername(), student.getPassword(), student.getIdentity(),
                            student.getName(), student.getSex(), student.getAge(), student.getPhone(), student.getStudentNum());
                    dtos.add(dto);
                }
            }
        }
        if (simpleTools.isEmpty(name) && !simpleTools.isEmpty(studentNum)) {
            for (Student student : list){
                if (studentNum.equals(student.getStudentNum())){
                    StudentDTO dto = new StudentDTO(student.getUsername(), student.getPassword(), student.getIdentity(),
                            student.getName(), student.getSex(), student.getAge(), student.getPhone(), student.getStudentNum());
                    dtos.add(dto);
                }
            }
        }
        if (!simpleTools.isEmpty(name) && !simpleTools.isEmpty(studentNum)) {
            for (Student student : list){
                if (name.equals(student.getName()) && studentNum.equals(student.getStudentNum())){
                    StudentDTO dto = new StudentDTO(student.getUsername(), student.getPassword(), student.getIdentity(),
                            student.getName(), student.getSex(), student.getAge(), student.getPhone(), student.getStudentNum());
                    dtos.add(dto);
                }
            }
        }
        if (simpleTools.isEmpty(name) && simpleTools.isEmpty(studentNum)){
            for (Student student : list){
                StudentDTO dto = new StudentDTO(student.getUsername(), student.getPassword(), student.getIdentity(),
                        student.getName(), student.getSex(), student.getAge(), student.getPhone(), student.getStudentNum());
                dtos.add(dto);
            }
        }
        return dtos;
    }

    /**
     * 查询老师信息
     * @return
     * @throws IOException
     */
    public static ArrayList<TeacherDTO> getTeacherByQuery() throws IOException {
        ArrayList<Teacher> list = TeacherTool.showAllTeacher();
         ArrayList<TeacherDTO> dtos = new ArrayList<>();
         for (Teacher teacher : list){
             TeacherDTO dto = new TeacherDTO(teacher.getWorkNum(), teacher.getUsername(), teacher.getPassword(),
                     teacher.getName(), teacher.getSex(), teacher.getAge(), teacher.getPhone());
             dtos.add(dto);
         }
         return dtos;
    }

    public static ArrayList<TeacherDTO> getTeacherByQuery(String name, String workNum) throws IOException {
        ArrayList<Teacher> list = TeacherTool.showAllTeacher();
        ArrayList<TeacherDTO> dtos = new ArrayList<>();
        if (!simpleTools.isEmpty(name) && simpleTools.isEmpty(workNum)) {
            for (Teacher teacher : list){
                if (name.equals(teacher.getName())){
                    TeacherDTO dto = new TeacherDTO(teacher.getWorkNum(), teacher.getUsername(), teacher.getPassword(),
                            teacher.getName(), teacher.getSex(), teacher.getAge(), teacher.getPhone());
                    dtos.add(dto);
                }
            }
        }
        if (simpleTools.isEmpty(name) && !simpleTools.isEmpty(workNum)) {
            for (Teacher teacher : list){
                if (workNum.equals(teacher.getWorkNum())){
                    TeacherDTO dto = new TeacherDTO(teacher.getWorkNum(), teacher.getUsername(), teacher.getPassword(),
                            teacher.getName(), teacher.getSex(), teacher.getAge(), teacher.getPhone());
                    dtos.add(dto);
                }
            }
        }
        if (!simpleTools.isEmpty(name) && !simpleTools.isEmpty(workNum)) {
            for (Teacher teacher : list){
                if (name.equals(teacher.getName()) && workNum.equals(teacher.getWorkNum())){
                    TeacherDTO dto = new TeacherDTO(teacher.getWorkNum(), teacher.getUsername(), teacher.getPassword(),
                            teacher.getName(), teacher.getSex(), teacher.getAge(), teacher.getPhone());
                    dtos.add(dto);
                }
            }
        }
        if (simpleTools.isEmpty(name) && simpleTools.isEmpty(workNum)){
            for (Teacher teacher : list){
                TeacherDTO dto = new TeacherDTO(teacher.getWorkNum(), teacher.getUsername(), teacher.getPassword(),
                        teacher.getName(), teacher.getSex(), teacher.getAge(), teacher.getPhone());
                dtos.add(dto);
            }
        }
        return dtos;
    }

}
