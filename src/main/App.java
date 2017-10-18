package main;

import java.sql.Date;
import java.util.ArrayList;

import connection.DatabaseConnection;
import connection.PizzaDomain;
import datatransferobject.OrderDTO;
import datatransferobject.ProductDTO;

public class App {
	
public static void main(String[] args) {
		
		//Select * from products
		ArrayList<ProductDTO> list = new PizzaDomain(new DatabaseConnection()).selectAllProducts();
		
		for(int i = 0; i < list.size(); i++) {
			
			System.out.print(list.get(i).getPk() + " ");
			System.out.print(list.get(i).getName() + " ");
			System.out.print(list.get(i).getPrice() + "\n");
			
		}
		
		//new PizzaDomain(new DatabaseConnection()).insertOrder(new OrderDTO(0, "grüezi@hsr.ch", new Date(System.currentTimeMillis())));
		
		
		//Select * from Order where date = date
		ArrayList<OrderDTO> orderList = new PizzaDomain(new DatabaseConnection()).selectOrdersByDate(new Date(System.currentTimeMillis()));
		
		for(int i = 0; i < orderList.size(); i++) {
			
			System.out.print(orderList.get(i).getPk() + " ");
			System.out.print(orderList.get(i).getEmail() + " ");
			System.out.print(orderList.get(i).getDate() + "\n");
			
		}
		
		//Select * from Order where email = email
		ArrayList<OrderDTO> orderList2 = new PizzaDomain(new DatabaseConnection()).selectOrdersByEmail("lvonnied@hsr.ch");
		
		for(int i = 0; i < orderList2.size(); i++) {
			
			System.out.print(orderList2.get(i).getPk() + " ");
			System.out.print(orderList2.get(i).getEmail() + " ");
			System.out.print(orderList2.get(i).getDate() + "\n");
			
		}
		
		//Select * from Order where pk = pk
		OrderDTO order = new PizzaDomain(new DatabaseConnection()).selectOrder(9);
		if(order != null) {
		System.out.println(order.getPk() + " " + order.getEmail() + " " + order.getDate());
		} else {
			System.out.println("There is no object at this primary key");
		}
		//Delete from Order where pk = pk
		//new PizzaDomain(new DatabaseConnection()).deleteOrder(8);
		
		//Select * from Order where pk = pk
		ProductDTO product = new PizzaDomain(new DatabaseConnection()).selectProduct(2);
		if(order != null) {
			System.out.println(product.getPk() + " " + product.getName() + " " + product.getPrice());
			} else {
				System.out.println("There is no object at this primary key");
			}
		
		
		
	}

}
