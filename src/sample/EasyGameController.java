package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import sample.Models.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import static sample.GetNameController.onlinePlayer;

public class EasyGameController implements Initializable {
    public static boolean exitGame = false;
    public static boolean pauseGame = false;

    public static ArrayList<SimpleHunter> listOfSimpleHunters = new ArrayList();
    public static ArrayList<ExplosiveHunter> listOfExplosiveHunters = new ArrayList();
    public static ArrayList<SimpleGuard> listOfSimpleGuards = new ArrayList();
    public static ArrayList<MineGuard> listOfMineGuards = new ArrayList();
    public static int counterOfHunters = -1;
    public static int counterOfSimpleGuards = -1;
    public static int counterOfMineGuards = -1;
    public static int counterOfExplosiveHunters = -1;

    public static int speedIncrease = 0;
    public static int damageIncrease = 0;
    public static int generateSpeedIncrease = 0;

    public int selectedGuardType;

    public Button pause_button;
    public Button exit_game_button;
    public Button main_menu;
    public Button continue_game_button;
    public AnchorPane myAnchorPane;
    public Label score_label;
    public Label name_label;
    public Label money_label;
    // rectangles
    public Rectangle rectangle_1_1;
    public Rectangle rectangle_1_2;
    public Rectangle rectangle_1_3;
    public Rectangle rectangle_1_4;
    public Rectangle rectangle_1_5;
    public Rectangle rectangle_1_6;
    public Rectangle rectangle_2_1;
    public Rectangle rectangle_2_2;
    public Rectangle rectangle_2_3;
    public Rectangle rectangle_2_4;
    public Rectangle rectangle_2_5;
    public Rectangle rectangle_2_6;
    public Rectangle rectangle_3_1;
    public Rectangle rectangle_3_2;
    public Rectangle rectangle_3_3;
    public Rectangle rectangle_3_4;
    public Rectangle rectangle_3_5;
    public Rectangle rectangle_3_6;
    public Rectangle rectangle_4_1;
    public Rectangle rectangle_4_2;
    public Rectangle rectangle_4_3;
    public Rectangle rectangle_4_4;
    public Rectangle rectangle_4_5;
    public Rectangle rectangle_4_6;
    public Rectangle rectangle_5_1;
    public Rectangle rectangle_5_2;
    public Rectangle rectangle_5_3;
    public Rectangle rectangle_5_4;
    public Rectangle rectangle_5_5;
    public Rectangle rectangle_5_6;
    public Rectangle rectangle_6_1;
    public Rectangle rectangle_6_2;
    public Rectangle rectangle_6_3;
    public Rectangle rectangle_6_4;
    public Rectangle rectangle_6_5;
    public Rectangle rectangle_6_6;
    // these booleans are used to check if a rectangle already has a guard or not
    public boolean rectangle_1_1_has_guard = false;
    public boolean rectangle_1_2_has_guard = false;
    public boolean rectangle_1_3_has_guard = false;
    public boolean rectangle_1_4_has_guard = false;
    public boolean rectangle_1_5_has_guard = false;
    public boolean rectangle_1_6_has_guard = false;
    public boolean rectangle_2_1_has_guard = false;
    public boolean rectangle_2_2_has_guard = false;
    public boolean rectangle_2_3_has_guard = false;
    public boolean rectangle_2_4_has_guard = false;
    public boolean rectangle_2_5_has_guard = false;
    public boolean rectangle_2_6_has_guard = false;
    public boolean rectangle_3_1_has_guard = false;
    public boolean rectangle_3_2_has_guard = false;
    public boolean rectangle_3_3_has_guard = false;
    public boolean rectangle_3_4_has_guard = false;
    public boolean rectangle_3_5_has_guard = false;
    public boolean rectangle_3_6_has_guard = false;
    public boolean rectangle_4_1_has_guard = false;
    public boolean rectangle_4_2_has_guard = false;
    public boolean rectangle_4_3_has_guard = false;
    public boolean rectangle_4_4_has_guard = false;
    public boolean rectangle_4_5_has_guard = false;
    public boolean rectangle_4_6_has_guard = false;
    public boolean rectangle_5_1_has_guard = false;
    public boolean rectangle_5_2_has_guard = false;
    public boolean rectangle_5_3_has_guard = false;
    public boolean rectangle_5_4_has_guard = false;
    public boolean rectangle_5_5_has_guard = false;
    public boolean rectangle_5_6_has_guard = false;
    public boolean rectangle_6_1_has_guard = false;
    public boolean rectangle_6_2_has_guard = false;
    public boolean rectangle_6_3_has_guard = false;
    public boolean rectangle_6_4_has_guard = false;
    public boolean rectangle_6_5_has_guard = false;
    public boolean rectangle_6_6_has_guard = false;
    ////////////////////////////////////////////////////
    public ImageView simple_guard_icon;
    public ImageView mine_guard_icon;
    // rectangle images
    public ImageView rectangle_image_1_1;
    public ImageView rectangle_image_1_2;
    public ImageView rectangle_image_1_3;
    public ImageView rectangle_image_1_4;
    public ImageView rectangle_image_1_5;
    public ImageView rectangle_image_1_6;
    public ImageView rectangle_image_2_1;
    public ImageView rectangle_image_2_2;
    public ImageView rectangle_image_2_3;
    public ImageView rectangle_image_2_4;
    public ImageView rectangle_image_2_5;
    public ImageView rectangle_image_2_6;
    public ImageView rectangle_image_3_1;
    public ImageView rectangle_image_3_2;
    public ImageView rectangle_image_3_3;
    public ImageView rectangle_image_3_4;
    public ImageView rectangle_image_3_5;
    public ImageView rectangle_image_3_6;
    public ImageView rectangle_image_4_1;
    public ImageView rectangle_image_4_2;
    public ImageView rectangle_image_4_3;
    public ImageView rectangle_image_4_4;
    public ImageView rectangle_image_4_5;
    public ImageView rectangle_image_4_6;
    public ImageView rectangle_image_5_1;
    public ImageView rectangle_image_5_2;
    public ImageView rectangle_image_5_3;
    public ImageView rectangle_image_5_4;
    public ImageView rectangle_image_5_5;
    public ImageView rectangle_image_5_6;
    public ImageView rectangle_image_6_1;
    public ImageView rectangle_image_6_2;
    public ImageView rectangle_image_6_3;
    public ImageView rectangle_image_6_4;
    public ImageView rectangle_image_6_5;
    public ImageView rectangle_image_6_6;
    //// row controller
    public boolean row1Active = true;
    public boolean row2Active = true;
    public boolean row3Active = true;
    public boolean row4Active = true;
    public boolean row5Active = true;
    public boolean row6Active = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // activate row check controller
            onlinePlayer.setGamePlayed(1);
            // initializing score and name and money amount
            score_label.setText(String.valueOf(onlinePlayer.getScore()));
            name_label.setText(onlinePlayer.getName());
            money_label.setText(onlinePlayer.getMoney() + " $");
            // generating objects
            randomHunterGeneratorCaller();
            randomMoneyBoxGenerator();
            RandomMineHunterGeneratorCaller();
            // start increasing damage and speed of hunters
            increaseDamageAndSpeed();
            // setting up room
            setUpRoom();
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException thrown!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void checkRows() throws IOException {
        if (!row1Active) {
            rectangle_1_1_has_guard = true;
            rectangle_1_2_has_guard = true;
            rectangle_1_3_has_guard = true;
            rectangle_1_4_has_guard = true;
            rectangle_1_5_has_guard = true;
            rectangle_1_6_has_guard = true;
            Platform.runLater(() -> {
                myAnchorPane.getChildren().remove(rectangle_1_1);
                myAnchorPane.getChildren().remove(rectangle_1_2);
                myAnchorPane.getChildren().remove(rectangle_1_3);
                myAnchorPane.getChildren().remove(rectangle_1_4);
                myAnchorPane.getChildren().remove(rectangle_1_5);
                myAnchorPane.getChildren().remove(rectangle_1_6);
            });
        }
        if (!row2Active) {
            rectangle_2_1_has_guard = true;
            rectangle_2_2_has_guard = true;
            rectangle_2_3_has_guard = true;
            rectangle_2_4_has_guard = true;
            rectangle_2_5_has_guard = true;
            rectangle_2_6_has_guard = true;
            Platform.runLater(() -> {
                myAnchorPane.getChildren().remove(rectangle_2_1);
                myAnchorPane.getChildren().remove(rectangle_2_2);
                myAnchorPane.getChildren().remove(rectangle_2_3);
                myAnchorPane.getChildren().remove(rectangle_2_4);
                myAnchorPane.getChildren().remove(rectangle_2_5);
                myAnchorPane.getChildren().remove(rectangle_2_6);
            });
        }
        if (!row3Active) {
            rectangle_3_1_has_guard = true;
            rectangle_3_2_has_guard = true;
            rectangle_3_3_has_guard = true;
            rectangle_3_4_has_guard = true;
            rectangle_3_5_has_guard = true;
            rectangle_3_6_has_guard = true;
            Platform.runLater(() -> {
                myAnchorPane.getChildren().remove(rectangle_3_1);
                myAnchorPane.getChildren().remove(rectangle_3_2);
                myAnchorPane.getChildren().remove(rectangle_3_3);
                myAnchorPane.getChildren().remove(rectangle_3_4);
                myAnchorPane.getChildren().remove(rectangle_3_5);
                myAnchorPane.getChildren().remove(rectangle_3_6);
            });
        }
        if (!row4Active) {
            rectangle_4_1_has_guard = true;
            rectangle_4_2_has_guard = true;
            rectangle_4_3_has_guard = true;
            rectangle_4_4_has_guard = true;
            rectangle_4_5_has_guard = true;
            rectangle_4_6_has_guard = true;
            Platform.runLater(() -> {
                myAnchorPane.getChildren().remove(rectangle_4_1);
                myAnchorPane.getChildren().remove(rectangle_4_2);
                myAnchorPane.getChildren().remove(rectangle_4_3);
                myAnchorPane.getChildren().remove(rectangle_4_4);
                myAnchorPane.getChildren().remove(rectangle_4_5);
                myAnchorPane.getChildren().remove(rectangle_4_6);
            });
        }
        if (!row5Active) {
            rectangle_5_1_has_guard = true;
            rectangle_5_2_has_guard = true;
            rectangle_5_3_has_guard = true;
            rectangle_5_4_has_guard = true;
            rectangle_5_5_has_guard = true;
            rectangle_5_6_has_guard = true;
            Platform.runLater(() -> {
                myAnchorPane.getChildren().remove(rectangle_5_1);
                myAnchorPane.getChildren().remove(rectangle_5_2);
                myAnchorPane.getChildren().remove(rectangle_5_3);
                myAnchorPane.getChildren().remove(rectangle_5_4);
                myAnchorPane.getChildren().remove(rectangle_5_5);
                myAnchorPane.getChildren().remove(rectangle_5_6);
            });
        }
        if (!row6Active) {
            rectangle_6_1_has_guard = true;
            rectangle_6_2_has_guard = true;
            rectangle_6_3_has_guard = true;
            rectangle_6_4_has_guard = true;
            rectangle_6_5_has_guard = true;
            rectangle_6_6_has_guard = true;
            Platform.runLater(() -> {
                myAnchorPane.getChildren().remove(rectangle_6_1);
                myAnchorPane.getChildren().remove(rectangle_6_2);
                myAnchorPane.getChildren().remove(rectangle_6_3);
                myAnchorPane.getChildren().remove(rectangle_6_4);
                myAnchorPane.getChildren().remove(rectangle_6_5);
                myAnchorPane.getChildren().remove(rectangle_6_6);
            });
        }
        if (!row1Active && !row2Active && !row3Active && !row4Active && !row5Active && !row6Active) {
            exitGame = true;
            pauseGame = true;
            try {
                Stage primaryStage = (Stage) pause_button.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("View/Fxml/EndingWindow.fxml"));
                Parent root = loader.load();
                EndingWindowController controller = loader.getController();
                primaryStage.setScene(new Scene(root, 1100, 700));
                primaryStage.show();
                AudioClip gameOver = new AudioClip(getClass().getResource("Audio/GameOver.mp3").toExternalForm());
                gameOver.play();
            } catch (NullPointerException e) {
                System.out.println("NullPointerException thrown!");
            }
        }
    }

    //Game pause menu methods..............................................
    public void exit(ActionEvent actionEvent) {
        exit_game_button.getScene().getWindow().hide();
        exitGame = true;
        Platform.exit();
    }

    public void continueGame(ActionEvent actionEvent) {
        Stage stage = (Stage) exit_game_button.getScene().getWindow();
        stage.close();
        pauseGame = false;
    }
    //.............................................
    // pause button selected -> open pause menu
    public void pauseMenu(ActionEvent actionEvent) throws IOException {
        pauseGame = true;
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/Fxml/PauseWindow.fxml"));
        Parent root = loader.load();
        HardGameController controller = loader.getController();
        primaryStage.setTitle("...Paused...");
        primaryStage.setScene(new Scene(root, 600, 400));
        Image icon = new Image("/sample/View/Images/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void hunterGenerator(int x, int y) {
        Image image = new Image("/sample/View/Images/covidGreen1.png");
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(90);
        imageView.setFitHeight(90);
        imageView.setPreserveRatio(true);
        myAnchorPane.getChildren().add(imageView);
        //create hunter object
        SimpleHunter hunter = new SimpleHunter();
        hunter.setX(x);
        hunter.setY(y);
        hunter.setActive(true);
        hunter.setCanMove(true);
        hunter.setHealth(3);
        listOfSimpleHunters.add(hunter);
        counterOfHunters++;
        int thisHunter = counterOfHunters;
        //...................
        new Thread (){
            @Override
            public void run() {
                super.run();
                while (listOfSimpleHunters.get(thisHunter).getX()>280 && !exitGame && listOfSimpleHunters.get(thisHunter).isActive()) {
                    pauseTheGame();
                    for (int i = 0; i <= counterOfMineGuards; i++)
                    {
                        if (listOfMineGuards.get(i).isActive()){
                            if (listOfSimpleHunters.get(thisHunter).getX() <= (listOfMineGuards.get(i).getX() + 90) && (listOfSimpleHunters.get(thisHunter).getY() <= listOfMineGuards.get(i).getY() + 80 && listOfSimpleHunters.get(thisHunter).getY() >= listOfMineGuards.get(i).getY())) {
                                listOfSimpleHunters.get(thisHunter).setActive(false);
                                listOfMineGuards.get(i).setActive(false);
                                AudioClip explosion = new AudioClip(getClass().getResource("Audio/Explosion.mp3").toExternalForm());
                                explosion.play();
                                increaseScore(100);
                            }
                        }
                    }
                    for (int i = 0; i <= counterOfSimpleGuards; i++)
                    {
                        if (listOfSimpleGuards.get(i).isActive()){
                            if (listOfSimpleHunters.get(thisHunter).getX() <= (listOfSimpleGuards.get(i).getX() + 90) && (listOfSimpleHunters.get(thisHunter).getY() <= listOfSimpleGuards.get(i).getY() + 80 && listOfSimpleHunters.get(thisHunter).getY() >= listOfSimpleGuards.get(i).getY())) {
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                listOfSimpleHunters.get(thisHunter).setCanMove(false);
                                listOfSimpleGuards.get(i).setHealth(listOfSimpleGuards.get(i).getHealth()-20-damageIncrease);
                                AudioClip bite = new AudioClip(getClass().getResource("Audio/Bite.mp3").toExternalForm());
                                bite.play();
                                if (listOfSimpleGuards.get(i).getHealth() <= 0)
                                {
                                    listOfSimpleGuards.get(i).setActive(false);
                                    listOfSimpleHunters.get(thisHunter).setCanMove(true);
                                }
                            }
                        }
                    }
                    Platform.runLater(() -> {
                        try {
                            listOfSimpleHunters.get(thisHunter).setX(hunter.getX() - 0.5);
                            imageView.setX(listOfSimpleHunters.get(thisHunter).getX());
                        } catch (NullPointerException e) {
                            System.out.println("NullPointerException thrown!");
                        }
                        if (listOfSimpleHunters.get(thisHunter).getX()<=280)
                        {
                            myAnchorPane.getChildren().remove(imageView);
                            listOfSimpleHunters.get(thisHunter).setActive(false);
                            switch (y){
                                case 125:
                                    row1Active = false;
                                    break;
                                case 215:
                                    row2Active = false;
                                    break;
                                case 305:
                                    row3Active = false;
                                    break;
                                case 395:
                                    row4Active = false;
                                    break;
                                case 485:
                                    row5Active = false;
                                    break;
                                case 575:
                                    row6Active = false;
                                    break;
                            }
                            try {
                                checkRows();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        else if (!listOfSimpleHunters.get(thisHunter).isActive())
                        {
                            myAnchorPane.getChildren().remove(imageView);
                        }
                    });
                    try {
                        if (speedIncrease <=9)
                            Thread.sleep(10 - speedIncrease);
                        else
                            Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Platform.runLater(() -> {
                    if (listOfSimpleHunters.get(thisHunter).getX()<=280)
                    {
                        myAnchorPane.getChildren().remove(imageView);
                        listOfSimpleHunters.get(thisHunter).setActive(false);
                    }
                    else if (!listOfSimpleHunters.get(thisHunter).isActive())
                    {
                        myAnchorPane.getChildren().remove(imageView);
                    }
                });
            }
        }.start();
    }
    public void randomHunterGeneratorCaller() {
        Random rand = new Random(); //instance of random class
        int upperbound = 6;
        int upperbound2 = 5;
        new Thread (){
            @Override
            public void run() {
                super.run();
                while (!exitGame) {
                    pauseTheGame();
                    try {
                        if (generateSpeedIncrease <= 4000)
                            Thread.sleep(5000 - generateSpeedIncrease);
                        else
                            Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(() -> {
                        int randomRow;
                        //generate random values from 0-4
                        int randomSpawnCount;
                        randomSpawnCount = rand.nextInt(upperbound2);
                        for (int i = 0; i<randomSpawnCount; i++) {
                            //generate random values from 0-5
                            randomRow = rand.nextInt(upperbound);
                            switch (randomRow) {
                                case 0:
                                    if (row1Active)
                                        hunterGenerator(730, 125);
                                    break;
                                case 1:
                                    if (row2Active)
                                        hunterGenerator(730, 215);
                                    break;
                                case 2:
                                    if (row3Active)
                                        hunterGenerator(730, 305);
                                    break;
                                case 3:
                                    if (row4Active)
                                        hunterGenerator(730, 395);
                                    break;
                                case 4:
                                    if (row5Active)
                                        hunterGenerator(730, 485);
                                    break;
                                case 5:
                                    if (row6Active)
                                        hunterGenerator(730, 575);
                                    break;
                            }
                        }
                    });
                }
            }
        }.start();
    }

    public void MineHunterGenerator(int x, int y) {
        Image image = new Image("/sample/View/Images/covidBlack.png");
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(90);
        imageView.setFitHeight(90);
        imageView.setPreserveRatio(true);
        myAnchorPane.getChildren().add(imageView);
        //create hunter object
        ExplosiveHunter hunter = new ExplosiveHunter();
        hunter.setX(x);
        hunter.setY(y);
        hunter.setActive(true);
        hunter.setCanMove(true);
        hunter.setHealth(2);
        listOfExplosiveHunters.add(hunter);
        counterOfExplosiveHunters++;
        int thisHunter = counterOfExplosiveHunters;
        //...................
        new Thread (){
            @Override
            public void run() {
                super.run();
                while (listOfExplosiveHunters.get(thisHunter).getX()>280 && !exitGame && listOfExplosiveHunters.get(thisHunter).isActive()) {
                    pauseTheGame();
                    for (int i = 0; i <= counterOfMineGuards; i++)
                    {
                        if (listOfMineGuards.get(i).isActive()){
                            if (listOfExplosiveHunters.get(thisHunter).getX() <= (listOfMineGuards.get(i).getX() + 90) && (listOfExplosiveHunters.get(thisHunter).getY() <= listOfMineGuards.get(i).getY() + 80 && listOfExplosiveHunters.get(thisHunter).getY() >= listOfMineGuards.get(i).getY())) {
                                listOfExplosiveHunters.get(thisHunter).setActive(false);
                                listOfMineGuards.get(i).setActive(false);
                                AudioClip explosion = new AudioClip(getClass().getResource("Audio/Explosion.mp3").toExternalForm());
                                explosion.play();
                                increaseScore(200);
                            }
                        }
                    }
                    for (int i = 0; i <= counterOfSimpleGuards; i++)
                    {
                        if (listOfSimpleGuards.get(i).isActive()){
                            if (listOfExplosiveHunters.get(thisHunter).getX() <= (listOfSimpleGuards.get(i).getX() + 90) && (listOfExplosiveHunters.get(thisHunter).getY() <= listOfSimpleGuards.get(i).getY() + 80 && listOfExplosiveHunters.get(thisHunter).getY() >= listOfSimpleGuards.get(i).getY())) {
                                listOfExplosiveHunters.get(i).setActive(false);
                                listOfSimpleGuards.get(i).setActive(false);
                                AudioClip explosion = new AudioClip(getClass().getResource("Audio/Explosion.mp3").toExternalForm());
                                explosion.play();
                                Platform.runLater(() -> {
                                    myAnchorPane.getChildren().remove(imageView);
                                });
                            }
                        }
                    }
                    Platform.runLater(() -> {
                        try {
                            if (listOfExplosiveHunters.get(thisHunter).isCanMove()) {
                                listOfExplosiveHunters.get(thisHunter).setX(hunter.getX() - 0.5);
                                imageView.setX(listOfExplosiveHunters.get(thisHunter).getX());
                            }
                        } catch (NullPointerException e) {
                            System.out.println("NullPointerException thrown!");
                        }
                    });
                    try {
                        if (speedIncrease <= 4)
                            Thread.sleep(5 - speedIncrease);
                        else
                            Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Platform.runLater(() -> {
                    if (listOfExplosiveHunters.get(thisHunter).getX()<=280)
                    {
                        myAnchorPane.getChildren().remove(imageView);
                        listOfExplosiveHunters.get(thisHunter).setActive(false);
                        switch (y){
                            case 125:
                                row1Active = false;
                                break;
                            case 215:
                                row2Active = false;
                                break;
                            case 305:
                                row3Active = false;
                                break;
                            case 395:
                                row4Active = false;
                                break;
                            case 485:
                                row5Active = false;
                                break;
                            case 575:
                                row6Active = false;
                                break;
                        }
                        try {
                            checkRows();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else if (!listOfExplosiveHunters.get(thisHunter).isActive())
                    {
                        myAnchorPane.getChildren().remove(imageView);
                    }
                });
            }
        }.start();
    }
    public void RandomMineHunterGeneratorCaller() {
        Random rand = new Random(); //instance of random class
        int upperbound = 6;
        int upperbound2 = 4;
        new Thread (){
            @Override
            public void run() {
                super.run();
                while (!exitGame) {
                    pauseTheGame();
                    try {
                        if ( generateSpeedIncrease <= 8000)
                            Thread.sleep(9000 - generateSpeedIncrease);
                        else
                            Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(() -> {
                        int randomRow;
                        //generate random values from 0-3
                        int randomSpawnCount;
                        randomSpawnCount = rand.nextInt(upperbound2);
                        for (int i = 0; i<randomSpawnCount; i++) {
                            //generate random values from 0-5
                            randomRow = rand.nextInt(upperbound);
                            switch (randomRow) {
                                case 0:
                                    if (row1Active)
                                        MineHunterGenerator(730, 125);
                                    break;
                                case 1:
                                    if (row2Active)
                                        MineHunterGenerator(730, 215);
                                    break;
                                case 2:
                                    if (row3Active)
                                        MineHunterGenerator(730, 305);
                                    break;
                                case 3:
                                    if (row4Active)
                                        MineHunterGenerator(730, 395);
                                    break;
                                case 4:
                                    if (row5Active)
                                        MineHunterGenerator(730, 485);
                                    break;
                                case 5:
                                    if (row6Active)
                                        MineHunterGenerator(730, 575);
                                    break;
                            }
                        }
                    });
                }
            }
        }.start();
    }

    public void moneyBoxGenerator(int x, int y) throws FileNotFoundException {
        //creating the image object
        Image image = new Image("/sample/View/Images/moneyBag.png");
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);
        myAnchorPane.getChildren().add(imageView);
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getTarget() == imageView) {
                    AudioClip money = new AudioClip(getClass().getResource("Audio/Money.mp3").toExternalForm());
                    money.play();
                    myAnchorPane.getChildren().remove(imageView);
                    onlinePlayer.setMoney(onlinePlayer.getMoney()+50);
                    money_label.setText(onlinePlayer.getMoney() + " $");
                }
            }
        });
    }
    public void randomMoneyBoxGenerator() throws FileNotFoundException {
        new Thread (){
            @Override
            public void run() {
                super.run();
                while (!exitGame) {
                    pauseTheGame();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(() -> {
                        try {
                            Random x = new Random();
                            int lowX = 280;
                            int highX = 770;
                            int resultX = x.nextInt(highX-lowX) + lowX;
                            Random y = new Random();
                            int lowY = 125;
                            int highY = 615;
                            int resultY = y.nextInt(highY-lowY) + lowY;
                            moneyBoxGenerator(resultX,resultY);
                        } catch (NullPointerException e) {
                            System.out.println("NullPointerException thrown!");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    });

                }
            }
        }.start();
    }

    public void increaseDamageAndSpeed (){
        new Thread (){
            @Override
            public void run() {
                super.run();
                while (!exitGame) {
                    pauseTheGame();
                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    speedIncrease += 1;
                    damageIncrease += 20;
                    generateSpeedIncrease += 200;
                }
            }
        }.start();
    }

    public void pauseTheGame(){
        while (pauseGame)
        {
            System.out.println("");
        }
    }

    public void setUpRoom(){
        // setting up game room
        try{
            rectangle_image_1_1.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_1_1 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_1_2.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_1_2 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_1_3.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_1_3 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_1_4.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_1_4 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_1_5.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_1_5 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_1_6.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_1_6 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_2_1.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_2_1 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_2_2.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_2_2 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_2_3.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_2_3 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_2_4.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_2_4 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_2_5.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_2_5 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_2_6.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_2_6 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_3_1.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_3_1 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_3_2.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_3_2 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_3_3.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_3_3 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_3_4.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_3_4 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_3_5.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_3_5 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_3_6.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_3_6 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_4_1.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_4_1 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_4_2.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_4_2 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_4_3.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_4_3 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_4_4.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_4_4 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_4_5.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_4_5 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_4_6.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_4_6 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_5_1.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_5_1 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_5_2.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_5_2 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_5_3.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_5_3 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_5_4.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_5_4 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_5_5.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_5_5 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_5_6.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_5_6 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_6_1.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_6_1 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_6_2.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_6_2 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_6_3.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_6_3 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_6_4.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_6_4 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_6_5.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_6_5 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });
            rectangle_image_6_6.setOnDragOver(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    if (event.getGestureSource() != rectangle_image_6_6 &&
                            event.getDragboard().hasImage()) {

                        event.acceptTransferModes(TransferMode.ANY);
                    }
                    event.consume();
                }
            });

            rectangle_image_1_1.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_1_1_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_1_1.setImage(db.getImage());
                            rectangle_1_1_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_1_1.getLayoutX());
                            simpleGuard.setY(rectangle_image_1_1.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_1.setImage(null);
                                                rectangle_1_1_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_1_1.setImage(db.getImage());
                            rectangle_1_1_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_1_1.getLayoutX());
                            mineGuard.setY(rectangle_image_1_1.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_1.setImage(null);
                                                rectangle_1_1_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_1_2.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_1_2_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_1_2.setImage(db.getImage());
                            rectangle_1_2_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_1_2.getLayoutX());
                            simpleGuard.setY(rectangle_image_1_2.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_2.setImage(null);
                                                rectangle_1_2_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_1_2.setImage(db.getImage());
                            rectangle_1_2_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_1_2.getLayoutX());
                            mineGuard.setY(rectangle_image_1_2.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_2.setImage(null);
                                                rectangle_1_2_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_1_3.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_1_3_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_1_3.setImage(db.getImage());
                            rectangle_1_3_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_1_3.getLayoutX());
                            simpleGuard.setY(rectangle_image_1_3.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_3.setImage(null);
                                                rectangle_1_3_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_1_3.setImage(db.getImage());
                            rectangle_1_3_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_1_3.getLayoutX());
                            mineGuard.setY(rectangle_image_1_3.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_3.setImage(null);
                                                rectangle_1_3_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_1_4.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_1_4_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_1_4.setImage(db.getImage());
                            rectangle_1_4_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_1_4.getLayoutX());
                            simpleGuard.setY(rectangle_image_1_4.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_4.setImage(null);
                                                rectangle_1_4_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_1_4.setImage(db.getImage());
                            rectangle_1_4_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_1_4.getLayoutX());
                            mineGuard.setY(rectangle_image_1_4.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_4.setImage(null);
                                                rectangle_1_4_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_1_5.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_1_5_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_1_5.setImage(db.getImage());
                            rectangle_1_5_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_1_5.getLayoutX());
                            simpleGuard.setY(rectangle_image_1_5.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_5.setImage(null);
                                                rectangle_1_5_has_guard = false;
                                            });
                                        }
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_1_5.setImage(db.getImage());
                            rectangle_1_5_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_1_5.getLayoutX());
                            mineGuard.setY(rectangle_image_1_5.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_5.setImage(null);
                                                rectangle_1_5_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_1_6.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_1_6_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_1_6.setImage(db.getImage());
                            rectangle_1_6_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_1_6.getLayoutX());
                            simpleGuard.setY(rectangle_image_1_6.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_6.setImage(null);
                                                rectangle_1_6_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_1_6.setImage(db.getImage());
                            rectangle_1_6_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_1_6.getLayoutX());
                            mineGuard.setY(rectangle_image_1_6.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_1_6.setImage(null);
                                                rectangle_1_6_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });

            rectangle_image_2_1.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_2_1_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_2_1.setImage(db.getImage());
                            rectangle_2_1_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_2_1.getLayoutX());
                            simpleGuard.setY(rectangle_image_2_1.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_1.setImage(null);
                                                rectangle_2_1_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_2_1.setImage(db.getImage());
                            rectangle_2_1_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_2_1.getLayoutX());
                            mineGuard.setY(rectangle_image_2_1.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_1.setImage(null);
                                                rectangle_2_1_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_2_2.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_2_2_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_2_2.setImage(db.getImage());
                            rectangle_2_2_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_2_2.getLayoutX());
                            simpleGuard.setY(rectangle_image_2_2.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_2.setImage(null);
                                                rectangle_2_2_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_2_2.setImage(db.getImage());
                            rectangle_2_2_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_2_2.getLayoutX());
                            mineGuard.setY(rectangle_image_2_2.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_2.setImage(null);
                                                rectangle_2_2_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_2_3.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_2_3_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_2_3.setImage(db.getImage());
                            rectangle_2_3_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_2_3.getLayoutX());
                            simpleGuard.setY(rectangle_image_2_3.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_3.setImage(null);
                                                rectangle_2_3_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_2_3.setImage(db.getImage());
                            rectangle_2_3_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_2_3.getLayoutX());
                            mineGuard.setY(rectangle_image_2_3.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_3.setImage(null);
                                                rectangle_2_3_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_2_4.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_2_4_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_2_4.setImage(db.getImage());
                            rectangle_2_4_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_2_4.getLayoutX());
                            simpleGuard.setY(rectangle_image_2_4.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_4.setImage(null);
                                                rectangle_2_4_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_2_4.setImage(db.getImage());
                            rectangle_2_4_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_2_4.getLayoutX());
                            mineGuard.setY(rectangle_image_2_4.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_4.setImage(null);
                                                rectangle_2_4_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_2_5.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_2_5_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_2_5.setImage(db.getImage());
                            rectangle_2_5_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_2_5.getLayoutX());
                            simpleGuard.setY(rectangle_image_2_5.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_5.setImage(null);
                                                rectangle_2_5_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_2_5.setImage(db.getImage());
                            rectangle_2_5_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_2_5.getLayoutX());
                            mineGuard.setY(rectangle_image_2_5.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_5.setImage(null);
                                                rectangle_2_5_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_2_6.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_2_6_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_2_6.setImage(db.getImage());
                            rectangle_2_6_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_2_6.getLayoutX());
                            simpleGuard.setY(rectangle_image_2_6.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_6.setImage(null);
                                                rectangle_2_6_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_2_6.setImage(db.getImage());
                            rectangle_2_6_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_2_6.getLayoutX());
                            mineGuard.setY(rectangle_image_2_6.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_2_6.setImage(null);
                                                rectangle_2_6_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });

            rectangle_image_3_1.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_3_1_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_3_1.setImage(db.getImage());
                            rectangle_3_1_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_3_1.getLayoutX());
                            simpleGuard.setY(rectangle_image_3_1.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_1.setImage(null);
                                                rectangle_3_1_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_3_1.setImage(db.getImage());
                            rectangle_3_1_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_3_1.getLayoutX());
                            mineGuard.setY(rectangle_image_3_1.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_1.setImage(null);
                                                rectangle_3_1_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_3_2.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_3_2_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_3_2.setImage(db.getImage());
                            rectangle_3_2_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_3_2.getLayoutX());
                            simpleGuard.setY(rectangle_image_3_2.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_2.setImage(null);
                                                rectangle_3_2_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_3_2.setImage(db.getImage());
                            rectangle_3_2_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_3_2.getLayoutX());
                            mineGuard.setY(rectangle_image_3_2.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_2.setImage(null);
                                                rectangle_3_2_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_3_3.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_3_3_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_3_3.setImage(db.getImage());
                            rectangle_3_3_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_3_3.getLayoutX());
                            simpleGuard.setY(rectangle_image_3_3.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_3.setImage(null);
                                                rectangle_3_3_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_3_3.setImage(db.getImage());
                            rectangle_3_3_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_3_3.getLayoutX());
                            mineGuard.setY(rectangle_image_3_3.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_3.setImage(null);
                                                rectangle_3_3_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_3_4.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_3_4_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_3_4.setImage(db.getImage());
                            rectangle_3_4_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_3_4.getLayoutX());
                            simpleGuard.setY(rectangle_image_3_4.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_4.setImage(null);
                                                rectangle_3_4_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_3_4.setImage(db.getImage());
                            rectangle_3_4_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_3_4.getLayoutX());
                            mineGuard.setY(rectangle_image_3_4.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_4.setImage(null);
                                                rectangle_3_4_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_3_5.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_3_5_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_3_5.setImage(db.getImage());
                            rectangle_3_5_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_3_5.getLayoutX());
                            simpleGuard.setY(rectangle_image_3_5.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_5.setImage(null);
                                                rectangle_3_5_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_3_5.setImage(db.getImage());
                            rectangle_3_5_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_3_5.getLayoutX());
                            mineGuard.setY(rectangle_image_3_5.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_5.setImage(null);
                                                rectangle_3_5_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_3_6.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_3_6_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_3_6.setImage(db.getImage());
                            rectangle_3_6_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_3_6.getLayoutX());
                            simpleGuard.setY(rectangle_image_3_6.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_6.setImage(null);
                                                rectangle_3_6_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_3_6.setImage(db.getImage());
                            rectangle_3_6_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_3_6.getLayoutX());
                            mineGuard.setY(rectangle_image_3_6.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_3_6.setImage(null);
                                                rectangle_3_6_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });

            rectangle_image_4_1.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_2_4_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_4_1.setImage(db.getImage());
                            rectangle_4_1_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_4_1.getLayoutX());
                            simpleGuard.setY(rectangle_image_4_1.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_1.setImage(null);
                                                rectangle_4_1_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_4_1.setImage(db.getImage());
                            rectangle_4_1_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_4_1.getLayoutX());
                            mineGuard.setY(rectangle_image_4_1.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_1.setImage(null);
                                                rectangle_4_1_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_4_2.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_4_2_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_4_2.setImage(db.getImage());
                            rectangle_4_2_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_4_2.getLayoutX());
                            simpleGuard.setY(rectangle_image_4_2.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_2.setImage(null);
                                                rectangle_4_2_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_4_2.setImage(db.getImage());
                            rectangle_4_2_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_4_2.getLayoutX());
                            mineGuard.setY(rectangle_image_4_2.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_2.setImage(null);
                                                rectangle_4_2_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_4_3.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_4_3_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_4_3.setImage(db.getImage());
                            rectangle_4_3_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_4_3.getLayoutX());
                            simpleGuard.setY(rectangle_image_4_3.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_3.setImage(null);
                                                rectangle_4_3_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_4_3.setImage(db.getImage());
                            rectangle_4_3_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_4_3.getLayoutX());
                            mineGuard.setY(rectangle_image_4_3.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_3.setImage(null);
                                                rectangle_4_3_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_4_4.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_4_4_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_4_4.setImage(db.getImage());
                            rectangle_4_4_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_4_4.getLayoutX());
                            simpleGuard.setY(rectangle_image_4_4.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_4.setImage(null);
                                                rectangle_4_4_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_4_4.setImage(db.getImage());
                            rectangle_4_4_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_4_4.getLayoutX());
                            mineGuard.setY(rectangle_image_4_4.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_4.setImage(null);
                                                rectangle_4_4_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_4_5.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_4_5_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_4_5.setImage(db.getImage());
                            rectangle_4_5_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_4_5.getLayoutX());
                            simpleGuard.setY(rectangle_image_4_5.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_5.setImage(null);
                                                rectangle_4_5_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_4_5.setImage(db.getImage());
                            rectangle_4_5_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_4_5.getLayoutX());
                            mineGuard.setY(rectangle_image_4_5.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_5.setImage(null);
                                                rectangle_4_5_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_4_6.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_4_6_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_4_6.setImage(db.getImage());
                            rectangle_4_6_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_4_6.getLayoutX());
                            simpleGuard.setY(rectangle_image_4_6.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_6.setImage(null);
                                                rectangle_4_6_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_4_6.setImage(db.getImage());
                            rectangle_4_6_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_4_6.getLayoutX());
                            mineGuard.setY(rectangle_image_4_6.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_4_6.setImage(null);
                                                rectangle_4_6_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });

            rectangle_image_5_1.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_5_1_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_5_1.setImage(db.getImage());
                            rectangle_5_1_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_5_1.getLayoutX());
                            simpleGuard.setY(rectangle_image_5_1.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_1.setImage(null);
                                                rectangle_5_1_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_5_1.setImage(db.getImage());
                            rectangle_5_1_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_5_1.getLayoutX());
                            mineGuard.setY(rectangle_image_5_1.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_1.setImage(null);
                                                rectangle_5_1_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_5_2.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_5_2_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_5_2.setImage(db.getImage());
                            rectangle_5_2_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_5_2.getLayoutX());
                            simpleGuard.setY(rectangle_image_5_2.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_2.setImage(null);
                                                rectangle_5_2_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_5_2.setImage(db.getImage());
                            rectangle_5_2_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_5_2.getLayoutX());
                            mineGuard.setY(rectangle_image_5_2.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_2.setImage(null);
                                                rectangle_5_2_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_5_3.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_5_3_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_5_3.setImage(db.getImage());
                            rectangle_5_3_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_5_3.getLayoutX());
                            simpleGuard.setY(rectangle_image_5_3.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_3.setImage(null);
                                                rectangle_5_3_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_5_3.setImage(db.getImage());
                            rectangle_5_3_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_5_3.getLayoutX());
                            mineGuard.setY(rectangle_image_5_3.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_3.setImage(null);
                                                rectangle_5_3_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_5_4.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_5_4_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_5_4.setImage(db.getImage());
                            rectangle_5_4_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_5_4.getLayoutX());
                            simpleGuard.setY(rectangle_image_5_4.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_4.setImage(null);
                                                rectangle_5_4_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_5_4.setImage(db.getImage());
                            rectangle_5_4_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_5_4.getLayoutX());
                            mineGuard.setY(rectangle_image_5_4.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_4.setImage(null);
                                                rectangle_5_4_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_5_5.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_5_5_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_5_5.setImage(db.getImage());
                            rectangle_5_5_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_5_5.getLayoutX());
                            simpleGuard.setY(rectangle_image_5_5.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_5.setImage(null);
                                                rectangle_5_5_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_5_5.setImage(db.getImage());
                            rectangle_5_5_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_5_5.getLayoutX());
                            mineGuard.setY(rectangle_image_5_5.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_5.setImage(null);
                                                rectangle_5_5_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_5_6.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_5_6_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_5_6.setImage(db.getImage());
                            rectangle_5_6_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_5_6.getLayoutX());
                            simpleGuard.setY(rectangle_image_5_6.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_6.setImage(null);
                                                rectangle_5_6_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_5_6.setImage(db.getImage());
                            rectangle_5_6_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_5_6.getLayoutX());
                            mineGuard.setY(rectangle_image_5_6.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_5_6.setImage(null);
                                                rectangle_5_6_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });

            rectangle_image_6_1.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_6_1_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_6_1.setImage(db.getImage());
                            rectangle_6_1_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_6_1.getLayoutX());
                            simpleGuard.setY(rectangle_image_6_1.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_1.setImage(null);
                                                rectangle_6_1_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_6_1.setImage(db.getImage());
                            rectangle_6_1_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_6_1.getLayoutX());
                            mineGuard.setY(rectangle_image_6_1.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_1.setImage(null);
                                                rectangle_6_1_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_6_2.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_6_2_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_6_2.setImage(db.getImage());
                            rectangle_6_2_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_6_2.getLayoutX());
                            simpleGuard.setY(rectangle_image_6_2.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_2.setImage(null);
                                                rectangle_6_2_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_6_2.setImage(db.getImage());
                            rectangle_6_2_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_6_2.getLayoutX());
                            mineGuard.setY(rectangle_image_6_2.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_2.setImage(null);
                                                rectangle_6_2_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_6_3.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_6_3_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_6_3.setImage(db.getImage());
                            rectangle_6_3_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_6_3.getLayoutX());
                            simpleGuard.setY(rectangle_image_6_3.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_3.setImage(null);
                                                rectangle_6_3_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_6_3.setImage(db.getImage());
                            rectangle_6_3_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_6_3.getLayoutX());
                            mineGuard.setY(rectangle_image_6_3.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_3.setImage(null);
                                                rectangle_6_3_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_6_4.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_6_4_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_6_4.setImage(db.getImage());
                            rectangle_6_4_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_6_4.getLayoutX());
                            simpleGuard.setY(rectangle_image_6_4.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_4.setImage(null);
                                                rectangle_6_4_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_6_4.setImage(db.getImage());
                            rectangle_6_4_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_6_4.getLayoutX());
                            mineGuard.setY(rectangle_image_6_4.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_4.setImage(null);
                                                rectangle_6_4_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_6_5.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_6_5_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_6_5.setImage(db.getImage());
                            rectangle_6_5_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_6_5.getLayoutX());
                            simpleGuard.setY(rectangle_image_6_5.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_5.setImage(null);
                                                rectangle_6_5_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_6_5.setImage(db.getImage());
                            rectangle_6_5_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_6_5.getLayoutX());
                            mineGuard.setY(rectangle_image_6_5.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_5.setImage(null);
                                                rectangle_6_5_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
            rectangle_image_6_6.setOnDragDropped(new EventHandler<DragEvent>() {
                public void handle(DragEvent event) {
                    Dragboard db = event.getDragboard();
                    if (db.hasImage() && !rectangle_6_6_has_guard) {
                        if (selectedGuardType == 1 && onlinePlayer.getMoney()>=50)
                        {
                            rectangle_image_6_6.setImage(db.getImage());
                            rectangle_6_6_has_guard = true;
                            // means we should create a simple guard.
                            SimpleGuard simpleGuard = new SimpleGuard();
                            simpleGuard.setActive(true);
                            simpleGuard.setHealth(100);
                            simpleGuard.setX(rectangle_image_6_6.getLayoutX());
                            simpleGuard.setY(rectangle_image_6_6.getLayoutY());
                            deployGuard(1);
                            counterOfSimpleGuards++;
                            int thisGuard = counterOfSimpleGuards;
                            listOfSimpleGuards.add (thisGuard, simpleGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfSimpleGuards.get(thisGuard).isActive()) {
                                        pauseTheGame();
                                        try {
                                            Thread.sleep(2000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        Platform.runLater(() -> {
                                            try {
                                                AudioClip shoot = new AudioClip(getClass().getResource("Audio/Shooting.mp3").toExternalForm());
                                                shoot.play();
                                                shooting (listOfSimpleGuards.get(thisGuard).getX(),listOfSimpleGuards.get(thisGuard).getY());
                                            } catch (NullPointerException e) {
                                                System.out.println("NullPointerException thrown!");
                                            }
                                        });
                                        if (!listOfSimpleGuards.get(thisGuard).isActive())
                                        {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_6.setImage(null);
                                                rectangle_6_6_has_guard = false;
                                            });
                                        }
                                    }
                                }
                            }.start();
                        }
                        else if (selectedGuardType == 2 && onlinePlayer.getMoney()>=200 )
                        {
                            rectangle_image_6_6.setImage(db.getImage());
                            rectangle_6_6_has_guard = true;
                            // means we should create a mine guard.
                            MineGuard mineGuard = new MineGuard();
                            mineGuard.setActive(true);
                            mineGuard.setHealth(100);
                            mineGuard.setX(rectangle_image_6_6.getLayoutX());
                            mineGuard.setY(rectangle_image_6_6.getLayoutY());
                            deployGuard(2);
                            counterOfMineGuards++;
                            int thisGuard = counterOfMineGuards;
                            listOfMineGuards.add (thisGuard, mineGuard);
                            new Thread (){
                                @Override
                                public void run() {
                                    super.run();
                                    while (!exitGame && listOfMineGuards.get(thisGuard).isActive()) {
                                        System.out.println("");
                                        if (!listOfMineGuards.get(thisGuard).isActive()) {
                                            Platform.runLater(() -> {
                                                rectangle_image_6_6.setImage(null);
                                                rectangle_6_6_has_guard = false;
                                            });
                                        }

                                    }
                                }
                            }.start();
                        }
                    }
                    event.consume();
                }
            });
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException thrown!");
        }
    }


    public void shooting (double x, double y){
        Image image = new Image("/sample/View/Images/whiteBloodCell.png");
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(x+50);
        imageView.setY(y+45);
        imageView.setFitWidth(40);
        imageView.setFitHeight(40);
        imageView.setPreserveRatio(true);
        myAnchorPane.getChildren().add(imageView);
        //create bullet object
        Bullet bullet = new Bullet();
        bullet.setX(x+50);
        bullet.setY(y+45);
        bullet.setActive(true);
        new Thread (){
            @Override
            public void run() {
                super.run();
                while (bullet.getX()<780 && !exitGame && bullet.isActive()) {
                    pauseTheGame();
                    Platform.runLater(() -> {
                        try {
                            bullet.setX(bullet.getX() + 1);
                            imageView.setX(bullet.getX());
                            for (int i = 0; i <= counterOfHunters; i++)
                            {
                                if (listOfSimpleHunters.get(i).isActive()) {
                                    if (bullet.getX() >= listOfSimpleHunters.get(i).getX() && (bullet.getY() <= listOfSimpleHunters.get(i).getY() + 90 && bullet.getY() >= listOfSimpleHunters.get(i).getY())) {
                                        myAnchorPane.getChildren().remove(imageView);
                                        AudioClip getShot = new AudioClip(getClass().getResource("Audio/GetShot.mp3").toExternalForm());
                                        getShot.play();
                                        bullet.setActive(false);
                                        listOfSimpleHunters.get(i).setHealth(listOfSimpleHunters.get(i).getHealth() - 1);
                                        if (listOfSimpleHunters.get(i).getHealth() <= 0) {
                                            increaseScore(100);
                                            listOfSimpleHunters.get(i).setActive(false);
                                        }
                                    }
                                }
                            }
                            for (int i = 0; i <= counterOfExplosiveHunters; i++)
                            {
                                if (listOfExplosiveHunters.get(i).isActive()) {
                                    if (bullet.getX() >= listOfExplosiveHunters.get(i).getX() && (bullet.getY() <= listOfExplosiveHunters.get(i).getY() + 90 && bullet.getY() >= listOfExplosiveHunters.get(i).getY())) {
                                        myAnchorPane.getChildren().remove(imageView);
                                        AudioClip getShot = new AudioClip(getClass().getResource("Audio/GetShot.mp3").toExternalForm());
                                        getShot.play();
                                        bullet.setActive(false);
                                        listOfExplosiveHunters.get(i).setHealth(listOfExplosiveHunters.get(i).getHealth() - 1);
                                        if (listOfExplosiveHunters.get(i).getHealth() <= 0) {
                                            increaseScore(200);
                                            listOfExplosiveHunters.get(i).setActive(false);
                                        }
                                    }
                                }
                            }
                        } catch (NullPointerException e) {
                            System.out.println("NullPointerException thrown!");
                        }
                    });
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(() -> {
                        if (bullet.getX()>=780)
                        {
                            myAnchorPane.getChildren().remove(imageView);
                            bullet.setActive(false);
                        }
                    });
                }
            }
        }.start();
    }

    public void simple_guard_selected(MouseEvent mouseEvent) {
        selectedGuardType = 1;
        Dragboard db = simple_guard_icon.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(simple_guard_icon.getImage());
        db.setContent(cb);

        mouseEvent.consume();
    }

    public void mine_guard_selected(MouseEvent mouseEvent) {
        selectedGuardType = 2;
        Dragboard db = mine_guard_icon.startDragAndDrop(TransferMode.ANY);
        ClipboardContent cb = new ClipboardContent();
        cb.putImage(mine_guard_icon.getImage());
        db.setContent(cb);

        mouseEvent.consume();
    }

    public void deployGuard (int type)
    {
        AudioClip drop = new AudioClip(getClass().getResource("Audio/Drop.mp3").toExternalForm());
        drop.play();
        if (type == 1)
        {
            onlinePlayer.setMoney(onlinePlayer.getMoney()-50);
            money_label.setText(onlinePlayer.getMoney() + " $");
        }
        else if (type == 2)
        {
            onlinePlayer.setMoney(onlinePlayer.getMoney()-200);
            money_label.setText(onlinePlayer.getMoney() + " $");
        }
    }

    public void increaseScore (int x){
        Platform.runLater(() -> {
            try {
                onlinePlayer.setScore(onlinePlayer.getScore()+x);
                score_label.setText(String.valueOf(onlinePlayer.getScore()));
            } catch (NullPointerException e) {
                System.out.println("NullPointerException thrown!");
            }
        });
    }
}