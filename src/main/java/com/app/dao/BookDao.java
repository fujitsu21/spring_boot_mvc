package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.app.model.Book;

@Repository
public class BookDao {
	
	// entity manager
	private EntityManager entityManager;
	
	// instance for query generate
	private CriteriaBuilder builder;
	
	// instance for run query
	private CriteriaQuery<Book> query;
	
	// 検索されるエンティティのルート
	private Root<Book> root;
	
	/*
	 * constructor
	 */
	public BookDao(EntityManager entityManager) {
		// entitymanager get
		this.entityManager = entityManager;
		builder = entityManager.getCriteriaBuilder();
		query = builder.createQuery(Book.class);
		root = query.from(Book.class);
	}
	
	/*
	 * 書籍情報検索
	 * @param String jan_code
	 * @param String book_name
	 * @param String employee_number
	 * @param String employee_mail
	 * @return ArrayList<Book> book_list
	 */
	public ArrayList<Book> find(String jan_code, String book_name, String employee_number, String employee_mail) {
		// set select
		query.select(root);
		
		//set where
		query.where(
				builder.like(root.get("jan_code"), "%" + jan_code + "%"),
				builder.like(root.get("book_name"), "%" + book_name + "%"),
				builder.like(root.get("employee_number"), "%" + employee_number + "%"),
				builder.like(root.get("employee_mail"), "%" + employee_mail + "%")
		);
		return (ArrayList<Book>)entityManager.createQuery(query).getResultList();
	}
	
	public List<Book> findone(String employee_number) {
		query.select(root);
		
		//set where
		query.where(
				builder.equal(root.get("employee_number"), employee_number)
		);
		return (List<Book>)entityManager.createQuery(query).getResultList();
	}
	
}
