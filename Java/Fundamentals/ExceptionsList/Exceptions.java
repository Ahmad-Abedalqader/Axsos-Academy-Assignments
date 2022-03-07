import java.util.ArrayList;
public class Exceptions{
    public static void main(String[] args) {
        ArrayList < Object > myList =  new ArrayList<Object>();
        myList.add( "13" );
        myList.add( "Hello World" );
        myList.add( 48 );
        myList.add( "Goodbye World" );

        for( int i =  0 ; i < myList.size(); i ++ ) {
            try{
                int castedValue = ( int ) myList.get(i);
            }
            catch(Exception e){
                System.out.println("error: this element can not be casted to integer " + i + ": " + myList.get(i) );
            }
        }
    }
    
}