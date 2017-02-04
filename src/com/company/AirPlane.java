package com.company;

/**
 * Created by Elise on 2017-02-04.
 */
public class AirPlane {
    private Boolean happy;

    private Boolean isInAir;
    private int fiveMinCounter;

    public AirPlane(Boolean happy, Boolean isInAir){
        this.happy = happy; // Not happy because has not landed/lifted.
        this.isInAir = isInAir;
    }

    public void addToFiveMinCounter(){
        this.fiveMinCounter ++;
    }

    public int getFiveMinCounter(){
        return this.fiveMinCounter;
    }

    public Boolean isHappy() {
        return happy;
    }

    public AirPlane setHappy(Boolean happy) {
        this.happy = happy;
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
