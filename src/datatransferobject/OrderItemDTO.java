package datatransferobject;

public class OrderItemDTO {
	
	private int pk;
	private int pkProduct;
	private int count;
	
	public OrderItemDTO(int pk, int pkProduct, int count) {
		
		this.pk = pk;
		this.pkProduct = pkProduct;
		this.count = count;
		
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public int getPkProduct() {
		return pkProduct;
	}

	public void setPkProduct(int pkProduct) {
		this.pkProduct = pkProduct;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
