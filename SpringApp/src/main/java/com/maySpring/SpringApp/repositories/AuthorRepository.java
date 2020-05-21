package com.maySpring.SpringApp.repositories;

import com.maySpring.SpringApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
