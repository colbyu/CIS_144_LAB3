package lab3b;

import java.util.*;

public class Invoices {
    public static void main(String args[]) {
    // the cast of charactors
    int invNum = 0;
    int numItems = 0;
    double itemPrice = 0.0, shipCharge = 0.0, totAmt = 0.0;
    double discount = 0.02, subTotal = 0.0;
    int carrier = 0; 
    String shipper = "";
    char shipMethod = '\0';
    String invDate = "";
    boolean check = false;
    Scanner sc = new Scanner(System.in);
    
    //obtain today's date
    Date date = new Date();
    
    // display time and date using toString()
    System.out.println(date.toString());
    
    // the program header
    System.out.println("[ Invoice Processing ]");
    System.out.println("----------------------\n");
    System.out.println("Today's Date is: " + date + "\n");
    // prompt user for data and receive data
    System.out.println("please enter the invoice number");
    invNum = sc.nextInt();
    System.out.println("the invoice number is: " + invNum);
    System.out.println("please enter the invoice date");
    invDate = sc.next();
    System.out.println("the invoice date is: " + invDate);
    System.out.println("please enter the number of items purchased");
    numItems = sc.nextInt();
    System.out.println("the number of items is: " + numItems);
    
    //determine the per item price
    if (numItems > 0 && numItems <= 10)
    itemPrice = 0.75;
    else if (numItems > 10 && numItems <= 50)
    itemPrice = 0.65;
    else
    itemPrice = 0.62;
    System.out.printf("the per item price is: $%.2f\n",itemPrice);
   ///////////////////////////////////////
   //determine the shipper
   ///////////////////////////////////////
    System.out.println("enter shipper (A for Fedex, B for UPS, C for DHL, or D for USPS )");
    carrier = sc.next().charAt(0);
    //Which company will deliver it?
    switch(carrier) {
        case 'A': case 'a': carrier = 1; break;
        case 'B': case 'b': carrier = 2; break;
        case 'C': case 'c': carrier = 3; break;
        case 'D': case 'd': carrier = 4; break;
        default:  carrier = 5;
        }
    //Check and correct erronious entry:
    do { 
         System.out.println("Invalid carrier choice!");
         System.out.println("enter shipper (A for Fedex, B for UPS, C for DHL, or D for USPS)");
         carrier = sc.next().charAt(0);
         switch(carrier) {
             case 'A': case 'a': carrier = 1; break;
             case 'B': case 'b': carrier = 2; break;
             case 'C': case 'c': carrier = 3; break;
             case 'D': case 'd': carrier = 4; break;
             default:  carrier = 5;
             }
         }while(carrier == 5);
    //Assign carrier a user friendly name
    if (carrier == 1){
        shipper = "Fedex";
    }else if (carrier == 2){
        shipper = "UPS";
    }else if (carrier == 3){
        shipper = "DHL";
    }else if (carrier == 4){
        shipper = "USPS";
    }else{
        shipper = "UPS";
    }
    ///////////////////////////////////////////
    //determine the shipping method
    //////////////////////////////////////////
    System.out.println("enter shipping method (A for expidiyed shipping ($5.00), B for one day shipping ($10.00), C for two day shipping ($7.20), or D for free standard ground shipping)");
    shipMethod = sc.next().charAt(0);
    //determine the shipping charge
    switch(shipMethod) {
        case 'A': case 'a': shipCharge = 5.00; break;
        case 'B': case 'b': shipCharge = 7.20; break;
        case 'C': case 'c': shipCharge = 10.00; break;
        case 'D': case 'd': shipCharge = 0.00; break;
        default:  shipCharge = 20.00;
        }
    //Check and correct erronious entry:
    do { 
         System.out.println("Invalid Shipping Choice");
         System.out.println("enter shipping method (A for Fedex $5.00 shipping, B for UPS $10.00 shipping, C for DHL $7.20 shippimg, or D for free USPS shipping)");
         shipMethod = sc.next().charAt(0);
         switch(shipMethod) {
             case 'A': case 'a': shipCharge = 5.00; break;
             case 'B': case 'b': shipCharge = 7.20; break;
             case 'C': case 'c': shipCharge = 10.00; break;
             case 'D': case 'd': shipCharge = 0.00; break;
             default:  shipCharge = 20.00;
             }
         }while(shipCharge == 20.00);
    System.out.printf("the shipping charge is: $%.2f\n" , shipCharge);
    System.out.println("and it will be shipped by " + shipper);
    
    //determine the days from invoice date to today's date
    System.out.println("is discount period valid? true or false");
    check = sc.hasNext();
    if (sc.hasNextBoolean()) {
    System.out.println("discount valid? " + check);
    check = true;
    }

    //determine and display the total invoice amount
    subTotal = numItems * itemPrice;
    if(check == true)
    totAmt = subTotal * (1 - discount) + shipCharge;
    else
    totAmt = subTotal + shipCharge;
    double savings = subTotal * discount;
    System.out.printf("(total invoice amount due) $%.2f\n",totAmt);
    System.out.printf("You saved $%.2f\n",savings );
    // the program footer
    System.out.println(" ");
    System.out.println("thank you!");
    System.out.println("---------------------");
    }
}


