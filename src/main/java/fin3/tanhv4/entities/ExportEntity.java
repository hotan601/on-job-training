package fin3.tanhv4.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * ExportEntity
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
@Table(name = "Exports")
@Entity
public class ExportEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String customerName;
	
	@Column
    private String phone;
	
	@Column
    private String address;
	
	@Column(columnDefinition = "date")
	@DateTimeFormat(iso = ISO.DATE)
	private Date exportedDate;
	
	@Column
	private boolean deleteFlag;
	
	@Column
	private double total;
	
	@OneToMany(mappedBy= "export")
	private List<ExportDetailEntity> exportDetails = new ArrayList<>();
	
	public ExportEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getExportedDate() {
		return exportedDate;
	}

	public void setExportedDate(Date exportedDate) {
		this.exportedDate = exportedDate;
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

	public List<ExportDetailEntity> getExportDetails() {
		return exportDetails;
	}

	public void setExportDetails(List<ExportDetailEntity> exportDetails) {
		this.exportDetails = exportDetails;
	}
	
	
}
