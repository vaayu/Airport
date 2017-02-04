package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elise on 2017-02-04.
 */
public class AirPort {
    private int activeCustomerId;
    private Boolean activeCustomerInAir;
    private List<AirPlane> planesInAir = new ArrayList<>();
    private List<AirPlane> planesOnGround = new ArrayList<>();
    private Boolean busy;
    private int timer;                      // When this has the value 4 it means that the activeCustomer is done!

    public AirPort(){
        this.timer = 0;
        this.busy = false;
    }

    public void setActiveCustomer(int id, Boolean activeCustomerInAir){
        this.activeCustomerId = id;
        this.activeCustomerInAir = activeCustomerInAir;
    }

    public int getActiveCustomerId(){
        return this.activeCustomerId;
    }

    public Boolean getActiveCustomerInAir(){
        return this.activeCustomerInAir;
    }

    public void addPlane(AirPlane airplane){
        if(airplane.getInAir()){
            this.planesInAir.add(airplane);
        }else{
            this.planesOnGround.add(airplane);
        }
    }

    public List<AirPlane> getPlanesInAir() {
        return planesInAir;
    }

    public AirPort setPlanesInAir(List<AirPlane> planesInAir) {
        this.planesInAir = planesInAir;
        return this;
    }

    public List<AirPlane> getPlanesOnGround() {
        return planesOnGround;
    }

    public AirPort setPlanesOnGround(List<AirPlane> planesOnGround) {
        this.planesOnGround = planesOnGround;
        return this;
    }

    public Boolean isBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    public void addToFiveMinCounter(){
        for(AirPlane airplane: this.planesInAir){
            if(!airplane.isHappy()) {
                airplane.addToFiveMinCounter();
            }
        }

        for(AirPlane airplane: this.planesOnGround){
            if(!airplane.isHappy()) {
                airplane.addToFiveMinCounter();
            }
        }
    }

    public void increaseTimer(){
        this.timer++;
    }

    public int getTimer(){
        return this.timer;
    }

    public void resetTimer(){
        this.timer = 0;
    }
}
