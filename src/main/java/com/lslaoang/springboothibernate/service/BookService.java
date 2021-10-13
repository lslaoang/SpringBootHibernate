package com.lslaoang.springboothibernate.service;

import com.lslaoang.springboothibernate.model.Book;
import com.lslaoang.springboothibernate.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book getById(Long id){
        return bookRepository.getById(id);
    }

    public void save(Book book){
        bookRepository.save(book);
    }

}
