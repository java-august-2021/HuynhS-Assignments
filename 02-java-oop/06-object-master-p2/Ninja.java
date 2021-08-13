public class Ninja extends Human{
    protected int stealth = 10;
    public Ninja(String name){
        super(name);
    }

    public void steal(Human person){
        System.out.printf("%s uses steal on %s. %s health is drastically reduced while %s's is greatly increased.",this.name, person.name, person.name, this.name );
        person.health -= this.stealth;
        this.health +=  this.stealth;
    }

    public void runAway(){
        System.out.printf("%s got scared and ran away. Its reduced by 10 points.", this.name);
        this.health -= 10;
    }
}
