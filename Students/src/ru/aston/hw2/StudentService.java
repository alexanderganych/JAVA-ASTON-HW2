package ru.aston.hw2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentService {
    private static final int YEAR_THRESHOLD = 2000;
    private static final int LIMIT = 3;

    public static List<Student> readStudents(final String fileName) throws Exception {
        final List<String> lines = Files.lines(Paths.get(fileName)).collect(Collectors.toList());
        final List<Student> students = new ArrayList<>();

        for (final String line : lines) {
            final String[] parts = line.split("; ");
            final String studentName = parts[0];
            final String[] bookTokens = parts[1].split("\\|");

            final Book book = new Book(
                    bookTokens[0],
                    Integer.parseInt(bookTokens[1]),
                    Integer.parseInt(bookTokens[2])
            );

            Student existing = null;
            for (final Student s : students) {
                if (s.getName().equals(studentName)) {
                    existing = s;
                    break;
                }
            }

            if (existing != null) {
                final List<Book> newBooks = new ArrayList<>(existing.getBooks());
                newBooks.add(book);
                students.remove(existing);
                students.add(new Student(studentName, newBooks));
            } else {
                final List<Book> newBooks = new ArrayList<>();
                newBooks.add(book);
                students.add(new Student(studentName, newBooks));
            }
        }
        return students;
    }

    public static Optional<Integer> findFirstBookAfter2000(final List<Student> students) {
        return students.stream()
                .peek(s -> System.out.println(s.getName()))
                .flatMap(s -> s.getBooks().stream())
                .sorted((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()))
                .distinct()
                .filter(b -> b.getYear() > YEAR_THRESHOLD)
                .limit(LIMIT)
                .map(Book::getYear)
                .findFirst();
    }
}
