package fin3.tanhv4.service;

import java.util.List;

import org.springframework.data.domain.Page;

import fin3.tanhv4.dto.BookDTO;
import fin3.tanhv4.entities.BookEntity;
/**
 * IBookService
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
public interface IBookService {
	
	/**
	 * Save.
	 * @param bookDTO the book DTO
	 */
	void save(BookDTO bookDTO);
	
	/**
	 * Find all.
	 * @return the list
	 */
	List<BookDTO> findAll();
	
	/**
	 * Find by id.
	 * @param id the id
	 * @return the book DTO
	 */
	BookDTO findById(int id);
	
	/**
	 * Delete.
	 * @param id the id
	 */
	void delete(int id);
	
	/**
	 * Find by keywords.
	 * @param keywords the keywords
	 * @return the list
	 */
	List<BookDTO> findByKeywords(String keywords);
	
	
	/**
	 * Check exist by name.
	 * @param name the name
	 * @return the book DTO
	 */
	BookDTO checkExistByName(String name);
	

	/**
	 * Delete books.
	 * @param ids the ids
	 */
	void deleteBooks(long[] ids);
	
	 Page<BookEntity> getAll(int pageNumber, int pageSize, String sortBy, String sortDirection);
	 
	 Page<BookEntity> findByName(String name, int pageNumber, int pageSize, String sortBy, String sortDirection);
}
