package fin3.tanhv4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fin3.tanhv4.entities.CategoryEntity;
import fin3.tanhv4.query.QueryStatement;
// TODO: Auto-generated Javadoc
/**
 * CategoryRepository
 * Version 1.0
 *
 * Date: Sep 16, 2021
 *
 * Copyright
 *
 * Modification Logs:
 *  DATE                 AUTHOR          DESCRIPTION
 *  -----------------------------------------------------------------------
 *  Sep 16, 2021        TanHV4            Create
 */
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
	
	/**
	 * Find by code.
	 * @param code the code
	 * @return the category entity
	 */
	CategoryEntity findByCode(String code);
	
	
	/**
	 * Find all by delete flag false order by id desc.
	 * @return the list
	 */
	List<CategoryEntity> findAllByDeleteFlagFalseOrderByIdDesc();
	
	/**
	 * Check exists by name.
	 * @param name the name
	 * @return the category entity
	 */
	@Query(QueryStatement.checkExistsByName)
	CategoryEntity checkExistsByName(String name);
	
	/**
	 * Check exists by code.
	 * @param code the code
	 * @return the category entity
	 */
	@Query(QueryStatement.checkExistsByCode)
	CategoryEntity checkExistsByCode(String code);
	
	/**
	 * Find by id and delete flag false.
	 * @param id the id
	 * @return the optional
	 */
	Optional<CategoryEntity> findByIdAndDeleteFlagFalse(Integer id);
}
