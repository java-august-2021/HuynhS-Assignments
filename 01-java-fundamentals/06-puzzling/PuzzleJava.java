import java.util.Random;
import java.util.ArrayList;
public class PuzzleJava {

    //getTenRolls
    public ArrayList<Integer> randomArray(ArrayList<Integer>  array){
        Random randMachine = new Random();
        for(int i = 1; i < 11; i++){
            array.add(randMachine.nextInt(20));
        };
        return array;
    };

    //alphabet
    public ArrayList<Character> alphabetArray(ArrayList<Character> letterArray){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < alphabet.length(); i++){
            letterArray.add((alphabet.charAt(i)));
        }
        return letterArray;
    }
    //randomLetter
    public char RandomLetter(String array){
        Random randomNumber = new Random();
        return array.charAt(randomNumber.nextInt(array.length()));
    }

    public ArrayList<String> generatePassword(ArrayList<String> stringArray,String array){
        Random randomNumber = new Random();
        for(int i = 0; i < 8; i++){
            stringArray.add(Character.toString(array.charAt(randomNumber.nextInt(array.length()))));
        }
        return stringArray;
    }

    //getNewPasswordSet
    public ArrayList<String> getNewPasswordSet(ArrayList<String> stringArray, String letterArray, int num){
        Random randomNumber = new Random();
        for(int i = 0; i < num; i++){
            stringArray.add(Character.toString(letterArray.charAt(randomNumber.nextInt(letterArray.length()))));
        }
        return stringArray;
    }



}