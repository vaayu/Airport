package com.company;
import java.util.Random;

/**
 * Created by Elise on 2017-02-04.
 */
public class Simulation {
    private int simulationYears;
    private int landingAirplane;
    private int takingOfAirplane;



    public Simulation(int simulationYears, int landingAirplane, int takingOfAirplane){
        setSimulationYears(simulationYears);
        this.landingAirplane = landingAirplane;
        this.takingOfAirplane = takingOfAirplane;
    }

    public void setSimulationYears(int years){
        int hour = 12; // 60 / 5 = 12
        int day  = hour * 24;
        int week = day * 7;
        int year = week * 52;
        this.simulationYears = year * years;
    }

    public int getSimulationYears(){
        return this.simulationYears;
    }

    public int randomInt(int min, int max){
        Random random = new Random();

        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int getLandingAirplane() {
        return landingAirplane;
    }


    public int getTakingOfAirplane() {
        return takingOfAirplane;
    }
}
