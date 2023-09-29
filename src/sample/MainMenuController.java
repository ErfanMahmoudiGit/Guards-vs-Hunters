package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    public Button start_a_new_game_button;
    public Button high_score_button;
    public Button exit_game_button;
    public AnchorPane rootPane;

    public void startNewGame(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) exit_game_button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/Fxml/GetName.fxml"));
        Parent root = loader.load();
        GetNameController controller = loader.getController();
        primaryStage.setScene(new Scene(root, 1100, 700));
        primaryStage.show();
    }

    public void highScore(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) start_a_new_game_button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/Fxml/HighScoreMenu.fxml"));
        Parent root = loader.load();
        HighScoreMenuController controller = loader.getController();
        primaryStage.setScene(new Scene(root, 1100, 700));
        primaryStage.show();
    }

    public void exit(ActionEvent actionEvent){
        Stage stage = (Stage) exit_game_button.getScene().getWindow();
        stage.close();
    }
}