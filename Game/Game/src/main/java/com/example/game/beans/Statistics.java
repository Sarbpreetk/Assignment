package com.example.game.beans;

import org.springframework.stereotype.Component;

@Component
public class Statistics {

    private int switchedBoxes;
    private int totalRun;
    private int wins;

    public void incrementStats(boolean switchedBox, boolean wonGame){
        totalRun ++;
        if(wonGame) wins++;
        if(switchedBox) switchedBoxes++;
    }

    public void resetStats(){
        switchedBoxes=0;
        totalRun=0;
        wins=0;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "switchedBoxes=" + switchedBoxes +
                ", totalRun=" + totalRun +
                ", wins=" + wins +
                ", winPercentage=" + winPercentage() +
                '}';
    }
    private String winPercentage(){
        if(totalRun==0) return "0.0";
        return  String.valueOf((wins*100.0/totalRun));
    }
}
