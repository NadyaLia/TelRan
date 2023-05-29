package Homework.tic_tac_toe;

import java.util.Scanner;

public class HumanPlayer implements Player {
    /**
     * Player name
     * Имя игрока
     */
    private final String NAME;

    /**
     * Player symbol, X or O
     * Символ игрока, Х или О
     */
    private final PlayerSymbol SYMBOL;


    /**
     * Constructor
     * Конструктор
     *
     * @param name      player name / имя игрока
     * @param symbol    player symbol / символ игрока
     */
    public HumanPlayer(String name, PlayerSymbol symbol) {
        // Implement the constructor body.
        // Реализовать тело конструктора.
        this.NAME = name;
        this.SYMBOL = symbol;
    }

    /**
     * Getter
     * Геттер
     *
     * @return player symbol / символ игрока
     */
    @Override
    public PlayerSymbol getSymbol() {
        // Implement the getter body.
        // Реализовать тело геттера.
        return SYMBOL;
    }

    /**
     * Getter
     * Геттер
     *
     * @return player name / имя игрока
     */
    @Override
    public String getName() {
        // Implement the getter body.
        // Реализовать тело геттера.
        return NAME;
    }

    /**
     * Make a move
     * Сделать ход
     *
     * @return  coordinates in string format with a space as a splitter, example - "2 3"
     *          координаты в виде строки с разделителем-пробелом, например - "2 3"
     */
    @Override
    public String makeMove() {
        // Logic of the method:
        // 1. Print to the console that the player should input the coordinates.
        // 2. Return the inputted value.

        // Логика метода:
        // 1. Вывести в консоль приглашение ввести координаты.
        // 2. Вернуть значение, которое ввёл пользователь.
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the coordinates: ");
        String coordinates = input.nextLine();
        return coordinates;
    }
}
