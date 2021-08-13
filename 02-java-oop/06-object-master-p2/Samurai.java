public class Samurai extends  Human {
    protected int health = 200;
    Samurai(String name) {
        super(name);
    }
    public void deathBlow(Human person){
        System.out.printf("%s received a deadly blow from %s. Its health bar is empty. %s is now dead. However, %s's health is reduced by half.", person.name, this.name, person.name, this.name);
        person.health -= person.health;
    }

    public void meditate(){
        System.out.printf("Meditation helps return %s health by half",this.name);
        this.health += this.health/2;
    }

    public int howMany(){
        return 3;
    }
}
