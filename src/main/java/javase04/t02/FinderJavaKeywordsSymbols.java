package javase04.t02;


import javase04.t01.FinderJavaKeywords;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FinderJavaKeywordsSymbols extends FinderJavaKeywords {

    public FinderJavaKeywordsSymbols(String file) {
        super(file);
    }

    private void FileRead() {
        try (Reader file = new FileReader(this.file)) {
            int val = file.read();
            while (val != -1) {
                text.append((char)val);
                val = file.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
