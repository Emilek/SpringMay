package com.maySpring.SpringApp.repositories;

import com.maySpring.SpringApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

}
