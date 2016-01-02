package javase04.t02;


import org.junit.Test;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FinderJavaKeywordsSymbolsTest {

    @Test
    public void findKeywordsTest() throws Exception {
        FinderJavaKeywordsSymbols test = new FinderJavaKeywordsSymbols("F:\\java\\java-home-work\\src\\main\\resources\\javase04\\t01\\input.txt");
        Map<String, Integer> find = test.findKeywords();

        System.out.println(find);
        assertTrue(find.get("new") == 4);
        assertTrue(find.get("private") == 1);
        assertTrue(find.get("class") == 1);
    }

}