package datatransferobject;

public class ProductDTO {
	
	private int pk;
	private String name;
	private double price;
	
	public ProductDTO(int pk, String name, double price) {
		
		this.pk = pk;
		this.name = name;
		this.price = price;
		
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
