package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connection.DatabaseConnection;
import connection.PizzaDomain;
import datatransferobject.OrderDTO;

public class TestOrderMapper {

	DatabaseConnection dbConnection;
	PizzaDomain domain;

	@BeforeEach
	void getConnection() throws IOException {
		dbConnection = new DatabaseConnection();
		domain = new PizzaDomain(dbConnection);
	}

	static void resetDb() {
		try {
			ProcessBuilder builder = new ProcessBuilder("C:\\Users\\lvonnied\\eclipse-workspace\\pizza\\batch.bat");
			builder.directory(new File("C:\\Users\\lvonnied\\eclipse-workspace\\pizza"));
			Process p = builder.start();
			p.waitFor();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@AfterEach
	void resetAfterEachTest() {
		resetDb();
	}
	
	@BeforeAll
	static void resetDbOnStart() {
		resetDb();
	}

	@Test
	void testSelect() {
		OrderDTO order = domain.selectOrder(1);
		String dateString = "2017-10-11";
		Date date = Date.valueOf(dateString);
		assertNotNull(order, "Checking if return value of select is not null");
		assertEquals("lvonnied@hsr.ch", order.getEmail());
		assertEquals(1, order.getPk());
		assertEquals(date, order.getDate());
	}

	@Test
	void testSelectByDate() {
		String dateString = "2017-10-13";
		Date date = Date.valueOf(dateString);
		ArrayList<OrderDTO> list = domain.selectOrdersByDate(date);
		assertNotNull(list, "Checking if return value of selectByDate is not null");
		assertFalse(list.isEmpty(), "check if list by date is empty");
		assertEquals("skeller@hsr.ch", list.get(0).getEmail());
		assertEquals(date, list.get(0).getDate());
	}

	@Test
	void testSelectByEmail() {
		String email = "lvonnied@hsr.ch";
		ArrayList<OrderDTO> list = domain.selectOrdersByEmail(email);
		assertNotNull(list, "Checking if return value of selectByEmail is not null");
		assertFalse(list.isEmpty(), "check if list by email is empty");
		assertEquals(email, list.get(0).getEmail());
		assertEquals(1, list.get(0).getPk());
	}

	@Test
	void testInsert() {
		String dateString = "2017-01-15";
		Date date = Date.valueOf(dateString);
		String email = "insert@gmail.com";
		OrderDTO order = new OrderDTO(1, email, date);
		domain.insertOrder(order);
		assertNotNull(domain.selectOrder(5));
		assertEquals(email, domain.selectOrder(5).getEmail());
		assertEquals(date, domain.selectOrder(5).getDate());
	}

	@Test
	void testDelete() {
		domain.deleteOrder(4);
		assertNull(domain.selectOrder(4));
	}

}
