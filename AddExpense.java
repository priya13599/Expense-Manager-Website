package Bean;

import java.util.Date;

public class AddExpense {
	private String email;
	private String amount;
	private String category;
	private Date date;
	public AddExpense(String email, String amount, String category, Date date) {
		
		this.email = email;
		this.amount = amount;
		this.category = category;
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "AddExpense [email=" + email + ", amount=" + amount + ", category=" + category + ", date=" + date + "]";
	}
	
	
	
	
}
