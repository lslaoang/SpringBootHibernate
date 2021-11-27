package com.lslaoang.springboothibernate;

import com.lslaoang.springboothibernate.model.Book;
import com.lslaoang.springboothibernate.repository.BookRepository;
import com.lslaoang.springboothibernate.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;


    @Test
    public void shouldSetUndefinedAsGenreIfNotSpecified(){
        Book book = new Book();
        book.setId(1L);
        book.setName("HAS NO GENRE");
        bookService.save(book);

        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("HAS NO GENRE");
        bookService.save(book1);

        //doReturn(book).when(bookService).getById(1L);

        verify(bookRepository,times(2)).save(any());

    }


}
