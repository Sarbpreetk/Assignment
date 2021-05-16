package com.example.game.util;

import com.example.game.beans.Box;
import com.example.game.beans.BoxWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

public class GameUtil {

    @Autowired
    BoxWrapper boxWrapper;

    private static final Logger logger = Logger.getLogger(String.valueOf(GameUtil.class));
    int emptyBoxNumber;


    public void startGame() {
        setBoxes();
    }

    public void selectBox(int boxNumber) {
        boxWrapper.getBoxMap().get(boxNumber).setSelected(true);
    }

    private void setBoxes() {
        boxWrapper = new BoxWrapper();
        Random randomNum = new Random();
        int moneyBox = randomNum.nextInt(3) + 1;
        for (int i = 1; i < 4; i++) {
            Box box = new Box();
            box.setBoxNumber(i);
            if (i == moneyBox) {
               box.setBoxWithMoney(true);
            }
            boxWrapper.getBoxMap().put(i, box);
        }

    }

    /**
     * This method return a box number which is empty and not selected bu user
     * @return
     */
    public int openEmptyBox() {
        for (Map.Entry<Integer, Box> entry : boxWrapper.getBoxMap().entrySet()) {
            if (!entry.getValue().isSelected() && !entry.getValue().isBoxWithMoney()) {
                emptyBoxNumber = entry.getKey();
                return entry.getKey();
            }
        }
        logger.severe("NO EMPTY BOX FOUND");
        return 0;
    }

    /**
     * This method will change selected box to the other unopened box.
     */
    public void changeBox() {
        for (Map.Entry<Integer, Box> entry : boxWrapper.getBoxMap().entrySet()) {
            if (entry.getValue().isSelected()) {
                entry.getValue().setSelected(false);
            } else if (!entry.getKey().equals(emptyBoxNumber)) {
                entry.getValue().setSelected(true);
            }
        }

    }

    public boolean checkWinner() {
        // logger.info("In CHECK WINNER");
        boolean isWinner = false;
        for (Map.Entry<Integer, Box> entry : boxWrapper.getBoxMap().entrySet()) {
            if (entry.getValue().isSelected() && entry.getValue().isBoxWithMoney()) {
                isWinner = true;
            }
        }
        return isWinner;
    }
}
