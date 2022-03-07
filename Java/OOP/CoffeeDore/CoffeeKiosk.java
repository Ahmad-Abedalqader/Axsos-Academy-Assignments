import java.util.ArrayList;
public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;
    // Constructors;
    public CoffeeKiosk(){
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    // getters and setters:
    public ArrayList<Item> getMenu(){
        return menu;
    }
    public void setMenu(ArrayList<Item> menu){
        this.menu = menu;
    }
    public ArrayList<Order> getOrder(){
        return orders;
    }
    public void setOrder(ArrayList<Order> orders){
        this.orders = orders;
    }

    public void addMenuItem(String name, double price){
        Item item = new Item(name, price);
        menu.add(item);
        item.setIndex(menu.indexOf(item));
    }

    public void displayMenu(){
        for (Item item: menu){
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }
    public void newOrder(){
        displayMenu();
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        Order newOrder = new Order(name);
        orders.add(newOrder);
        
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        while(!itemNumber.equals("q")){
            newOrder.additem(menu.get(Integer.parseInt(itemNumber)));
            System.out.println("Please enter another menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        newOrder.display();
    }



}
