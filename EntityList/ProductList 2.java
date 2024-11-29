package EntityList;
import Entity.Product;
public class ProductList{
	private Product products[];
	
	public ProductList(int size){
		products = new Product[size];
	}
	public void insert(Product p){
		boolean flag = false;
		for(int i=0;i<products.length;i++){
			if(products[i]==null){
				products[i] =p;
				flag = true;
				break;
			}
		}
		
		if(flag){
			System.out.println("Successfully Inserted.");
		}
		else{
			System.out.println("Insertion Failed.");
		}
	}
	public Product getByCode(String productCode){
		boolean flag = false;
		Product p = null;
		for(int i=0;i<products.length;i++){
			if(products[i]!=null){
				if(products[i].getProductCode().equals(productCode)){
					p = products[i];
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Product found.");
		}
		else{
			System.out.println("Product not found.");
		}
		return p;
	}
	
	public void removeByCode(String productCode){
		boolean flag = false;
		for(int i=0;i<products.length;i++){
			if(products[i]!=null){
				if( products[i].getProductCode().equals(productCode)){
					products[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Product Removed.");
		}
		else{
			System.out.println("Product not found.");
		}
	}
	
	public void showAll(){
		for(int i=0;i<products.length;i++){
			if(products[i]!=null){
				System.out.println("-------------");
				products[i].showdetails();
				System.out.println("-------------");
			}
		}
	}
		public String getAllProductAsString(){
		String allProduct="";
		for(int i=0;i<products.length;i++){
			if(products[i]!=null){
				allProduct += "-------------"+"\n"+
							products[i].toString()+"\n"+
							"-------------"+"\n";
			}
		}
		return allProduct;
		}
}

