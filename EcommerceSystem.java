import java.util.Scanner;
public class EcommerceSystem {
public static void main(String[]args){
    Scanner input =new Scanner(System.in);

    ElectronicProduct e1= new ElectronicProduct(1,"smart phone",599.9f,"Samsung",1);
    ClothingProduct c1=new ClothingProduct(2,"T-Shirt",19.99f,"Medium","Cotton");
    BookProduct b1=new BookProduct(3,"OOP",39.99f,"O'Reilly","X Publciations");
    System.out.println("Welcome to E-Commerce System!");
    System.out.println("How many Products you want to add to your cart?");
    int numProducts= input.nextInt();
    System.out.println("Please enter Your Name");
    String Name = input.next();
    input.nextLine();
    System.out.println("Please enter you address");
    String address = input.next();
    input.nextLine();
    System.out.println("Please enter Your ID");
    int id= input.nextInt();
    Customer Saif=new Customer(id,Name,address);
    Product[] MyProducts=new Product[numProducts];
    Cart Saif_cart=new Cart(id,numProducts,MyProducts);
    Order Saif_order=new Order(Saif_cart.calculatePrice(), 1,numProducts,id,MyProducts);
for(int i=0;i<numProducts;i++){
    System.out.print("Which Product would you like to add? ");
    System.out.println("1- SmartPhone 2-T-shirt 3- OOP");
int choice=input.nextInt();
        if (choice==1) {
            MyProducts[i] =e1;

        }
        else if(choice==2){
            MyProducts[i]=c1;

        }
        else if(choice==3){
            MyProducts[i]=b1;

        }

}
    System.out.println("Total price is: "+Saif_order.getTotalPrice());


System.out.print("Do You want to place order? ");
System.out.println("1-Yes 2-No");
int w = input.nextInt();
if(w==1){
    System.out.println("Here is Your Order Summary");
    Saif_order.printOrderInfo();


}
else if(w==2){
    System.out.println("Thanks For Visiting our shop");

}
}
}