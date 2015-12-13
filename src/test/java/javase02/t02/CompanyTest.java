package javase02.t02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CompanyTest {

    @Test
    public void test() throws Exception {

        Company company = new Company("Epam");
        company.addWorker("Ivan Ivanov", "Java Developer");
        company.addWorker("Ivan Petrov", "C++ Developer");
        company.addStationery("Ivan Ivanov", "pen", 22.02);
        company.addStationery("Ivan Ivanov", "notebook", 123.03);
        company.addStationery("Ivan Petrov", "pencil", 23.5);

        double all = company.getSumStationery();
        double first = company.getWorkerSumStationery("Ivan Ivanov");
        double second = company.getWorkerSumStationery("Ivan Petrov");
        double error = company.getWorkerSumStationery("Jon");

        assertEquals(all, 168.55, 0.1);
        assertEquals(first, 145.05, 0.1);
        assertEquals(second, 23.5, 0.1);
        assertEquals(error, 0, 0.1);
        System.out.println(company);

    }
}