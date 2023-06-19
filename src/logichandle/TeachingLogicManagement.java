package logichandle;

import entity.Subject;
import entity.Teacher;
import entity.TeachingManagement;
import entity.TeachingManagementDetail;

import java.util.Scanner;

public class TeachingLogicManagement {

    private final TeachingManagement[] teachingManagements = new TeachingManagement[100];

    private TeacherLogicManagement teacherLogicManagement;
    private SubjectLogicManagement subjectLogicManagement;

    public TeachingLogicManagement(TeacherLogicManagement teacherLogicManagement, SubjectLogicManagement subjectLogicManagement) {
        this.teacherLogicManagement = teacherLogicManagement;
        this.subjectLogicManagement = subjectLogicManagement;
    }

    public void inputNewTeaching() {
        if (!teacherLogicManagement.teacherIsNotEmpty() || !subjectLogicManagement.subjectIsNotEmpty()) {
            System.out.println("Không có dữ liệu về giảng viên hoặc môn học, vui lòng tạo đủ dữ liệu trước khi phân công");
            return;
        }

        System.out.println("Nhập số giảng viên bạn muốn phân công giảng dạy: ");
        int teacherNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < teacherNumber; i++) {
            System.out.println("Nhập thông tin cho giảng viên thứ " + (i + 1) + " muốn phân công giảng dạy.");
            System.out.println("Nhập ID giảng viên: ");
            int teacherId;
            Teacher teacher = null;
            do {
                teacherId = new Scanner(System.in).nextInt();
                for (int j = 0; j < teacherLogicManagement.getTeachers().length; j++) {
                    if (teacherLogicManagement.getTeachers()[j] != null && teacherLogicManagement.getTeachers()[j].getId() == teacherId) {
                        teacher = teacherLogicManagement.getTeachers()[j];
                        break;
                    }
                }
                if (teacher != null) {
                    break;
                }
                System.out.println("Không tồn tại ID giảng viên vừa nhập, xin vui lòng nhập lại: ");
            } while (true);

            System.out.println("Ông này dạy bao nhiêu môn: ");
            int subjectNumber = new Scanner(System.in).nextInt();
            TeachingManagementDetail[] details = new TeachingManagementDetail[subjectNumber];
            int count = 0;
            for (int j = 0; j < subjectNumber; j++) {
                System.out.println("Môn học thứ " + (j + 1) + " mà ông này muốn dạy là môn nào: ");
                int subjectId;
                Subject subject = null;
                do {
                    subjectId = new Scanner(System.in).nextInt();
                    for (int k = 0; k < subjectLogicManagement.getSubjects().length; k++) {
                        if (subjectLogicManagement.getSubjects()[k] != null && subjectLogicManagement.getSubjects()[k].getId() == subjectId) {
                            subject = subjectLogicManagement.getSubjects()[k];
                            break;
                        }
                    }
                    if (subject != null) {
                        break;
                    }
                    System.out.println("Không tồn tại môn học có ID vừa nhập, vui lòng nhập lại: ");
                } while (true);

                System.out.println("Môn này ông dạy bao nhiêu lớp: ");
                int classNumber;
                do {
                    classNumber = new Scanner(System.in).nextInt();
                    if (classNumber < 1 || classNumber > 3) {
                        System.out.println("Số lớp phải là số dương và nhỏ hơn 3, đừng có tham.");
                        continue;
                    }
                    break;
                } while (true);
                TeachingManagementDetail teachingManagementDetail = new TeachingManagementDetail(subject, classNumber);
                details[count] = teachingManagementDetail;
                count++;
            }

            TeachingManagement teachingManagement = new TeachingManagement(teacher, details);
            saveTeaching(teachingManagement);
        }

    }

    public void showTeaching() {
        for (int i = 0; i < teachingManagements.length; i++) {
            if (teachingManagements[i] != null) {
                System.out.println(teachingManagements[i]);
            }
        }
    }

    public void saveTeaching(TeachingManagement teachingManagement) {
        for (int i = 0; i < teachingManagements.length; i++) {
            if (teachingManagements[i] == null) {
                teachingManagements[i] = teachingManagement;
                break;
            }
        }
    }


    public void calculateSalary() {
        for (int i = 0; i < teachingManagements.length; i++) {
            TeachingManagement teachingManagement = teachingManagements[i];
            if (teachingManagement == null) {
                continue;
            }
            Teacher teacher = teachingManagement.getTeacher();
            double salary = 0;
            TeachingManagementDetail[] details = teachingManagement.getDetails();
            for (int j = 0; j < details.length; j++) {
                Subject subject = details[i].getSubject();
                salary += ((subject.getTotalLesson() - subject.getTheoryLesson()) * 0.7 * subject.getPrice() + subject.getPrice() * subject.getTheoryLesson()) * details[i].getClassNumber();
            }
            System.out.println("Lương của giảng viên " + teacher.getName() + " là  " + salary);
        }
    }
}
