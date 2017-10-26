package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import connection.DatabaseConnection;
import mapper.ProductMapper;

class TestProductMapper {
	
	ProductMapper mapper = new ProductMapper(new DatabaseConnection().getConnection());

	@Test
	void testSelect() {
		assertNotNull(mapper.select(1), "Checking if return value is not null");
	}

	@Test
	void testSelectAll() {
		assertNotNull(mapper.selectAll(), "Checking if return value is not null");
		assertFalse(mapper.selectAll().isEmpty(), "Checking if list is not empty");
	}

}
