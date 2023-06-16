package Homework.tic_tac_toe;

public abstract class AbstractPlayer implements Player {
    /**
     * Player name.
     * Имя игрока.
     */
    protected final String NAME;

    /**
     * Player symbol, X or O.
     * Символ игрока, Х или О.
     */
    protected final PlayerSymbol SYMBOL;

    /**
     * Constructor.
     * Конструктор.
     *
     * @param name      player name / имя игрока.
     * @param symbol    player symbol / символ игрока.
     */
    public AbstractPlayer(String name, PlayerSymbol symbol) {
        // Implement the constructor body.
        // Реализовать тело конструктора.
        this.NAME = name;
        this.SYMBOL = symbol;
    }

     /**
     * Getter.
     * Геттер.
     *
     * @return player symbol / символ игрока.
     */
    @Override
    public PlayerSymbol getSymbol() {
        // Implement the getter body.
        // Реализовать тело геттера.

        return SYMBOL;
    }

    /**
     * Getter.
     * Геттер.
     *
     * @return player name / имя игрока.
     */
    @Override
    public String getName() {
        // Implement the getter body.
        // Реализовать тело геттера.

        return NAME;
    }
}
