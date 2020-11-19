package lesson4;

import java.util.Scanner;

public class Lesson4 {

    private static final int FIELD_SIZE = 3;
    static char[][] FIELD = new char[FIELD_SIZE][FIELD_SIZE];
    private static final Scanner SCANNER = new Scanner(System.in);
    static final char X_VALUE = 'X';
    static final char O_VALUE = 'O';
    static final char EMPTY_VALUE = '.';
    static int moveX;
    static int moveY;
    private static int winner = 0;

    public static void main(String[] args) {
        game(false, false);
    }

    private static void game(boolean player1, boolean player2) {
        fillField();
        printField();
        do {
            do {
                if (player1) playerTurn();
                else aiTurn(X_VALUE, O_VALUE);
            } while (!turnDrawnX());
            printField();
            if (!checkWin()) {
                do {
                    if (player2) playerTurn();
                    else aiTurn(O_VALUE, X_VALUE);
                } while (!turnDrawnO());
                printField();
            }
        } while (!checkWin());
        String player1Name = player1 ? "Игрок 1" : "Компьютер 1";
        String player2Name = player2 ? "Игрок 2" : "Компьютер 2";
        System.out.println("Game over\n" + (winner == 1 ? "Победил " + player1Name : winner == -1 ? "Победил " + player2Name : "Ничья"));
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
        if (checkEmpty()) {
            FIELD[moveY - 1][moveX - 1] = X_VALUE;
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkEmpty() {
        return FIELD[moveY - 1][moveX - 1] == EMPTY_VALUE;
    }

    public static boolean turnDrawnO() {
        if (checkEmpty()) {
            FIELD[moveY - 1][moveX - 1] = O_VALUE;
            return true;
        } else {
            return false;
        }
    }

    public static void aiTurnRandom() {
        do {
            int aiTurn = (int) (Math.random() * 3 + 1);
            moveX = aiTurn;
            aiTurn = (int) (Math.random() * 3 + 1);
            moveY = aiTurn;
        } while (!checkEmpty());
        System.out.printf("Хожу рандомно в %d %d%n", moveX, moveY);
    }

    public static boolean aiTurnSmart(char enemy, boolean againstMyself) {
        int qRow, qCol;
        boolean hasEmptyRow, hasEmptyCol;
        int emptyRowX, emptyRowY;
        int emptyColX, emptyColY;

        int qDiag1 = 0, qDiag2 = 0;
        boolean hasEmptyDiag1 = false, hasEmptyDiag2 = false;
        int emptyDiag1X = 0, emptyDiag1Y = 0;
        int emptyDiag2X = 0, emptyDiag2Y = 0;

        for (int i = 0; i < FIELD.length; i++) {
            qRow = 0;
            qCol = 0;
            emptyRowX = 0;
            emptyRowY = 0;
            emptyColX = 0;
            emptyColY = 0;
            hasEmptyRow = false;
            hasEmptyCol = false;
            for (int j = 0; j < FIELD.length; j++) {
                if (FIELD[i][j] == EMPTY_VALUE) {
                    hasEmptyRow = true;
                    emptyRowX = j;
                    emptyRowY = i;
                }
                if (FIELD[i][j] == enemy) {
                    qRow = qRow + 1;
                }

                if (FIELD[j][i] == EMPTY_VALUE) {
                    hasEmptyCol = true;
                    emptyColX = i;
                    emptyColY = j;
                }
                if (FIELD[j][i] == enemy) {
                    qCol = qCol + 1;
                }
                if (qCol == 2 && hasEmptyCol || qRow == 2 && hasEmptyRow) {
                    moveX = (qCol == 2 && hasEmptyCol ? emptyColX : emptyRowX) + 1;
                    moveY = (qCol == 2 && hasEmptyCol ? emptyColY : emptyRowY) + 1;
                    if (!againstMyself) {
                        System.out.print("Вижу, что нужно блокировать " + (qCol == 2 ? "столбец " : "строку ") + (i + 1));
                    } else {
                        System.out.print("Вижу, что нужно выигрывать " + (qCol == 2 ? "столбец " : "строку ") + (i + 1));
                    }
                    System.out.printf(". Хожу %d %d%n", moveX, moveY);
                    return true;
                }
            }
            if (FIELD[i][i] == EMPTY_VALUE) {
                hasEmptyDiag1 = true;
                emptyDiag1X = i;
                emptyDiag1Y = i;
            }
            if (FIELD[i][i] == enemy) {
                qDiag1 = qDiag1 + 1;
            }

            if (FIELD[i][FIELD.length - 1 - i] == EMPTY_VALUE) {
                hasEmptyDiag2 = true;
                emptyDiag2X = FIELD.length - 1 - i;
                emptyDiag2Y = i;
            }
            if (FIELD[i][FIELD.length - 1 - i] == enemy) {
                qDiag2 = qDiag2 + 1;
            }

            if (qDiag1 == 2 && hasEmptyDiag1 || qDiag2 == 2 && hasEmptyDiag2) {
                moveX = (qDiag1 == 2 && hasEmptyDiag1 ? emptyDiag1X : emptyDiag2X) + 1;
                moveY = (qDiag1 == 2 && hasEmptyDiag1 ? emptyDiag1Y : emptyDiag2Y) + 1;
                if (!againstMyself) {
                    System.out.print("Вижу, что нужно блокировать " + (qDiag1 == 2 ? "левую диагональ" : "правую диаганоль"));
                } else {
                    System.out.print("Вижу, что нужно выигрывать " + (qDiag1 == 2 ? "левую диагональ" : "правую диаганоль"));
                }
                System.out.printf(". Хожу %d %d%n", moveX, moveY);
                return true;
            }
        }
        return false;
    }

    public static void aiTurn(char me, char enemy) {
        if (!aiTurnSmart(me, true) && !aiTurnSmart(enemy, false)) aiTurnRandom();
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
            if (xDiag1 == 3 || xDiag2 == 3 || oDiag1 == 3 || oDiag2 == 3) {
                winner = xDiag1 == 3 || xDiag2 == 3 ? +1 : -1;
                return true;
            }
        }
        return !hasEmpty; //draw or continue

    }
}
