package fin3.tanhv4.converter;

import org.springframework.stereotype.Component;

import fin3.tanhv4.dto.CategoryDTO;
import fin3.tanhv4.entities.CategoryEntity;
// TODO: Auto-generated Javadoc
/**
 * CategoryConverter
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
public class CategoryConverter {
	
	/**
	 * To dto.
	 * @param entity the entity
	 * @return the category DTO
	 */
	public CategoryDTO toDto(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(entity.getId());
		dto.setCategoryName(entity.getName());
		dto.setCategoryCode(entity.getCode());
		dto.setDescription(entity.getDescription());
		return dto;	
	}
	
	/**
	 * To entity.
	 * @param dto the dto
	 * @return the category entity
	 */
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();	
		entity.setName(dto.getCategoryName());
		entity.setCode(dto.getCategoryCode());
		entity.setDescription(dto.getDescription());
		return entity;
	}
	
	/**
	 * To entity.
	 * @param dto the dto
	 * @param entity the entity
	 * @return the category entity
	 */
	public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity entity) {
		entity.setName(dto.getCategoryName());
		entity.setCode(dto.getCategoryCode());
		entity.setDescription(dto.getDescription());
		return entity;		
	}
}
