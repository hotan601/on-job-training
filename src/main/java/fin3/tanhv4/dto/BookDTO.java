package fin3.tanhv4.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * BookDTO
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
public class BookDTO {
	private Integer id;
	
	@NotBlank(message = "Name can not be null")
	@Size(min = 5, message = "Name must be greater than 5 character")
	@Size(max = 50, message = "Name must be less than 50 character")
	private String name;
	
	@NotBlank(message = "Author can not be null")
	@Size(min = 5, message = "Author must be greater than 5 character")
	@Size(max = 50, message = "Author must be less than 50 character")
	private String author;
	private LocalDate createdDate;
	
	@NotNull(message = "Published date can not be null")
	private LocalDate publishedDate;	
	
	@Size(max = 1000, message = "Description must be less than 1000 character")
	private String description;
	
	private String deleteFlag;
	

	@Min(value = 10000,message = "Price must be at least 10,000 VND")
	@Max(value = 10000000,message = "Price must be less than 10,000,000 VND")
	private int price;	
	

	@Min(value = 1,message = "Quantity must be at least 1")
	@Max(value = 1000,message = "Quantity must be less than 1000")
	private int quantity;
	private String status;
	private String categoryCode;
	private String categoryName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", name=" + name + ", author=" + author + ", createdDate=" + createdDate
				+ ", publishedDate=" + publishedDate + ", description=" + description
				+ ", deleteFlag=" + deleteFlag + ", price=" + price + ", quantity=" + quantity + ", status=" + status
				+ ", categoryCode=" + categoryCode + ", categoryName=" + categoryName + "]";
	}

	
	
	
}
