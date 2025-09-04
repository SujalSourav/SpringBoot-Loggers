package com.example.assign01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String index() {
        return "index";  // loads index.html
    }

    @PostMapping("/guess")
    public String guessNumber(@RequestParam int guess, Model model) {
        String result = gameService.checkGuess(guess);
        model.addAttribute("result", result);
        return "result"; // loads result.html
    }
}
