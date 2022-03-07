import java.util.Date;
public class AlfredQuotes {
    public String basicGreeting() {
        // No necesitas codificar aquí, este es un método de ejemplo
        return "Hello, nice to see you. How are you?";
    }

    public  String guestGreeting( String name) {
        // YOUR CODE HERE 
        return  "Hello, "+ name + " Lovely to see you";
    }

    public  String dateAnnouncement() {
        // YOUR CODE HERE 
        Date date = new Date();
        return "it's currently, " + date;
    }

    public  String answeringBeforeAlexis( String conversation) {
        // YOUR CODE HERE 
        int a = conversation.indexOf( "Alexis" );
        int b = conversation.indexOf( "Alfred" );
        if (a >= 0){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        if (b >= 0){
            return "At your service. As you wish, naturally.";
        }
        else{
            return "Right. And with that I shall retire.";
        }
    }
}
