public class AlfredTest {
    public static void main(String[] args) {
    AlfredQuotes alfredBot = new AlfredQuotes();
    String testGuestGreeting = alfredBot.guestGreeting("Beth Kane", "evening");
    System.out.println(testGuestGreeting);

    String testDateAnnouncement = alfredBot.dateAnnouncement();
    System.out.println(testDateAnnouncement);


    }
}
