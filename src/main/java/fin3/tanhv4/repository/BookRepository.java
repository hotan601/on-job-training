package fin3.tanhv4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fin3.tanhv4.entities.BookEntity;
import fin3.tanhv4.query.QueryStatement;
// TODO: Auto-generated Javadoc
/**
 * BookRepository
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
public interface BookRepository extends JpaRepository<BookEntity, Integer>{	

	/**
	 * Find all by delete flag false order by id desc.	 
	 * @return the list
	 */
	List<BookEntity> findAllByDeleteFlagFalseOrderByIdDesc();
	
	/**
	 * Find by keywords.
	 * @param keywords the keywords
	 * @return the list
	 */
	@Query(QueryStatement.search)
	List<BookEntity> findByKeywords(String keywords);
	
	
	/**
	 * Check exists by name.
	 * @param name the name
	 * @return the book entity
	 */
	@Query(QueryStatement.checkExists)
	BookEntity checkExistsByName(String name);
	
	/**
	 * Find by id and delete flag false.
	 * @param id the id
	 * @return the optional
	 */
	Optional<BookEntity> findByIdAndDeleteFlagFalse(Integer id);
	
	Page<BookEntity> findByNameContainingAndDeleteFlagFalse(String name, Pageable pageable);
	
	Page<BookEntity> findAllByDeleteFlagFalse(Pageable pageable);
}

