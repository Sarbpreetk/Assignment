package com.example.game.beans;

import java.util.HashMap;
import java.util.Map;

public class BoxWrapper {
    private Map<Integer, Box> boxMap = new HashMap<Integer, Box>();

    public Map<Integer, Box> getBoxMap() {
        return boxMap;
    }

    public void setBoxMap(Map<Integer, Box> boxMap) {
        this.boxMap = boxMap;
    }

}
