package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connection.DatabaseConnection;
import mapper.ProductMapper;

class TestProductMapper {
	
	ProductMapper mapper;
	
	@BeforeEach
	void getConnection() {
		mapper = new ProductMapper(new DatabaseConnection().getConnection());
	}

	@Test
	void testSelect() {
		assertNotNull(mapper.select(1), "checking value at 1");
	}

	@Test
	void testSelectAll() {
		assertNotNull(mapper.selectAll(), "Checking if return value of all selections is not null");
		assertFalse(mapper.selectAll().isEmpty(), "Checking if list is not empty");
	}

}
