package mapper;

import java.sql.Connection;

public abstract class DatabaseMapper {
	
	Connection connection;
	
	public DatabaseMapper(Connection connection) {
		
		this.connection = connection;
		
	}

}
