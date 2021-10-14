package fin3.tanhv4.service.impl;

import org.springframework.stereotype.Service;

import fin3.tanhv4.converter.ImportConverter;
import fin3.tanhv4.dto.ImportDTO;
import fin3.tanhv4.entities.ImportEntity;
import fin3.tanhv4.entities.SupplierEntity;
import fin3.tanhv4.repository.ImportRepository;
import fin3.tanhv4.repository.SupplierRepository;
import fin3.tanhv4.service.IImportService;

@Service
public class ImportService implements IImportService {
	
	private ImportRepository importRepository;
	
	private ImportConverter importConverter;
	
	private SupplierRepository supplierRepository;
	
	@Override
	public void save(ImportDTO dto) {
		
		ImportEntity entity = importConverter.toEntity(dto);
		SupplierEntity supplierEntity = supplierRepository.findById(dto.getSupplierID()).get();
		entity.setDeleteFlag(false);
		entity.setSupplier(supplierEntity);
		importRepository.save(entity);
	}

}
