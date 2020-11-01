package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void matches() {
        Book book = new Book(1,"Poems",250,"Pushkin");

        boolean actual = book.matches("Poems");
        assertEquals(true,actual);
    }

    @Test
    public void notMatches() {
        Book book = new Book(1,"Poems",250,"Pushkin");

        boolean actual = book.matches("Prose");
        assertEquals(false,actual);
    }
}
