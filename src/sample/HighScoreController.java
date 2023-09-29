package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HighScoreController {
    public Button exit_game_button;
    public Button main_menu;

    public void exit(ActionEvent actionEvent) {
        Stage stage = (Stage) exit_game_button.getScene().getWindow();
        stage.close();
    }

    public void mainMenu(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) exit_game_button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/Fxml/MainMenu.fxml"));
        Parent root = loader.load();
        MainMenuController controller = loader.getController();
        primaryStage.setScene(new Scene(root, 1100, 700));
        primaryStage.show();
    }
}