package javase04.t03;

import java.io.*;

public class FileConverter {
    public static final String ENCODING_OUT = "UTF-16";

    private StringBuilder text = new StringBuilder();
    private String fileIn;
    private String fileOut;

    public FileConverter(String fileIn, String fileOut) {
        this.fileIn = fileIn;
        this.fileOut = fileOut;
    }

    private void readFile() {
        try (Reader file = new FileReader(fileIn)) {
            int val = file.read();
            while (val != -1) {
                text.append((char) val);
                val = file.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFile() {
        try (OutputStreamWriter file = new OutputStreamWriter(new FileOutputStream(fileOut), ENCODING_OUT)) {
            file.write(text.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convert() {
        readFile();
        writeFile();
    }

    public String getFileIn() {
        return fileIn;
    }

    public String getFileOut() {
        return fileOut;
    }
}
