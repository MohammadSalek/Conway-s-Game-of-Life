public class Console {
    
    public static void print_grid(Grid grid) {
        System.out.println("< print grid >");
        Cell cells[][] = grid.getCells();
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[0].length; ++j) {
                Cell cell = cells[i][j];
                if (cell.isAlive()) {
                    System.out.print("A");
                } else {
                    System.out.print("D");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void print_neighbors(Grid grid, int col_index, int row_index) {
        System.out.println("< print neighbors >");
        Cell[][] neighbors = grid.get_neighbors(col_index, row_index);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                try {
                    System.out.print(neighbors[i][j].isAlive() + " ");
                } catch (NullPointerException e) {
                    System.out.print(null + " ");
                }
            }
            System.out.println();
        }
    }
    
}
