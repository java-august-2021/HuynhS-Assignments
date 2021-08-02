import java.util.Date;

public class AlfredQuotes {

    public String guestGreeting(String name, String dayPeriod) {
        String greeting = String.format("Good %s %s, Lovely to see you.", dayPeriod, name);
        return greeting;
    }

    public String dateAnnouncement(){
        Date date = new Date();
        return "Current date is : " + date;


    }
    // public String respondBeforeAlexis(String conversation) {

    //     return "place holder for snarky response return string";
    // }

}

