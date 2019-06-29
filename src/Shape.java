import java.util.concurrent.ThreadLocalRandom;

public class Shape {

    public static void blinker(Grid grid, int col, int row) {
        Cell[][] cells = grid.getCells();
        cells[col][row].setAlive(true);
        cells[col][row + 1].setAlive(true);
        cells[col][row + 2].setAlive(true);
    }

    public static void beacon(Grid grid, int col, int row) {
        Cell[][] cells = grid.getCells();
        cells[col][row].setAlive(true);
        cells[col][row + 1].setAlive(true);
        cells[col + 1][row].setAlive(true);
        cells[col + 1][row + 1].setAlive(true);
        cells[col + 2][row + 2].setAlive(true);
        cells[col + 2][row + 3].setAlive(true);
        cells[col + 3][row + 2].setAlive(true);
        cells[col + 3][row + 3].setAlive(true);
    }

    public static void random(Grid grid, int random_cell_num) {
        Cell[][] cells = grid.getCells();
        for (int i = 0; i < random_cell_num; ++i) {
            int col = ThreadLocalRandom.current().nextInt(0, grid.getCol());
            int row = ThreadLocalRandom.current().nextInt(0, grid.getRow());
            cells[col][row].setAlive(true);
        }
    }

}
