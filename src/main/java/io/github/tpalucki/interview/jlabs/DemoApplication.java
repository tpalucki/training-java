package io.github.tpalucki.interview.jlabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	// rest api
	// no database

	// books
	// id
	// titile
	// author

	// /v1/books
	// POST
	/**
	 * {
	 *     title,
	 *     author
	 * }
	 */

	// controller = adapter
	// servie - core
	// persistence - adapter


	// usuwanie
	// author
	// ret number of deleted

	// /v1/books
	// DELETE
	// /v1/books/authors/{author}
	// /v1/authors/{author}/books
	// DELETE /v1/books?author={author}
}
