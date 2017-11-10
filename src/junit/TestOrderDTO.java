package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datatransferobject.OrderDTO;

class TestOrderDTO {
	
	OrderDTO order;
	
	@BeforeEach
	void createObject() {
		
		order = new OrderDTO(1, "lvonnied@hsr.ch", new Date(System.currentTimeMillis()));
		
	}

	@Test
	void testGetDate() {
		assertEquals(new Date(System.currentTimeMillis()), order.getDate(), "Compare Date");
	}
	
	@Test
	void testSetDate() {
		order.setDate(new Date(0));
		assertEquals(new Date(0), order.getDate(), "Compare Date after setting a new one");
	}
	
	@Test
	void testGetPk() {
		assertEquals(1, order.getPk(), "Compare PK");
	}
	
	@Test
	void testSetPk() {
		order.setPk(5);
		assertEquals(5, order.getPk(), "Compare PK after setting a new one");
	}
	
	@Test
	void testGetEmail() {
		assertEquals("lvonnied@hsr.ch", order.getEmail(), "Compare Email");
	}
	
	@Test
	void testSetEmail() {
		order.setEmail("asdf@asdf.com");
		assertEquals("asdf@asdf.com", order.getEmail(), "Compare Email after setting a new one");
	}

}
