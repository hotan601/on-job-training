/*
 * 
 */
package fin3.tanhv4.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fin3.tanhv4.dto.BookDTO;
import fin3.tanhv4.entities.BookEntity;
import fin3.tanhv4.service.IBookService;

/**
 * BookController
 * Version 1.0
 *
 * Date: Sep 16, 2021
 *
 * Copyright
 *
 * Modification Logs:
 *  DATE                 AUTHOR          DESCRIPTION
 *  -----------------------------------------------------------------------
 *  Sep 16, 2021        TanHV4            Create
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	/**
	 * Show books.
	 * @return the list
	 */
	@GetMapping(value = "/book")
//	public Object getFacilities(@RequestParam(name = "query", defaultValue = "", required = false) String query,
//			@RequestParam(name = "sortBy", defaultValue = "id", required = false) String sortBy,
//			@RequestParam(name = "sortDirection", defaultValue = "desc", required = false) String sortDirection,
//			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
//			@RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {
//
//		Page<FacilityEntity> facilities;
//		if (query.isEmpty()) {
//			facilities = facilityServiceImpl.getAll(pageNumber, pageSize, sortBy, sortDirection);
//		} else {
//			facilities = facilityServiceImpl.findByName(query, pageNumber, pageSize, sortBy, sortDirection);
//		}
//		return facilities.isEmpty() ? new ResponseEntity<>(Page.empty(), HttpStatus.NO_CONTENT)
//				: new ResponseEntity<>(facilities, HttpStatus.OK);
//	}

	public Object showBooks(@RequestParam(name ="query", defaultValue = "", required = false) String query,
			@RequestParam(name= "sortBy", defaultValue = "id", required = false) String sortBy,
			@RequestParam(name = "sortDirection", defaultValue = "desc", required = false) String sortDirection,
			@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "5") int pageSize) {	
		Page<BookEntity> books;
		if (query == null || query.isEmpty()) {
			System.out.println("for pagination");
			books = bookService.getAll(pageNumber, pageSize, sortBy, sortDirection);
		}
		else {
			books = bookService.findByName(query, pageNumber, pageSize, sortBy, sortDirection);
			System.out.println("for search");
		}
		return books;
	}
//	@GetMapping(value = "/book")
//	public List<BookDTO> showBooks() {	
//		return bookService.findAll();
//	}
	
	/**
	 * Show book by id.
	 * @param id the id
	 * @return the book DTO
	 */
	@GetMapping(value = "/book/details/{id}")
	public BookDTO showBookById(@PathVariable("id") int id) {	
		return bookService.findById(id);
	}
	
	/**
	 * Creates the book.
	 * @param model the model
	 * @throws Exception 
	 */
	@PostMapping(value= "/book")
	public void createBook(@RequestBody @Valid BookDTO model) {
		bookService.save(model);		
	}

	
	/**
	 * Update book.
	 * @param model the model
	 * @param id the id
	 */
	@PutMapping(value="/book/update/{id}")
	public void updateBook(@RequestBody @Valid BookDTO model, @PathVariable("id") int id) {
		model.setId(id);
		bookService.save(model);
	}
	
	/**
	 * Delete book.
	 * @param id the id
	 */
	@DeleteMapping(value="/book/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		bookService.delete(id);
	}
	
	/**
	 * Search.
	 * @param keywords the keywords
	 * @return the list
	 */
	@GetMapping(value = "/book/search")
	public List<BookDTO> search(@RequestParam("key") String keywords) {	
		return bookService.findByKeywords(keywords);
	}
	
	/**
	 * Show book by name.
	 * @param name the name
	 * @return the book DTO
	 */
	@GetMapping(value = "/book/findByName/{name}")
	public BookDTO showBookByName(@PathVariable("name") String name) {	
		return bookService.checkExistByName(name);
	}
	
	@PostMapping(value="/delete/books")
	public void deleteMultipleBooks(@RequestBody long[] ids) {
		bookService.deleteBooks(ids);
	}
	
}
