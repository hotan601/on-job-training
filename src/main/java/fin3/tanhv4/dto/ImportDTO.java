package fin3.tanhv4.dto;

import java.time.LocalDate;

public class ImportDTO {

	private int id;
	
	private LocalDate importedDate;
	
	private double total;

	private int supplierID;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getImportedDate() {
		return importedDate;
	}

	public void setImportedDate(LocalDate importedDate) {
		this.importedDate = importedDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	
	
}
