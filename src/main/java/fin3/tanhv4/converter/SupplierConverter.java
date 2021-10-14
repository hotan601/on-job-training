package fin3.tanhv4.converter;

import org.springframework.stereotype.Component;

import fin3.tanhv4.dto.ImportDTO;
import fin3.tanhv4.dto.SupplierDTO;
import fin3.tanhv4.entities.ImportEntity;
import fin3.tanhv4.entities.SupplierEntity;
// TODO: Auto-generated Javadoc
/**
 * SupplierConverter
 * Version 1.0
 *
 * Date: Oct 8, 2021
 *
 * Copyright
 *
 * Modification Logs:
 *  DATE                 AUTHOR          DESCRIPTION
 *  -----------------------------------------------------------------------
 *  Oct 8, 2021        TanHV4            Create
 */
@Component
public class SupplierConverter {
	
	public SupplierEntity toEntity(SupplierDTO dto) {
		SupplierEntity entity = new SupplierEntity();
//		entity.setSupplier(new SupplierEntity(dto.getSupplierID()));
//		entity.setImportedDate(Date.valueOf(dto.getImportedDate()));
//		entity.setTotal(dto.getTotal());
		return entity;
	}
	
	public SupplierDTO toDto(SupplierEntity entity) {
		SupplierDTO dto = new SupplierDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		dto.setAddress(entity.getAddress());
		return dto;		
	}
	
	public ImportEntity toEntity(ImportDTO dto, ImportEntity entity) {
//		entity.setAuthor(dto.getAuthor());
//		entity.setDescription(dto.getDescription());
//		entity.setName(dto.getName());
//		entity.setPrice(dto.getPrice());
//		entity.setPublishedDate(Date.valueOf(dto.getPublishedDate()));
//		entity.setQuantity(dto.getQuantity());	
		return entity;		
	}
}
