package javase04.t04;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FilmsWrapperTest {

    @Test
    public void testAddFilm() throws Exception {
        FilmsWrapper wrapper = new FilmsWrapper();

        wrapper.addFilm("Film 1", "Actor1,Actor2,Actor3");
        wrapper.addFilm("Film 2", "Actor1,Actor3,Actor5");
        assertTrue(wrapper.getFilms().getFilms().size() == 2);
        assertTrue(wrapper.getFilms().getActors().size() == 4);
    }

    @Test
    public void testAddActor() throws Exception {
        FilmsWrapper wrapper = new FilmsWrapper();

        wrapper.addActor("Actor 1", "12-12-2015", "1dfh");
        wrapper.addActor("Actor 2", "10-12-2015", "6");
        Map<Integer, Actor> actors = wrapper.getFilms().getActors();
        assertTrue(actors.get(1).getRating() == 0);
        assertTrue(actors.get(2).getRating() == 6);
        assertTrue(wrapper.getFilms().getActors().size() == 2);

    }

    @Test
    public void testSerialize() throws Exception {
        FilmsWrapper wrapper = new FilmsWrapper();
        wrapper.addActor("Actor 1", "12-12-2015", "1dfh");
        wrapper.addActor("Actor 2", "10-12-2015", "6");
        wrapper.addFilm("Film 1", "Actor 1,Actor 2,Actor 3");
        wrapper.addFilm("Film 2", "Actor 1,Actor 3,Actor 5");

        wrapper.serialize();

        FilmsWrapper newWrapper = new FilmsWrapper();
        newWrapper.unSerualize();

        assertTrue(wrapper.getFilms().getFilms().size() == newWrapper.getFilms().getFilms().size());
        assertTrue(wrapper.getFilms().getActors().size() == newWrapper.getFilms().getActors().size());

    }
}