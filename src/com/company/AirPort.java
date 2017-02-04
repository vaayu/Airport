package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elise on 2017-02-04.
 */
public class AirPort {
    private AirPlane activeCustomer;
    private List<AirPlane> planesInAir = new ArrayList<>();
    private List<AirPlane> planesOnGround = new ArrayList<>();

    public AirPort(){

    }

    public void setActiveCustomer(AirPlane airplane){
        this.activeCustomer = airplane;
    }

    public AirPlane getActiveCustomer(){
        return this.activeCustomer;
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
}
