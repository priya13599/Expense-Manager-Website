package Bean;

public class DisplayYearwise {

	private String amount;
	private String category;
	private String year;
	public DisplayYearwise(String amount, String category, String year) {
		
		this.amount = amount;
		this.category = category;
		this.year = year;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "DisplayYearwise [amount=" + amount + ", category=" + category + ", year=" + year + "]";
	}
	

}
