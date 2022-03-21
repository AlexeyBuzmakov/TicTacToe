import java.util.Scanner;

public class TicTacToe {
    private final char[][] FIELD = new char[3][3];
    private final static double FIRST_MOVE = (int) (1 + Math.random() * 2);
    private static int numberMovies = 1;
    private char sign;
    private int indexLineField;
    private int indexColumnField;
    private int numberPlayingField;
    Scanner scanner = new Scanner(System.in);

    public void startGame() {
            showPlayingField();
            while (true) {
                determiningTurnOrder();
                showField();
                if (checkConditionVictory()) {
                    return;
                }
                if (checkConditionDraw()) {
                    return;
                }
            }
        }

    private void determiningTurnOrder() {
        if(FIRST_MOVE == 1) {
            if(numberMovies % 2 != 0) {
                humanStep();
            }
            else {
                computerStep();
            }
        }
        else {
            if(numberMovies % 2 != 0) {
                computerStep();
            }
            else {
                humanStep();
            }
        }
    }

    private void humanStep() {
        System.out.println("Ваш ход");
        numberPlayingField = scanner.nextInt();
        checkNumberPLayingField();
        convertArrayPlayField();
        checkInputDoubleField();
        sign = checkInputCharacter();
    }

    private void computerStep() {
        System.out.println("Ход компьютера");
        numberPlayingField = computerMoveLogic();
        convertArrayPlayField();
        checkInputDoubleFieldComputer();
        sign = checkInputComputerSign();
    }

    private int computerMoveLogic() {
        if (numberMovies == 1) {
          return computerLogicFirstMove();
        } else {
            if (FIRST_MOVE == 1) {
                if(testWinComputer() > 0) {
                    return testWinComputer();
                }
                else if(testWinComputer() < 0) {
                    return testLoseComputer();
                }
                else {
                    return (int) (1 + Math.random() * 9);
                }
            } else {
                if(testLoseComputer() > 0) {
                    return testLoseComputer();
                }
                else if(testLoseComputer() < 0) {
                    return testWinComputer();
                }
                else {
                    return (int) (1 + Math.random() * 9);
                    }
                }
            }
        }

    private int computerLogicFirstMove() {
        if (FIRST_MOVE == 1) {
            if (FIELD[1][1] == 'x') {
                int anyCornerField = (int) (1 + Math.random() * 4);
                switch (anyCornerField) {
                    case 1 -> {return 1;}
                    case 2 -> {return 3;}
                    case 3 -> {return 7;}
                    case 4 -> {return 9;}
                }
            } else {
                return 5;
            }
        }
        return 5;
    }

    private int testWinComputer() {
        if (FIELD[0][1] == 'o' && FIELD[0][2] == 'o' || FIELD[1][0] == 'o' && FIELD[2][0] == 'o'
                || FIELD[1][1] == 'o' && FIELD[2][2] == 'o') {
            return 1;
        } else if (FIELD[0][0] == 'o' && FIELD[0][2] == 'o' || FIELD[1][1] == 'o' && FIELD[2][1] == 'o') {
            return 2;
        } else if (FIELD[0][0] == 'o' && FIELD[0][1] == 'o' || FIELD[1][2] == 'o' && FIELD[2][2] == 'o'
                || FIELD[2][0] == 'o' && FIELD[1][1] == 'o') {
            return 3;
        } else if (FIELD[0][0] == 'o' && FIELD[2][0] == 'o' || FIELD[1][1] == 'o' && FIELD[1][2] == 'o') {
            return 4;
        } else if (FIELD[0][0] == 'o' && FIELD[2][2] == 'o' || FIELD[0][2] == 'o' && FIELD[2][0] == 'o'
                || FIELD[1][0] == 'o' && FIELD[1][2] == 'o' || FIELD[0][1] == 'o' && FIELD[2][1] == 'o') {
            return 5;
        } else if (FIELD[0][2] == 'o' && FIELD[2][2] == 'o' || FIELD[1][0] == 'o' && FIELD[1][1] == 'o') {
            return 6;
        } else if (FIELD[0][0] == 'o' && FIELD[1][0] == 'o' || FIELD[2][1] == 'o' && FIELD[2][2] == 'o'
                || FIELD[0][2] == 'o' && FIELD[1][1] == 'o') {
            return 7;
        } else if (FIELD[2][0] == 'o' && FIELD[2][2] == 'o' || FIELD[0][1] == 'o' && FIELD[1][1] == 'o') {
            return 8;
        } else if (FIELD[0][2] == 'o' && FIELD[1][2] == 'o' || FIELD[2][0] == 'o' && FIELD[2][1] == 'o'
                || FIELD[0][0] == 'o' && FIELD[1][1] == 'o') {
            return 9;
        }
        else {
            return 0;
        }
    }


