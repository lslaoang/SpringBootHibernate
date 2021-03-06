package com.lslaoang.springboothibernate.bootstrap;

import com.lslaoang.springboothibernate.model.Book;
import com.lslaoang.springboothibernate.model.Genre;
import com.lslaoang.springboothibernate.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private final BookService bookService;

    public DataLoader(BookService bookService) {
        this.bookService = bookService;
    }


    @Override
    public void run(String... args) throws Exception {
        Book historyBook = new Book();

        historyBook.setId(11L);
        historyBook.setName("Hekasi");
        historyBook.setGenre(Genre.HISTORY);
        bookService.save(historyBook);

        Book book = new Book();
        book.setId(4L);
        book.setName("NO GENRE");

        bookService.save(book);
    }
}
