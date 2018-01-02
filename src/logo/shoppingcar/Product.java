package logo.shoppingcar;

public class Product {
	private String type;
	private String title;
	private double price;    
	
	public Product(String title, double price) {
		this.title = title;
		this.price = price;
	}

	public Product(String type, String title, double price) {
		this.type = type;
		this.title = title;
		this.price = price;
	}

	
	public String getType(){
		return type;
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getPrice() {
		 return price;
	} 
	
	public boolean equals(Object o) {
		if (o instanceof Product) {
			Product p = (Product)o;
		        return p.getTitle().equals(title);
		}	
		return false;
	}

}
