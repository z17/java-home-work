package javase03.t03;


import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParseHTMLFile {
    private StringBuilder html = new StringBuilder();

    public void loadFile(String file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                String line = br.readLine();

                while (line != null) {
                    html.append(line);
                    html.append(System.lineSeparator());
                    line = br.readLine();
                }
            } finally {
                br.close();
            }
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

    }

    // определяем последовательность ссылок
    public boolean detectSequence() {
        String patternLinks = "\\((р|Р)ис\\. ([0-9]*)\\)";
        Pattern patternFindLinks = Pattern.compile(patternLinks);
        Matcher links = patternFindLinks.matcher(html);
        int prev = 0;
        while (links.find()) {
            int current = Integer.parseInt(links.group(2));
            System.out.print(current);
            if (current > prev) {
                prev = current;
            } else {
              //  return false;
            }
        }
        return true;

        /*
        // находим все описания к изображениям
        String patternImages = "(<p>|<div>)(Р|р)ис\\.\\s?([0-9]*)";
        Pattern patternFindImages = Pattern.compile(patternImages);
        Matcher images = patternFindImages.matcher(html);
        ArrayList<Integer> collectImages = new ArrayList<Integer>();
        while (images.find()) {
            collectImages.add(Integer.parseInt(images.group(3)));
        }
        System.out.println(collectImages);
        */
    }

    public ArrayList<String> getAllLinkSentence() {
        ArrayList<String> result = new ArrayList<String>();
        String clearText = Jsoup.parse(html.toString()).text();

        /*
        ну и ад.
        предложение начинается с заглавной буквы, далее группа означающая всё что может быть, дальше ссылка на рисунок, и снова такая группа
        в конце . ? или !
         */
        String pattern = "([А-ЯA-Z](|[^?!.\\(]|\\([^\\)]*\\))*\\((р|Р)ис\\. ([0-9]*)\\)(|[^?!.\\(]|\\([^\\)]*\\))*[.?!])";
        Pattern patternFind = Pattern.compile(pattern);
        Matcher sentence = patternFind.matcher(clearText);
        while (sentence.find()) {
            System.out.print(sentence.group(4));
        }
        return result;
    }

    public StringBuilder getHtml() {
        return html;
    }
}
