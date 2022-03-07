import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil{
    public int getStreakGoal(int numweeks){
        int sum = 0;
        for (int i = 1; i <= numweeks; i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double total = 0;
        for(double price:prices){
            total+=price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for (int i=0; i < menuItems.size(); i++){
            System.out.println(i + " " + menuItems.get(i));
        }
    }
    public void addCustomer(ArrayList<String> customers){
        System.out.println("Enter your name, please");
        String userName =  System.console().readLine();
        System.out.println("Hello " + userName);
        System.out.println("There are " + customers.size() + " people ahead of you.");
        customers.add(userName);
        System.out.println(customers);
    }
}