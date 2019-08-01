public class Main {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        CheckWinner checkWinner = new CheckWinner();
        HumanMove human = new HumanMove();
        ComputerMove computer = new ComputerMove();
        System.out.println("A new game started! Let's go! :)");
        game.printGameTableWithNumbers();
        while (true){
            game.printGameTable();
            System.out.println("Please type number");
            int number = human.readHumanChoice();
            if (number >= 1 && number <= 9) {
                if (!human.handleHumanChoice(number)) {
                    break;
                } else if (computer.handleComputerChoice()) {
                    if (checkWinner.check() != 0) {
                        human.closer();
                        break;
                    }
                    if (game.isDraw()){
                        human.closer();
                        break;
                    }
                }
            } else System.out.println("Invalid value");
        }
        game.showResultsGame();
    }
}
