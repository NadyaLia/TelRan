package Homework.tic_tac_toe;

public interface Player {
    /**
     * Getter
     * Геттер
     *
     * @return player symbol / символ игрока
     */
    PlayerSymbol getSymbol();

    /**
     * Getter
     * Геттер
     *
     * @return player name / имя игрока
     */
    String getName();

    /**
     * Make a move
     * Сделать ход
     *
     * @return  coordinates in string format with a space as a splitter, example - "2 3"
     *          координаты в виде строки с разделителем-пробелом, например - "2 3"
     */
    String makeMove();

}
