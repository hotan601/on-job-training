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

/**
 * ImportEntity
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

@Table(name="Imports")
@Entity
public class ImportEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column(columnDefinition = "date")
	@DateTimeFormat(iso = ISO.DATE)
	private Date importedDate;
	
	@Column
	private boolean deleteFlag;
	
	@Column
	private double total;
	
	@OneToMany(mappedBy = "importEntity")
	private List<ImportDetailEntity> importDetails = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private SupplierEntity supplier;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getImportedDate() {
		return importedDate;
	}

	public void setImportedDate(Date importedDate) {
		this.importedDate = importedDate;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<ImportDetailEntity> getImportDetails() {
		return importDetails;
	}

	public void setImportDetails(List<ImportDetailEntity> importDetails) {
		this.importDetails = importDetails;
	}

	public SupplierEntity getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}
	
}
