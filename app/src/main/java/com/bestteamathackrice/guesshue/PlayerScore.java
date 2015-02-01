package com.bestteamathackrice.guesshue;

/**
 * Wrapper class for a player score in the leaderboard "database".
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
        return other.getScore() - this.getScore();
    }
}
