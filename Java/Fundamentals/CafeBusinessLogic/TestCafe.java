import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public  static  void main( String [] args){
        CafeUtil appTest = new CafeUtil();

        System .out.println( "\n----- Try Meta coffee -----" );
        System .out.printf( "Purchases needed for week 10: %s \n\n" , appTest.getStreakGoal(10));
    
        System.out.println("----- Order Total Test -----"); 
        double[] lineItems = {3.5, 1.5, 4.0, 4.5}; 
        System.out.printf("Order Total: %s \n\n",appTest.getOrderTotal(lineItems));
    
        ArrayList<String> menu = new ArrayList<String>(); 
        menu.add("drip coffee"); 
        menu.add("cappuccino"); 
        menu.add("latte"); 
        menu.add("mocha"); 
        appTest.displayMenu(menu);

        System.out.println("\n----- Try add client-----"); 
        ArrayList<String> customers = new ArrayList<String>(); 
        // --- Test 4 times --- 
        for (int i = 0; i < 4; i++) { 
        appTest.addCustomer(customers); 
        System.out.println("\n"); 
        }
    }
}
