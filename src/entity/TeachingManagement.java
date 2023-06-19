package entity;

import java.util.Arrays;

public class TeachingManagement {

    private Teacher teacher;

//    private Subject[] subjects;
//    private int[] classNumber;
    /**
     * subjects = [A, B, C, D]
     * A --> 2
     * B --> 1
     * C --> 1
     * D --> 3
     * <p>
     * classNumber = [2, 1, 1, 3]
     */

    private TeachingManagementDetail[] details;


    public TeachingManagement(Teacher teacher, TeachingManagementDetail[] details) {
        this.teacher = teacher;
        this.details = details;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public TeachingManagementDetail[] getDetails() {
        return details;
    }

    public void setDetails(TeachingManagementDetail[] details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "TeachingManagement{" +
                "teacher=" + teacher +
                ", details=" + Arrays.toString(details) +
                '}';
    }

}
