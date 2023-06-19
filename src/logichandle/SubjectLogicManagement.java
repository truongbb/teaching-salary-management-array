package logichandle;

import entity.Subject;

import java.util.Scanner;

public class SubjectLogicManagement {

    private Subject[] subjects = new Subject[100];

    public Subject[] getSubjects() {
        return subjects;
    }

    public void showSubject() {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                System.out.println(subjects[i]);
            }
        }
    }

    public void inputNewSubject() {
        System.out.println("Bạn muốn nhập dữ liệu cho bao nhiêu môn học: ");
        int subjectNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < subjectNumber; i++) {
            Subject subject = new Subject();
            subject.inputInfo();
            saveSubject(subject);
        }
    }

    public void saveSubject(Subject subject) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == null) {
                subjects[i] = subject;
                break;
            }
        }
    }

    public boolean subjectIsNotEmpty() {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                return true;
            }
        }
        return false;
    }

}