    private int testLoseComputer() {
        if (FIELD[0][1] == 'x' && FIELD[0][2] == 'x' || FIELD[1][0] == 'x' && FIELD[2][0] == 'x'
                || FIELD[1][1] == 'x' && FIELD[2][2] == 'x') {
            return 1;
        } else if (FIELD[0][0] == 'x' && FIELD[0][2] == 'x' || FIELD[1][1] == 'x' && FIELD[2][1] == 'x') {
            return 2;
        } else if (FIELD[0][0] == 'x' && FIELD[0][1] == 'x' || FIELD[1][2] == 'x' && FIELD[2][2] == 'x'
                || FIELD[2][0] == 'x' && FIELD[1][1] == 'x') {
            return 3;
        } else if (FIELD[0][0] == 'x' && FIELD[2][0] == 'x' || FIELD[1][1] == 'x' && FIELD[1][2] == 'x') {
            return 4;
        } else if (FIELD[0][0] == 'x' && FIELD[2][2] == 'x' || FIELD[0][2] == 'x' && FIELD[2][0] == 'x'
                || FIELD[1][0] == 'x' && FIELD[1][2] == 'x' || FIELD[0][1] == 'x' && FIELD[2][1] == 'x') {
            return 5;
        } else if (FIELD[0][2] == 'x' && FIELD[2][2] == 'x' || FIELD[1][0] == 'x' && FIELD[1][1] == 'x') {
            return 6;
        } else if (FIELD[0][0] == 'x' && FIELD[1][0] == 'x' || FIELD[2][1] == 'x' && FIELD[2][2] == 'x'
                || FIELD[0][2] == 'x' && FIELD[1][1] == 'x') {
            return 7;
        } else if (FIELD[2][0] == 'x' && FIELD[2][2] == 'x' || FIELD[0][1] == 'x' && FIELD[1][1] == 'x') {
            return 8;
        } else if (FIELD[0][2] == 'x' && FIELD[1][2] == 'x' || FIELD[2][0] == 'x' && FIELD[2][1] == 'x'
                || FIELD[0][0] == 'x' && FIELD[1][1] == 'x') {
            return 9;
        }
        else {
            return 0;
        }
    }


    private char checkInputComputerSign() {
        if(FIRST_MOVE == 1) {
            return 'o';
        }
        else {
            return 'x';
        }
    }

    private void checkNumberPLayingField() {
        while (true) {
            if (numberPlayingField > 0 && numberPlayingField < 10) {
                return;
            }
            System.out.println("Номер поля от 1 до 9. Повторите ввод");
            numberPlayingField = scanner.nextInt();
        }
    }

    private void convertArrayPlayField() {
        switch (numberPlayingField) {
            case 1 -> {
                indexLineField = 0;
                indexColumnField = 0;
            }
            case 2 -> {
                indexLineField = 0;
                indexColumnField = 1;
            }
            case 3 -> {
                indexLineField = 0;
                indexColumnField = 2;
            }
            case 4 -> {
                indexLineField = 1;
                indexColumnField = 0;
            }
            case 5 -> {
                indexLineField = 1;
                indexColumnField = 1;
            }
            case 6 -> {
                indexLineField = 1;
                indexColumnField = 2;
            }
            case 7 -> {
                indexLineField = 2;
                indexColumnField = 0;
            }
            case 8 -> {
                indexLineField = 2;
                indexColumnField = 1;
            }
            case 9 -> {
                indexLineField = 2;
                indexColumnField = 2;
            }
        }
    }

