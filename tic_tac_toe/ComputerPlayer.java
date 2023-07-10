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
     * Make a move. AI chooses a cell according the next logic:
     * 1. If there is a possibility to win the game, AI will make its move that way.
     * 2. If there is a possibility for the opponent winning in the next move,
     *    AI will try to block that move.
     * 3. Trying to place symbol near an existing symbol if the win is possible in that direction.
     * 4. If none of this possibilities are available, AI will make its move randomly.
     *
     * Сделать ход. Компьютер принимает решение по следующему алгоритму:
     * 1. Есть ли возможность выигрыша на данном ходу? Если да - делаем такой ход.
     * 2. Есть ли возможность выигрыша противника в следующем ходу? Если да - блокируем его ход.
     * 3. Пытаемся поставить символ рядом с уже существующим символом в том направлении, где ещё возможна победа.
     * 4. Если не выполнились предыдущие три условия, ставим символ рандомно.
     *
     * @return coordinates in string format with a space as a splitter, example - "2 3"
     *         координаты в виде строки с разделителем-пробелом, например - "2 3".
     */
    @Override
    public String makeMove() {
        // Logic of the method:
        // 1. Print to console message about AI making a move.
        // 2. Make a pause for the comfortable perception of the process of the AI moving
        //    (about 2 seconds).
        // 3. Try to get the coordinates for winning
        //    using the right method located in that class.
        //    Return that coordinates if they are not null.
        // 4. Try to get the coordinates for blocking the opponent move
        //    using the right method located in that class.
        //    Return that coordinates if they are not null.
        // 5. Try to get the coordinates for continuing the existed combination
        //    using the right method located in that class.
        //    Return that coordinates if they are not null.
        // 6. Return the random coordinates.

        // Логика метода:
        // 1. Выведите в консоль сообщение о том, что ходит компьютер.
        // 2. Сделайте паузу около 2 секунд для комфортного восприятия процесса хода компьютера.
        // 3. Попытаться получить координаты для выигрыша
        //    с помощью соответствующего метода данного класса.
        //    Если полученные координаты не null, вернуть их.
        // 4. Попытаться получить координаты для блокировки хода противника
        //    с помощью соответствующего метода данного класса.
        //    Если полученные координаты не null, вернуть их.
        // 5. Попытаться получить координаты для продолжения существующей комбинации
        //    с помощью соответствующего метода данного класса.
        //    Если полученные координаты не null, вернуть их.
        // 6. Вернуть случайно выбранные координаты.

        System.out.println("Computer is in the game!");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String coordinates = tryToWin();
        if (coordinates != null) {
            return coordinates;
        }

        coordinates = tryToBlock();
        if (coordinates != null) {
            return coordinates;
        }

        coordinates = tryToContinueCombination();
        if (coordinates != null) {
            return coordinates;
        }
        return getRandomCoordinates();

    }

    /**
     * Attempting to continue the win combination from existing symbol.
     * Попытка развить выигрышную комбинацию от уже существующего символа.
     *
     * @return coordinates for the move or null if attempting failed.
     *         координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String tryToContinueCombination() {
        // Logic of the method:
        // 1. Start the cycle that iterates all cells of the game field. Inside that cycle:
        // 2. If the current cell contains the symbol of the AI player,
        //    check all directions from that cell if there is a possibility to continuing the existing combination
        //    using the right method located in that class.

        // Логика метода:
        // 1. Пройти циклом по всем ячейкам игрового поля. Внутри цикла:
        // 2. Если в текущей ячейке находится символ игрока-компьютера,
        //    проверить все направления от данной ячейки на предмет возможности продолжения комбинации,
        //    вызвав соответствующий метод данного класса.

        for (int row = 0; row < FIELD.getFieldSize(); row++) {
            for (int column = 0; column < FIELD.getFieldSize(); column++) {
                char cellSymbol = FIELD.getSymbolByCoordinates(row, column);
                if (cellSymbol == SYMBOL.getValue()) {
                    String directionCoordinates = checkAllDirectionsFromCurrentCell(row, column);
                    return directionCoordinates;
                }
            }
        }
        return null;
    }

    /**
     * Checking all directions from the selected cell.
     * Проверяем по очереди все направления от выбранной ячейки.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          coordinates for the move or null if there is no options for move like this.
     *                  координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String checkAllDirectionsFromCurrentCell(int row, int column) {
        // Logic of the method:
        // Check all 8 directions from the current cell using the right methods located in that class.
        // If there is a possibility to continue the combination in any of direction,
        // return the coordinates for that move, otherwise return null.

        // Логика метода:
        // Проверить все восемь направлений от текущей ячейки, вызвав соответствующие методы данного класса.
        // Если построение в каком-либо направлении возможно,
        // вернуть координаты для такого хода, в противном случае вернуть null.

        String coordinates = getUpRightDiagonalCoordinates(row, column);
        if (coordinates != null) {
            return coordinates;
        }

        coordinates = getDownRightDiagonalCoordinates(row, column);
        if (coordinates != null) {
            return coordinates;
        }

        coordinates = getDownLeftDiagonalCoordinates(row, column);
        if (coordinates != null) {
            return coordinates;
        }

        coordinates = getUpLeftDiagonalCoordinates(row, column);
        if (coordinates != null) {
            return coordinates;
        }

        coordinates = getUpDirectionCoordinates(row, column);
        if (coordinates != null) {
            return coordinates;
        }

        coordinates = getDownDirectionCoordinates(row, column);
        if (coordinates != null) {
            return coordinates;
        }

        coordinates = getLeftDirectionCoordinates(row, column);
        if (coordinates != null) {
            return coordinates;
        }

        coordinates = getRightDirectionCoordinates(row, column);
        if (coordinates != null) {
            return coordinates;
        }
        return null;
    }

    /**
     * Getting the coordinates for a move in up and right direction.
     * Получить координаты для хода по направлению вверх и вправо.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          coordinates for the move or null if there is no options for move like this.
     *                  координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String getUpRightDiagonalCoordinates(int row, int column) {
        // Logic of the method:
        // Find the empty cell in the up and right direction from the current cell and return its coordinates.

        // Логика метода:
        // В направлении вверх и вправо от указанной ячейки найти пустую ячейку и вернуть её координаты.

        while (row >= 0 && column < FIELD.getFieldSize()) {
            if (!FIELD.isCellOccupied(row, column)) {
                return (column + 1) + " " + (row + 1);
            }
            row--;
            column++;
        }
        return null;
    }

    /**
     * Getting the coordinates for a move in down and right direction.
     * Получить координаты для хода по направлению вниз и вправо.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          coordinates for the move or null if there is no options for move like this.
     *                  координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String getDownRightDiagonalCoordinates(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        while (row < FIELD.getFieldSize() && column < FIELD.getFieldSize()) {
            if (!FIELD.isCellOccupied(row, column)) {
                return (column + 1) + " " + (row + 1);
            }
            row++;
            column++;
        }
        return null;
    }

    /**
     * Getting the coordinates for a move in down and left direction.
     * Получить координаты для хода по направлению вниз и влево.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          coordinates for the move or null if there is no options for move like this.
     *                  координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String getDownLeftDiagonalCoordinates(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        while (row < FIELD.getFieldSize() && column >= 0) {
            if (!FIELD.isCellOccupied(row, column)) {
                return (column + 1) + " " + (row + 1);
            }
            row++;
            column--;
        }
        return null;
    }

    /**
     * Getting the coordinates for a move in up and left direction.
     * Получить координаты для хода по направлению вверх и влево.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          coordinates for the move or null if there is no options for move like this.
     *                  координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String getUpLeftDiagonalCoordinates(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        while (row >= 0 && column >= 0) {
            if (!FIELD.isCellOccupied(row, column)) {
                return (column + 1) + " " + (row + 1);
            }
            row--;
            column--;
        }
        return null;
    }

    /**
     * Getting the coordinates for a move in up direction.
     * Получить координаты для хода по направлению вверх.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          coordinates for the move or null if there is no options for move like this.
     *                  координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String getUpDirectionCoordinates(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        while (row >= 0) {
            if (!FIELD.isCellOccupied(row, column)) {
                return (column + 1) + " " + (row + 1);
            }
            row--;
        }
        return null;
    }

    /**
     * Getting the coordinates for a move in down direction.
     * Получить координаты для хода по направлению вниз.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          coordinates for the move or null if there is no options for move like this.
     *                  координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String getDownDirectionCoordinates(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        while (row < FIELD.getFieldSize()) {
            if (!FIELD.isCellOccupied(row, column)) {
                return (column + 1) + " " + (row + 1);
            }
            row++;
        }
        return null;
    }

    /**
     * Getting the coordinates for a move in left direction.
     * Получить координаты для хода по направлению влево.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          coordinates for the move or null if there is no options for move like this.
     *                  координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String getLeftDirectionCoordinates(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        while (column >= 0) {
            if (!FIELD.isCellOccupied(row, column)) {
                return (column + 1) + " " + (row + 1);
            }
            column--;
        }
        return null;
    }

    /**
     * Getting the coordinates for a move in right direction.
     * Получить координаты для хода по направлению вправо.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          coordinates for the move or null if there is no options for move like this.
     *                  координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String getRightDirectionCoordinates(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        while (column < FIELD.getFieldSize()) {
            if (!FIELD.isCellOccupied(row, column)) {
                return (column + 1) + " " + (row + 1);
            }
            column++;
        }
        return null;
    }

    /**
     * Checking if the win combination may be built in the up and right direction.
     * Проверить направление вверх и вправо на возможность построения выигрышной комбинации.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          true if the win combination may be built in that direction.
     *                  true, если возможно построить выигрышную комбинацию.
     */
    private boolean checkUpRightDiagonal(int row, int column) {
        // Logic of the method:
        // 1. Start the cycle that checks all cells in specified direction
        //    within the win combination length.
        // 2. Return false if at least one opponent symbol found in that direction,
        //    otherwise return true.

        // Логика метода:
        // 1. Запустить цикл, который проверяет ячейки в указанном направлении
        //    в пределах длины выигрышной комбинации.
        // 2. Вернуть false, если в указанном направлении будет найден хотя бы один символ противника,
        //    иначе вернуть true.

        int count = 0;

        while (row >= 0 && column < FIELD.getFieldSize()) {
            if (count >= FIELD.getWIN_LENGTH()) {
                return true;
            }
            if (getSymbol() == PlayerSymbol.getOpponentSymbol(SYMBOL)) {
                return false;
            }
            row--;
            column++;
            count++;
        }
        return false;
    }

    /**
     * Checking if the win combination may be built in the down and right direction.
     * Проверить направление вниз и вправо на возможность построения выигрышной комбинации.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          true if the win combination may be built in that direction.
     *                  true, если возможно построить выигрышную комбинацию.
     */
    private boolean checkDownRightDiagonal(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.
        int count = 0;

        while (row < FIELD.getFieldSize() && column < FIELD.getFieldSize()) {
            if (count >= FIELD.getWIN_LENGTH()) {
                return true;
            }
            if (getSymbol() == PlayerSymbol.getOpponentSymbol(SYMBOL)) {
                return false;
            }
            row++;
            column++;
            count++;
        }
        return false;
    }

    /**
     * Checking if the win combination may be built in the down and left direction.
     * Проверить направление вниз и влево на возможность построения выигрышной комбинации.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          true if the win combination may be built in that direction.
     *                  true, если возможно построить выигрышную комбинацию.
     */
    private boolean checkDownLeftDiagonal(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        int count = 0;

        while (row < FIELD.getFieldSize() && column >= 0) {
            if (count >= FIELD.getWIN_LENGTH()) {
                return true;
            }
            if (getSymbol() == PlayerSymbol.getOpponentSymbol(SYMBOL)) {
                return false;
            }
            row++;
            column--;
            count++;
        }
        return false;
    }

    /**
     * Checking if the win combination may be built in the up and left direction.
     * Проверить направление вверх и влево на возможность построения выигрышной комбинации.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          true if the win combination may be built in that direction.
     *                  true, если возможно построить выигрышную комбинацию.
     */
    private boolean checkUpLeftDiagonal(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        int count = 0;

        while (row >= 0 && column >= 0) {
            if (count >= FIELD.getWIN_LENGTH()) {
                return true;
            }
            if (getSymbol() == PlayerSymbol.getOpponentSymbol(SYMBOL)) {
                return false;
            }
            row--;
            column--;
            count++;
        }
        return false;
    }
    /**
     * Checking if the win combination may be built in the up direction.
     * Проверить направление вверх на возможность построения выигрышной комбинации.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          true if the win combination may be built in that direction.
     *                  true, если возможно построить выигрышную комбинацию.
     */
    private boolean checkUpDirection(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        int count = 0;

        while (row >= 0) {
            if (count >= FIELD.getWIN_LENGTH()) {
                return true;
            }
            if (getSymbol() == PlayerSymbol.getOpponentSymbol(SYMBOL)) {
                return false;
            }
            row--;
            count++;
        }
        return false;
    }

    /**
     * Checking if the win combination may be built in the down direction.
     * Проверить направление вниз на возможность построения выигрышной комбинации.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          true if the win combination may be built in that direction.
     *                  true, если возможно построить выигрышную комбинацию.
     */
    private boolean checkDownDirection(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        int count = 0;

        while (row < FIELD.getFieldSize()) {
            if (count >= FIELD.getWIN_LENGTH()) {
                return true;
            }
            if (getSymbol() == PlayerSymbol.getOpponentSymbol(SYMBOL)) {
                return false;
            }
            row++;
            count++;
        }
        return false;
    }

    /**
     * Checking if the win combination may be built in the left direction.
     * Проверить направление влево на возможность построения выигрышной комбинации.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          true if the win combination may be built in that direction.
     *                  true, если возможно построить выигрышную комбинацию.
     */
    private boolean checkLeftDirection(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        int count = 0;

        while (column >= 0) {
            if (count >= FIELD.getWIN_LENGTH()) {
                return true;
            }
            if (getSymbol() == PlayerSymbol.getOpponentSymbol(SYMBOL)) {
                return false;
            }
            column--;
            count++;
        }
        return false;
    }

    /**
     * Checking if the win combination may be built in the right direction.
     * Проверить направление вправо на возможность построения выигрышной комбинации.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          true if the win combination may be built in that direction.
     *                  true, если возможно построить выигрышную комбинацию.
     */
    private boolean checkRightDirection(int row, int column) {
        // Logic of the method:
        // Same logic as the logic of the previous method but for other direction of the searching.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска.

        int count = 0;

        while (column < FIELD.getFieldSize()) {
            if (count >= FIELD.getWIN_LENGTH()) {
                return true;
            }
            if (getSymbol() == PlayerSymbol.getOpponentSymbol(SYMBOL)) {
                return false;
            }
            column++;
            count++;
        }
        return false;
    }

    /**
     * Attempting to block the opponent's move.
     * Попытка заблокировать ход противника.
     *
     * @return coordinates for the move or null if there is no options for move like this.
     *         координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String tryToBlock() {
        // Logic of the method:
        // 1. Get the opponent's symbol using a right method located in Enum class.
        // 2. Start the cycle that iterates all cells of the game field.
        //      Inside this cycle (check only empty cells):
        //      1. Set the temporary symbol of the opponent into the current cell.
        //      2. Check if the opponent can win that way.
        //      3. Remove the temporary symbol from the cell.
        //      4. If the opponent can win this way, return the coordinates of the current cell.
        // 3. Return null.

        // Логика метода:
        // 1. Получить символ противника, воспользовавшись методом, который находится в классе-перечислении.
        // 2. Запустить цикл, который проходит по всем ячейкам игрового поля.
        //      Внутри цикла (проверяем только незанятые ячейки):
        //      1. Установить временный символ противника в ячейку.
        //      2. Проверить, выиграет ли противник таким образом.
        //      3. Убрать временный символ из ячейки.
        //      4. Если противник может выиграть, вернуть координаты данной ячейки.
        // 3. Вернуть null.

        PlayerSymbol opponentSymbol = PlayerSymbol.getOpponentSymbol(SYMBOL);

        for (int row = 0; row < FIELD.getFieldSize(); row++) {
            for (int column = 0; column < FIELD.getFieldSize(); column++) {
                String coordinates = (column +1) + " " + (row +1);
                if (!FIELD.isCellOccupied(row, column)) {
                    FIELD.setSymbol(opponentSymbol, coordinates);
                    if (FIELD.isWin(opponentSymbol.getValue())) {
                        FIELD.setSymbol(null, coordinates);
                        return coordinates;
                    }
                    FIELD.setSymbol(null, coordinates);
                }
            }
        }
        return null;
    }

    /**
     * Attempting to finish the win combination.
     * Попытка закончить выигрышную комбинацию.
     *
     * @return coordinates for the move or null if there is no options for move like this.
     *         координаты для хода, либо null, если нет вариантов для такого хода.
     */
    private String tryToWin() {
        // Logic of the method:
        // 1. Start the cycle that iterates all cells of the game field.
        //      Inside this cycle (check only empty cells):
        //      1. Set the temporary symbol into the current cell.
        //      2. Check if the AI player can win that way.
        //      3. Remove the temporary symbol from the cell.
        //      4. If the AI player can win this way, return the coordinates of the current cell.
        // 2. Return null.

        // Логика метода:
        // 1. Запустить цикл, который проходит по всем ячейкам игрового поля.
        //      Внутри цикла (проверяем только незанятые ячейки):
        //      1. Установить временный символ в ячейку.
        //      2. Проверить, выиграет ли компьютер таким образом.
        //      3. Убрать временный символ из ячейки.
        //      4. Если компьютер может выиграть, вернуть координаты данной ячейки.
        // 2. Вернуть null.

        for (int row = 1; row <= FIELD.getFieldSize(); row++) {
            for (int cell = 1; cell <= FIELD.getFieldSize(); cell++) {
                String coordinates = cell + " " + row;
                if (!FIELD.isCellOccupied(row-1, cell-1)) {
                    FIELD.setSymbol(this.SYMBOL, coordinates);
                    if (FIELD.isWin(this.SYMBOL.getValue())) {
                        FIELD.setSymbol(null, coordinates);
                        return coordinates;
                    }
                    FIELD.setSymbol(null, coordinates);
                }
            }
        }
        return null;
    }

    /**
     * Getting a random coordinates.
     * Получить случайные координаты для хода.
     *
     * @return random coordinates / случайные координаты.
     */
    private String getRandomCoordinates() {
        // Logic of the method:
        // 1. Get the random values of row and column within the game field.
        // 2. Repeat step 1 until the empty cell is selected
        //    (use methods of the game field instance).
        // 3. Return selected row and column as a string with the space as a separator.

        // Логика метода:
        // 1. Выберите случайные значения для строки и столбца в пределах игрового поля.
        // 2. Повторяйте пункт 1 до тех пор, пока не будет выбрана свободная ячейка.
        //    (используя методы объекта игрового поля).
        // 3. Верните выбранные значения в виде строки с разделителем-пробелом.

        int fieldSize = FIELD.getFieldSize();
        while (true) {
            int randomRow = (int) (Math.random() * fieldSize);
            int randomColumn = (int) (Math.random() * fieldSize);
            String coordinates = (randomColumn + 1) + " " + (randomRow +1);

            if (!FIELD.isCellOccupied(randomRow, randomColumn)) {
                return coordinates;
            }
        }
    }

    /**
     * Transforming the coordinates into the string format.
     * Преобразование координат в строковое выражение.
     *
     * @param row       the row number / номер строки.
     * @param column    the column number / номер столбца.
     * @return          coordinates in the string format / запись координат в виде строки.
     */
        private String coordinatesToString(int row, int column) {
            // Logic of the method:
            // Return selected row and column as a string with the space as a separator.

            // Логика метода:
            // Вернуть значения строки и столбца в виде строки с разделителем-пробелом.

            return row + " " + column;
        }
}
