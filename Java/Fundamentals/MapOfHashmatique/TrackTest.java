import java.util.HashMap;

public class TrackTest {
    public  static  void main( String [] args){
        TrackList hashMap = new TrackList();
        HashMap<String, String> tracklist = hashMap.getTrackList();
        System.out.println(tracklist.get("Infinity"));

        for( String key : tracklist.keySet()) {
            System .out.println(key + ": " + tracklist.get(key));
        }
    }
}
