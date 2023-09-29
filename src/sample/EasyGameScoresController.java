package sample;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.ListView;
        import javafx.stage.Stage;
        import sample.Models.Player;
        import sample.Utils.FileManager;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.ResourceBundle;


public class EasyGameScoresController implements Initializable {
    public Button exit_game_button;
    public Button main_menu;
    public ListView list;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showScores(1);
    }

    public void showScores (int gameType){
        FileManager f = new FileManager();
        ArrayList<Player> listOfPlayers = f.ReadPlayerData();
        sortListOfPlayers(listOfPlayers);
        for (int i = 0; i<listOfPlayers.size(); i++){
            if (listOfPlayers.get(i).getGamePlayed() == gameType)
                list.getItems().add(listOfPlayers.get(i).toString());
        }
    }
    public void sortListOfPlayers(ArrayList<Player> listOfPlayers){
        try {
            int length = listOfPlayers.size();
            int maxScore, num;
            for (int i = 1; i < length; i++) {
                maxScore = listOfPlayers.get(i).getScore();
                num = i;
                for (int j = i + 1; j < length; j++) {
                    if (maxScore < listOfPlayers.get(j).getScore()) {
                        maxScore = listOfPlayers.get(j).getScore();
                        num = j;
                    }
                }
                Player player = listOfPlayers.get(i-1);
                listOfPlayers.set(i - 1, listOfPlayers.get(num));
                listOfPlayers.set(num, player);
            }
        }catch (NullPointerException e){
            System.out.println("null");
        }
    }
}