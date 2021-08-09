public class GorillaTest {
    public static void main(String[] args) {
        System.out.println("hello");
        Gorilla g = new Gorilla();
        // System.out.println(g.displayEnergy(3));
        System.out.println(g.throwSomething("Gorilla has thrown something. Energy level is now:", 5));
        System.out.println(g.throwSomething("Gorilla has thrown something. Energy level is now:", 5));
        System.out.println(g.throwSomething("Gorilla has thrown something. Energy level is now:", 5));

        System.out.println(g.eatBanana("Gorilla is satisfied.Energy level is now: ", 10));
        System.out.println(g.eatBanana("Gorilla is satisfied.Energy level is now: ", 10));

        System.out.println(g.climb("Gorilla has climbed. Energy level is now:", 10));
    }
}
