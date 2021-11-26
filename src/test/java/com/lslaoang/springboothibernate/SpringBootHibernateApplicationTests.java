package com.lslaoang.springboothibernate;

import com.lslaoang.springboothibernate.model.Book;
import com.lslaoang.springboothibernate.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringBootHibernateApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private BookService bookService;

    @Test
    public void shouldSaveBook(){

        Book book1 = new Book(111L, "Test Book");
        bookService.save(book1);
        Book book2 = bookService.getById(111L);
        assertNotNull(book2);
        assertEquals(book1.getName(),book2.getName());
    }


}
