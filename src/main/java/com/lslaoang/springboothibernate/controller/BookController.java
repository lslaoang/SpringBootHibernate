package com.lslaoang.springboothibernate.controller;

import com.lslaoang.springboothibernate.model.Book;
import com.lslaoang.springboothibernate.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1",method = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE})
public class BookController{


    @Autowired
    private final BookService bookService;

    public BookController( BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping(value="/books")
    public List<Book> getAllBooks(){
        List<Book> listOfBooks =  bookService.findAll();
        return listOfBooks;
    }

    @GetMapping(value="/book/{bookId}")
    public Book getBookById(@PathVariable("bookId") Long id){
        //System.out.println("Book repository ID");
         return bookService.getById(id);
    }

    @DeleteMapping(value ="/delete/{bookId}")
    public String deleteById(@PathVariable("bookId") @NonNull Long id) {
        String status = null;

     if (bookService.getById(id).getId() == id) {
                bookService.deleteById(id);
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
