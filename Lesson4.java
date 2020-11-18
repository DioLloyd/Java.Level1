import java.util.Scanner;

public class Lesson4 {

    private static final int FIELD_SIZE = 3;
    private static final char[][] FIELD = new char[FIELD_SIZE][FIELD_SIZE];
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final char X_VALUE = 'X';
    private static final char O_VALUE = 'O';
    private static final char EMPTY_VALUE = '.';
    private static int moveX;
    private static int moveY;
    private static int winner = 0;


    public static void main(String[] args) {
        fillField();
        printField();

        do {
            do {
//                playerTurn();
                aiTurn();
            } while (!turnDrawnX());
            printField();

            if (!checkWin()) {
                do {
                    aiTurn();
                } while (!turnDrawnO());
                printField();
            }
        } while (!checkWin());
        System.out.println("Game over\n"+ (winner == 1 ? "player won" : winner == -1 ? "AI won" : "draw"));
    }

    public static void fillField() {
        for (int i = 0; i < FIELD.length; i++) {
            for (int j = 0; j < FIELD.length; j++) {
                FIELD[i][j] = EMPTY_VALUE;
            }
        }
    }

    public static void printField() {
        System.out.println("0 1 2 3");
        for (int i = 0; i < FIELD.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < FIELD.length; j++) {
                System.out.print(FIELD[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void playerTurn() {
        do {
            System.out.println("Player turn");
            System.out.println("Input X and Y");
            moveX = SCANNER.nextInt();
            moveY = SCANNER.nextInt();
        } while (moveX <= 0 || moveX > 3 || moveY <= 0 || moveY > 3);
    }

    public static boolean turnDrawnX() {
        if (check()) {
            FIELD[moveY - 1][moveX - 1] = X_VALUE;
            return true;
        } else {
            return false;
        }
    }

    public static boolean check() {
        return FIELD[moveY - 1][moveX - 1] == EMPTY_VALUE;
    }

    public static boolean turnDrawnO() {
        if (check()) {
            FIELD[moveY - 1][moveX - 1] = O_VALUE;
            return true;
        } else {
            return false;
        }
    }

    public static void aiTurn() {
        int aiTurn = (int) (Math.random() * 3 + 1);
        moveX = aiTurn;
        aiTurn = (int) (Math.random() * 3 + 1);
        moveY = aiTurn;
    }

    public static void aiTurnSmart() {

        //чекнуть как винчеке и посмотреть есть ли там два крестика и пустая клетка
        //Если нет хода который надо блокировать, то рандомь

        int aiTurn = (int) (Math.random() * 3 + 1);
        moveX = aiTurn;
        aiTurn = (int) (Math.random() * 3 + 1);
        moveY = aiTurn;
    }

    public static boolean checkWin() {
        int xRow, oRow, xCol, oCol;
        int xDiag1 = 0, oDiag1 = 0, xDiag2 = 0, oDiag2 = 0;
        boolean hasEmpty = false;
        for (int i = 0; i < FIELD.length; i++) {
            xRow = 0;
            oRow = 0;
            xCol = 0;
            oCol = 0;
            for (int j = 0; j < FIELD.length; j++) {
                if (FIELD[i][j] == EMPTY_VALUE) {
                    hasEmpty = true;
                }
                if (FIELD[i][j] == X_VALUE) {
                    xRow = xRow + 1;
                } else if (FIELD[i][j] == O_VALUE) {
                    oRow = oRow + 1;
                }
                if (FIELD[j][i] == X_VALUE) {
                    xCol = xCol + 1;
                } else if (FIELD[j][i] == O_VALUE) {
                    oCol = oCol + 1;
                }
                if (xCol == 3 || oCol == 3 || xRow == 3 || oRow == 3) {
                    winner = xCol == 3 || xRow == 3 ? +1 : -1;
                    return true;
                }
            }
            if (FIELD[i][i] == X_VALUE) {
                xDiag1 = xDiag1 + 1;
            } else if (FIELD[i][i] == O_VALUE) {
                oDiag1 = oDiag1 + 1;
            }
            if (FIELD[i][FIELD.length - 1 - i] == X_VALUE) {
                xDiag2 = xDiag2 + 1;
            } else if (FIELD[i][FIELD.length - 1 - i] == O_VALUE) {
                oDiag2 = oDiag2 + 1;
            }
            if (xDiag1 == 3 || oDiag1 == 3) {
                winner = xDiag1 == 3 || xDiag2 == 3 ? +1 : -1;
                return true;
            }
        }
        return !hasEmpty; //draw or continue

    }
}
