package javase02.t05;

import java.util.ArrayList;

public class Group<T> {
    ArrayList<Student> students = new ArrayList<Student>();
    Subject subject;


    public Group(Subject subject) {
        this.subject = subject;
    }

    public void addStudent(String name, T mark) {
        Student<T> newStudent = new Student<T>(name, mark);
        students.add(newStudent);
    }

    public T getStudentMark(String name) {
        for (Student current: students) {
            if (current.getName().equals(name)) {
                return (T)current.getMark();
            }
        }

        return null;
    }
}
