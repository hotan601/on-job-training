/**
 * CategoryController
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
package fin3.tanhv4.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fin3.tanhv4.dto.CategoryDTO;
import fin3.tanhv4.service.ICategoryService;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryController.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	
	/** The category service. */
	@Autowired
	private ICategoryService categoryService;
	
	
	/**
	 * Show categories.
	 * @return the list
	 */
	@GetMapping(value = "/category")
	public List<CategoryDTO> showAllCategories() {	
		return categoryService.findAll();
	}
//	@GetMapping(value = "/category")
//	public List<CategoryDTO> showCategories() {	
//		return categoryService.findAllCategories();
//	}
	
	/**
	 * Creates the category.
	 * @param model the model
	 */
	@PostMapping(value= "/category")
	public void createCategory(@RequestBody @Valid CategoryDTO model) {
		categoryService.save(model);		
	}
	
	/**
	 * Show category by name.
	 * @param name the name
	 * @return the category DTO
	 */
	@GetMapping(value= "/category/findByName/{name}")
	public CategoryDTO showCategoryByName(@PathVariable("name") String name) {
		return categoryService.checkExistsByName(name);
	}
	
	/**
	 * Show category by code.
	 * @param code the code
	 * @return the category DTO
	 */
	@GetMapping(value= "/category/findByCode/{code}")
	public CategoryDTO showCategoryByCode(@PathVariable("code") String code) {
		return categoryService.checkExistsByCode(code);
	}
	
	/**
	 * Show category by id.
	 * @param id the id
	 * @return the category DTO
	 */
	@GetMapping(value = "/category/details/{id}")
	public CategoryDTO showCategoryById(@PathVariable("id") int id) {	
		return categoryService.findById(id);
	}
	
	/**
	 * Update category.
	 * @param model the model
	 * @param id the id
	 */
	@PutMapping(value="/category/update/{id}")
	public void updateCategory(@RequestBody CategoryDTO model, @PathVariable("id") int id) {
		model.setId(id);
		categoryService.save(model);
	}
}
