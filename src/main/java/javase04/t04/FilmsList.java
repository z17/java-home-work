package javase04.t04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FilmsList implements java.io.Serializable {
    private int maxActorId;
    private ArrayList<Film> films;

    // ключ - id, а не имя, т.к. могут быть два актёра с одним именем
    private HashMap<Integer, Actor> actors;

    public FilmsList() {
        maxActorId = 0;
        films = new ArrayList<>();
        actors = new HashMap<>();
    }

    public void addActor(String name, String date, int rating) {
        Actor newActor = new Actor(name, date, rating);
        actors.put(++maxActorId, newActor);
    }

    public void addActor(String name, String date) {
        Actor newActor = new Actor(name, date);
        actors.put(++maxActorId, newActor);
    }

    public void addFilm(String name, ArrayList<String> actors) {
        Film newFilm = new Film(name);

        for(String actor: actors) {
            int actorId = findActorIdByName(actor);
            if (actorId >= 0) {
                newFilm.addActor(actorId);
            } else {
                Actor newActor = new Actor(actor);
                this.actors.put(++maxActorId, newActor);
                newFilm.addActor(maxActorId);
            }
        }
        films.add(newFilm);
    }

    public void addFilm(String name, HashSet<Integer> actors) {
        Film newFilm = new Film(name, actors);
        films.add(newFilm);
    }

    private int findActorIdByName(String name) {
        for (Map.Entry<Integer, Actor> entry: actors.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public HashMap<Integer, Actor> getActors() {
        return actors;
    }
}
