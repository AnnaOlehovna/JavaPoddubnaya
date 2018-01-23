package by.itacademy.task1;

import by.itacademy.task1.Books.Book;
import by.itacademy.task1.Factories.FactoryInterface;
import by.itacademy.task1.Lessons.Lesson;

public class Application {

    private Book book;
    private Lesson lesson;

    private FactoryInterface factoryInterface;

    public Application(FactoryInterface factoryInterface) {
        book = factoryInterface.createBook();
        lesson = factoryInterface.createLesson();
        this.factoryInterface = factoryInterface;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
