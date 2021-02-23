package com.app.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Book;
import com.app.repository.BookRepository;

@RestController
public class ReturnJson {
	
	@Autowired
	BookRepository bookrepository;
	
	// GETリクエストに対してBookテーブルの中身を応答する
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public List<Book> bookGet() {
		// リポジトリからテーブル内の全レコードを取り出す
		// SELECT * FROM bookが実行される
		List<Book> book = bookrepository.findAll();
		/*
		 *  取り出したListオブジェクトをリターンすると,
		 *  JSON文字列に変換されてレスポンスが送られる
		 */
		return book;
	}
	
	// POSTリクエストによってbookテーブルにデータをINSERTする
	@RequestMapping(value="/book", method = RequestMethod.POST)
	public List<Book> bookPost(
			// リクエストボディに渡されたJSONを引数にマッピングする
			@RequestBody List<Book> bookList) {
		// ListをBookテーブルにInsertする＝＞INSERTしたデータのリストが返ってくる
		List<Book> result = bookrepository.saveAll(bookList);
		return result;
	}
	
	// PUTリクエストによってbookテーブルのデータをUPDATEする
	@RequestMapping(value="/book", method = RequestMethod.PUT)
	public Book bookPut(@RequestBody Book book) {
		// 指定されたデータのIDを指定してレコードを取り出す
		Optional<Book> target = bookrepository.findById(book.getId());
		// もしも指定されたIDが見つからない場合はNullを返して終了
		if(target.isEmpty()) {
			return null;
		}
		// 見つかったら与えられたデータで更新する
		else {
			bookrepository.save(book);
			// 更新した結果のデータを返す
			return target.get();
		}
	}
	
	// DELETEリクエストによってbookテーブルのデータをDELETEする
	@RequestMapping(value = "/book", method = RequestMethod.DELETE) 
	public Book bookDelete(@RequestBody Book book) {
		// 指定されたデータのIDを指定してレコードを返す
		Optional<Book> target = bookrepository.findById(book.getId());
		if(target.isEmpty()) {
		// 指定されたデータが見つからない場合は何もせずに終了
			return null;
		}
		else {
			// データをDELETEする
			bookrepository.deleteById(target.get().getId());
			return target.get();
		}
	}
	
	// employee_numberの指定で検索をかける
	// @Requestmapping(value = "/book2", method = RequestMethod.GET)
	//　public List<Book> get(@RequestParam(value="employee_number") String number) {
		// List<Book> books = bookrepository.findByEmployee_number(number);
		// return books;
	//}
}
