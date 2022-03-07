import java.util.ArrayList;
public class Order {
    private String name;
    public double total;
    private boolean ready;
    private ArrayList<Item> items;
    // Constructors:
    public Order(){
        name = "Guest";
        items = new ArrayList<Item>();
    }
    public Order(String name){
        this.name = name;
        items = new ArrayList<Item>();
    }

    // Setters and Getters:
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getTotal(){
        return total;
    }
    public void incrementTotal(double price){
        total += price;
    }

    public boolean isReady(){
        return ready;
    }
    public void setToReady(boolean ready){
        this.ready = ready;
    }

    public ArrayList<Item> getItems(){
        return items;
    } 
    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    // Class Methods:
    public void additem(Item item) {
        items.add(item);
        total += item.getPrice();
    }
    public String getStatusMessage(){
        if (this.ready){
            return "Your order is ready";
        }
        else{
            return "Thank you for waiting, your order will be ready soon";
        }
    }
    public void display(){
        System.out.println("Customer Name: " + name);
        for (Item item: items){
            System.out.println(item.getName()+ " - $" + item.getPrice());
        }
        System.out.println("Total: $" + total);
    }
    public double getOrderTotal(){
        return total;
    }



}
