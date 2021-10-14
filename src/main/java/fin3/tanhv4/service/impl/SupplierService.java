package fin3.tanhv4.service.impl;

import org.springframework.stereotype.Service;

import fin3.tanhv4.converter.SupplierConverter;
import fin3.tanhv4.dto.SupplierDTO;
import fin3.tanhv4.entities.SupplierEntity;
import fin3.tanhv4.repository.SupplierRepository;
import fin3.tanhv4.service.ISupplierService;

@Service
public class SupplierService implements ISupplierService {
	
	private SupplierRepository supplierRepository;
	
	private SupplierConverter supplierConverter;

	@Override
	public SupplierDTO findOneById(int id) {
		SupplierEntity entity = supplierRepository.findById(id).get();		
		SupplierDTO dto = supplierConverter.toDto(entity);
		return dto;
	}

}
