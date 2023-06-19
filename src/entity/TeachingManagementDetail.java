package entity;

public class TeachingManagementDetail {

    private Subject subject;
    private int classNumber;

    public TeachingManagementDetail(Subject subject, int classNumber) {
        this.subject = subject;
        this.classNumber = classNumber;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "TeachingManagementDetail{" +
                "subject=" + subject +
                ", classNumber=" + classNumber +
                '}';
    }
}
