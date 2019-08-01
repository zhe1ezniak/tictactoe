public class Game {
    protected final static char COMPUTER = 'O';
    protected final static char HUMAN = 'X';
    protected final static char EMPTY = ' ';

    private char WINNER;
    private char[][] gameField;

    private static Game instance;

    private Game() {
        WINNER = 0;
        gameField = new char[][]{
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        };
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public char getWINNER() {
        return WINNER;
    }

    public void setWINNER(char WINNER) {
        this.WINNER = WINNER;
    }

    public char[][] getGameField() {
        return gameField;
    }

    public void setGameField(char[][] gameField) {
        this.gameField = gameField;
    }

    public boolean isCellFree(int number){
        if (number <= 3) {
            if (gameField[0][number-1] == EMPTY) return true;
        }
        else if (number <= 6) {
            if (gameField[1][number-4] == EMPTY) return true;
        }
        else {
            if (gameField[2][number-7] == EMPTY) return true;
        }
        return false;
    }

    public boolean isDraw(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (gameField[i][j] == EMPTY) return false;
            }
        }
        return true;
    }

    public void printGameTable() {
        System.out.println();
        System.out.println("------------------------");
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j ++){
                System.out.print(" " + gameField[i][j]);
                if (j != 2) System.out.print(" |");
            }
            System.out.println();
            if (i != 2){
                for (int j = 0; j < 3; j++){
                    System.out.print("---");
                    if (j != 2) System.out.print("-");
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("------------------------");

    }

    public void printGameTableWithNumbers(){
        System.out.println("------------------------");
        System.out.println("You should to pick one of this numbers for your choice");
        int number = 1;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j ++){
                System.out.print(" " + number);
                number++;
                if (j != 2) System.out.print(" |");
            }
            System.out.println();
            if (i != 2){
                for (int j = 0; j < 3; j++){
                    System.out.print("---");
                    if (j != 2) System.out.print("-");
                }
                System.out.println();
            }
        }
        System.out.println("------------------------");

    }

    public void showResultsGame() {
        printGameTable();
        if (WINNER == HUMAN) System.out.println("You win this game.");
        if (WINNER == COMPUTER) System.out.println("Computer win this game. Try again, looser.");
        if (isDraw()) System.out.println("It's draw. Next game?");
    }
}
