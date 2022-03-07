public class TestOrder {
    public static void main(String[] args) {
        CoffeeKiosk kiosek = new CoffeeKiosk();
        kiosek.addMenuItem("drip coffee", 1.5);
        kiosek.addMenuItem("banana", 2.2);
        kiosek.addMenuItem("muffin", 3.1);
        kiosek.addMenuItem("capuccino", 2.5);
        kiosek.addMenuItem("latte", 4.5);

        kiosek.newOrder();
    }
}
