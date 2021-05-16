package com.example.game.beans;

import org.springframework.stereotype.Component;

@Component
public class GameInput {
    private int selectedBoxNumber;
    private boolean changeBox;


    public int getSelectedBoxNumber() {
        return selectedBoxNumber;
    }

    public void setSelectedBoxNumber(int selectedBoxNumber) {
        this.selectedBoxNumber = selectedBoxNumber;
    }

    public boolean isChangeBox() {
        return changeBox;
    }

    public void setChangeBox(boolean changeBox) {
        this.changeBox = changeBox;
    }
}
