package com.example.game;

import com.example.game.beans.GameInput;
import com.example.game.service.GameService;
import com.example.game.service.PlayGameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class GameApplicationTests {

	@Autowired
	GameService gameService;

	@Autowired
	GameInput gameInput;


	@Test
	void testGameChangeBox() {
		Random randomNum = new Random();
		System.out.println("Test to run the game by setting change box as true");
		for (int i=1; i<=100;i++){
			int selectedBox = randomNum.nextInt(3) + 1;
			gameInput.setSelectedBoxNumber(selectedBox);
			gameInput.setChangeBox(true);
			gameService.playGame(gameInput);
		}
	}

	@Test
	void testGameKeepBox(){
		Random randomNum = new Random();
		System.out.println("Test to run the game by setting change box as false");
		for (int i=1; i<=100;i++){
			int selectedBox = randomNum.nextInt(3) + 1;
			gameInput.setSelectedBoxNumber(selectedBox);
			gameInput.setChangeBox(false);
			gameService.playGame(gameInput);
		}
	}

}
