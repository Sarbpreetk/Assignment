package com.example.game.scheduler;

import com.example.game.beans.Statistics;
import com.example.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.regex.Pattern;

@Component
@EnableScheduling
public class GameScheduler {

    @Autowired
    GameService gameService;

    @Autowired
    Statistics stats;

    Scanner scanInput = new Scanner(System.in);

    /**
     * This scheduled method will prompt to play Game on console
     */
    @Scheduled(fixedRate=5000)
    public void playGame() {
        Pattern pattern = Pattern.compile("[y]|[Y]|[n]|[N]");
        System.out.println("Play Game? : Y/N");
        while (!scanInput.hasNext(pattern)) {
            System.out.println("Enter valid selection to Play Game : Y/N");
            scanInput.next();
        }
        String playAgain = scanInput.next();
        if (playAgain.equalsIgnoreCase("Y")) {
            gameService.playGame(null);
        }else{
            System.out.println("Resetting Stats");
            stats.resetStats();
            System.out.println(stats.toString());

        }
    }
}
