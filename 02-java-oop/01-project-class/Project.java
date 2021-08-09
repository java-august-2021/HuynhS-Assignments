    //class declaration
public class Project {
    //attributes
    private String name;
    private String description;
    private double initialCost=3.2;
    //constructor
    public Project(){
        this.name = "yo!";
    };
    public Project(String name){
        this.name = name;
    };

    public Project(String name, String description, double initialCost){
        this.name = name;
        this.description = description;
        this.initialCost = initialCost;
    }

    public String elevatorPitch(){
        return String.format("%s (%02f) %s", name, initialCost, description);
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public double getInitialCost(){
        return this.initialCost;
    }




    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setInitialCost(double num){
        this.initialCost = initialCost;
    }

}