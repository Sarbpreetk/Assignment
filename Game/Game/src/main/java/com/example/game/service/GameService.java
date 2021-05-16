package com.example.game.service;

import com.example.game.beans.GameInput;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    public void playGame(GameInput gameInput);
}
