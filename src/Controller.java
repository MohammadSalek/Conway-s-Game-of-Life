import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private AnchorPane anchor;

    @FXML
    private Pane gridPane;

    public void initialize() {
        anchor.setMinSize(Grid.getWIDTH(), Grid.getHEIGHT());
        gridPane.getChildren().addAll(Main.getGridGroup());
    }

}