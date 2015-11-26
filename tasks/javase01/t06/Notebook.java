package javase01.t06;

import java.util.ArrayList;
import java.util.Iterator;

public class Notebook {
    private ArrayList<Note> notes;

    public Notebook() {
        notes = new ArrayList<>();

    }

    public void addNote(String text) {
        Note newNote = new Note(text);
        notes.add(newNote);
    }

    // удаляет все записи с таким же текстом
    public void deleteNote(String text) {
        for (int i = 0; i < notes.size(); i++) {
            Note current = notes.get(i);
            if (current.equalsValue(text)) {
                notes.remove(i);
            }
        }
    }

    public void deleteNote(int number) {
        notes.remove(number);
    }

    public void print() {
        System.out.println("Notebook:");
        for(Note current: notes) {
            System.out.println(current.toString());
        }
        System.out.println();
    }

    public boolean editNote(int number, String newText){
        if (number < notes.size() && number >= 0) {
            notes.get(number).setText(newText);
            return true;
        } else {
            return false;
        }
    }
}
