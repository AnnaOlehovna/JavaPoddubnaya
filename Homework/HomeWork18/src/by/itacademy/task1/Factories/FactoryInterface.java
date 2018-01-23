package by.itacademy.task1.Factories;

import by.itacademy.task1.Books.Book;
import by.itacademy.task1.Lessons.Lesson;

public interface FactoryInterface {
    Lesson createLesson();
    Book createBook();
}
