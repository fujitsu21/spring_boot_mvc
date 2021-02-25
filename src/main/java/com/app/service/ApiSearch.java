package com.app.service;

import java.util.ArrayList;
import java.util.List;

import com.app.model.Book;

public class ApiSearch {
	int status;
	String message;
	
	List<Book> results = new ArrayList<>();
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<Book> getResults() {
		return results;
	}
}
