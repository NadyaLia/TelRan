package Homework.tic_tac_toe;

public enum PlayerSymbol {
    /**
     * Symbol X
     * Символ X
     */
    X ('X'),

    /**
     * Symbol O
     * Символ O
     */
    O ('O');

    /**
     * Symbol value
     * Символьное значение
     */
    private final char VALUE;

    /**
     * Constructor
     * Конструктор
     *
     * @param value symbol value / символьное значение
     */
    PlayerSymbol(char value) {
        this.VALUE = value;
    }

    /**
     * Getter
     * Геттер
     *
     * @return symbol value / символьное значение
     */
    public char getValue() {
        return VALUE;
    }

    /**
     * Get the opponent symbol.
     * Получить символ соперника.
     *
     * @param symbol    current symbol / свой символ.
     * @return          opponent symbol / символ соперника.
     */
    public static PlayerSymbol getOpponentSymbol(PlayerSymbol symbol) {
        // Logic of the method:
        // Return a symbol other than the one passed to the method.

        // Логика метода:
        // Вернуть символ, отличный от того, который передан в метод.

        if (symbol == PlayerSymbol.X) {
            return PlayerSymbol.O;
        } else if (symbol == PlayerSymbol.O) {
            return PlayerSymbol.X;
        } else {
            return null;
        }
    }

}
