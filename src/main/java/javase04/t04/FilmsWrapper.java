package javase04.t04;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class FilmsWrapper {
    public static final String SERIALIZE_PATH = "F:\\java\\java-home-work\\src\\main\\resources\\javase04\\t04\\output.out";

    private FilmsList films;
    private Scanner scanner;

    public static void main(String[] args) {
        FilmsWrapper project = new FilmsWrapper();

        String command;
        do {
            System.out.println("Enter command: add film, add actor, print films, print actors, serialize, unserialize or exit");
            command = project.scanner.nextLine();

            switch (command) {
                case "add film":
                    System.out.println("Enter film name");
                    String filmName = project.scanner.nextLine();
                    System.out.println("ok! Enter actors name, with separator ','");
                    String actors = project.scanner.nextLine();
                    project.addFilm(filmName, actors);
                    break;
                case "add actor":
                    System.out.println("Enter actor name");
                    String actorName = project.scanner.nextLine();
                    System.out.println("Enter actor date of bith");
                    String actorDate = project.scanner.nextLine();
                    System.out.println("Enter actor rating (0-10)");
                    String actorRating = project.scanner.nextLine();
                    project.addActor(actorName, actorDate, actorRating);
                    break;
                case "print films":
                    project.printFilms();
                    break;
                case "print actors":
                    project.printActors();
                    break;
                case "serialize":
                    project.serialize();
                    break;
                case "unserialize":
                    project.unSerualize();
                    break;
                case "exit":
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("command error, try more");
                    break;
            }
        } while (!command.equals("exit"));
    }

    public FilmsWrapper() {
        this.films = new FilmsList();
        scanner = new Scanner(System.in);
    }

    public void addFilm(String name, String actors) {
        ArrayList<String> actorsList = new ArrayList<>(Arrays.asList(actors.split(",")));
        films.addFilm(name, actorsList);
    }

    public void addActor(String actorName, String actorDate, String actorRating) {
        try {
            int rating = Integer.parseInt(actorRating);
            films.addActor(actorName, actorDate, rating);
        } catch (java.lang.NumberFormatException e) {
            films.addActor(actorName, actorDate);
        }
    }

    public void printActors() {
        for (Map.Entry<Integer, Actor> entry : films.getActors().entrySet()) {
            System.out.println(entry.getKey() + " = [" + entry.getValue() + "]");
        }
        System.out.println();
    }

    public void printFilms() {
        for (Film film : this.films.getFilms()) {
            System.out.println(film);
        }
    }

    public void serialize() {
        try (
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);
                OutputStream file = new FileOutputStream(SERIALIZE_PATH);
        ) {
            oos.writeObject(films);
            os.writeTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void unSerualize() {
        try(
                InputStream file = new FileInputStream(SERIALIZE_PATH);
                ObjectInputStream ois = new ObjectInputStream(file);
        ) {
            films = (FilmsList) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public FilmsList getFilms() {
        return films;
    }
}
