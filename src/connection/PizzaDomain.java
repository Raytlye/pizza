package connection;

import java.util.ArrayList;

import datatransferobject.ProductDTO;
import mapper.ProductMapper;

public class PizzaDomain {
	
	DatabaseConnection connector;
	
	public PizzaDomain(DatabaseConnection connector) {
		
		this.connector = connector;
		
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
		
	}

}
