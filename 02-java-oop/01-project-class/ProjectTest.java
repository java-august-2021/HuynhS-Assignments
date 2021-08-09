import javax.xml.namespace.QName;

public class ProjectTest {
    public static void main(String[] args) {
        //Object instantiation
        Project projectOne  = new Project();

        System.out.println(projectOne.getName());
        projectOne.setName("yo yo!@");
        System.out.println(projectOne.getName());

        Project project = new Project("Project two YO!");
        System.out.println(projectTwo.getName());
        projectTwo.setName("Setting a name for Yo project TWO@");
        System.out.println(projectTwo.getName());

        Project projectThree = new Project("Project three in your face", "Yep my beautiful face");
        System.out.println(projectThree.getName());
        projectThree.setName("In my face's project is done!");
        System.out.println(projectThree.getDescription());
        System.out.println(projectThree.getName());
        projectThree.setDescription("Cool cool!");
        System.out.println(projectThree.getDescription());
        System.out.println(projectThree.getInitialCost());
        System.out.println(projectThree.elevatorPitch());
        // System.out.println(projectThree.setInitialCost());
        System.out.println(projectThree.elevatorPitch());
        projectTwo.setDescription("blah");
        System.out.println(projectTwo.getDescription());
        projectOne.setInitialCost(10003.3);
        System.out.println(projectOne.setInitialCost());
}
