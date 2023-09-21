package com.example.guessing_game.controller;

import com.example.guessing_game.model.Game;
import com.example.guessing_game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping({"", "/", "/home"})
    public String getGamePage(Model model) {
        model.addAttribute("game", gameService.getGame());
        model.addAttribute("choice", gameService.getChoice());
        return "game";
    }

    @PostMapping("/play")
    public String getChoice(@RequestParam("choice") int choice){ // primitív típus miatt ide RequestParam annotáció kell, nem pedig a ModelAttribute
        gameService.useChoice(choice);
        if(gameService.getGame().end()){
            return "redirect:/game/gg";
        }
        return "redirect:/game/home";
    }

    @GetMapping("/gg")
    public String getEnd(){
        return "gg";
    }
    @PostMapping("/new_game")
    public String newGame(){
        gameService.newGame();
        return "redirect:/game/home";
    }
}
