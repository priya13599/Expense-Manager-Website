package Bean;

public class ContactUsBean {

	
	
	String email_id;
	String name;
	String phone_number;
	String message;
	public ContactUsBean( String email_id,String name, String phone_number, String message) {
		
		
		this.email_id = email_id;
		this.name = name;
		this.phone_number = phone_number;
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ContactUsBean [name=" + name + ", email_id=" + email_id + ", phone_number=" + phone_number
				+ ", message=" + message + "]";
	}
	
	
}
