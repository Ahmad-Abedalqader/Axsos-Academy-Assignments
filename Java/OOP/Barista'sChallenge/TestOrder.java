public class TestOrder {
    public static void main(String[] args) {
        Item item1 = new Item("mocha", 2.5);
        Item item2 = new Item("latte", 3.2);
        Item item3 = new Item("drip coffee", 2.0);
        Item item4 = new Item("cappuccino", 3.5);
        Item item5 = new Item("Esspresso", 2.8);

        Order order1 = new Order();
        order1.additem(item1);
        order1.additem(item2);
        Order order2 = new Order();
        order2.additem(item2);
        order2.additem(item4);

        Order order3 = new Order("Ahmad");
        order3.additem(item2);
        order3.additem(item5);
        Order order4 = new Order("Sanad");
        order4.additem(item3);
        order4.additem(item1);
        Order order5 = new Order("Maher");
        order5.additem(item1);
        order5.additem(item4);

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        order2.setToReady(true);
        System.out.println(order2.getStatusMessage());
        System.out.println(order1.getStatusMessage());
    }
}
