package logichandle;

import java.util.Scanner;

public class MenuLogicManagement {

    private final TeacherLogicManagement teacherLogicManagement = new TeacherLogicManagement();
    private final SubjectLogicManagement subjectLogicManagement = new SubjectLogicManagement();
    private final TeachingLogicManagement teachingLogicManagement = new TeachingLogicManagement(teacherLogicManagement, subjectLogicManagement);

    public void menu() {
        while (true) {
            showMenuContent();
            int choice = functionChoice();
            switch (choice) {
                case 1:
                    teacherLogicManagement.inputNewTeacher();
                    break;
                case 2:
                    teacherLogicManagement.showTeacher();
                    break;
                case 3:
                    subjectLogicManagement.inputNewSubject();
                    break;
                case 4:
                    subjectLogicManagement.showSubject();
                    break;
                case 5:
                    teachingLogicManagement.inputNewTeaching();
                    break;
                case 6:
                    teachingLogicManagement.showTeaching();
                    break;
                case 7:
                    break;
                case 8:
                    teachingLogicManagement.calculateSalary();
                    break;
                case 9:
                    return;
            }
        }
    }

    private int functionChoice() {
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 9) {
                break;
            }
            System.out.println("Nhập sai, mời nhập lại: ");
        } while (true);
        return choice;
    }

    private void showMenuContent() {
        System.out.println("=============PHẦN MỀM QUẢN LÝ TRẢ LƯƠNG CHO GIẢNG VIÊN THỈNH GIẢNG==============");
        System.out.println("1. Thêm mới giảng viên.");
        System.out.println("2. In danh sách giảng viên.");
        System.out.println("3. Thêm mới môn học.");
        System.out.println("4. In danh sách môn học.");
        System.out.println("5. Lập bảng kê khai giảng dạy.");
        System.out.println("6. In bảng kê khai giảng dạy.");
        System.out.println("7. Sắp xếp bảng kê khai giảng dạy.");
        System.out.println("8. Tính lương giảng viên.");
        System.out.println("9. Thoát.");
        System.out.println("Chọn đê: ");
    }

}
