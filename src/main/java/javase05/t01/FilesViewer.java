package javase05.t01;

import java.io.*;

public class FilesViewer {
    private static final String FOLDER_NOT_FOUND = "Folder Not Found";
    private static final String FILE_NOT_FOUND = "File Not Found";
    File currentFolder;

    public static final String DEFAULT_PATH = "C:\\";


    public FilesViewer() {
        openFolder(DEFAULT_PATH);
    }

    public FilesViewer(String path) {
        openFolder(path);
    }

    public void ls() {
        File[] files = currentFolder.listFiles();

        try {
            for (File one : files) {
                System.out.println(one);
            }
        } catch (NullPointerException e) {
            System.out.println(FOLDER_NOT_FOUND);
        }
    }

    public void cd(String folderName) {
        String path = getPath(folderName);
        openFolder(path);
    }

    public void echo(String fileName, String text, boolean append) {
        fileName = getPath(fileName);
        try (OutputStreamWriter file = new OutputStreamWriter(new FileOutputStream(fileName, append));
             BufferedWriter fileBuffer = new BufferedWriter(file);
        ) {
            fileBuffer.write(text);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(String fileName) {
        fileName = getPath(fileName);
        try (Reader file = new FileReader(fileName)) {
            StringBuilder text = new StringBuilder();
            int val = file.read();
            while (val != -1) {
                text.append((char) val);
                val = file.read();
            }
            System.out.println(text);

        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void openFolder(String path) {
        File newFile = new File(path);
        if (newFile.exists()) {
            currentFolder = newFile;
        } else {
            System.out.println(FOLDER_NOT_FOUND);
        }
    }

    private String getPath(String path) {
        if (path.contains("\\")) {
            return path;
        } else {
            return currentFolder.getAbsolutePath() + "\\" + path;
        }

    }
}
