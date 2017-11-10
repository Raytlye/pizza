package junit;

import java.sql.Date;
import java.text.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connection.DatabaseConnection;
import mapper.OrderMapper;

import static org.junit.jupiter.api.Assertions.*;

public class TestOrderMapper {
	
	OrderMapper mapper;
	
	@BeforeEach
	void getConnection() throws ParseException {
		mapper = new OrderMapper(new DatabaseConnection().getConnection());
	}
	
	@Test
	void testSelect() {
		assertNotNull(mapper.select(1), "Checking if return value of select is not null");
	}

	@Test
	void testSelectByDate() {
		String dateString = "2017-10-30";
		Date date = Date.valueOf(dateString);
		assertNotNull(mapper.selectByDate(date), "Checking if return value of selectByDate is not null");
		System.out.println(mapper.selectByDate(date));
		assertFalse(mapper.selectByDate(date).isEmpty(), "check if list by date is empty");
	}

	@Test
	void testSelectByEmail() {
		assertNotNull(mapper.selectByEmail("lvonnied@hsr.ch"), "Checking if return value of selectByEmail is not null");
		assertFalse(mapper.selectByEmail("lvonnied@hsr.ch").isEmpty(), "check if list by email is empty");
	}

}
