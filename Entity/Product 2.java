package Entity;
    public class Product {
	    private String productCode;
	    private String productName;
	    private int productQuantity;
	    private int productPrice;
	    private int discount;
		
    
	public Product( String productCode , String productName , int productQuantity , int productPrice , int discount){ 
   
	setProductCode (productCode);
	setProductName (productName);
	setProductQuantity (productQuantity);
	setProductPrice (productPrice);
	setDiscount( discount);
	}
    public void setProductCode(String productCode)
	{
		this.productCode=productCode;
	}
	public String getProductCode()
	{
		return productCode;
	}
	public void setProductName (String productName)
	{
		this.productName=productName;
	}
	public String getProductName()
	{
		return productName;
	}
	public void setProductQuantity(int productQuantity)
	{
		this.productQuantity=productQuantity;
	}
	public int getProductQuantity()
	{
		return productQuantity;
	}
	public void setProductPrice(int productPrice)
	{
		this.productPrice=productPrice;
	}
	public int getProductPrice()
	{
		return productPrice;
	}
	public void setDiscount(int discount)
	{
		this.discount=discount;
	}
	public int getDiscount()
	{
		return discount;
	}
	public double DiscountPrice(){
		 return (productPrice - (productPrice *( (double)discount / 100)));
		 
	}
		
	public void showdetails()
	{
		System.out.println("............");
		System.out.println("Product Code:"+productCode);
		System.out.println("Product Name:"+productName);
		System.out.println("Product Quantity:"+productQuantity+" kg" );
		System.out.println ( "Product Price/kg = "+productPrice+" BDT");
		System.out.println("Discount ="+discount+"%");
		System.out.println("Discounted Price ="+DiscountPrice()+" BDT");
		System.out.println("............");
	}
	}
	