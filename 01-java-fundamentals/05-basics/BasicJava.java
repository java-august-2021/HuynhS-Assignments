import java.util.ArrayList;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.UnaryOp.Sqrt;
public class BasicJava {
        //Print 1-255
    public int PrintAllNumbers(int number){
        return number;
    };
        //Print odd numbers between 1-255
    public int OddNumbers(int number){
        return number;
    }

    //Sigma of 255 AKA Sum to 255
    public int SumOf255(int number){
        int sum = 0;
        for(int i = 1; i < number; i++){
            sum+=i;
        }
        return sum;
    }

    //Iterating through an array
    public int Average(ArrayList<Integer> array){
        int sum = 0;
        for(int i=0; i< array.size(); i++){
            sum+=i;
        }
        return sum/array.size();
    }
    public int GreaterThan(int[] array, int num){
        int greater = 0;
        for(int i = 0; i < array.length;i++){
            if(array[i] > num){
                greater+=1;
            }
        }
        return greater;
    }
    //Eliminate Negative Numbers
    public ArrayList<Integer> EliminateNegativeNumbers(ArrayList<Integer> array){
        for(int i = 0; i < array.size(); i++){
            if(array.get(i) < 0){
                array.remove(i);
                array.add(0);
            }
        }
        return array;
    }
    //Square the values
    public int[] SquareTheValues(int[] array){
        for(int i = 0; i < array.length; i++){
        }
        return array;
    }


}
