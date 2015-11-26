package javase01.t06;


/**
 * <p>Одна запись</p>
 *
 * @author Maksim
 * @version 1
 */
public class Note {
    private String text;

    public Note() {
    }
    /**
     * @param text строка - содержимое записи
     */
    public Note(String text) {
        this.text = text;
    }

    /**
     * @return Запись
     */
    public String getText() {
        return text;
    }

    /**
     * @param text новое значение записи
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @param text строка для проверки
     */
    public boolean equalsValue(String text) {
        return this.text.equals(text);
    }


    /**
     * @return текстовое представление объекта
     */
    public String toString() {
        return "Note{" +
                "text='" + text + '\'' +
                '}';
    }
}
