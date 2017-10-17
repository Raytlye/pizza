package connection;

import java.sql.Date;
import java.util.ArrayList;

import datatransferobject.OrderDTO;
import datatransferobject.ProductDTO;
import mapper.OrderMapper;
import mapper.ProductMapper;

public class PizzaDomain {
	
	DatabaseConnection connector;
	
	public PizzaDomain(DatabaseConnection connector) {
		
		this.connector = connector;
		
	}
	
	public void insertOrder(OrderDTO order) {
		
		OrderMapper mapper = new OrderMapper(connector.getConnection());
		mapper.insert(order);
		
	}
	
	public ArrayList<ProductDTO> selectAllProducts(){
		
		ProductMapper mapper = new ProductMapper(connector.getConnection());
		return mapper.selectAll();
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<ProductDTO> list = new PizzaDomain(new DatabaseConnection()).selectAllProducts();
		
		for(int i = 0; i < list.size(); i++) {
			
			System.out.print(list.get(i).getPk() + " ");
			System.out.print(list.get(i).getName() + " ");
			System.out.print(list.get(i).getPrice() + "\n");
			
		}
		
		new PizzaDomain(new DatabaseConnection()).insertOrder(new OrderDTO(1, "yallah@hsr.ch", new Date(System.currentTimeMillis())));
		
		
		
	}

}
