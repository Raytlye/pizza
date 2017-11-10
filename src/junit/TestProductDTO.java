package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datatransferobject.ProductDTO;

class TestProductDTO {
	
	ProductDTO product;

	@BeforeEach
	void createObject() {
		product = new ProductDTO(1, "Piccante", 20.0);
	}
	
	@Test
	void testGetPk() {
		assertEquals(1, product.getPk());
	}
	
	@Test
	void testSetPk() {
		product.setPk(10);
		assertEquals(10, product.getPk());
	}
	
	@Test
	void testGetName() {
		assertEquals("Piccante", product.getName());
	}
	
	@Test
	void testSetName() {
		product.setName("Margherita");
		assertEquals("Margherita", product.getName());
	}
	
	@Test
	void testGetPrice() {
		assertEquals(20.0, product.getPrice());
	}
	
	@Test
	void testSetPrice() {
		product.setPrice(500.0);
		assertEquals(500.0, product.getPrice());
	}

}
