package connection;

import java.sql.Date;
import java.util.ArrayList;

import datatransferobject.OrderDTO;
import datatransferobject.ProductDTO;
import mapper.OrderMapper;
import mapper.ProductMapper;

public class PizzaDomain {
	
	DatabaseConnection connector;
	OrderMapper mapper;
	
	public PizzaDomain(DatabaseConnection connector) {
		
		this.connector = connector;
		
	}
	
	public ArrayList<ProductDTO> selectAllProducts(){
		
		ProductMapper mapper = new ProductMapper(connector.getConnection());
		ArrayList<ProductDTO> list = mapper.selectAll();
		connector.closeConnection();
		return list;
		
	}
	
	public void insertOrder(OrderDTO order) {
		
		OrderMapper mapper = new OrderMapper(connector.getConnection());
		mapper.insert(order);
		connector.closeConnection();
		
	}
	
	public ArrayList<OrderDTO> selectOrdersByDate(Date date) {
		
		OrderMapper mapper = new OrderMapper(connector.getConnection());
		ArrayList<OrderDTO> list = mapper.selectByDate(date);
		connector.closeConnection();
		return list;
		
	}
	
	public ArrayList<OrderDTO> selectOrdersByEmail(String email) {
		
		OrderMapper mapper = new OrderMapper(connector.getConnection());
		ArrayList<OrderDTO> list = mapper.selectByEmail(email);
		connector.closeConnection();
		return list;
		
	}
	
	public OrderDTO selectOrder(int pk) {
		
		OrderMapper mapper = new OrderMapper(connector.getConnection());
		OrderDTO order = mapper.select(pk);
		connector.closeConnection();
		return order;
		
	}
	
	public void deleteOrder(int pk) {
		
		OrderMapper mapper = new OrderMapper(connector.getConnection());
		mapper.delete(pk);
		connector.closeConnection();
		
	}
	
	public ProductDTO selectProduct(int pk) {
		
		ProductMapper mapper = new ProductMapper(connector.getConnection());
		ProductDTO product = mapper.select(pk);
		connector.closeConnection();
		return product;
		
	}
	
	public void insertProduct(ProductDTO product) {
		
		ProductMapper mapper = new ProductMapper(connector.getConnection());
		mapper.insert(product);
		connector.closeConnection();
		
	}
	
	public void deleteProduct(int pk) {
		
		ProductMapper mapper = new ProductMapper(connector.getConnection());
		mapper.delete(pk);
		connector.closeConnection();
		
	}

}