    private void showPlayingField() {
        System.out.println("Игровое поле");
        String[][]playingField = new String[3][3];
        char numberCell = '1';
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                playingField[i][j] = "[" + numberCell + "]";
                System.out.print(playingField[i][j]);
                numberCell++;
                if(j == 2) {
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    private void checkInputDoubleFieldComputer() {
        while (true) {
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(FIELD[indexLineField][indexColumnField] != 'x' && FIELD[indexLineField][indexColumnField] != 'o') {
                        return;
                    }
                }
            }
            numberPlayingField = (int) (1 + Math.random() * 9);
            convertArrayPlayField();
        }
    }


    private void checkInputDoubleField() {
        while (true) {
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(FIELD[indexLineField][indexColumnField] != 'x' && FIELD[indexLineField][indexColumnField] != 'o') {
                        return;
                    }
                }
            }
            System.out.println("Поле уже занято. Повторите ввод.");
            numberPlayingField = scanner.nextInt();
            convertArrayPlayField();
        }
    }

    private char checkInputCharacter() {
        if (FIRST_MOVE == 1) {
            return 'x';
        }
        else {
            return 'o';
        }
    }

    private void showField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.println();
                }
                if (i == indexLineField && j == indexColumnField) {
                    FIELD[i][j] = sign;
                }
                System.out.print(FIELD[i][j] + " ");
            }
        }
        System.out.println();
    }

    private boolean checkConditionVictory() {
           if (FIELD[0][0] == 'x' && FIELD[0][1] == 'x' && FIELD[0][2] == 'x'
            || FIELD[1][0] == 'x' && FIELD[1][1] == 'x' && FIELD[1][2] == 'x'
            || FIELD[2][0] == 'x' && FIELD[2][1] == 'x' && FIELD[2][2] == 'x'
            || FIELD[0][0] == 'x' && FIELD[1][0] == 'x' && FIELD[2][0] == 'x'
            || FIELD[0][1] == 'x' && FIELD[1][1] == 'x' && FIELD[2][1] == 'x'
            || FIELD[0][2] == 'x' && FIELD[1][2] == 'x' && FIELD[2][2] == 'x'
            || FIELD[0][0] == 'x' && FIELD[1][1] == 'x' && FIELD[2][2] == 'x'
            || FIELD[0][2] == 'x' && FIELD[1][1] == 'x' && FIELD[2][0] == 'x') {
        if(FIRST_MOVE == 1) {
                System.out.println("Игра окончена. Вы победили.");
            }
        else {
                System.out.println("Игра окончена. Победил компьютер.");
            }
            return true;
        }
      else if (FIELD[0][0] == 'o' && FIELD[0][1] == 'o' && FIELD[0][2] == 'o'
            || FIELD[1][0] == 'o' && FIELD[1][1] == 'o' && FIELD[1][2] == 'o'
            || FIELD[2][0] == 'o' && FIELD[2][1] == 'o' && FIELD[2][2] == 'o'
            || FIELD[0][0] == 'o' && FIELD[1][0] == 'o' && FIELD[2][0] == 'o'
            || FIELD[0][1] == 'o' && FIELD[1][1] == 'o' && FIELD[2][1] == 'o'
            || FIELD[0][2] == 'o' && FIELD[1][2] == 'o' && FIELD[2][2] == 'o'
            || FIELD[0][0] == 'o' && FIELD[1][1] == 'o' && FIELD[2][2] == 'o'
            || FIELD[0][2] == 'o' && FIELD[1][1] == 'o' && FIELD[2][0] == 'o') {
        if(FIRST_MOVE == 1) {
                System.out.println("Игра окончена. Победил компьютер");
            }
        else {
                System.out.println("Игра окончена. Вы победили");
            }
            return true;
        }
        return false;
    }

    private boolean checkConditionDraw() {
        numberMovies++;
        if (numberMovies > 9) {
            System.out.println("Игра окончена. Ничья");
            return true;
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        TicTacToe a = new TicTacToe();
        a.startGame();
    }
}
