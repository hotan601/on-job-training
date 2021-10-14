package fin3.tanhv4.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fin3.tanhv4.converter.BookConverter;
import fin3.tanhv4.dto.BookDTO;
import fin3.tanhv4.entities.BookEntity;
import fin3.tanhv4.entities.CategoryEntity;
import fin3.tanhv4.repository.BookRepository;
import fin3.tanhv4.repository.CategoryRepository;
import fin3.tanhv4.service.IBookService;

// TODO: Auto-generated Javadoc
/**
 * BookService
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
@Service
public class BookService implements IBookService{

	/** The book repository. */
	@Autowired
	private BookRepository bookRepository;

	/** The book converter. */
	@Autowired
	private BookConverter bookConverter;

	/** The category repository. */
	@Autowired
	private CategoryRepository categoryRepository;
	
	/**
	 * Save.
	 * @param bookDTO the book DTO
	 */
	@Override
	public void save(BookDTO bookDTO) {
		BookEntity bookEntity = new BookEntity();
		if (bookDTO.getId() != null) {
			Optional<BookEntity> bookOptional = bookRepository.findById(bookDTO.getId());
			BookEntity oldBookEntity = bookOptional.get();
			bookEntity = bookConverter.toEntity(bookDTO, oldBookEntity);
			
		} else {
			bookEntity = bookConverter.toEntity(bookDTO);
			bookEntity.setCreatedDate(Date.valueOf(LocalDate.now()));
			bookEntity.setDeleteFlag(false);
			bookEntity.setStatus(true);
		}		
		CategoryEntity categoryEntity = categoryRepository.findByCode(bookDTO.getCategoryCode());
		bookEntity.setCategory(categoryEntity);	
		
		bookRepository.save(bookEntity);
	}

	/**
	 * Find all.
	 * @return the list
	 */
	@Override
	public List<BookDTO> findAll() {
		List<BookDTO> results = new ArrayList<>();
		List<BookEntity> entities = bookRepository.findAllByDeleteFlagFalseOrderByIdDesc();
		for (BookEntity bookEntity : entities) {
			BookDTO bookDto = bookConverter.toDto(bookEntity);
			results.add(bookDto);
		}
		return results;
	}

	/**
	 * Delete.
	 * @param id the id
	 */
	@Override
	public void delete(int id) {
		BookEntity bookEntity = bookRepository.getById(id);
		bookEntity.setDeleteFlag(true);
		bookRepository.save(bookEntity);
	}
	
	/**
	 * Find by id.
	 * @param id the id
	 * @return the book DTO
	 */
	@Override
	public BookDTO findById(int id) {
		Optional<BookEntity> bookOptional = bookRepository.findByIdAndDeleteFlagFalse(id);
		if (bookOptional.isPresent()) {
			return bookConverter.toDto(bookOptional.get());
		}
		return null;
	}
	
	/**
	 * Find by keywords.
	 * @param keywords the keywords
	 * @return the list
	 */
	@Override
	public List<BookDTO> findByKeywords(String keywords) {
		List<BookDTO> results = new ArrayList<>();
		List<BookEntity> entities = bookRepository.findByKeywords(keywords);
		for (BookEntity bookEntity : entities) {
			BookDTO bookDto = bookConverter.toDto(bookEntity);
			results.add(bookDto);
		}
		return results;
	}


	/**
	 * Check exist by name.
	 * @param name the name
	 * @return the book DTO
	 */
	@Override
	public BookDTO checkExistByName(String name) {	 
		BookEntity bookEntity = bookRepository.checkExistsByName(name);
		if (bookEntity != null) {
			BookDTO bookDTO = bookConverter.toDto(bookEntity);
			return bookDTO;
		}
		return null;
	}

	/**
	 * Delete books.
	 * @param ids the ids
	 */
	@Override
	public void deleteBooks(long[] ids) {
		for (long id : ids) {
			BookEntity bookEntity = bookRepository.getById((int) id);
			bookEntity.setDeleteFlag(true);
			bookRepository.save(bookEntity);		
		}
	}

	@Override
	public Page<BookEntity> getAll(int pageNumber, int pageSize, String sortBy, String sortDirection) {
		pageNumber = pageNumber != 0 ? pageNumber - 1 : pageNumber;
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.fromString(sortDirection.toUpperCase()),
				sortBy);
		Page<BookEntity> page = bookRepository.findAllByDeleteFlagFalse(pageable);
		return page;
	}

	@Override
	public Page<BookEntity> findByName(String name, int pageNumber, int pageSize, String sortBy,
			String sortDirection) {
		pageNumber = pageNumber != 0 ? pageNumber - 1 : pageNumber;
		try {
		
			Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.fromString(sortDirection.toUpperCase()), sortBy);
			Page<BookEntity> page = bookRepository
					.findByNameContainingAndDeleteFlagFalse(name, pageable);
			return page;
		} catch (Exception e) {
			return Page.empty();
		}
	}	
}
