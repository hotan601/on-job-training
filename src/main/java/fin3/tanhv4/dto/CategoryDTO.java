package fin3.tanhv4.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * CategoryDTO
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
public class CategoryDTO {
	private Integer id;
	
	@NotBlank(message = "Category code can not be null")
	@Size(min = 5, message = "Category code must be greater than 5 character")
	@Size(max = 50, message = "Category code must be less than 50 character")
	private String categoryCode;
	
	@NotBlank(message = "Category name can not be null")
	@Size(min = 5, message = "Category name must be greater than 5 character")
	@Size(max = 50, message = "Category name must be less than 50 character")
	private String categoryName;
	
	@Size(max = 1000, message = "Description must be less than 1000 character")
	private String description;
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
