package com.example.guessing_game.model;

public class Game {
    private int number;
    private int min;
    private int max;
    private boolean isEnd;

    public Game(int number, int min, int max) {
        this.isEnd = false;
        this.number = number;
        this.min = min;
        this.max = max;
    }

    public int number() {
        return number;
    }

    public void number(int number) {
        this.number = number;
    }

    public int min() {
        return min;
    }

    public void min(int min) {
        this.min = min;
    }

    public int max() {
        return max;
    }

    public void max(int max) {
        this.max = max;
    }

    public boolean end() {
        return isEnd;
    }

    public void end(boolean end) {
        isEnd = end;
    }
}
