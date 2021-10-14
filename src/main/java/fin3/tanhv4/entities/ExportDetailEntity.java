package fin3.tanhv4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ExportDetailEntity
 * Version 1.0
 *
 * Date: Sep 30, 2021
 *
 * Copyright
 *
 * Modification Logs:
 *  DATE                 AUTHOR          DESCRIPTION
 *  -----------------------------------------------------------------------
 *   Sep 30, 2021       TanHV4            Create
 */
@Table(name= "ExportDetails")
@Entity
public class ExportDetailEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private int price;
	
	@Column
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="export_id")
	private ExportEntity export;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private BookEntity book;
	
	public ExportDetailEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public ExportEntity getExport() {
		return export;
	}

	public void setExport(ExportEntity export) {
		this.export = export;
	}

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}
	
}
