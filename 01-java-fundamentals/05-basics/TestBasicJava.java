
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
        // System.out.println(javaBasic.ArrayIterating(ArrayIteration));

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


        //Get Average
        ArrayList<Integer> GetAverage = new ArrayList<Integer>();

        for(int i = 0; i <= 7; i++){
            GetAverage.add(i);
        }
        System.out.println(GetAverage);
        System.out.println(javaBasic.Average(GetAverage));


        //Greater Than Y
        int[] GreaterThanY = {1,3,5,7,};
        System.out.println(javaBasic.GreaterThan(GreaterThanY,3));

        //Eliminate Negative Numbers
        ArrayList<Integer> NegativeNumbers = new ArrayList<Integer>();
        NegativeNumbers.add(1);
        NegativeNumbers.add(5);
        NegativeNumbers.add(10);
        NegativeNumbers.add(-2);
        NegativeNumbers.add(-10);
        NegativeNumbers.add(-10);
        NegativeNumbers.add(-10);

        System.out.println(javaBasic.EliminateNegativeNumbers(NegativeNumbers));

        //Square the values
        int[] Square = {1,5,10,-2,};
        System.out.println(javaBasic.SquareTheValues(Square));
    };

}
