package javase01.t06;

import java.util.ArrayList;

/**
 * <p>Блокнот</p>
 *
 * @author Maksim
 * @version 1
 */
public class Notebook {

    /**
     * <p>Массив записей</p>
     */
    private ArrayList<Note> notes;


    public Notebook() {
        notes = new ArrayList<Note>();

    }


    /**
     * @param number номер
     * @return Note
     */
    public Note getNote(int number) {
        return notes.get(number);
    }

    /**
     *
     * @return кол-во записей
     */
    public int getCountNote() {
        return notes.size();
    }

    /**
     * <p>Добавляет запись в строку</p>
     *
     * @param text строка - содержимое новой записи
     */
    public void addNote(String text) {
        Note newNote = new Note(text);
        notes.add(newNote);
    }

    /**
     * <p>Удаляет все записи с заданным текстом</p>
     *
     * @param text строка - содержимое удаляемой записи
     */
    public void deleteNote(String text) {
        for (int i = 0; i < notes.size(); i++) {
            Note current = notes.get(i);
            if (current.equalsValue(text)) {
                notes.remove(i);
            }
        }
    }

    /**
     * <p>Удаляет заданную запись</p>
     *
     * @param number строка - содержимое удаляемой записи
     * @return true, если удалено, иначе false
     */
    public boolean deleteNote(int number) {
        if (number < notes.size() && number >= 0) {
            notes.remove(number);
            return true;
        } else {
            return false;
        }
    }

    /**
     * <p>Выводит содержимое в консоль</p>
     *
     */
    public void print() {
        System.out.println("Notebook:");
        for (Note current : notes) {
            System.out.println(current.toString());
        }
        System.out.println();
    }

    /**
     * <p>Редактирует запись</p>
     *
     * @param number номер записи
     * @param newText Новое значение записи
     * @return true, если изменено, иначе false
     */
    public boolean editNote(int number, String newText) {
        if (number < notes.size() && number >= 0) {
            notes.get(number).setText(newText);
            return true;
        } else {
            return false;
        }
    }


}
