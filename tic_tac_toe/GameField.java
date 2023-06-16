package Homework.tic_tac_toe;

public class GameField {
    /**
     * Array containing the game field
     * Массив, содержащий игровое поле
     */
    private char[][] field;

    /**
     * Value of an empty cell
     * Значение для пустой ячейки
     */
    private final char EMPTY_CELL = '.';

    /**
     * Size of the game field.
     * Размер игрового поля.
     */
    private final int FIELD_SIZE;

    /**
     * Length of the win combination.
     * Длина выигрышной комбинации.
     */
    private final int WIN_LENGTH;

    /**
     * Constructor.
     * Конструктор.
     *
     * @param fieldSize size of the game field / размер игрового поля.
     */
    public GameField(int fieldSize, int winLength) {
        // Implement the constructor body.
        // When this constructor is called, initial filling of the game field should be performed.
        // Реализовать тело конструктора.
        // При вызове конструктора должно производиться первоначальное заполнение игрового поля.
        this.FIELD_SIZE = fieldSize;
        this.WIN_LENGTH = winLength;
        initialize();
    }

    /**
     * Initial filling of the game field
     * Первоначальное заполнение игрового поля
     */
    public void initialize() {
        // Logic of the method:
        // 1. Initialize the "field" field with an array of the selected size.
        // 2. Fill all cells of the array with the value for an empty cell.

        // Логика метода:
        // 1. Инициализировать поле field массивом выбранного размера.
        // 2. Пройтись по всему массиву и заполнить все его элементы значением для пустой ячейки.

        this.field = new char[FIELD_SIZE][FIELD_SIZE];

        for (char[] row : field) {
            for (int i = 0; i < row.length; i++) {
                row[i] = EMPTY_CELL;
            }
        }
    }

    /**
     * Print the game field to the console
     * Вывести игровое поле в консоль
     */
    public void repaint() {
        // Logic of the method:
        // Print the array to the console. Each row should be printed in a new line.
        // Symbols within one row should be separated by a space.

        // Логика метода:
        // Вывести массив, содержащий игровое поле, в консоль.
        // При этом каждая строка массива должна выводиться в новой строке,
        // а символы одной строки должны быть отделены друг от друга пробелом.

        System.out.println("---------------------");
        for (char[] row : field) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }

    /**
     * Put the player symbol in the chosen cell
     * Проставить символ игрока в нужное поле
     *
     * @param symbol      player symbol (X or O) / символ игрока (Х или О)
     * @param coordinates coordinates in string format / координаты в виде строки
     *                    Coordinates must be in string format with a space as a splitter, example - "2 3".
     *                    Координаты должны передаваться в виде строки с разделителем-пробелом, пример - "2 3".
     * @return true, if the move was success and player symbol putted in chosen cell correctly
     * true, если ход выполнен успешно, символ игрока проставлен в поле
     */
    public boolean setSymbol(PlayerSymbol symbol, String coordinates) {
        // Logic of the method:
        // 1. Transform the coordinates into the String type array by dividing with a space.
        // 2. Return false if size of the array is different from 2.
        // 3. Parse the coordinates into the int type. Return false if any exception occurred during that.
        // 4. Check if the selected cell is already occupied. Return false in the case of that.
        // 5. Put the player symbol in the selected cell.
        // 6. Return false if any exception occurred during execution of steps 4 and 5.
        // 7. Return true. Reaching the end of the method means the move is correctly performed.

        // Логика метода:
        // 1. Разбиваем полученные координаты на два значения.
        // 2. Проверяем, если число координат - не 2, возвращаем false.
        // 3. Парсим координаты в числовой тип. В случае ошибки парсинга возвращаем false.
        // 4. Проверяем не занята ли выбранная ячейка. Если занята - возвращаем false.
        // 5. Заполняем выбранную ячейку символом игрока.
        // 6. В случае ошибок в пунктах 4 и 5 возвращаем false.
        // 7. В конце метода возвращаем true (если дошли до конца метода, значит ход успешен).

        String[] co = coordinates.split(" ");

        if (co.length != 2) {
            System.out.println("Incorrect input of coordinates");
            return false;
        }

        int row = Integer.parseInt(co[1]) - 1;
        int cell = Integer.parseInt(co[0]) - 1;


        if (row < 0 || row > getFieldSize()) {
            System.out.println("Incorrect input of coordinates");
            return false;
        }

        if (cell < 0 || cell > getFieldSize()) {
            System.out.println("Incorrect input of coordinates");
            return false;
        }

        if (isCellOccupied(row, cell)) {
            System.out.println("Field is already occupied");
            return false;
        }

        this.field[row][cell] = symbol.getValue();

        return true;
    }

