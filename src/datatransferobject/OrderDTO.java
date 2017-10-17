package datatransferobject;

import java.sql.Date;

public class OrderDTO {
	
	private int pk;
	private String email;
	private Date date;
	
	public OrderDTO(int pk, String email, Date date) {
		
		this.pk = pk;
		this.email = email;
		this.date = date;
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

}
