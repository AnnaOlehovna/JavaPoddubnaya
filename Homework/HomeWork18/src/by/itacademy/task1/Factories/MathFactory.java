package by.itacademy.task1.Factories;

import by.itacademy.task1.Books.Book;
import by.itacademy.task1.Books.MathBook;
import by.itacademy.task1.Lessons.Lesson;
import by.itacademy.task1.Lessons.MathLesson;

public class MathFactory implements FactoryInterface {
    @Override
    public Lesson createLesson() {
        return new MathLesson();
    }

    @Override
    public Book createBook() {
        return new MathBook();
    }
}
