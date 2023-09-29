package sample.Models;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name = "";
    private int Score;
    private int Money;
    private int gamePlayed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + getName() + '\'' +
                ", Score=" + getScore() +
                '}';
    }

    public int getGamePlayed() {
        return gamePlayed;
    }

    public void setGamePlayed(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }
}
