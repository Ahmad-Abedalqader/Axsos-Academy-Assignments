import java.util.ArrayList;
public class Order {
    String name;
    double total;
    boolean ready;
    ArrayList<Item> items = new ArrayList<Item>();
    public Order(String name){
        this.name = name;
    }
}
