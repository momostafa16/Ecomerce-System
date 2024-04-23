
import java.util.Arrays;
import java.util.Scanner;
public class Cart {
    private float totalPrice=0f;
    private int customerId;

    private int nProducts;
    private Product[] originalproducts=new Product[nProducts];
    private Product[] newProducts;
    private Product[] Products;

    public Product[] getProducts() {
        return Products;
    }
    public void setProducts(Product[] Products) {
        Products = Products;
    }

    boolean changeArray=false;
    public Cart() {
    }

    public Cart(int customerId, int nProducts, Product[] products) {
        this.customerId = Math.abs(customerId);
        this.nProducts = nProducts;
    }
    public Cart(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    public int getnProducts() {
        return nProducts;
    }

    public void setnProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
    }

    public Product[] removeProduct(){
        int newSize=nProducts-1;
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the position of the object you want to remove");
        int index=input.nextInt();
    newProducts=new Product[newSize];
 //here i will copy the array from its start to the product i want to remove
 System.arraycopy(originalproducts,0,newProducts,0,index);
 // here i will copy the array from the product i want to remove till the end of the array
 System.arraycopy(originalproducts,index+1,newProducts,index,newSize-index);
        changeArray=true;
return newProducts;
    }
    public Product[] addProduct(Product product){
        changeArray=true;
        int newSize=nProducts+1;
        newProducts=new Product[newSize];
        System.arraycopy(originalproducts,0,newProducts,0,nProducts-1);
        newProducts[newSize-1]=product;
        return newProducts;
    }
    public float calculatePrice(){
        if(changeArray==true){
            Products=new Product[newProducts.length];
            System.arraycopy(newProducts,0,Products,0,newProducts.length);
        } else if (changeArray==false){
            Products=new Product[originalproducts.length];
            System.arraycopy(originalproducts,0,Products,0,originalproducts.length);
        }
        for(Product product:Products){
            totalPrice+=product.getPrice();
        }
return totalPrice;
    }
    public Product[] placeOrder(Product[] FinalProducts){
        if(changeArray==true){
            Products=new Product[newProducts.length];
            System.arraycopy(newProducts,0,FinalProducts,0,newProducts.length);
            return Products;
        } else{
            Products=new Product[originalproducts.length];
            System.arraycopy(originalproducts,0,FinalProducts,0,originalproducts.length);
        return Products;
        }
    }

}