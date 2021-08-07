import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String,String> trackList = new HashMap<String,String>();
        trackList.put("The Reason","I'm not a perfect person");
        trackList.put("You are the reason", "There goes my heart beating");
        trackList.put("Hello", "There's such a difference between us");
        trackList.put("Someone Like you", "I heard that your dreams came true");

        System.out.println(trackList.get("The Reason"));

        Set<String> trackTitles = trackList.keySet();
        for(String title : trackTitles){
            // System.out.println(title);
            System.out.println(title + ":" + trackList.get(title));
        }

    }
}
