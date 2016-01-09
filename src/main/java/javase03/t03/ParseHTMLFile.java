package javase03.t03;


import javafx.util.Pair;
import org.jsoup.Jsoup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParseHTMLFile {
    private StringBuilder html = new StringBuilder();

    public void loadFile(String file) {
        try {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();

                while (line != null) {
                    html.append(line);
                    html.append(System.lineSeparator());
                    line = br.readLine();
                }
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
            if (current > prev) {
                prev = current;
            } else {
                return false;
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

    // возвращает все предложения, где содержатся ссылки на рисунки. Если в предложении несколько ссылок - в результате предложения дублируются
    public ArrayList<String> getAllLinkSentence() {
        ArrayList<String> result = new ArrayList<>();
        String clearText = Jsoup.parse(html.toString()).text();

        /*
        ну и ад.
        предложение начинается с заглавной буквы, далее группа означающая всё что может быть, дальше ссылка на рисунок, и снова такая группа
        в конце . ? или !
         */

        // карта где ключ - позиции начала и конца предложения, значение - само предложение
        HashMap<Integer, String> sentences = new HashMap<>();

        //String pattern = "([А-ЯA-Z](|[^?!.\\(]|\\([^\\)]*\\))*\\((р|Р)ис\\. ([0-9]*)\\)(|[^?!.\\(]|\\([^\\)]*\\))*[.?!])";
        //pattern = "([А-ЯA-Z]([^?!.\\(]|\\([^\\)]*\\))*?\\((р|Р)ис\\. ([0-9]*)\\)([^?!.\\(]|\\([^\\)]*\\))*?[.?!])";
        String pattern = "([А-ЯA-Z]([^?!.\\(]|\\([^\\)]*\\))*?[.?!])";
        Pattern patternFind = Pattern.compile(pattern);
        Matcher sentence = patternFind.matcher(clearText);
        while (sentence.find()) {
            sentences.put(sentence.start(), sentence.group(0));
        }

        String patternLinks = "\\((р|Р)ис\\. ([0-9]*)\\)";
        Pattern patternFindLinks = Pattern.compile(patternLinks);
        Matcher links = patternFindLinks.matcher(clearText);
        int prev = 0;
        while (links.find()) {
            int position = links.start();
            String findSentence  = findSentece(position, sentences);
            if (findSentence != null) {
                result.add(findSentence);
            }
        }

        return result;
    }

    public StringBuilder getHtml() {
        return html;
    }

    private String findSentece(int position, HashMap<Integer, String> sentences) {
        for(Entry<Integer, String> current: sentences.entrySet()) {
            if (position >= current.getKey() && position <= current.getKey() + current.getValue().length()) {
                return current.getValue();
            }

        }
        return null;
    }
}
