package inventoryManager;

public class Product {
	private String name; 
	private String category;
	private double price;
	private int stockQuantity; //количество 
	
	public Product(String name, String category, double price, int stockQuantity) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
		Inventory.getProducts().add(this);
	}
	
	public void updateStock(int quantity){
		if(stockQuantity+quantity<0) {
			System.out.println("Not correct num, now quantity is "+stockQuantity);
		}else {
			System.out.println("Done. Now quantity of "+name+" is "+stockQuantity);
		}
	}
	
	public void getProductDetails(){
		System.out.println("Product name: "+name+", category: "+category+",price: "+price+", stockQuantity: "+stockQuantity);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	
	
	

}
