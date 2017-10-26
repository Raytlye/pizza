package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import connection.DatabaseConnection;
import mapper.OrderMapper;

class TestOrderMapper {

	OrderMapper mapper = new OrderMapper(new DatabaseConnection().getConnection());
	Date date = new Date(2017, 10, 17);
	
	@Test
	void testSelect() {
		assertNotNull(mapper.select(1), "Checking if return value of select is not null");
	}

	@Test
	void testSelectByDate() {
		assertNotNull(mapper.selectByDate(date), "Checking if return value of selectByDate is not null");
		assertFalse(mapper.selectByDate(date).isEmpty(), "check if list by date is empty");
	}

	@Test
	void testSelectByEmail() {
		assertNotNull(mapper.selectByEmail("lvonnied@hsr.ch"), "Checking if return value of selectByEmail is not null");
		assertFalse(mapper.selectByEmail("lvonnied@hsr.ch").isEmpty(), "check if list by email is empty");
	}

}
