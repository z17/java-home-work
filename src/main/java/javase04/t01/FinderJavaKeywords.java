package javase04.t01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class FinderJavaKeywords {
    protected StringBuilder text = new StringBuilder();
    protected String file;

    public FinderJavaKeywords(String file) {
        this.file = file;
    }

    private void FileRead(String fileName) {
        try (InputStream file = new FileInputStream(fileName)) {
            int val = file.read();
            while (val != -1) {
                text.append((char)val);
                val = file.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> findKeywords() {
        FileRead(file);

        HashMap<String, Integer> result = new HashMap<>();

        for (String current : JavaKeywords.KEYWORDS) {
            int count = text.toString().split(current).length - 1;
            if (count > 0) {
                result.put(current, count);
            }
        }
        return result;
    }


}
