package fin3.tanhv4.service;

import java.util.List;

import fin3.tanhv4.dto.CategoryDTO;
/**
 * ICategoryService
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
public interface ICategoryService {
	
	/**
	 * Find all categories.
	 * @return the list
	 */
	List<CategoryDTO> findAllCategories();
	
//	Map<Integer, String> findAll();
	
	
	/**
	 * Save.
	 * @param categoryDTO the category DTO
	 */
	void save(CategoryDTO categoryDTO);
	
	
	/**
	 * Find all.
	 * @return the list
	 */
	List<CategoryDTO> findAll();
	
	
	/**
	 * Check exists by name.
	 * @param name the name
	 * @return the category DTO
	 */
	CategoryDTO checkExistsByName(String name);
	
	
	/**
	 * Check exists by code.
	 * @param code the code
	 * @return the category DTO
	 */
	CategoryDTO checkExistsByCode(String code);
	
	/**
	 * Find by id.
	 * @param id the id
	 * @return the category DTO
	 */
	CategoryDTO findById(int id);
}
