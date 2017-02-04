package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Elise on 2017-02-04.
 */
public class Simulation {
    private int simulationYears;
    private int landingAirplane;
    private int takingOfAirplane;
    private List<AirPlane> landingPlanes = new ArrayList<>();
    private List<AirPlane> takingOfPlanes = new ArrayList<>();

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

    public Simulation setLandingAirplane(int landingAirplane) {
        this.landingAirplane = landingAirplane;
        return this;
    }

    public int getTakingOfAirplane() {
        return takingOfAirplane;
    }

    public Simulation setTakingOfAirplane(int takingOfAirplane) {
        this.takingOfAirplane = takingOfAirplane;
        return this;
    }

    public List<AirPlane> getLandingPlanes() {
        return landingPlanes;
    }

    public Simulation setLandingPlanes(List<AirPlane> landingPlanes) {
        this.landingPlanes = landingPlanes;
        return this;
    }

    public List<AirPlane> getTakingOfPlanes() {
        return takingOfPlanes;
    }

    public Simulation setTakingOfPlanes(List<AirPlane> takingOfPlanes) {
        this.takingOfPlanes = takingOfPlanes;
        return this;
    }

    public void addPlaneLanding(){
        AirPlane airPlane = new AirPlane(false);
        this.landingPlanes.add(airPlane);
    }

    public void addPlaneTakingOf(){
        AirPlane airPlane = new AirPlane(false);
        this.takingOfPlanes.add(airPlane);
    }
}