package javase01.t06;


public class Note {
    private String text;

    public Note() {
    }

    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean equalsValue(String text) {
        return this.text.equals(text);
    }

    @Override
    public String toString() {
        return "Note{" +
                "text='" + text + '\'' +
                '}';
    }
}
