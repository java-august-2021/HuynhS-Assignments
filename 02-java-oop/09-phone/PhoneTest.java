public class PhoneTest {
    public static void main(String[] args) {
        IPhone p1 = new IPhone("iPhone 11 ProMax", 83,"T-Mobile", "blah blah blah");

        Galaxy g1 = new Galaxy("Galaxy Over 9999", 1, "Verizon", "Bazinga Bazinga Bazinga");

        p1.ring();
        p1.unlock();
        p1.displayInfo();

        g1.ring();
        g1.unlock();
        g1.displayInfo();

    }
}
