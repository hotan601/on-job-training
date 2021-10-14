package fin3.tanhv4.query;
/**
 * QueryStatement
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
public class QueryStatement {
	
	public static final String search = "SELECT b FROM BookEntity b WHERE CONCAT(b.name, b.author) LIKE %?1% AND b.deleteFlag = 0 ORDER BY b.id DESC";
	
	public static final String checkExists = "SELECT b FROM BookEntity b WHERE b.name = ?1";
	
	public static final String checkExistsByName = "SELECT c FROM CategoryEntity c WHERE c.name = ?1";
	
	public static final String checkExistsByCode = "SELECT c FROM CategoryEntity c WHERE c.code = ?1";
}
