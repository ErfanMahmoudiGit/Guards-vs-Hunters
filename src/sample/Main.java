package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import sample.Models.Player;
import sample.Utils.FileManager;

import java.util.ArrayList;

import static sample.GetNameController.onlinePlayer;
import static sample.HardGameController.exitGame;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/Fxml/MainMenu.fxml"));
        primaryStage.setTitle("Guards vs Hunters");
        primaryStage.setScene(new Scene(root, 1100, 700));
        Image icon = new Image("/sample/View/Images/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.show();
        AudioClip backGroundMusic = new AudioClip(getClass().getResource("Audio/Sound.mp3").toExternalForm());
        backGroundMusic.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void stop(){
        exitGame = true;
        FileManager f =new FileManager();
        f.AddPlayerData(onlinePlayer);
    }
}