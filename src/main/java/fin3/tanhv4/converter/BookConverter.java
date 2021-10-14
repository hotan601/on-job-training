package fin3.tanhv4.converter;

import java.sql.Date;

import org.springframework.stereotype.Component;

import fin3.tanhv4.dto.BookDTO;
import fin3.tanhv4.entities.BookEntity;
// TODO: Auto-generated Javadoc
/**
 * BookConverter
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
@Component
public class BookConverter {
	
	/**
	 * To entity.
	 * @param dto the dto
	 * @return the book entity
	 */
	public BookEntity toEntity(BookDTO dto) {
		BookEntity entity = new BookEntity();
		entity.setAuthor(dto.getAuthor());
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setPublishedDate(Date.valueOf(dto.getPublishedDate()));
		entity.setQuantity(dto.getQuantity());	
		return entity;
	}
	
	
	/**
	 * To dto.
	 * @param entity the entity
	 * @return the book DTO
	 */
	public BookDTO toDto(BookEntity entity) {
		BookDTO dto = new BookDTO();
		dto.setId(entity.getId());
		dto.setAuthor(entity.getAuthor());
		dto.setDescription(entity.getDescription());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setPublishedDate(entity.getPublishedDate().toLocalDate());
		dto.setCategoryName(entity.getCategory().getName());
		dto.setQuantity(entity.getQuantity());
		dto.setCategoryCode(entity.getCategory().getCode());
		return dto;		
	}
	

	/**
	 * To entity.
	 * @param dto the dto
	 * @param entity the entity
	 * @return the book entity
	 */
	public BookEntity toEntity(BookDTO dto, BookEntity entity) {
		entity.setAuthor(dto.getAuthor());
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setPublishedDate(Date.valueOf(dto.getPublishedDate()));
		entity.setQuantity(dto.getQuantity());	
		return entity;		
	}
}
