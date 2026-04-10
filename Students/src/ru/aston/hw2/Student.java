package ru.aston.hw2;

import java.util.List;

public class Student {
    private final String name;
    private final List<Book> books;

    public Student(final String name, final List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return name + " " + books;
    }
}
