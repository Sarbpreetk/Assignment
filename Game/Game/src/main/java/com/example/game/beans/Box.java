package com.example.game.beans;

public class Box {
    private int boxNumber;
    private boolean isSelected;
    private boolean boxWithMoney;


    public int getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(int boxNumber) {
        this.boxNumber = boxNumber;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isBoxWithMoney() {
        return boxWithMoney;
    }

    public void setBoxWithMoney(boolean boxWithMoney) {
        this.boxWithMoney = boxWithMoney;
    }
}
