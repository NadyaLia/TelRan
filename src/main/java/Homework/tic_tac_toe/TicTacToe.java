package Homework.tic_tac_toe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    private static final List<Player> PLAYERS = new ArrayList<>();
    private static boolean isGameOver;
    private static GameField field;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 8;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Logic of the method:
        // 1. Create the game field (call the right method located in this class).
        // 2. Start the game cycle, which continues while isGameOver value is false.
        //      Inside the cycle:
        //      1. Start another cycle that iterates through the players, inside this cycle:
        //      2. Read the coordinates inputted by the player (using the method of the player instance).
        //      3. Pass that coordinates to the method of the playing field, filling the cell with the player symbol.
        //      4. Steps 2 and 3 should be repeated until the player enters the correct coordinates.
        //      5. Print the game field to the console.
        //      6. Check if the player won after his move.
        //         In that case print the message about the victory to the console and finish the game.
        //      7. Check if the game field is completely filled.
        //         In that case print the message about the draw to the console and finish the game.

        // Логика работы метода:
        // 1. Создать игровое поле (вызвать соответствующий метод этого же класса).
        // 2. Запустить игровой цикл, который продолжается до тех пор, пока isGameOver == false.
        //    Внутри цикла:
        //      1. Запустить ещё один цикл, перебирающий игроков и внутри этого цикла:
        //      2. Считать координаты, введённые игроком с помощью готового метода игрока.
        //      3. Передать считанные координаты в метод игрового поля, заполняющий ячейку символом игрока.
        //      4. Пункты 2 и 3 должны повторяться до тех пор, пока пользователь не введёт корректные координаты.
        //      5. Отрисовать в консоли игровое поле.
        //      6. Проверить, не выиграл ли игрок в результате своего хода.
        //         Если выиграл - выводим сообщение о победе и завершаем игру.
        //      7. Проверить, не заполнено ли игровое поле полностью.
        //         Если заполнено - выводим сообщение о ничье и завершаем игру.

        init();
        do {

            for (int i = 0; i < PLAYERS.size(); i++) {

                Player player = PLAYERS.get(i);
                System.out.println(player.getName());

                boolean successfulMove = false;
                while (!successfulMove) {
                    String coordinates = PLAYERS.get(i).makeMove();
                    successfulMove = field.setSymbol(player.getSymbol(), coordinates);

                    if (successfulMove) {
                        field.repaint();
                    }
                }

                boolean win = false;
                win = field.isWin(player.getSymbol().getValue());
                if (win) {
                    isGameOver = true;
                    System.out.println(player.getName() + " - you won!");
                    break;
                }

                if (field.isFieldFull()) {
                    isGameOver = true;
                    System.out.println("The game is over! Draw!");
                    break;
                }
            }
        } while (!isGameOver);
        System.out.println();
    }

    /**
     * Initializing of the game, creating the game field.
     * Первоначальная инициализация игры, создание игрового поля.
     */
    private static void init() {
        // Logic of the method:
        // 1. Print the name of the game to the console.
        // 2. Create an instance of the game field
        //    (get the size of it and the win combination length
        //    by calling a right methods located in this class).
        // 3. Create two players by calling a right method located in this class.
        // 4. Print the game field to the console (using the method of the game field instance).

        // Логика работы метода:
        // 1. Вывести в консоль название игры.
        // 2. Создать экземпляр игрового поля
        //    (получив его размер и длину выигрышной комбинации,
        //    вызвав соответствующие методы данного класса).
        // 3. Создать двух игроков, используя метод данного класса.
        // 4. Отрисовать в консоли игровое поле (с помощью готового метода игрового поля).

        System.out.println("Tic Tac Toe");

        int fieldSize = getFieldSize();
        int winLength = getWinLength(fieldSize);
        field = new GameField(fieldSize, winLength);

        if (fieldSize < MIN_FIELD_SIZE || fieldSize > MAX_FIELD_SIZE) {
            throw new IllegalArgumentException("Field size must be between " + MIN_FIELD_SIZE + " and " + MAX_FIELD_SIZE);
        }

        createPlayers();

        field.repaint();

    }

    /**
     * Creating two players, the second player may be AI depending on the selected game mode.
     * Метод создаёт игроков в зависимости от выбранного режима игры.
     */
    private static void createPlayers() {
        // Logic of the method:
        // 1. Print to the console invitation to select the game mode: 1 - human against human, 2 - human against AI.
        // 2. Read the inputted value from the console.
        // 3. Repeat steps 1 and 2 until the player inputs the correct value.
        // 4. Create a human player and add him ti the game.
        // 5. Depends on the selected game mode create human or AI player and add him/it to the game.

        // Логика работы метода:
        // 1. Выведите в консоль приглашение выбрать режим игры: 1 - два игрока, 2 - игрок против компьютера.
        // 2. Считать с консоли значение, введённое игроком.
        // 3. Повторять пункты 1 и 2 до тех пор, пока не будет введено корректное значение.
        // 4. Создать и добавить в игру первого игрока-человека.
        // 5. В зависимости от выбранного режима игры создать игрока-человека
        //    или компьютерного игрока и добавить в игру.

       Scanner input2 = new Scanner(System.in);

        boolean isCorrectValue = false;
        String gameMode = "";
        while (!isCorrectValue) {
            System.out.println("Please select the game mode: 1 - human against human, 2 - human against AI");
            gameMode = input2.nextLine();
            if (gameMode.equals("1") || gameMode.equals("2")) {
                isCorrectValue = true;
            } else {
                System.out.println("Your input is not correct");
            }
        }

        System.out.println("Name of the first player");
        String playerName1 = input2.nextLine();
        PLAYERS.add(new HumanPlayer(playerName1, PlayerSymbol.O));
        System.out.println("-------");
        if (gameMode.equals("1")) {
            System.out.println("Name of the second player");
            String playerName2 = input2.nextLine();
            PLAYERS.add(new HumanPlayer(playerName2, PlayerSymbol.X));
        } else {
            System.out.println("Play against the computer");
            PLAYERS.add(new ComputerPlayer(PlayerSymbol.X, field));
        }
    }

    /**
     * Choosing the win combination length by the player.
     * Выбор игроком длины выигрышной комбинации.
     *
     * @param fieldSize game field size / размер игрового поля.
     * @return          win combination length / длина выигрышной комбинации.
     */
    private static int getWinLength(int fieldSize) {
        // Logic of the method:
        // 1. Print to the console invitation to select the win combination length
        //    (from 3 to value of the game field size).
        // 2. Read the inputted value from the console.
        // 3. Repeat steps 1 and 2 until the player inputs the correct value.
        // 4. Return the inputted value.

        // Логика работы метода:
        // 1. Вывести в консоль приглашение выбрать длину выигрышной комбинации
        //    (от 3 до значения размера игрового поля).
        // 2. Считать с консоли число, введённое игроком.
        // 3. Повторять шаги 1 и 2 до тех пор, пока игрок не введёт корректное значение.
        // 4. Вернуть введённое значение.
        if (fieldSize == 3) {
            return fieldSize;
        }

        boolean validWinSize = false;
        int winLength = 0;
        while (!validWinSize) {
            System.out.println("Please select the win combination length from 3 to "+ fieldSize);
            winLength = input.nextInt();

            if (winLength >= 3 && winLength <= fieldSize) {
                validWinSize = true;
            } else {
                System.out.println("Your input is not correct");
            }
        }
        return winLength;
    }

    /**
     * Choosing the game field size by the player.
     * Выбор игроком размера игрового поля.
     *
     * @return the size of the game field / размер игрового поля.
     */
    private static int getFieldSize() {
        // Logic of the method:
        // 1. Print to the console invitation to select the game field size.
        // 2. Read the inputted value from the console.
        // 3. Repeat steps 1 and 2 until the player inputs the correct value.
        // 4. Return the inputted value.

        // Логика работы метода:
        // 1. Вывести в консоль приглашение выбрать размер игрового поля (от 3 до 8).
        // 2. Считать с консоли число, введённое игроком.
        // 3. Повторять шаги 1 и 2 до тех пор, пока игрок не введёт корректное значение.
        // 4. Вернуть введённое значение.

        System.out.println("Please select the game field size from 3 to 8");

        int fieldSize;
        do {
            fieldSize = input.nextInt();
        } while (fieldSize < 3 || fieldSize > 8);
        return fieldSize;
    }
}

