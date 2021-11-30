package com.lslaoang.springboothibernate;

import com.lslaoang.springboothibernate.repository.BookRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
   // @Commit
    public void shouldAddToRepository(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(0);
        //bookRepository.save(new Book(32L,"TestThis", Genre.UNDEFINED));
       // long countAfter = bookRepository.count();
       // assertThat(countBefore).isLessThan(countAfter);

    }
}
