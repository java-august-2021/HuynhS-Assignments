
import java.util.ArrayList;
public class TestBasicJava {
    public static void main(String[] args) {
        BasicJava javaBasic = new BasicJava();

        //Print 1-255
        for(int i = 0; i < 256; i++){
            System.out.print(javaBasic.PrintAllNumbers(i));
        };

        //Print odd numbers between 1-255
        for(int i = 1; i <= 255; i++){
            if(i % 3 == 0){
            System.out.println(javaBasic.OddNumbers(i));
            }
        };

        //Sigma of 255 AKA Sum to 255
            System.out.println(javaBasic.SumOf255(256));

        //Iterating through an array
        ArrayList<Integer> ArrayIteration = new ArrayList<Integer>();
        ArrayIteration.add(1);
        ArrayIteration.add(3);
        ArrayIteration.add(5);
        ArrayIteration.add(7);
        ArrayIteration.add(9);
        ArrayIteration.add(13);
        System.out.println(ArrayIteration);
        for(int i = 0; i < ArrayIteration.size(); i++){
            System.out.println(ArrayIteration.get(i));
        }

        //Find Max
        ArrayList<Integer> FindMaxArray = new ArrayList<Integer>();
        FindMaxArray.add(-10);
        FindMaxArray.add(-1);
        FindMaxArray.add(0);
        FindMaxArray.add(-20);
        FindMaxArray.add(-10);
        FindMaxArray.add(5);
        FindMaxArray.add(100);
        FindMaxArray.add(3);
        System.out.println(FindMaxArray);
        int max = FindMaxArray.get(0);
        System.out.println(max);
        for(int i = 0; i < FindMaxArray.size(); i++){
            if(FindMaxArray.get(i) > max){
                max = FindMaxArray.get(i);
                System.out.println(max);
            }

        };
        //Array with Odd Numbers
        ArrayList<Integer> OddArray = new ArrayList<Integer>();

        for(int i = 1; i < 255; i=i+2){
            OddArray.add(i);
        }
        System.out.println(OddArray);
    };
}
