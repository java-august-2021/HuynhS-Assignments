public class AlfredTest {
    public static void main(String[] args) {
    AlfredQuotes alfredBot = new AlfredQuotes();
    String testGuestGreeting = alfredBot.guestGreeting("Beth Kane", "evening");
    System.out.println(testGuestGreeting);

    String testDateAnnouncement = alfredBot.dateAnnouncement();
    System.out.println(testDateAnnouncement);

    String alexisTest = alfredBot.respondBeforeAlexis("Alexis, dinner is not ready. We'll need to eat out at a nearby restaurant.");
    System.out.println(alexisTest);

    String alfredTest = alfredBot.respondBeforeAlexis("That's awesome Alfred!, all these look amazing.");
    System.out.println(alfredTest);

    String noneRespondedTest = alfredBot.respondBeforeAlexis("No one is around to respond to your greeting. Move on");
    System.out.println(noneRespondedTest);


        //Ninja Bonus
        String testLength = alfredBot.lengthOfSomething("Ninja Bonus at CodingDojo BootCamp");
        System.out.println(testLength);

        String testWeather = alfredBot.todaysWeather("weather", 77);
        System.out.println(testWeather);

        Integer total = alfredBot.multiply(29, 70);
        System.out.println(total);

        String length = alfredBot.inDexOf("howday Jessica!");
        System.out.println(length);

        Boolean testBoolean = alfredBot.statusCheck(false);
        System.out.println(testBoolean);

    }



}
