import java.util.Random;

public class ComputerMove {
    private Game game = Game.getInstance();

    protected boolean handleComputerChoice(){
        if (checkComputerChoiceOnRows(game.COMPUTER)) return true;
        else if (checkComputerChoiceOnColumns(game.COMPUTER)) return true;
        else if (checkComputerChoiceOnMainDiagonal(game.COMPUTER)) return true;
        else if (checkComputerChoiceOnNotMainDiagonal(game.COMPUTER)) return true;
        else if (checkComputerChoiceOnRows(game.HUMAN)) return true;
        else if (checkComputerChoiceOnColumns(game.HUMAN)) return true;
        else if (checkComputerChoiceOnMainDiagonal(game.HUMAN)) return true;
        else if (checkComputerChoiceOnNotMainDiagonal(game.HUMAN)) return true;
        else {
            Random random = new Random();
            while (true){
                int number = random.nextInt(8) + 1;
                if(game.isCellFree(number)) {
                    if (number <= 3) game.getGameField()[0][number - 1] = game.COMPUTER;
                    else if (number <= 6) game.getGameField()[1][number - 4] = game.COMPUTER;
                    else game.getGameField()[2][number - 7] = game.COMPUTER;
                    return true;
                }
            }
        }
    }



    private boolean checkComputerChoiceOnRows(char value) {
        int count = 0;
        boolean empty = false;
        int index = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.getGameField()[i][j] == value) count++;
                else if (game.getGameField()[i][j] == game.EMPTY) {
                    empty = true;
                    index = j;
                }
            }
            if (count == 2 && empty) {
                game.getGameField()[i][index] = game.COMPUTER;
                return true;
            } else {
                count = 0;
                empty = false;
            }
        }
        return false;
    }

    private boolean checkComputerChoiceOnColumns(int value){
        int count = 0;
        boolean empty = false;
        int index = -1;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.getGameField()[j][i] == value) count++;
                if (game.getGameField()[j][i] == game.EMPTY) {
                    empty = true;
                    index = j;
                }
            }
            if (count == 2 && empty) {
                game.getGameField()[index][i] = game.COMPUTER;
                return true;
            } else {
                count = 0;
                empty = false;
            }
        }
        return false;
    }

    private boolean checkComputerChoiceOnMainDiagonal(char value){
        if (game.getGameField()[0][0] == value) {
            if (game.getGameField()[1][1] == game.getGameField()[0][0] && game.getGameField()[2][2] == game.EMPTY){
                game.getGameField()[2][2] = game.COMPUTER;
                return true;
            } else if (game.getGameField()[0][0] == game.getGameField()[2][2] && game.getGameField()[1][1] == game.EMPTY){
                game.getGameField()[1][1] = game.COMPUTER;
                return true;
            }
        } else if (game.getGameField()[1][1] == value
                && game.getGameField()[1][1] == game.getGameField()[2][2]
                && game.getGameField()[0][0] == game.EMPTY){
            game.getGameField()[0][0] = game.COMPUTER;
            return true;
        }
        return false;
    }

    private boolean checkComputerChoiceOnNotMainDiagonal(char value){
        if (game.getGameField()[1][1] == value){
            if (game.getGameField()[1][1] == game.getGameField()[0][2] && game.getGameField()[2][0] == game.EMPTY){
                game.getGameField()[2][0] = game.COMPUTER;
                return true;
            } else if (game.getGameField()[1][1] == game.getGameField()[2][0] && game.getGameField()[0][2] == game.EMPTY) {
                game.getGameField()[0][2] = game.COMPUTER;
                return true;
            }
        } else if (game.getGameField()[0][2] == value
                && game.getGameField()[0][2] == game.getGameField()[2][0]
                && game.getGameField()[1][1] == game.EMPTY){
            game.getGameField()[1][1] = game.COMPUTER;
            return true;
        }
        return false;
    }
}
