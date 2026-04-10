package ru.aston.hw2;

import java.util.List;
import java.util.Optional;

public class MainExample {

    public static void main(final String[] args) {

        try {
            final List<Student> students = StudentService.readStudents("Students.txt");

            System.out.println("Студенты: ");
            final Optional<Integer> resultYear = StudentService.findFirstBookAfter2000(students);

            if (resultYear.isPresent()) {
                System.out.println("\nПервая книга старше 2000 года - " + resultYear.get());
            } else {
                System.out.println("\nКнига старше 2000 года, не найдена.");
            }

            students.forEach(System.out::println);

        } catch (final Exception e) {
            System.out.println("Ошибка при чтении файла - " + e.getMessage());
        }
    }
}
