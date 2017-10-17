package mapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import datatransferobject.OrderDTO;

public class OrderMapper extends DatabaseMapper {

	public OrderMapper(Connection connection) {
		super(connection);
	}
	
	public void insert(OrderDTO order) {
		
		String insertSQL = "INSERT INTO public.\"Order\"" 
				+ "(email, date)" 
				+ "VALUES(?, ?)";
		
		try(PreparedStatement ps = connection.prepareStatement(insertSQL)) {
			
			ps.setString(1, order.getEmail());
			ps.setDate(2, order.getDate());
			
			ps.executeUpdate();
			System.out.println("Record is inserted into DBUSER table!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public OrderDTO select(int pk) {
		
		return null;
		
	}
	
	public ArrayList<OrderDTO> selectByDate(Date date) {
		
		return null;
		
	}
	
	public ArrayList<OrderDTO> selectByEmail(String email) {
		
		return null;
		
	}
	
	public void delete(int pk) {
		
		
		
	}

}
