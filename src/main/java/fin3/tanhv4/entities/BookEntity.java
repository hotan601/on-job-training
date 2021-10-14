/** ===================================================================
 * System name: Book
 * Version: 1.0
 * Created date: 8:34:52 PM
 * Description: Create by TanHV4
 * Copyright (c) 2021 FPT Da Nang
 ====================================================================*/

/**
 * BookEntity.java
 * Version 1.0
 *
 * Date: Sep 22, 2021
 *
 * Copyright
 *
 * Modification Logs:
 *  DATE                 AUTHOR          DESCRIPTION
 *  -----------------------------------------------------------------------
 *   Sep 22, 2021        TanHV4            Create
 */
package fin3.tanhv4.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * BookEntity
 * Version 1.0
 *
 * Date: Sep 15, 2021
 *
 * Copyright
 *
 * Modification Logs:
 *  DATE                 AUTHOR          DESCRIPTION
 *  -----------------------------------------------------------------------
 *  Sep 15, 2021        TanHV4            Create
 */
@Table(name="Books")
@Entity
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String author;
	
	@Column(columnDefinition = "date")
	@DateTimeFormat(iso = ISO.DATE)
	private Date createdDate;
	
	@Column(columnDefinition = "date")
	@DateTimeFormat(iso = ISO.DATE)
	private Date publishedDate;
	
	@Column(columnDefinition = "text")
	private String description;
	
	@Column
	private boolean deleteFlag;
	
	@Column
	private int price;
	
	@Column
	private int quantity;
	
	@Column
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	@JsonIgnore
	@OneToMany(mappedBy="book")
	private List<ImportDetailEntity> importDetails = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="book")
	private List<ExportDetailEntity> exportDetails = new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
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


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<ImportDetailEntity> getImportDetails() {
		return importDetails;
	}

	public void setImportDetails(List<ImportDetailEntity> importDetails) {
		this.importDetails = importDetails;
	}
	
	
	
}
