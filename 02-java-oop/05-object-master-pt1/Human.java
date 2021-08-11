public class Human {
    protected int strength = 3;
    protected int stealth = 3;
    protected int intelligence = 3;
    protected int health = 100;
    protected String name;
    Human(String name){
        this.name = name;
    }
    public void attack(Human name){
        System.out.printf("Inflicted %d damage to %s",this.strength, this.name);
        health -= strength;
    }
}
