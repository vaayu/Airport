package com.company;

/**
 * Created by Elise on 2017-02-04.
 */
public class AirPlane {
    private Boolean isHappy;

    private Boolean isInAir;
    private int fiveMinCounter;

    public AirPlane(Boolean isHappy, Boolean isInAir){
        this.isHappy = false; // Not happy because has not landed/lifted.
        this.isInAir = isInAir;
    }

    public void addToFiveMinCounter(){
        this.fiveMinCounter ++;
    }

    public int getFiveMinCounter(){
        return this.fiveMinCounter;
    }

    public Boolean getHappy() {
        return isHappy;
    }

    public AirPlane setHappy(Boolean happy) {
        isHappy = happy;
        return this;
    }

    public Boolean getInAir() {
        return isInAir;
    }

    public AirPlane setInAir(Boolean inAir) {
        isInAir = inAir;
        return this;
    }

    public AirPlane setFiveMinCounter(int fiveMinCounter) {
        this.fiveMinCounter = fiveMinCounter;
        return this;
    }
}
