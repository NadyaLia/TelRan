package Homework.tic_tac_toe;

/**
 * AI player.
 * Игрок-компьютер.
 */
public class ComputerPlayer extends AbstractPlayer {

    /**
     * The instance of the game field for the implementation of the move logic.
     * Экземпляр игрового поля, нужен для реализации логики хода.
     */
    private final GameField FIELD;

    /**
     * Constructor.
     * Конструктор.
     *
     * @param symbol player symbol / символ игрока.
     * @param field  instance of the game field / экземпляр игрового поля.
     */
    public ComputerPlayer(PlayerSymbol symbol, GameField field) {
// Implement the constructor body just by calling the superclass constructor
// and passing some kind of name for the AI to it.
// Реализовать тело конструктора, вызвав конструктор суперкласса и
// передав туда какое-нибудь имя для игрока-компьютера.

        super("Computer", symbol);
        this.FIELD = field;
    }

    /**
     * Make a move. AI chooses the coordinates randomly.
     * Сделать ход. Компьютер выбирает координаты рандомно.
     *
     * @return coordinates in string format with a space as a splitter, example - "2 3"
     * координаты в виде строки с разделителем-пробелом, например - "2 3".
     */
    @Override
    public String makeMove() {
// Logic of the method:
// 1. Print to console message about AI making a move.
// 2. Make a pause for the comfortable perception of the process of the AI moving
//    (about 2 seconds).
// 3. Get the random values of row and column.
// 4. Repeat step 3 until the empty cell is selected
//    (use methods of the game field instance).
// 5. Return selected row and column as a string with the space as a separator.

// Логика метода:
// 1. Выведите в консоль сообщение о том, что ходит компьютер.
// 2. Сделайте паузу около 2 секунд для комфортного восприятия процесса хода компьютера.
// 3. Выберите случайные значения для строки и столбца.
// 4. Повторяйте пункт 3 до тех пор, пока не будет выбрана свободная ячейка.
// 5. Верните выбранные значения в виде строки с разделителем-пробелом.
        System.out.println("Computer is in the game!");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        boolean madeMove = false;
        int rowValue = 0;
        int columnValue = 0;
        String coordinates = "";
        while (!madeMove) {

            rowValue = (int) (Math.random()* (FIELD.getFieldSize()))+1;
            columnValue = (int) (Math.random()* (FIELD.getFieldSize()))+1;
            coordinates = columnValue  + " " + rowValue;

            boolean isOccupied = FIELD.isCellOccupied(rowValue-1, columnValue-1);

            if (!isOccupied) {
                madeMove = true;
            }
        }
        return coordinates;
    }
}
