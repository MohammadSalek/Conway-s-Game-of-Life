import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Grid grid;

    @Override
    public void start(Stage primaryStage) throws Exception {

        init_grid();

        primaryStage.setTitle("Conway's Game of Life");
        final FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("app.fxml"));
        fxmlLoader.setController(new Controller());
        final Parent root = fxmlLoader.load();
        Scene mainScene = new Scene(root);
        primaryStage.setResizable(false);
        primaryStage.setScene(mainScene);

        boolean start = true;
        new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long currentNanoTime) {
                if (currentNanoTime - lastUpdate >= 70_000_000) {
                    if (start) {
                        Rules.apply(grid);
                        lastUpdate = currentNanoTime;
                    }
                }
            }
        }.start();
        primaryStage.show();
    }

    private static void init_grid() {
        grid = new Grid(29, 29);
//        Shape.blinker(grid, 4, 4);
//        Shape.beacon(grid,2, 2);
        Shape.random(grid, 500);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Group getGridGroup() {
        return grid.getGroup();
    }

}
