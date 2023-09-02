import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws SQLException {
        window w = new window(); // окно будет создано здесь
    }
    public static void main(String args) {
        launch(args);
    }
}
