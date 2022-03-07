public  class  CafeJava {
    public  static  void main( String [] args) {
    String generalGreeting =  "Welcome to Cafe Java, " ;
    String pendingMessage =  ", your order will be ready shortly" ;
    String readyMessage =  ", your order is ready" ;
    String displayTotalMessage =  "Your total is $" ;
    
    // Menu variables (add yours below) 
    double mochaPrice =  3.5 ;
    double dripCoffeePrice = 3.1;
    double lattePrice = 4.0;
    double cappucinoPrice = 2.9;
    
    // Client name variables (add yours below) 
    String customer1 = "Cindhuri";
    String customer2 = "Sam";
    String customer3 = "Jimmy";
    String customer4 = "Noah";

    // Order completions (add yours below) 
    boolean isReadyOrder1 =  false ;
    boolean isReadyOrder2 =  true ;
    boolean isReadyOrder3 =  true ;
    boolean isReadyOrder4 =  true ;

    // SIMULATION OF APP INTERACTION(Add your code for the challenges below) 
    // Example: 
    System .out.println(generalGreeting + customer1); // Displays "Welcome to Café Java, Cindhuri" 
    // ** Print statements about customer interactions will go here ** //
    //1.
    System.out.println(customer1 + pendingMessage);
    //2.
    if (isReadyOrder4) {
        System.out.println(customer4 + readyMessage);
        System.out.println(displayTotalMessage + cappucinoPrice);
    }
    else {
        System.out.println(customer4 + pendingMessage);
    }
    //3.
    System.out.println(displayTotalMessage + lattePrice * 2);
    if (isReadyOrder2) {
        System.out.println(customer2 + readyMessage);
    }
    else {
        System.out.println(customer2 + pendingMessage);
    }
    //4.
    System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice));
    }
}