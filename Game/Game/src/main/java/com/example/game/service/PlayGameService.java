package com.example.game.service;

import com.example.game.beans.GameInput;
import com.example.game.beans.Statistics;
import com.example.game.util.GameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.regex.Pattern;

@Service
public class PlayGameService implements GameService {

    @Autowired
    GameUtil gameUtil;

    @Autowired
    Statistics stats;

    Scanner scanInput = new Scanner(System.in);

    /**
     * This method starts the game and executes various stages via GameUtil
     * gameInput can be null if user wants to play via console-from GameScheduler
     * Input param gameInput is set via Test execution to autorun for 100 cases
     * @param gameInput
     */
    public void playGame(GameInput gameInput) {
        gameUtil.startGame();
        System.out.println("Select a Box 1, 2 or 3");
        Pattern pattern = Pattern.compile("[1-3]");
        int selectedBox = 0;
        if (gameInput != null) {
            selectedBox = gameInput.getSelectedBoxNumber();
        } else {
            while (!scanInput.hasNext(pattern)) {
                System.out.println("Enter a valid number: 1/2/3");
                scanInput.next();
            }
            selectedBox = scanInput.nextInt();
        }
        gameUtil.selectBox(selectedBox);
        int emptyBoxNumber = gameUtil.openEmptyBox();
        System.out.println("Let's Open Empty Box: " + emptyBoxNumber);
        boolean switchBox = isSwitchBox(gameInput);
        checkWinner(switchBox);
    }

    /**
     * This method is to prompt user with change box option
     * @param gameInput
     * @return
     */
    private boolean isSwitchBox(GameInput gameInput) {
        //Ask user for Changing Box
        Pattern pattern = Pattern.compile("[y]|[Y]|[n]|[N]");
        boolean switchBox = false;
        if (gameInput != null) {
            switchBox = gameInput.isChangeBox();
        } else {
            System.out.println("Do you wish to Change? Y/N");
            while (!scanInput.hasNext(pattern)) {
                System.out.println("Enter valid selection to Change Box : Y/N");
                scanInput.next();
            }
            String changeBox = scanInput.next();
            switchBox = changeBox.equalsIgnoreCase("Y");
        }
        if (switchBox) {
            gameUtil.changeBox();
        }
        return switchBox;
    }

    private void checkWinner(boolean switchBox) {
        boolean isWinner = gameUtil.checkWinner();
        if (isWinner) {
            System.out.println("CONGRATULATIONS YOU WIN!!");
        } else {
            System.out.println("OOPS! You loose.");
        }
        stats.incrementStats(switchBox, isWinner);
        System.out.println(stats.toString());
    }



}
