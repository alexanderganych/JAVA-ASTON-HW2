package ru.aston.hw2;

public class Book {
    private final String title;
    private final int pages;
    private final int year;

    public Book(final String title, final int pages, final int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "(" + title + ", стр." + pages + ", " + year + " г.)";
    }

}
