package com.maySpring.SpringApp.bootstrap;

import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.maySpring.SpringApp.domain.Author;
import com.maySpring.SpringApp.domain.Book;
import com.maySpring.SpringApp.domain.Publisher;
import com.maySpring.SpringApp.repositories.AuthorRepository;
import com.maySpring.SpringApp.repositories.BookRepository;
import com.maySpring.SpringApp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRespository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRespository;
		this.publisherRepository = publisherRepository;
	}



	public void run(String... args) throws Exception {
		
		System.err.println("Started in Bottstrap");
		Publisher publisher = new Publisher();
		publisher.setName("SFG Publishing");
		publisher.setCity("St Petersburg");
		publisher.setState("FL");
		publisherRepository.save(publisher);
		
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Mojito Kunito", "456789");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);
		System.err.println("Publisher count: " + publisherRepository.count());
		
		
		Author rod = new Author("Rod", "Stewart");
		Book noEJB = new Book("Kuna Matata", "369852");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);
		
		System.err.println("Number of books in the repository: " + bookRepository.count());
		System.err.println("Publisher number of books: " + publisher.getBooks().size());
	}

}
