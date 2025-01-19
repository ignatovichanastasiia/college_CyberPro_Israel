package inventoryManager;

public class Main {
	private static int program;

	public static void main(String[] args) {
		Product p1 = new Product("p1","fruit",45,12);
		Product p2 = new Product("p2","vegetable",78,1);
		Product p3 = new Product("p3","fruit",89,9);
		Product p4 = new Product("p4","vegetable",34,10);
		Product p5 = new Product("p5","bakery",67,13);
		Product p6 = new Product("p6","bakery",34,17);
		goProgram();
	}
	
	private static void menu(){
		System.out.println("\nMenu:\n1-all products\n2-add product\n3-remove product\n4-sort products by price\n5-get category's product"
				+ "\n6-search by name\n7-products with stock below the threshold\n0-exit");
	}
	
	private static void goProgram() {
		do {
			menu();
			program = Integer.valueOf(Inventory.getStringName("Enter number of program: ").trim());
			switch(program) {
			case 1:
				Inventory.allProductsInfo();
				break;
			case 2:
				Inventory.addProduct();
				break;
			case 3:
				Inventory.removeProduct(Inventory.getStringName("Enter name of product you want to remove: "));
				break;
			case 4:
				Inventory.sortByPrice();
				Inventory.allProductsInfo();
				Inventory.sortProducts();
				break;
			case 5:
				Inventory.findProductByCategory(Inventory.getStringName("Enter category:"));
				break;
			case 6:
				Inventory.findProductByName(Inventory.getStringName("Enter name of product you search: "));
				break;
			case 7:
				Inventory.getLowStockProducts();
				break;
			case 0:
				Inventory.exit();
				break;
			}
		}while(program!=0);
	}
}



//Project 2: Inventory Management System  
//Objective: Implement an inventory system using various array and list operations. 
//Requirements: 
//1. Create a Product class with: 
//○ name (String) 
//○ category (String) 
//○ price (double) 
//○ stockQuantity (int) 
//○ Methods: 
//■ updateStock(int quantity): Increases/decreases stock. 
//■ getProductDetails(): Returns a formatted string. 


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
//○ Allow the user to search, filter, and modify the inventory dynamically. 