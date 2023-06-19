package logichandle;

import entity.Teacher;

import java.util.Scanner;

public class TeacherLogicManagement {

    private Teacher[] teachers = new Teacher[100];

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void inputNewTeacher() {
        System.out.println("Bạn muốn thêm mới bao nhiêu giảng viên: ");
        int teacherNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < teacherNumber; i++) {
            System.out.println("Nhập thông tin cho ông giảng viên thứ " + (i + 1));
            Teacher teacher = new Teacher();
            teacher.inputInfo();
            saveTeacher(teacher);
        }
    }

    public void saveTeacher(Teacher teacher) {
        for (int j = 0; j < teachers.length; j++) {
            if (teachers[j] == null) {
                teachers[j] = teacher;
                break;
            }
        }
    }

    public void showTeacher() {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null) {
                System.out.println(teachers[i]);
            }
        }
    }

    public boolean teacherIsNotEmpty() {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null) {
                return true;
            }
        }
        return false;
    }

}
