package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Models.Player;

import java.io.IOException;

public class GetNameController {
    public static Player onlinePlayer = new Player();
    public Button exit_game_button;
    public Button main_menu;
    public TextField name_enter_field;
    public AnchorPane anchorPane;

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

    public void name_entered(ActionEvent actionEvent) throws IOException {

        onlinePlayer.setName(name_enter_field.getText());
        onlinePlayer.setMoney(1000);
        onlinePlayer.setScore(0);

            Stage primaryStage = (Stage) exit_game_button.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View/Fxml/NewGameMenu.fxml"));
            Parent root = loader.load();
            NewGameMenuController controller = loader.getController();
            primaryStage.setScene(new Scene(root, 1100, 700));
            primaryStage.show();
}
}