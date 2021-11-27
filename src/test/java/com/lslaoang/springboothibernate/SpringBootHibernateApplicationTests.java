package com.lslaoang.springboothibernate;

import com.lslaoang.springboothibernate.model.Book;
import com.lslaoang.springboothibernate.model.Genre;
import com.lslaoang.springboothibernate.service.BookService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringBootHibernateApplicationTests {

    @Autowired
    private BookService bookService;

    Book mockBook = Mockito.mock(Book.class);

    @Test
    @Order(1)
    @Commit
    public void shouldSaveBook(){

        Book book1 = new Book(1L, "TestBook", Genre.ENTERTAINMENT);
        bookService.save(book1);
        Book book2 = bookService.getById(1L);
        assertNotNull(book2);
        assertEquals(book2.getName(),book1.getName());
    }

    @Test
    @Order(2)
    @Commit
    public void shouldFindBook(){
        mockBook = new Book(2L, "TestBook1", Genre.ENTERTAINMENT);
        bookService.save(mockBook);

        System.out.println(bookService.findById(2L));
        System.out.println(bookService.count());
        assertNotNull(bookService.findById(2L));
    }

    @Test
    @Order(3)
    public void shouldDeleteBook() throws EmptyResultDataAccessException {

        try {
            Book book1 = new Book(1L, "TestBook", Genre.ENTERTAINMENT);
            bookService.save(book1);

            bookService.deleteById(1L);
            System.out.println("Book deleted");
            assertThrows(JpaObjectRetrievalFailureException.class, ()->{
                bookService.getById(1L);
            });
        } catch (EmptyResultDataAccessException e){
            System.out.println("Error occured.");
        }

    }

    @Test
    @Order(4)
    public void shouldNotReceiveNullId(){
        assertThrows(NullPointerException.class, () ->{
            mockBook = new Book(null,"NullBook",Genre.HISTORY);
                });
    }

    @Test
    @Order(5)
    public void shouldSetUndefinedAsGenreIfNotSpecified(){
        Book mockBook = Mockito.mock(Book.class);

        BookService bookService = new BookService();

        mockBook.setId(4L);
        mockBook.setName("NO GENRE");

        bookService.save(mockBook);
        assertNotNull(mockBook.getGenre());
        assertEquals(mockBook.getGenre().toString(),"UNDEFINED");
    }

}
