package javase02.t05;

import org.junit.Test;


public class GroupPullTest {

    @Test
    public void test() throws Exception {
        GroupPull test = new GroupPull();
        test.createGroup(Subject.BIOLOGY);
        test.createGroup(Subject.CHEMISTRY);
        test.addMark(0, "Ivanov", 5);
        test.addMark(0, "Petrov", 10);
        test.addMark(1, "Ivanov", 3.2);
        test.addMark(1, "Sidorov", 5.3);

        test.getMarksOfStudent("Ivanov");
    }
}