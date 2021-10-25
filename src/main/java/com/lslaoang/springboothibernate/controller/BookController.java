package com.lslaoang.springboothibernate.controller;

import com.lslaoang.springboothibernate.model.Book;
import com.lslaoang.springboothibernate.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repo")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping({"/books"})
    public List<Book> getAllBooks(){
        List<Book> listOfBooks =  bookRepository.findAll();
        return listOfBooks;
    }

    @GetMapping("books/{bookId}")
    public Book getBookById(@PathVariable("bookId") Long id){
        //System.out.println("Book repository ID");
         return bookRepository.getById(id);
    }

    @DeleteMapping("books/delete/{bookId}")
    public String deleteById(@PathVariable("bookId") Long id){
        bookRepository.deleteById(id);
        return "Book "+id +" deleted.";
    }
}
