package com.example.guessing_game.service;

import com.example.guessing_game.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {
    private Game game;
    private int choice;

    @Autowired
    public GameService(Game game) {
        this.game = game;
    }

    public void useChoice(int choice) {
        if (game.number() == choice) {
            game.end(true);
        } else if (game.number() > choice) {
            game.min(choice);
        } else {
            game.max(choice);
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void newGame() {
        this.setGame(new Game(new Random().nextInt(1000),
                0,
                1000));
    }
}
