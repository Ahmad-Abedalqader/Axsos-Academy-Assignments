import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava{

    public void getTenRolls(){
        Random rand = new Random();
        ArrayList<Integer> randomNum = new ArrayList<Integer>();
        for (int i=0; i<10; i++){
            randomNum.add(rand.nextInt((20 - 1) + 1) + 1);
        }
        System.out.println(randomNum);
    }

    public char getRandomLetter(){
        ArrayList<Character> randomLetter = new ArrayList<Character>();
        Random rand = new Random();
        int randomIndex = rand.nextInt(26);
        for(char alphabet = 'a'; alphabet <='z'; alphabet++ ){
            randomLetter.add(alphabet);
        }
        return randomLetter.get(randomIndex);
    }
    public String generatePassword(){
        String password = new String();
        for (int i=0; i<8; i++){
            password += getRandomLetter();
        }
        return password;
    }
    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> passwords = new ArrayList<String>();
        for (int i=0; i<length; i++){
            passwords.add(generatePassword());
        }
        return passwords;
    }
}