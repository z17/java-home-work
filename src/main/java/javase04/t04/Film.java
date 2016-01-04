package javase04.t04;

import java.util.HashSet;

public class Film implements java.io.Serializable {
    private String name;
    private HashSet<Integer> actors;    // только уникальные значения


    public Film(String name) {
        this.name = name;
        actors = new HashSet<>();
    }

    public Film(String name, HashSet<Integer> actors) {
        this.name = name;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public HashSet<Integer> getActors() {
        return actors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addActor(int actor) {
        actors.add(actor);
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", actors=" + actors +
                '}';
    }
}
