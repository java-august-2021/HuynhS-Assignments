    //class declaration
public class Project { 
    //attributes
    private String name;
    private String description;
    private double initialCost;

    public Project(){
        this.name = "yo!";
    };
    public Project(String name){
        this.name = name;
    };

    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    public elevatorPitch(String name, String description){
        return name (cost) + ": " + description;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public double getInitialCost(){
        return this.initalCost;
    }

    public double setInitialCost(double number){
        this.initalCost = initialCost;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

}