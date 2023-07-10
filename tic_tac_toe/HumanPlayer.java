package Homework.tic_tac_toe;

import java.util.Scanner;

/**
 * Human player.
 * Игрок-человек.
 */
public class HumanPlayer extends AbstractPlayer {

    /**
     * Constructor.
     * Конструктор.
     *
     * @param name      player name / имя игрока.
     * @param symbol    player symbol / символ игрока.
     */
    public HumanPlayer(String name, PlayerSymbol symbol) {
    // Implement the constructor body just by calling the superclass constructor.
    // Реализовать тело конструктора, вызвав конструктор суперкласса.
        super(name, symbol);
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
        return input.nextLine();
    }
}





