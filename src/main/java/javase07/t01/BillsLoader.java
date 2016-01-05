package javase07.t01;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BillsLoader {
    private String path;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public BillsLoader(String path) {
        this.path = path;
    }

    public ArrayList<Bill> load() {
        ArrayList<String> billsStr = getFile();
        ArrayList<Bill> bills = new ArrayList<>();

        for (String bill: billsStr) {
            String pattern = "(\\d*?) (\\d*?) (\\d\\d-\\d\\d-\\d\\d\\d\\d \\d\\d:\\d\\d) (\\d*)";
            Pattern patternFind = Pattern.compile(pattern);
            Matcher links = patternFind.matcher(bill);
            if (links.find()) {
                String from = links.group(1);
                String to = links.group(2);
                String dateStr = links.group(3);
                int sum = Integer.parseInt(links.group(4));
                LocalDateTime date = LocalDateTime.parse(dateStr, FORMATTER);
                bills.add(new Bill(from, to, sum, date));
            }
        }
        return  bills;
    }

    public void saveBill(Bill bill) {
        String text = bill.getSender() + " " + bill.getRecipient() + " " + bill.getDate().format(FORMATTER) + " " + bill.getSum() + "\n";
        try (OutputStreamWriter file = new OutputStreamWriter(new FileOutputStream(path, true));
             BufferedWriter fileBuffer = new BufferedWriter(file);
        ) {
            fileBuffer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> getFile() {
        ArrayList<String> bills = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                bills.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bills;
    }
}
