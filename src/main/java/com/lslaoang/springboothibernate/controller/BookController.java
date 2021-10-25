package com.lslaoang.springboothibernate.controller;

import com.lslaoang.springboothibernate.model.Book;
import com.lslaoang.springboothibernate.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE})
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value="/books")
    public List<Book> getAllBooks(){
        List<Book> listOfBooks =  bookRepository.findAll();
        return listOfBooks;
    }

    @GetMapping(value="/book/{bookId}")
    public Book getBookById(@PathVariable("bookId") Long id){
        //System.out.println("Book repository ID");
         return bookRepository.getById(id);
    }

    @RequestMapping(value ="/{bookId}",method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("bookId") Long id){
        bookRepository.getById(id);
        System.out.println("Deleted");
        return "Book "+id +" deleted.";
    }
}
