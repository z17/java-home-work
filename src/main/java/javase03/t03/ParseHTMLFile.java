package javase03.t03;


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

    // выделяем последовательность описаний изображений и ссылок на них
    public void detect() {
        String patternLinks = "\\((р|Р)ис\\. ([0-9]*)\\)";
        Pattern patternFindLinks = Pattern.compile(patternLinks);
        Matcher links = patternFindLinks.matcher(html);
        ArrayList<Integer> collectLinks = new ArrayList<Integer>();
        while (links.find()) {
            collectLinks.add(Integer.parseInt(links.group(2)));
        }
        System.out.println(collectLinks);

        String patternImages = "(<p>|<div>)(Р|р)ис\\.\\s?([0-9]*)";
        Pattern patternFindImages = Pattern.compile(patternImages);
        Matcher images = patternFindImages.matcher(html);
        ArrayList<Integer> collectImages = new ArrayList<Integer>();
        while (images.find()) {
            collectImages.add(Integer.parseInt(images.group(3)));
        }
        System.out.println(collectImages);
    }

    public StringBuilder getHtml() {
        return html;
    }
}
