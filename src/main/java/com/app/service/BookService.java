package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.model.Book;
import com.app.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public ApiSearch service(String number) {
		return restTemplate.getForObject("/api", ApiSearch.class, number);
	}
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	public Book findOne(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if(book.isPresent()) {
			return book.get();
		}
		else {
			return null;
		}
	}
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
	
	
}
