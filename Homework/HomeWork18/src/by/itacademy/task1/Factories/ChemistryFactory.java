package by.itacademy.task1.Factories;

import by.itacademy.task1.Books.Book;
import by.itacademy.task1.Books.ChemistryBook;
import by.itacademy.task1.Lessons.ChemistryLesson;
import by.itacademy.task1.Lessons.Lesson;

public class ChemistryFactory implements FactoryInterface{
    @Override
    public Lesson createLesson() {
        return new ChemistryLesson();
    }

    @Override
    public Book createBook() {
        return new ChemistryBook();
    }
}
