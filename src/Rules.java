public class Rules {

    public static void apply(Grid grid) {
        Cell[][] cells = grid.getCells();
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[0].length; ++j) {
                Cell cell = cells[i][j];
                Cell[][] neighbors = grid.get_neighbors(i, j);
                int alive_neighbors = 0;
                for (int k = 0; k < 3; ++k) {
                    for (int q = 0; q < 3; ++q) {
                        if (k == 1 && q == 1) {
                            continue;
                        }
                        try {
                            Cell neighbor = neighbors[k][q];
                            if (neighbor.isAlive()) {
                                if (!neighbor.isRecently_changed()) {
                                    ++alive_neighbors;
                                }
                            } else {
                                if (neighbor.isRecently_changed()) {
                                    ++alive_neighbors;
                                }
                            }
                        } catch (NullPointerException e) { }
                    }
                }
                if (cell.isAlive()) {
                    if (alive_neighbors < 2 || alive_neighbors > 3) {
                        cell.setAlive(false);
                        cell.setRecently_changed(true);
                    }
                } else {
                    if (alive_neighbors == 3) {
                        cell.setAlive(true);
                        cell.setRecently_changed(true);
                    }
                }
            }
        }

        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[0].length; ++j) {
                cells[i][j].setRecently_changed(false);
            }
        }
    }

}
