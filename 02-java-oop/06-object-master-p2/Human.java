public class Human {
    protected int strength = 3;
    protected int stealth = 3;
    protected int intelligence = 3;
    protected int health = 100;
    protected String name;
    public Human(String name){
        this.name = name;
    }
    public void attack(Human person){
        System.out.printf("%s inflicted %d damage to %s.",this.name, this.strength, person.name);
        person.health -= this.strength;
    }
}
