import java.util.Date;

import org.w3c.dom.TypeInfo;

public class AlfredQuotes {

    public String guestGreeting(String name, String dayPeriod) {
        String greeting = String.format("Good %s %s, Lovely to see you.", dayPeriod, name);
        return greeting;
    };

    public String dateAnnouncement(){
        Date date = new Date();
        return "Current date is : " + date;

    };
    public String respondBeforeAlexis(String conversation){
        Boolean testAlexis = conversation.contains("Alexis");
        Boolean testAlfred = conversation.contains("Alfred");
        if(testAlexis){
            return conversation;
        }else if(testAlfred){
            return conversation;
        }else {
            return conversation;
        }
        // return Boolean.toString(testAlexis);
    };
    //Ninja Bonus

    public String lengthOfSomething(String length){
        int stringLength = length.length();
        return "String Length is: " + stringLength;
    }


    public String todaysWeather(String weather, int degree){
        String weatherOfToday = String.format("Todays %s is %d degrees", weather, degree);
        return  weatherOfToday;
    }
    public Integer multiply(Integer num, Integer numTwo){
        return num * numTwo;
    }

    public String inDexOf(String message){
        int lengthOf = message.indexOf("howday");
        return Integer.toString(lengthOf);
    }

    public Boolean statusCheck(Boolean message){
        if(message){
            return true;
        }else{
            return false;
        }
    }
};

