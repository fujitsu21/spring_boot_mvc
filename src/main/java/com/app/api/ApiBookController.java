package com.app.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BookDao;
import com.app.model.Book;
import com.app.repository.BookRepository;

@RestController
public class ApiBookController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	private BookDao bookDao;
	
	// GETリクエストに対してbookテーブルの中身を応答する
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public List<Book> bookGet() {
		// リポジトリからテーブル内の全レコードを取り出す
		// select * from bookが実行される
		List<Book> list = bookRepository.findAll();
		return list;
	}
	
	/*
	 * POSTリクエストに対して、社員番号からタイトルの検索をかける
	 */
	@RequestMapping(value = "/api", method=RequestMethod.POST)
	public List<Book> bookPost(@RequestBody String number) {		
		// bookstoreテーブルから検索
		List<Book> result = bookDao.findone(number);
		return result;
	}
	
	/*
	 * PUTリクエストによってテーブルのデータをUPDATEする（１件のみ）
	 */
	@RequestMapping(value = "/api", method=RequestMethod.PUT)
	public Book bookPut(@RequestBody Book book) {
		// 指定されたデータのIDを指定してレコードを取り出す
		Optional<Book> target = bookRepository.findById(book.getId());
		if(target.isEmpty()) {
			return null;
		}
		else {
			bookRepository.save(book);
			return target.get();
		}
	}
	
	@RequestMapping(value = "/api", method=RequestMethod.DELETE)
	public Book bookDelete(@RequestBody Book book) {
		// 指定されたデータのIDを指定してレコードを取り出す
		Optional<Book> target = bookRepository.findById(book.getId());
		if(target.isEmpty()) {
			return null;
		}
		else {
			bookRepository.deleteById(target.get().getId());
			return target.get();
		}
	}
}
