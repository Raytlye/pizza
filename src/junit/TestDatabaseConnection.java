package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import connection.DatabaseConnection;

class TestDatabaseConnection {

	@Test
	void testGetConnection() {
		DatabaseConnection connection = new DatabaseConnection();
		assertNotNull(connection.getConnection(), "checking if connection is not null");
	}

}
