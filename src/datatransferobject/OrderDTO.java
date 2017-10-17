package datatransferobject;

public class OrderDTO {
	
	private int pk;
	private String email;
	private String date;
	
	public OrderDTO(int pk, String email, String date) {
		
		this.pk = pk;
		this.email = email;
		this.date = date;
		
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
