package inventoryManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	private static Scanner sc = new Scanner(System.in);
	private static Product pr;
	private static boolean done;
	private static boolean ascending;
	private static ArrayList <Product> products = new ArrayList<Product>();
	
	public static void addProduct() {
		//String name, String category, double price, int stockQuantity
		System.out.println("Let's make a new product.");
		String name = getStringName("Enter name of product: ");
		String category = getStringName("Enter category: ");
		Double price = (double)0;
		int stockQuantity = 0;
		try {
			price = Double.valueOf(getStringName("Enter price as number: ").trim());
			stockQuantity = Integer.valueOf(getStringName("Enter quantity as number: ").trim());
		}catch(Exception e) {
			System.out.println("This number is not correct");
			System.out.println(e.getMessage());	
		}
		pr = new Product(name,category,price,stockQuantity);
		System.out.println("Product is added");
	}
	
	public static void removeProduct(String name){
		done = false;
		products.forEach(p -> {
			if(p.getName().equals(name)) {
				pr = p;
				done = true;
			}
		});
		products.remove(pr);
		System.out.println("Product "+pr.getName()+" is deleted");
		if(!done) {
			System.out.println("Product not found");
		}
	}
		
	public static void sortByPrice() {
		if(Inventory.getStringName("Do you want to sort products by ascending? Y/N: ").trim().equalsIgnoreCase("y")) {
			ascending = true;
		}else {
			ascending = false;
		}
		if(ascending) {
			products.sort((p1, p2) -> ((Double)p1.getPrice()).compareTo((Double)(p2.getPrice()))); 
		}else {
			products.sort((p1, p2) -> (-1)*((Double)p1.getPrice()).compareTo((Double)(p2.getPrice())));
		}
		System.out.println("Products are sorted");
	}
	
	public static void getLowStockProducts() {
		try {
			double threshold = Double.valueOf(Inventory.getStringName("Enter price: ").trim());
			done = false;
			products.forEach(p -> {
				if(p.getPrice()<threshold) {
					p.getProductDetails();
					done = true;
				}
			});
		}catch(Exception e) {
			e.getMessage();
		}
		if(!done) {
			System.out.println("Products not found");
		}
	}
	
	public static void sortProducts() {
		products.sort((p1, p2) -> p1.getName().compareTo(p2.getName())); 
	}
	
	public static void allProductsInfo() {
		products.forEach(p -> p.getProductDetails());
	}
	
	
	public static Product findProductByCategory(String category) {
		done = false;
		products.forEach(p -> {
			if(p.getCategory().equalsIgnoreCase(category)) {
				p.getProductDetails();
				done = true;
			}
		});
		if(!done) {
			System.out.println("Category not found");
		}
		return pr;
	}
	
	public static Product findProductByName(String productName) {
		done = false;
		pr = products.getFirst();
		products.forEach(p -> {
			if(p.getName().equalsIgnoreCase(productName)) {
				pr = p;
				System.out.println("Product found");
				done = true;
			}
		});
		if(!done) {
			System.out.println("Product not found");
		}
		pr.getProductDetails();
		return pr;
	}
	
	public static String getStringName(String str) {
		int x = 5;
		while(x>0) {
			System.out.println(str);
			String clientString = sc.nextLine();
			if(clientString.isBlank()) {
				System.out.println("This is not correct. You have attempts: "+(--x));
			}else {
				return clientString;
			}
		}
		return "Not real";
		
	}
	
	public static void exit(){
		System.out.println("Bye");
		sc.close();
	}

	public static ArrayList<Product> getProducts() {
		return products;
	}

	public static void setProducts(ArrayList<Product> products) {
		Inventory.products = products;
	}	
}

//products (ArrayList of Product objects)

//2. Create an Inventory class with: 
//○ products (ArrayList of Product objects) 
//○ Methods: 
//■ addProduct(Product p): Adds a product. 
//■ removeProduct(String name): Removes a product. 
//■ searchByCategory(String category): Returns all products in a 
//category. 
//■ sortByPrice(boolean ascending): Sorts the products by price. 
//■ getLowStockProducts(int threshold): Returns products with 
//stock below the threshold. 
//3. Implementation Details: 
//○ Use array operations to manipulate stock levels. 
//○ Use sorting (Bubble Sort, Selection Sort, or Java’s built-in) to sort 
//products. 
