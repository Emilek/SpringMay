package com.maySpring.SpringApp.bootstrap;

import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.maySpring.SpringApp.domain.Author;
import com.maySpring.SpringApp.domain.Book;
import com.maySpring.SpringApp.repositories.AuthorRepository;
import com.maySpring.SpringApp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRespository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRespository;
	}



	public void run(String... args) throws Exception {
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Mojito Kunito", "456789");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod", "Stewart");
		Book noEJB = new Book("Kuna Matata", "369852");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		System.err.println("Started in bootstrap");
		System.err.println("Number of books in the repository: " + bookRepository.count());
	}

}
