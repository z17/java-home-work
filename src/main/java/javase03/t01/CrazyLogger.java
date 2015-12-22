package javase03.t01;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrazyLogger {
    static StringBuffer buffer = new StringBuffer();


    public static void add(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy : HH:mm");
        String newMessage = dateFormat.format( new Date() ) + " - " + message + '\n';
        buffer.append(newMessage);
    }

    public static StringBuffer findMessages(int day, int month, int year) {
        StringBuffer finder = new StringBuffer();
        String pattern;
        if (day == 0 && month == 0 ) {
            pattern = "(\\d\\d-" + "\\d\\d-" + year + " : \\d\\d:\\d\\d - (.*)\\n)";
        } else if (day == 0) {
            pattern = "(\\d\\d-" + month + "-" + year + " : \\d\\d:\\d\\d - (.*)\\n)";
        } else {
            pattern = "(" + day + "-" + month + "-" + year + " : \\d\\d:\\d\\d - (.*)\\n)";
        }

        Pattern patternFind = Pattern.compile(pattern);
        Matcher m = patternFind.matcher(buffer);
        while (m.find()) {
            finder.append(m.group(1));
        }
        return finder;
    }

    public static StringBuffer findMessages(int month, int year) {
        return findMessages(0, month, year);
    }

    public static StringBuffer findMessages(int year) {
        return findMessages(0, 0, year);
    }

    public static StringBuffer getBuffer() {
        return buffer;
    }
}
