import Entity.Product;
import EntityList.ProductList;
import GUI.*;
public class Start{
	public static void main (String args[]){
		ProductList productlist = new ProductList(6);
		productlist.insert( new Product("1", "Burger Buns", 100,75,20));
		productlist.insert( new Product("2", "Hotdog Buns", 90,60,12));
		productlist.insert( new Product("3", "Sausage", 50,120,10));
		productlist.insert( new Product("4", "Ground Beef ", 60,150,5));
        productlist.showAll();
		
		productlist.getByCode("2").setProductQuantity(70);
		productlist.removeByCode("1");
		productlist.showAll();
		
		ProductInventoryPage pip= new ProductInventoryPage();
	}
}