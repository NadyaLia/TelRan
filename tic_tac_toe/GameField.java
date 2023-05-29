package Homework.tic_tac_toe;

public class GameField {
    /**
     * Array containing the game field
     * Массив, содержащий игровое поле
     */
    public char[][] field;

    /**
     * Value of an empty cell
     * Значение для пустой ячейки
     */
    private final char EMPTY_CELL = '.';

    /**
     * Constructor
     * Конструктор
     */
    public GameField() {
        // When this constructor is called, initial filling of the game field should be performed.
        // При вызове конструктора должно производиться первоначальное заполнение игрового поля.
        initialize();
    }

    /**
     * Initial filling of the game field
     * Первоначальное заполнение игрового поля
     */
    public void initialize() {
        // Logic of the method:
        // 1. Initialize the "field" field with an array of the desired size (3 rows, 3 columns).
        // 2. Fill all cells of the array with the value for an empty cell.

        // Логика метода:
        // 1. Инициализировать поле field массивом нужного размера (3 х 3).
        // 2. Пройтись по всему массиву и заполнить все его элементы значением для пустой ячейки.
        this.field = new char[3][3];

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


        if (row < 0 || row > 2) {
            System.out.println("Incorrect input of coordinates");
            return false;
        }

        if (cell < 0 || cell > 2) {
            System.out.println("Incorrect input of coordinates");
            return false;
        }

        char value = field[row][cell];

        if (value != '.') {
            System.out.println("Field is already occupied");
            return false;
        }

        this.field[row][cell] = symbol.getValue();

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
        // Return true if at least one of the methods checkRows, checkColumns, checkDiagonals returns true.

        // Логика метода:
        // Вернуть true, если хотя бы один из методов checkRows, checkColumns, checkDiagonals вернёт true.
        if (checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol) == true) {
            return true;
        }
        return false;
    }

    /**
     * Check if the win combination present in any of rows of the game field
     * Проверка, присутствует ли в каком-либо ряду выигрышная комбинация
     *
     * @param symbol player symbol / символ игрока
     * @return true if the win combination present in any of rows of the game field
     * true, если выигрышная комбинация присутствует в каком-либо ряду
     */
    boolean checkRows(char symbol) {
        // Logic of the method:
        // Check all the rows of the game field, return true if one of them is completely filled with player symbols.

        // Логика метода:
        // Пройтись по всем строкам массива и вернуть true, если хотя бы одна из них полностью заполнена символами игрока.

        for (char[] row : field) {
            for (int i = 0; i < row.length; i++) {

                if (field[i][0] == symbol && field[i][1] == symbol && field[i][2] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the win combination present in any of columns of the game field
     * Проверка, присутствует ли в каком-либо столбце выигрышная комбинация
     *
     * @param symbol player symbol / символ игрока
     * @return true if the win combination present in any of columns of the game field
     * true, если выигрышная комбинация присутствует в каком-либо столбце
     */
    boolean checkColumns(char symbol) {
        // Logic of the method:
        // Check all the columns of the game field, return true if one of them is completely filled with player symbols.

        // Логика метода:
        // Пройтись по всем столбцам массива и вернуть true, если хотя бы один из них полностью заполнен символами игрока.
        for (char[] row : field) {
            for (int i = 0; i < row.length; i++) {

                if (field[0][i] == symbol && field[1][i] == symbol && field[2][i] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the win combination present in any of diagonals of the game field
     * Проверка, присутствует ли в одной из диагоналей выигрышная комбинация
     *
     * @param symbol player symbol / символ игрока
     * @return true if the win combination present in any of diagonals of the game field
     * true, если выигрышная комбинация присутствует в одной из диагоналей
     */
    boolean checkDiagonals(char symbol) {
        // Logic of the method:
        // Check all the diagonals of the game field, return true if one of them is completely filled with player symbols.

        // Логика метода:
        // Вернуть true, если хотя бы одна из диагоналей полностью заполнена символами игрока.
        for (char[] row : field) {
            for (int i = 0; i < row.length; i++) {

                if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol ||
                        field[2][0] == symbol && field[1][1] == symbol && field[0][2] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }
}

