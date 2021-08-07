import java.util.Random;
import java.util.ArrayList;
public class TestPuzzleJava { 
    public static void main(String[] args) {
        PuzzleJava puzzleJava = new PuzzleJava();
        //getTenRolls
        ArrayList<Integer> getTenRolls = new ArrayList<Integer>();
        System.out.println(puzzleJava.randomArray(getTenRolls));

        //letterArray
        ArrayList<Character> alphabets = new ArrayList<Character>();
        System.out.println(puzzleJava.alphabetArray(alphabets));

        //randomLetter
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(puzzleJava.RandomLetter(alphabet));

        //generatePassword
        ArrayList<String> stringPassword = new ArrayList<String>();

        System.out.println(puzzleJava.generatePassword(stringPassword, alphabet));


        //getNewPasswordSet

        ArrayList<String> passwordSetArray = new ArrayList<String>();
        System.out.println(puzzleJava.getNewPasswordSet(passwordSetArray, alphabet, 8));

    }
}
