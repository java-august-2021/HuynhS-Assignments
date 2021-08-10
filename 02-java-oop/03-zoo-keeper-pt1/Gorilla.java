public class Gorilla extends Mammal {

    Gorilla(){};

    public void throwSomething(){
        System.out.println("Gorilla throw something. Energy level decreases  by 5.");
        energyLevel -= 5;
    }
    public void eatBanana(){
        System.out.println("Gorilla eats banana. Energy gains by 5.");
        energyLevel +=5;
    }
    public void climb(){
        System.out.print("Gorilla has climbed. Energy reduces by 10.");
        energyLevel -=10;
    }
}
