public class CheckWinner {
    private Game game = Game.getInstance();

    protected char check(){
        if (checkWinnerOnRows()) return game.getWINNER();
        else if (checkWinnerOnColumns()) return game.getWINNER();
        else if (checkWinnerOnMainDiagonal()) return game.getWINNER();
        else if (checkWinnerOnNotMainDiagonal()) return game.getWINNER();
        return game.getWINNER();
    }

    private boolean checkWinnerOnNotMainDiagonal() {
        if (game.getGameField()[0][2] == game.getGameField()[1][1]
                && game.getGameField()[0][2] == game.getGameField()[2][0]
                && game.getGameField()[0][2] != game.EMPTY) {
            game.setWINNER(game.getGameField()[0][2]);
            return true;
        }
        return false;
    }

    private boolean checkWinnerOnMainDiagonal() {
        if (game.getGameField()[0][0] == game.getGameField()[1][1]
                && game.getGameField()[0][0] == game.getGameField()[2][2]
                && game.getGameField()[0][0] != game.EMPTY) {
            game.setWINNER(game.getGameField()[0][0]);
            return true;
        }
        return false;
    }

    private boolean checkWinnerOnColumns() {
        for (int i = 0; i < 3; i++){
            if (game.getGameField()[0][i] == game.getGameField()[1][i]
                    && game.getGameField()[0][i] == game.getGameField()[2][i]
                    && game.getGameField()[0][i] != game.EMPTY) {
                game.setWINNER(game.getGameField()[0][i]);
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerOnRows() {
        for (int i = 0; i < 3; i++){
            if (game.getGameField()[i][0] == game.getGameField()[i][1]
                    && game.getGameField()[i][0] == game.getGameField()[i][2]
                    && game.getGameField()[i][0] != game.EMPTY) {
                game.setWINNER(game.getGameField()[i][0]);
                return true;
            }
        }
        return false;
    }
}
