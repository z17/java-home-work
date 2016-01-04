package javase05.t01;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesViewerWrapper {
    public static void help() {
        System.out.println("------------------");
        System.out.println("cd PATH_NAME - change folder");
        System.out.println("ls - view current folder");
        System.out.println("echo TEXT > FILE - create file with text TEXT");
        System.out.println("echo TEXT >> FILE - append to file (if exist) text TEXT");
        System.out.println("read FILE_NAME - print file to console");
        System.out.println("help - print all commands to console");
        System.out.println("exit");
        System.out.println("------------------");
    }

    public static void main(String[] args) {
        FilesViewer wrap = new FilesViewer();
        Scanner scanner = new Scanner(System.in);
        String command;
        help();
        System.out.println("Enter command:");
        do {
            command = scanner.nextLine();
            if (command.startsWith("cd ")) {
                String path = command.substring(3);
                wrap.cd(path);
            } else if (command.equals("ls")) {
                wrap.ls();
            } else if (command.startsWith("echo")) {
                String pattern = "echo(.*?)>(>?)(.*)";
                Pattern patternFind = Pattern.compile(pattern);
                Matcher links = patternFind.matcher(command);
                if (links.find()) {
                    String content = links.group(1).trim();
                    String append = links.group(2).trim();
                    String file = links.group(3).trim();
                    if (append.length() > 0) {
                        wrap.echo(file, content, true);
                    } else {
                        wrap.echo(file, content, false);
                    }
                }
            } else if (command.startsWith("read ")) {
                String path = command.substring(5);
                wrap.readFile(path);
            } else if (command.equals("help")) {
                help();
            } else {
                if (!command.equals("exit")) {
                    System.out.println("command error");
                }
            }
        } while (!command.equals("exit"));
    }
}
