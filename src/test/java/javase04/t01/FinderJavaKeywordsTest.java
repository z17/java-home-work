package javase04.t01;


import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.assertTrue;


public class FinderJavaKeywordsTest {

    @Test
    public void testFileRead() throws Exception {
        FinderJavaKeywords test = new FinderJavaKeywords("F:\\java\\java-home-work\\src\\main\\resources\\javase04\\t01\\input.txt");
        Map<String, Integer> find = test.findKeywords();
        System.out.println(find);
        assertTrue(find.get("new") == 4);
        assertTrue(find.get("private") == 1);
        assertTrue(find.get("class") == 1);
    }
}