package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product{
    private String made;

    public Smartphone(int id, String name, int price, String made) {
        super(id, name, price);
        this.made = made;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || search.equals(this.made);
    }
}
