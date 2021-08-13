public class HumanTest {
    public static void main(String[] args) {
        Human h = new Human("Orginal Human");
        Human h1 = new Human("Generic Modified Human");
        h.attack(h1);
        System.out.println("------------------");
        Wizard w = new Wizard("Merlin");
        System.out.println(w.health);
        w.heal(h1);
        System.out.println("------------------");
        w.fireball(h);
        System.out.println("------------------");
        System.out.println(h.health);
        System.out.println("------------------");
        Ninja n = new Ninja("Kungfu Panda");
        n.steal(h);
        System.out.println("------------------");
        System.out.println(h.health);
        System.out.println("------------------");
        n.runAway();
        System.out.println("------------------");
        System.out.println(n.health);
        System.out.println("------------------");
        Samurai s = new Samurai("King Arthur");
        System.out.println("------------------");
        s.deathBlow(h);
        System.out.println(w.health);
        s.meditate();
        s.howMany();
    }
}
