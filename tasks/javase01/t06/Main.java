package javase01.t06;

public class Main {
    public static void main(String[] args) {

    // входные данные
        String test1 = "note";
        String test2 = "note two";
        String test3 = "note tree";
        String test4 = "note more";
        String test5 = "note!!";
        String test6 = "note 13";
        String edit = "Edit";

        Notebook notebook = new Notebook();
        notebook.addNote(test1);
        notebook.addNote(test2);
        notebook.addNote(test3);
        notebook.addNote(test4);
        notebook.addNote(test5);
        notebook.addNote(test6);

        notebook.print();
        notebook.deleteNote(2);
        notebook.print();
        notebook.deleteNote(test4);
        notebook.print();
        notebook.editNote(-20, edit);
        notebook.print();
    }
}
