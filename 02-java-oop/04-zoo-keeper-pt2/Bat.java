public class Bat extends Mammal {
    protected int energyLevel = 300;
    protected String name;
    Bat(String name){
        this.name=name;
    }

    public void fly(){
        System.out.printf("%s started flying. Energy level decreases by 50", this.name);
        energyLevel -=50;
    }

    public void eatHumans(){
        System.out.printf("%s started eating humans. Energy level increases by 25", this.name);
        energyLevel +=25;
    }

    public void attackTown(){
        System.out.printf("%s started attacking towns. Energy level decreases  by 100", this.name);
        energyLevel -=100;
    }
}
