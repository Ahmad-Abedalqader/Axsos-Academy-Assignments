public class PuzzleTest {
    public  static  void main( String [] args){
        PuzzleJava puzzle = new PuzzleJava();
        puzzle.getTenRolls();

        System.out.println(puzzle.getRandomLetter());

        System.out.println(puzzle.generatePassword());

        System.out.println(puzzle.getNewPasswordSet(5));
    }
}
