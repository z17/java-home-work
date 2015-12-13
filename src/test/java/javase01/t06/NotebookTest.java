package javase01.t06;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class NotebookTest {

    Notebook notebook = new Notebook();

    @Test
    public void testAddNote() throws Exception {
        String test1 = "note";
        String test2 = "note two";
        String test3 = "note tree";
        notebook.addNote(test1);
        notebook.addNote(test2);
        notebook.addNote(test3);
        assertTrue(notebook.getCountNote() > 0);
    }

    @Test
    public void testDeleteNote() throws Exception {
        String test1 = "note";
        String test2 = "note two";
        notebook.addNote(test1);
        notebook.addNote(test2);
        int size1 = notebook.getCountNote();
        notebook.deleteNote(0);
        int size2 = notebook.getCountNote();
        notebook.deleteNote(test2);
        assertTrue(size1 > size2);
        assertTrue(size2 > notebook.getCountNote());
    }

    @Test
    public void testPrint() throws Exception {
        notebook.addNote("test");
        notebook.print();
    }

    @Test
    public void testEditNote() throws Exception {
        String str1 = "test";
        String str2 = "edit";
        notebook.addNote(str1);

        assertEquals(notebook.getNote(0).getText(), str1);
        notebook.editNote(0, str2);
        assertEquals(notebook.getNote(0).getText(), str2);

    }
}