package pizzaorder;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
public class PizzaOrder{

    /**
     *
     * @param args
     */
    
    /*
    MY CODE
    */
    public static void main (String[] args)
    {        
        try
            {
            Scanner keyboard = new Scanner (System.in);

            String firstName;
            boolean discount = false;               //flag for discount
            int inches;                                         //size of the pizza
            char crustType;                                //for type of crust
            String crust = "Hand-tossed";        //default crust option
            double cost = 12.99;                       //cost default of the pizza
            final double TAX_RATE = 0.08;      //8% tax rate constant
            double tax;                                        //tax amount
            char choice;                                       //user's choice
            String input;                                      //user input
            String toppings = "Cheese % n ";            //list of topping
            int numberOfToppings = 0;             //number of topping

            //prompt user and get first name
            System.out.println("Welcome to Mike and "
                    + "Diane's Pizza");
            System.out.print("Enter your first name: ");
            firstName = keyboard.nextLine();


            //Determine if the user is eligible for discount by 
            //having the same first name as the owners.
            //ADD LINES HERE FOR TASK #1

            if(firstName.equalsIgnoreCase("Mike")   ||
                    firstName.equalsIgnoreCase("Diane"))
            {
                discount = true;
            }

            //Prompt user and get pizza size choice.
            System.out.println("Pizza Size (inches)  Cost");
            System.out.println("            10                   $10.99");
            System.out.println("            12                   $12.99");
            System.out.println("            14                   $14.99");
            System.out.println("            16                   $16.99");
            System.out.println("What size pizza " +
                                                   " would you like?");
            System.out.println("10, 12, 14, or 16");
            inches = keyboard.nextInt();

            //Set price and size of pizza ordered.
            //ADD LINES HERE FOR TASK #2

            if(inches == 10){
                System.out.println("You choose 10 inches pizza,"
                        + " your initial cost is $10.99");
                cost = 10.99;
            }

            else if(inches == 12){
                System.out.println("You choose 12 inches pizza, "
                        + " your initial cost is $12.99");
                cost = 12.99;
            }

            else if(inches == 14){
                System.out.println("You choose 14 inches pizza, "
                        + " your initial cost will be $14.99 ");
                cost = 14.99;
            }

            else if(inches == 16){
                System.out.println("You choose 16 inches pizza, "
                        + " your initial cost will be $16.99");
                cost = 16.99;
            }

            else{
                System.out.println("That was not the choice, you will get a "
                        + "12 inches pizza as a default.");
                inches = 12;
                cost = 12.99;
            }

            //continue the remaining newline character
            keyboard.nextLine();
            
            //Prompt the user to get crust choice.
            System.out.println("What type of crust "
                    + "would you like?");
            System.out.println("(H)   Hand-tossed,"
                                           + "(T)  Thin-crust,"
                    + "(D)  Deep-dish   "
                    + "(enter H,    T, or    D");
            input = keyboard.nextLine();
            crustType = input.charAt(0);

            //Set user's crust choice on pizza ordered.
            //ADD LINE FOR TASK #3
            switch(Character.toLowerCase(input.charAt(0)))
            {
                case 'h':
                case 'H':
                    crust = "Hand-Tossed";
                    break;
                    
                case 'T':
                case't':
                    crust = "Thin-crust";
                    break;
                    
                case'D':
                case'd':
                    crust = "Deep-dish";
                    break;
                default:
                    System.out.println("That was no one of the choices, " + 
                            " you will get a Hand-Tossed 12 inch pizza.");
                    crust = "Hand-tossed";
            }
                                                
           //prompt user and get topping cjoices one at a time.         
            System.out.println("All pizzas come with cheese.");
            System.out.println("Additional toppings are "
                                                    + "$1.25 each, choose from: ");
            System.out.println("Pepperoni, Sausage, "
                                                    + "Onion, Mushroom");
            
            //If topping is desired,
            //add to topping list and number of toppings
            System.out.print("Do you want Pepperoni? (Y/N):  ");
            input = keyboard.nextLine();
            choice = input.charAt(0);
            if (choice == 'y' || choice  ==  'Y'){
                numberOfToppings  +=  1;
                toppings = toppings + "Pepperoni %n ";
            }
            
            System.out.print("Do you want Sausage?  (Y/N):  ");
            input = keyboard.nextLine();
            choice = input.charAt(0);
            if(choice == 'Y'  ||  choice == 'y' ){
                numberOfToppings +=1;
                toppings = toppings + "Sausage %n ";
            }
            
            System.out.print("Do you want Onion?  (Y/N):  ");
            input = keyboard.nextLine();
            choice = input.charAt(0);
            if(choice == 'Y' || choice == 'y')
            {
                numberOfToppings += 1;
                toppings += "Mushroom %n ";
            }
            
            //ADD additional toppin cost to cost of pizza
            cost = cost + (1.25 * numberOfToppings);
            
            //Displaying the order confirmation
            System.out.println();
            System.out.println("Your order is as follows: ");
            System.out.println(inches + " inch pizza");
            System.out.println(crust + "  crust");
            System.out.println(toppings);
            
            //apply discount if the user is eligible
            //apply lines for task #4
            if(discount)
            {
                if(firstName.equalsIgnoreCase("Mike")){
                    cost -= 2;
                    System.out.println("Heyy Mikey, here is a $2 discount for you budd.");
                }
                {
                    if(firstName.equalsIgnoreCase("Diane")){
                        cost -= 2;
                        System.out.println("Heyy homegirl, here's $2 discount just for you lady.");
                    }
                }
            }
           
            //EDIT PROGRAM FOR TASK #5
            //SO all the money output appears with 2 decimal places
            System.out.printf("The cost of your order" +
                      " is:   $%.2f\n", cost);
            
            //Calculate and display the tax and total cost
            tax = cost * TAX_RATE;
            System.out.printf("The tax is: $%.2f\n", tax);
            System.out.printf("The total due is: $%.2f\n", (tax + cost));
                                                
            System.out.println("Your order will be ready  " +
                                                " for pickup in 30 minutes.");        
            
                            
             
                
            }
         catch(Exception e)
        {
            System.out.println("Try entering a valid numerical value.");
        }
 
    }
}
          
     