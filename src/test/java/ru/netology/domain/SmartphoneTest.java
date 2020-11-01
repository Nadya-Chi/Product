package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartphoneTest {

    @Test
    public void matches() {
        Smartphone smartphone = new Smartphone(3,"Apple",50000,"USA");

        boolean actual = smartphone.matches("USA");
        assertEquals(true,actual);
    }

    @Test
    public void notMatches() {
        Smartphone smartphone = new Smartphone(3,"Apple",50000,"USA");

        boolean actual = smartphone.matches("Pushkin");
        assertEquals(false,actual);
    }
}