    /**
     * Check if the selected cell is already occupied.
     * Проверка, занята ли выбранная ячейка.
     *
     * @param row       row number / номер строки.
     * @param column    column number / номер столбца.
     * @return          true if the cell is already occupied.
     *                  true, если ячейка занята.
     */
    public boolean isCellOccupied(int row, int column) {
        // Logic of the method:
        // 1. Return true if the selected cell is already occupied.

        // Логика метода:
        // 1. Вернуть true, если выбранная ячейка занята.
        char value = field[row][column];

        if (value != '.') {
            System.out.println("Cell is already occupied");
        }
        return true;
    }

    /**
     * Check if game field is completely filled
     * Проверка, заполнено ли поле
     *
     * @return true if game field is completely filled with players symbols
     * true, если поле полностью заполнено символами игроков
     */
    boolean isFieldFull() {
        // Logic of the method:
        // Return false if at least one empty cell present in the game field, otherwise return true.

        // Логика метода:
        // Вернуть false, если есть хотя бы одна пустая ячейка, иначе вернуть true.
        for (char[] row : field) {
            for (int i = 0; i < row.length; i++) {

                if (row[i] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if the win combination present in the game field
     * Проверка, присутствует ли на поле выигрышная комбинация
     *
     * @param symbol player symbol / символ игрока
     * @return true if the win combination present in the game field
     * true, если выигрышная комбинация присутствует на поле
     */
    boolean isWin(char symbol) {
        // Logic of the method:
        // 1. Use cycle to go through all the cells of the game field.
        // 2. For each cell call the methods that check the presence of the win combination
        //    in four directions. Return true if at least one win combination found.

        // Логика метода:
        // 1. Пройти циклом по всем ячейкам игрового поля.
        // 2. Для каждой ячейки вызвать методы, проверяющие наличие выигрышной комбинации
        //    в четырёх направлениях. Если найдётся хотя бы одна комбинация, вернуть true.

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (checkUpRightDiagonal(i, j, symbol)
                        || checkDownRightDiagonal(i, j, symbol)
                        || checkRightDirection(i, j, symbol)
                        || checkDownDirection(i, j, symbol)
                ) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if there is a win combination in the up and right direction from the selected cell.
     * Проверяем наличие выигрышной комбинации по направлению вверх и вправо от указанной ячейки.
     *
     * @param x         x coordinate / координата ячейки x.
     * @param y         y coordinate / координата ячейки y.
     * @param symbol    player symbol / символ игрока.
     * @return          true if there is a win combination.
     *                  true, если нашли выигрышную комбинацию.
     */
    private boolean checkUpRightDiagonal(int x, int y, char symbol) {
        // Logic of the method:
        // 1. Use a variable as the counter of the player symbols.
        // 2. Start the cycle, the number of iterations of which is equal to the win combination length.
        //      Inside the cycle:
        //      1. Increment the counter if the current cell contains the player symbol.
        //      2. Change the coordinates so that the next cell is located up and right from the current cell.
        //      3. An exception here means going out of bounds of the array,
        //         and that means there is no win combination present. In that case return false.
        // 3. Return true if counter value is equal to the win combination length, otherwise return false.

        // Логика метода:
        // 1. Используем переменную в качестве счётчика символов игрока.
        // 2. Запускаем цикл, количество итераций которого равно длине выигрышной комбинации.
        //      Внутри цикла:
        //      1. Если в текущей ячейке стоит символ игрока - увеличить счётчик.
        //      2. Изменить координаты таким образом, чтобы следующая проверяемая ячейка была выше и правее текущей.
        //      3. Если вылетает ошибка, значит вышли за пределы массива,
        //         а это значит, выигрышной комбинации нет, вернуть false.
        // 3. Вернуть true, если значение счётчика равно значению длины выигрышной комбинации, иначе вернуть false.

        int countSymbols = 0;
        for (int i = 0; i <= WIN_LENGTH; i++) {
            if (field[x][y] == symbol) {
                countSymbols++;
                x++;
                y++;
            }
            if (field.length <= x) {
                return false;
            }
            if (field[x].length <= y) {
                return false;
            }
        }
        if (countSymbols == WIN_LENGTH) {
            return true;
        }
        return false;
    }

    /**
     * Check if there is a win combination in the down and right direction from the selected cell.
     * Проверяем наличие выигрышной комбинации по направлению вниз и вправо от указанной ячейки.
     *
     * @param x         x coordinate / координата ячейки x.
     * @param y         y coordinate / координата ячейки y.
     * @param symbol    player symbol / символ игрока.
     * @return          true if there is a win combination.
     *                  true, если нашли выигрышную комбинацию.
     */
    private boolean checkDownRightDiagonal(int x, int y, char symbol) {
        // Logic of the method:
        // Same logic as the logic of the previous method but other direction of the searching of the win combination.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска выигрышной комбинации.

        int countSymbols = 0;
        for (int i = 0; i <= WIN_LENGTH; i++) {
            if (field[x][y] == symbol) {
                countSymbols++;
                x--;
                y--;
            }
            if (field.length <= x) {
                return false;
            }
            if (field[x].length <= y) {
                return false;
            }
        }
        if (countSymbols == WIN_LENGTH) {
            return true;
        }
        return false;
    }

    /**
     * Check if there is a win combination in the right direction from the selected cell.
     * Проверяем наличие выигрышной комбинации по направлению вправо от указанной ячейки.
     *
     * @param x         x coordinate / координата ячейки x.
     * @param y         y coordinate / координата ячейки y.
     * @param symbol    player symbol / символ игрока.
     * @return          true if there is a win combination.
     *                  true, если нашли выигрышную комбинацию.
     */
    private boolean checkRightDirection(int x, int y, char symbol) {
        // Logic of the method:
        // Same logic as the logic of the previous method but other direction of the searching of the win combination.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска выигрышной комбинации.

        int countSymbols = 0;
        for (int i = 0; i <= WIN_LENGTH; i++) {
            if (field[x][y] == symbol) {
                countSymbols++;
                x++;
            }
            if (field.length <= x) {
                return false;
            }
            if (field[x].length <= y) {
                return false;
            }
        }
        if (countSymbols == WIN_LENGTH) {
            return true;
        }
        return false;
    }

    /**
     * Check if there is a win combination in the down direction from the selected cell.
     * Проверяем наличие выигрышной комбинации по направлению вниз от указанной ячейки.
     *
     * @param x         x coordinate / координата ячейки x.
     * @param y         y coordinate / координата ячейки y.
     * @param symbol    player symbol / символ игрока.
     * @return          true if there is a win combination.
     *                  true, если нашли выигрышную комбинацию.
     */
    private boolean checkDownDirection(int x, int y, char symbol) {
        // Logic of the method:
        // Same logic as the logic of the previous method but other direction of the searching of the win combination.

        // Логика метода:
        // Та же логика, что у предыдущего метода, только другое направление поиска выигрышной комбинации.

        int countSymbols = 0;
        for (int i = 0; i <= WIN_LENGTH; i++) {
            if (field[x][y] == symbol) {
                countSymbols++;
                y--;
            }
            if (field.length <= x) {
                return false;
            }
            if (field[x].length <= y) {
                return false;
            }
        }
        if (countSymbols == WIN_LENGTH) {
            return true;
        }
        return false;
    }

    /**
     * Getter.
     * Геттер.
     *
     * @return size of the game field / размер игрового поля.
     */
    public int getFieldSize() {
        // Implement the getter body.
        // Реализовать тело геттера.

        return FIELD_SIZE;
    }
}