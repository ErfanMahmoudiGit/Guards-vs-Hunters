package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import static sample.GetNameController.onlinePlayer;

public class EndingWindowController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            score_label.setText("Your Score is: "+ onlinePlayer.getScore());
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException thrown!");
        }

    }
    public Button exit_game_button;
    public Label score_label;

    public void exit(ActionEvent actionEvent){
        Stage stage = (Stage) exit_game_button.getScene().getWindow();
        stage.close();
    }
}
