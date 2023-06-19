package entity;

import java.util.Scanner;

public class Subject implements InputInfo {

    private static int AUTO_ID = 100;

    private int id;
    private String name;
    private int totalLesson;
    private int theoryLesson;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalLesson() {
        return totalLesson;
    }

    public void setTotalLesson(int totalLesson) {
        this.totalLesson = totalLesson;
    }

    public int getTheoryLesson() {
        return theoryLesson;
    }

    public void setTheoryLesson(int theoryLesson) {
        this.theoryLesson = theoryLesson;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalLesson=" + totalLesson +
                ", theoryLesson=" + theoryLesson +
                ", price=" + price +
                '}';
    }

    @Override
    public void inputInfo() {
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập tên môn học: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập tổng số tiết: ");
        this.totalLesson = new Scanner(System.in).nextInt();
        System.out.println("Nhập tổng số tiết lý thuyết: ");
        this.theoryLesson = new Scanner(System.in).nextInt();
        System.out.println("Nhập mức kinh phí cho 1 tiết học: ");
        this.price = new Scanner(System.in).nextDouble();
    }

}
