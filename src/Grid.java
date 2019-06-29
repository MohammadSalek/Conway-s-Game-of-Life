import javafx.scene.Group;

public class Grid {

    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    private final double strokeWidth = Cell.getStroke();

    private Cell[][] cells;
    private int col;
    private int row;

    private Group group;
    private double cell_size;

    public Grid(int col, int row) {
        this.row = row;
        this.col = col;
        group = new Group();
        cell_size = ((float)WIDTH / row) - strokeWidth * 2;
        cells = new Cell[col][row];
        for (int i = 0; i < col; ++i) {
            for (int j = 0; j < row; ++j) {
                cells[i][j] = new Cell(i, j);
                putOnGrid(cells[i][j], i, j);
            }
        }
    }

    private void putOnGrid(Cell cell, int col_index, int row_index) {
        cell.getStackPane().setTranslateX((cell_size + strokeWidth * 2) * col_index);
        cell.getStackPane().setTranslateY((cell_size + strokeWidth * 2) * row_index);
        group.getChildren().add(cell.getStackPane());
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell[][] get_neighbors(int col_index, int row_index) {
        Cell[][] neighbors = new Cell[3][3];
        loop:
            for (int i = 0; i < col; ++i) {
                for (int j = 0; j < row; ++j) {
                    if (col_index == i && row_index == j) {
                        for (int k = -1; k <= 1; ++k) {
                            for (int q = -1; q <= 1; ++q) {
                                try {
                                    Cell neighbor = cells[i + k][j + q];
                                    neighbors[k + 1][q + 1] = neighbor;
                                } catch (IndexOutOfBoundsException e) {
                                    neighbors[k + 1][q + 1] = null;
                                }
                            }
                        }
                        break loop;
                    }
                }
        }
        return neighbors;
    }

    public Group getGroup() {
        return group;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}
