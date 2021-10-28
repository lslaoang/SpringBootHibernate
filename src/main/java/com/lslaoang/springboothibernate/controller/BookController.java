package com.lslaoang.springboothibernate.controller;

import com.lslaoang.springboothibernate.model.Book;
import com.lslaoang.springboothibernate.repository.BookRepository;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE})
public class BookController{

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value="/books")
    public List<Book> getAllBooks(){
        List<Book> listOfBooks =  bookRepository.findAll();
        return listOfBooks;
    }

    @GetMapping(value="/book/{bookId}")
    public Book getBookById(@PathVariable("bookId") Long id){
        //System.out.println("Book repository ID");
         return bookRepository.getById(id);
    }

    @DeleteMapping(value ="/delete/{bookId}")
    public String deleteById(@PathVariable("bookId") @NonNull Long id) {
        String status = null;

     if (bookRepository.getById(id).getId() == id) {
                bookRepository.deleteById(id);
                status = "Deleted " + id;
            } else {
                status = "Cannot find " + id;
            }

            return status;
    }

    @GetMapping("/error")
    public String error() {
            return "error";
        }
}
