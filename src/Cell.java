import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Cell {

    private Random rand = new Random();

    final static private double rect_size = 7.5;
    final static private double stroke = 0.1;

//    final static private Color alive_color = Color.BLACK;
    final static private Color dead_color = Color.WHITE;

    private boolean isAlive;
    private int col_index;
    private int row_index;
    private boolean recently_changed = false;

    private Circle circle;
    private StackPane stackPane;

    public Cell(int col_index, int row_index) {
        isAlive = false;
        this.col_index = col_index;
        this.row_index = row_index;
        circle = new Circle(rect_size);
        circle.setFill(null);
        circle.setStroke(Color.GREY);
        circle.setStrokeWidth(stroke);
        circle.setFill(dead_color);
        stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().add(circle);
    }

    public StackPane getStackPane() {
        return stackPane;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
        if (alive) {
            int r = rand.nextInt(256);
            int g = rand.nextInt(256);
            int b = rand.nextInt(256);
            circle.setFill(Color.rgb(r, g, b));
        } else  {
            circle.setFill(dead_color);
        }
    }

    public int getCol_index() {
        return col_index;
    }

    public int getRow_index() {
        return row_index;
    }

    public void setRecently_changed(boolean recently_changed) {
        this.recently_changed = recently_changed;
    }

    public boolean isRecently_changed() {
        return recently_changed;
    }

    public static double getStroke() {
        return stroke;
    }

}
