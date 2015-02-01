package com.bestteamathackrice.guesshue;

/**
 * Created by johnking on 1/31/15.
 */
public class PlayerScore implements Comparable<PlayerScore> {
    private String name;
    private int score;

    public PlayerScore (String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int compareTo(PlayerScore other) {
        return this.getScore() - other.getScore();
    }
}
