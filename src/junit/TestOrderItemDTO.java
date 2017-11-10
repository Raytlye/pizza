package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datatransferobject.OrderItemDTO;

class TestOrderItemDTO {
	
	OrderItemDTO orderItem;

	@BeforeEach
	void createObject() {
		orderItem = new OrderItemDTO(1, 1, 5);
	}
	
	@Test
	void testGetPk() {
		assertEquals(1, orderItem.getPk());
	}
	
	@Test
	void testSetPk() {
		orderItem.setPk(2);
		assertEquals(2, orderItem.getPk());
	}
	
	@Test
	void testGetPkProduct() {
		assertEquals(1, orderItem.getPkProduct());
	}
	
	@Test
	void testSetPkProduct() {
		orderItem.setPkProduct(10);
		assertEquals(10, orderItem.getPkProduct());
	}
	
	@Test
	void testGetCount() {
		assertEquals(5, orderItem.getCount());
	}
	
	@Test
	void testSetCount() {
		orderItem.setCount(100);
		assertEquals(100, orderItem.getCount());
	}

}
