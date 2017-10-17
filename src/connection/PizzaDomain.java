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
		return mapper.selectAll();
		
	}
	
	public void insertOrder(OrderDTO order) {
		
		OrderMapper mapper = new OrderMapper(connector.getConnection());
		mapper.insert(order);
		
	}
	
	public ArrayList<OrderDTO> selectOrdersByDate(Date date) {
		
		OrderMapper mapper = new OrderMapper(connector.getConnection());
		return mapper.selectByDate(date);
		
	}
	
	public ArrayList<OrderDTO> selectOrdersByEmail(String email) {
		
		OrderMapper mapper = new OrderMapper(connector.getConnection());
		return mapper.selectByEmail(email);
		
	}
	
	public OrderDTO selectOrder(int pk) {
		
		OrderMapper mapper = new OrderMapper(connector.getConnection());
		return mapper.select(pk);
		
	}
	
	public void deleteOrder(int pk) {
		
		OrderMapper mapper = new OrderMapper(connector.getConnection());
		mapper.delete(pk);
		
	}
	
	public ProductDTO selectProduct(int pk) {
		
		ProductMapper mapper = new ProductMapper(connector.getConnection());
		return mapper.select(pk);
		
	}

}
