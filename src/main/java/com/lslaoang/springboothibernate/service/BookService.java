package com.lslaoang.springboothibernate.service;

import com.lslaoang.springboothibernate.model.Book;
import com.lslaoang.springboothibernate.model.Genre;
import com.lslaoang.springboothibernate.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService{

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }

    public Book getById(Long id){
        return bookRepository.getById(id);
    }

    public void save(Book book){
        if(book.getGenre()!=null){
            book.setGenre(Genre.valueOf("UNDEFINED"));
        }
            bookRepository.save(book);
    }

    public void delete(Book book){
        bookRepository.delete(book);
    }

    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }

    public long count(){
        return  bookRepository.count();
    }

}
