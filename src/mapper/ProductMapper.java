package mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datatransferobject.ProductDTO;

public class ProductMapper extends DatabaseMapper {

	public ProductMapper(Connection connection) {
		super(connection);
	}
	
	public ProductDTO select(int pk) {
		
		String selectSQL = "SELECT * from product WHERE productpk = ?";
		
		try(PreparedStatement ps = connection.prepareStatement(selectSQL)) {
			
			ps.setInt(1, pk);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				ProductDTO product = new ProductDTO(rs.getInt("productpk"), rs.getString("name"), rs.getDouble("price"));
				return product;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public ArrayList<ProductDTO> selectAll() {
		
		
		String selectAllSQL = "SELECT * FROM product";
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(selectAllSQL)) {
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				
				ProductDTO product = new ProductDTO(rs.getInt("productpk"), rs.getString("name"), rs.getDouble("price"));
				list.add(product);
				
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
