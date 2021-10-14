package fin3.tanhv4.repository;
/**
 * ImportRepository
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
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fin3.tanhv4.entities.ImportEntity;

@Repository
public interface ImportRepository extends JpaRepository<ImportEntity, Integer>{
	
	
	/**
	 * Find all by delete flag false order by id desc.
	 *
	 * @return the list
	 */
	List<ImportEntity> findAllByDeleteFlagFalseOrderByIdDesc();
	
}
