package javase02.t05;


import java.util.ArrayList;

public class GroupPull {
    ArrayList<Group> groups = new ArrayList<Group>();

    public void createGroup(Subject type) {
        Group newGroup = null;
        switch (type) {
            case BIOLOGY:
                newGroup = new Group<Integer>(type);
                break;
            case LANGUAGE:
                newGroup = new Group<Double>(type);
                break;
            case MATH:
                newGroup = new Group<Integer>(type);
                break;
            case CHEMISTRY:
                newGroup = new Group<Double>(type);
                break;
            default:
                System.exit(-1);
        }
        groups.add(newGroup);
    }

    public <T> void addMark(int number, String name, T mark) {
        Group current = groups.get(number);
        current.addStudent(name, mark);
    }

    public void getMarksOfStudent(String name) {
        for (Group currentGroup: groups) {
            if (currentGroup.getStudentMark(name) != null) {
                System.out.println(
                        currentGroup.subject +
                        " = " +
                        currentGroup.getStudentMark(name)
                );
            }
        }
    }


}
