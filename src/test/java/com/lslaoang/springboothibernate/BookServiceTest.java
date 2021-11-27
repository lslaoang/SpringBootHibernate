package com.lslaoang.springboothibernate;

import com.lslaoang.springboothibernate.model.Book;
import com.lslaoang.springboothibernate.service.BookService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Mock
    BookService bookService;

    Book  book = new Book();

    @Commit
    @BeforeEach
    @Test
    public void init(){

        book.setId(1L);
        book.setName("NO GENRE");
        bookService.save(book);
    }

    @Test
    public void shouldSetUndefinedAsGenreIfNotSpecified(){

        book.setId(2L);
        book.setName("NO GENRE");
        bookService.save(book);

        System.out.println(bookService.getById(1L));
        System.out.println(bookService.getById(2L));

        //assertSame(book1.getGenre(), Genre.UNDEFINED);
    }
}
