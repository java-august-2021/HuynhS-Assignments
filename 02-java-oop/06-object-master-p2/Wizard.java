public class Wizard extends Human{
    protected int health = 50;
    protected int intelligence = 8;

    public Wizard(String name) {
        super(name);

    }

    public void heal(Human person){
        System.out.printf("%s returns %d health to %s", this.name,this.strength, person.name);
        person.health =+ this.strength;
    }

    public void fireball(Human person){
        int total_damage = this.intelligence * 3;
        System.out.printf("%s inflicted %d fireball damage to %s", this.name, total_damage, person.name);
        person.health -= total_damage;
    }

}
