package mapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			System.out.println("Record is inserted into Order table!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public OrderDTO select(int pk) {
		
		return null;
		
	}
	
	public ArrayList<OrderDTO> selectByDate(Date date) {
		
		String selectWhereDateSQL = "SELECT * from public.\"Order\" WHERE DATE = ?";
		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();
		
		try(PreparedStatement ps = connection.prepareStatement(selectWhereDateSQL)) {
			
			ps.setDate(1, date);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				OrderDTO order = new OrderDTO(rs.getInt("orderpk"), rs.getString("email"), rs.getDate("date"));
				list.add(order);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public ArrayList<OrderDTO> selectByEmail(String email) {
		
		String selectWhereEmailSQL = "SELECT * from public.\"Order\" WHERE EMAIL = ?";
		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();
		
		try(PreparedStatement ps = connection.prepareStatement(selectWhereEmailSQL)) {
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				OrderDTO order = new OrderDTO(rs.getInt("orderpk"), rs.getString("email"), rs.getDate("date"));
				list.add(order);
				
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void delete(int pk) {
		
		String deleteSQL = "DELETE FROM public.\"Order\" WHERE orderpk = ?";
		
		try(PreparedStatement ps = connection.prepareStatement(deleteSQL)) {
			
			ps.setInt(1, pk);
			
			ps.executeUpdate();
			System.out.println("Record deleted from Order table!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
