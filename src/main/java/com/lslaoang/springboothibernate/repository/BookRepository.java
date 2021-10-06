package com.lslaoang.springboothibernate.repository;

import com.lslaoang.springboothibernate.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
}
