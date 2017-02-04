package com.company;

/**
 * Created by Elise on 2017-02-04.
 */
public class AirPlane {
    private Boolean isHappy;
    private int fiveMinCounter;

    public AirPlane(Boolean isHappy){
        this.isHappy = false; // Not happy because has not landed/lifted.
    }

    public void addToFiveMinCounter(){
        this.fiveMinCounter ++;
    }

    public int getFiveMinCounter(){
        return this.fiveMinCounter;
    }
}
