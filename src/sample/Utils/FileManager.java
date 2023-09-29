package sample.Utils;

import sample.Models.Player;

import java.io.*;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    public ArrayList<Player> listOfPlayers = new ArrayList();
    public static void CreateFile (String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void AddPlayerData(Player newP) {
        String fileName = "PlayerScores.txt";
        CreateFile (fileName);
        try {
            FileWriter myWriter = new FileWriter(fileName,true);
            myWriter.write(newP.getName() + "\n");
            myWriter.write(newP.getScore() + "\n");
            myWriter.write(newP.getGamePlayed() + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<Player> ReadPlayerData() {
        String filePath = "PlayerScores.txt";
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("[,\n]");
            int x=0;
            while (scanner.hasNext()) {
                Player player = new Player();
                player.setName(scanner.nextLine());
                player.setScore(Integer.parseInt(scanner.nextLine()));
                player.setGamePlayed(Integer.parseInt(scanner.nextLine()));
                listOfPlayers.add(player);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listOfPlayers;
    }
}