package com.example.assign01;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final int secretNumber;

    public GameService() {
        this.secretNumber = new Random().nextInt(10) + 1; // 1–10
    }

    public String checkGuess(int guess) {
        if (guess == secretNumber) {
            return "🎉 Correct! You guessed the number.";
        } else if (guess < secretNumber) {
            return "Too low! Try again.";
        } else {
            return "Too high! Try again.";
        }
    }
}