package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HighScoreMenuController {

    public Button exit_game_button;
    public Button see_easy_game;
    public Button see_normal_game;
    public Button see_hard_game;
    public Button main_menu;

    public void seeEasyGame(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) exit_game_button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/Fxml/Scores/EasyGameScores.fxml"));
        Parent root = loader.load();
        EasyGameScoresController controller = loader.getController();
        primaryStage.setScene(new Scene(root, 1100, 700));
        primaryStage.show();
    }

    public void seeNormalGame(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) exit_game_button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/Fxml/Scores/NormalGameScores.fxml"));
        Parent root = loader.load();
        NormalGameScoresController controller = loader.getController();
        primaryStage.setScene(new Scene(root, 1100, 700));
        primaryStage.show();
    }

    public void seeHardGame(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = (Stage) exit_game_button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/Fxml/Scores/HardGameScores.fxml"));
        Parent root = loader.load();
        HardGameScoresController controller = loader.getController();
        primaryStage.setScene(new Scene(root, 1100, 700));
        primaryStage.show();
    }

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