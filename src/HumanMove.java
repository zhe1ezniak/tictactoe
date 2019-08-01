import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanMove {
    protected static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Game game = Game.getInstance();
    private CheckWinner checkWinner = new CheckWinner();

    protected int readHumanChoice() {
        int choice = -1;
        try{
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Something wrong. Try again, bro");
        }
        return choice;
    }

    protected boolean handleHumanChoice(int number) {
        if(game.isCellFree(number)) {
            if (number <= 3) game.getGameField()[0][number - 1] = game.HUMAN;
            else if (number <= 6) game.getGameField()[1][number - 4] = game.HUMAN;
            else game.getGameField()[2][number - 7] = game.HUMAN;
        }
        if (checkWinner.check() != 0) return false;
        if (game.isDraw()) return false;
        return true;
    }

    public void closer (){
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Exception of closing reader");
        }
    }
}
