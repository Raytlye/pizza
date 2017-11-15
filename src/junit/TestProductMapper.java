package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import connection.DatabaseConnection;
import connection.PizzaDomain;
import datatransferobject.ProductDTO;

class TestProductMapper {
	
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
		ProductDTO  product = domain.selectProduct(1);
		assertNotNull(product, "checking if null");
		assertEquals(1, product.getPk());
		assertEquals("Margherita", product.getName());
		assertEquals(18.00, product.getPrice());
	}

	@Test
	void testSelectAll() {
		ArrayList<ProductDTO> list = domain.selectAllProducts();
		assertNotNull(list, "Checking if return value of all selections is not null");
		assertFalse(list.isEmpty(), "Checking if list is not empty");
		assertEquals("CocaCola", list.get(8).getName());
		assertEquals(3.00, list.get(5).getPrice());
		assertEquals(9, list.size());
	}
	
	@Test
	void testInsert() {
		double price = 20.00;
		String name = "Odenssnus";
		ProductDTO product = new ProductDTO(1, name, price);
		domain.insertProduct(product);
		assertNotNull(domain.selectProduct(10));
		assertEquals(name, domain.selectProduct(10).getName());
		assertEquals(price, domain.selectProduct(10).getPrice());
	}

	@Test
	void testDelete() {
		domain.deleteProduct(4);
		assertNull(domain.selectProduct(4));
	}

}
