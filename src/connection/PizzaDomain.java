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
	
	public static void main(String[] args) {
		
		//Select * from products
		ArrayList<ProductDTO> list = new PizzaDomain(new DatabaseConnection()).selectAllProducts();
		
		for(int i = 0; i < list.size(); i++) {
			
			System.out.print(list.get(i).getPk() + " ");
			System.out.print(list.get(i).getName() + " ");
			System.out.print(list.get(i).getPrice() + "\n");
			
		}
		
		//new PizzaDomain(new DatabaseConnection()).insertOrder(new OrderDTO(1, "yallah@hsr.ch", new Date(System.currentTimeMillis())));
		
		
		//Select * from Order where date = date
		ArrayList<OrderDTO> orderList = new PizzaDomain(new DatabaseConnection()).selectOrdersByDate(new Date(System.currentTimeMillis()));
		
		for(int i = 0; i < orderList.size(); i++) {
			
			System.out.print(orderList.get(i).getPk() + " ");
			System.out.print(orderList.get(i).getEmail() + " ");
			System.out.print(orderList.get(i).getDate() + "\n");
			
		}
		
		//Select * from Order where email = email
		ArrayList<OrderDTO> orderList2 = new PizzaDomain(new DatabaseConnection()).selectOrdersByEmail("yallah@hsr.ch");
		
		for(int i = 0; i < orderList2.size(); i++) {
			
			System.out.print(orderList2.get(i).getPk() + " ");
			System.out.print(orderList2.get(i).getEmail() + " ");
			System.out.print(orderList2.get(i).getDate() + "\n");
			
		}
		
		
		
	}

}
