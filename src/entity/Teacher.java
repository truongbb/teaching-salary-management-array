package entity;

import statics.TeacherLevel;

import java.util.Scanner;

public class Teacher extends Person {

    private static int AUTO_ID = 100;

    private int id;
    private TeacherLevel level;

    public Teacher() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public TeacherLevel getLevel() {
        return level;
    }

    public void setLevel(TeacherLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", level=" + level +
                '}';
    }

    // Alt + Insert

    @Override
    public void inputInfo() {
        super.inputInfo();
        System.out.println("Nhập trình độ: ");
        System.out.println("1. GS-TS");
        System.out.println("2. PGS-TS");
        System.out.println("3. Giảng viên chính");
        System.out.println("4. Thạc sĩ");
        System.out.println("Chọn đi: ");
        int levelChoice;
        do {
            levelChoice = new Scanner(System.in).nextInt();
            if (levelChoice >= 1 && levelChoice <= 4) {
                break;
            }
            System.out.println("Nhập sai, mời nhập lại: ");
        } while (true);
        switch (levelChoice) {
            case 1:
                this.setLevel(TeacherLevel.GS_TS);
                break;
            case 2:
                this.setLevel(TeacherLevel.PGS_TS);
                break;
            case 3:
                this.setLevel(TeacherLevel.GIANG_VIEN_CHINH);
                break;
            case 4:
                this.setLevel(TeacherLevel.THAC_SY);
                break;
        }
    }

    public int getId() {
        return this.id;
    }
}
