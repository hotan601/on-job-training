package fin3.tanhv4.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fin3.tanhv4.converter.CategoryConverter;
import fin3.tanhv4.dto.CategoryDTO;
import fin3.tanhv4.entities.BookEntity;
import fin3.tanhv4.entities.CategoryEntity;
import fin3.tanhv4.repository.CategoryRepository;
import fin3.tanhv4.service.ICategoryService;
// TODO: Auto-generated Javadoc
/**
 * CategoryService
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
public class CategoryService implements ICategoryService{
	
	/** The category repository. */
	@Autowired
	private CategoryRepository categoryRepository;
	
	/** The category converter. */
	@Autowired
	private CategoryConverter categoryConverter;

	/**
	 * Find all categories.
	 * @return the list
	 */
	@Override
	public List<CategoryDTO> findAllCategories() {
		List<CategoryDTO> results = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity categoryEntity : entities) {
			CategoryDTO categoryDto = categoryConverter.toDto(categoryEntity);
			results.add(categoryDto);
		}
		return results;
	}

	/**
	 * Save.
	 * @param categoryDTO the category DTO
	 */
	@Override
	public void save(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if (categoryDTO.getId() != null) {
			Optional<CategoryEntity> categoryOptional = categoryRepository.findById(categoryDTO.getId());
			CategoryEntity oldCategoryEntity = categoryOptional.get();
			categoryEntity = categoryConverter.toEntity(categoryDTO, oldCategoryEntity);
		} else {
			categoryEntity = categoryConverter.toEntity(categoryDTO);
			categoryEntity.setDeleteFlag(false);
		}
		categoryRepository.save(categoryEntity);	
	}

	/**
	 * Find all.
	 * @return the list
	 */
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> results = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAllByDeleteFlagFalseOrderByIdDesc();
		for (CategoryEntity categoryEntity : entities) {
			CategoryDTO categoryDto = categoryConverter.toDto(categoryEntity);
			results.add(categoryDto);
		}
		return results;
	}

	/**
	 * Check exists by name.
	 * @param name the name
	 * @return the category DTO
	 */
	@Override
	public CategoryDTO checkExistsByName(String name) {
		CategoryEntity categoryEntity = categoryRepository.checkExistsByName(name);
		if (categoryEntity != null) {
			CategoryDTO categoryDTO = categoryConverter.toDto(categoryEntity);
			return categoryDTO;
		}
		return null;
	}

	/**
	 * Check exists by code.
	 * @param code the code
	 * @return the category DTO
	 */
	@Override
	public CategoryDTO checkExistsByCode(String code) {
		CategoryEntity categoryEntity = categoryRepository.checkExistsByCode(code);
		if (categoryEntity != null) {
			return categoryConverter.toDto(categoryEntity);
		}
		return null;
	}

	/**
	 * Find by id.
	 * @param id the id
	 * @return the category DTO
	 */
	@Override
	public CategoryDTO findById(int id) {
		Optional<CategoryEntity> categoryOptional = categoryRepository.findByIdAndDeleteFlagFalse(id);
		if (categoryOptional.isPresent()) {
			return categoryConverter.toDto(categoryOptional.get());
		}
		return null;
	}

//	@Override
//	public Map<Integer, String> findAll() {
//		Map<Integer, String> results = new HashMap<>();
//		List<CategoryEntity> entityList = categoryRepository.findAll();
//		List<CategoryDTO> dtoList = new ArrayList<>();
//		for (CategoryEntity entity : entityList) {
//			dtoList.add(categoryConverter.toDto(entity));
//		}	
//		for (CategoryDTO dto : dtoList) {
//			results.put(dto.getId(), dto.getCategoryName());
//		}
//		return results;
//	}
	
}
