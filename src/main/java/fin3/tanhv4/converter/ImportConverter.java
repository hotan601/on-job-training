package fin3.tanhv4.converter;

import java.sql.Date;

import org.springframework.stereotype.Component;

import fin3.tanhv4.dto.ImportDTO;
import fin3.tanhv4.entities.ImportEntity;
import fin3.tanhv4.entities.SupplierEntity;
// TODO: Auto-generated Javadoc
/**
 * ImportConverter
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
public class ImportConverter {
	
	public ImportEntity toEntity(ImportDTO dto) {
		ImportEntity entity = new ImportEntity();
//		entity.setSupplier(new SupplierEntity(dto.getSupplierID()));
		entity.setImportedDate(Date.valueOf(dto.getImportedDate()));
		entity.setTotal(dto.getTotal());
		return entity;
	}
	
	public ImportDTO toDto(ImportEntity entity) {
		ImportDTO dto = new ImportDTO();
//		dto.setId(entity.getId());
//		dto.setAuthor(entity.getAuthor());
//		dto.setDescription(entity.getDescription());
//		dto.setName(entity.getName());
//		dto.setPrice(entity.getPrice());
//		dto.setPublishedDate(entity.getPublishedDate().toLocalDate());
//		dto.setCategoryName(entity.getCategory().getName());
//		dto.setQuantity(entity.getQuantity());
//		dto.setCategoryCode(entity.getCategory().getCode());
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
