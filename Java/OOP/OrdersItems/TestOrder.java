public class TestOrder {
    public static void main(String[] args) {
        // Menu items
        Item item1 = new Item("mocha", 2.5);
        Item item2 = new Item("latte", 3.0);
        Item item3 = new Item("drip coffee", 3.2);
        Item item4 = new Item("capuccino", 2.8);

        // Order variables -- order1, order2 etc.
        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");

        // Application Simulations
        //Add item1 to order2's item list and increment the order's total.
        order2.items.add(item1);
        order2.total += item1.price;
        //order3 ordered a cappucino. Add the cappuccino to their order list and to their tab.
        order3.items.add(item4);
        order3.total += item4.price;
        // order4 added a latte. Update accordingly
        order4.items.add(item2);
        order4.total += item2.price;
        // Cindhuri’s order is now ready. Update her status.
        order1.ready = true;
        // Sam ordered more drinks - 2 lattes. Update their order as well.
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += (2*item2.price);
        // Jimmy’s order is now ready. Update his status.
        order2.ready = true;

        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("is Order4 Ready: %s\n", order2.ready);
    }
}
