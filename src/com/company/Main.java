package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Simulation simulation = new Simulation(1,5,10);
        AirPort airPort = new AirPort();


        for(int i = 0; i < simulation.getSimulationYears(); i++){
            //Check if we have a plane that wants to lift of or land
            int landingOrTakingOf = simulation.randomInt(1,20);

            if(landingOrTakingOf == simulation.getLandingAirplane()){
                // We have a airplane that want's to land
                AirPlane airPlane = new AirPlane(false, true);
                airPort.addPlane(airPlane);

            }else if(landingOrTakingOf == simulation.getTakingOfAirplane()){
                // We have a airplane that wants to take of.. and be free..
                AirPlane airPlane = new AirPlane(false, false);
                airPort.addPlane(airPlane);
            }

            if(airPort.isBusy()){
                if(airPort.getTimer() == 4){
                    if(airPort.getActiveCustomerInAir()){
                        int id = airPort.getActiveCustomerId();
                        // Plane in air has landed
                        airPort.getPlanesInAir().get(id).setHappy(true); // Mission accomplished
                    }else{
                        // Plane on ground has lifted
                        int id = airPort.getActiveCustomerId();
                        airPort.getPlanesOnGround().get(id).setHappy(true); // Mission accomplished
                    }
                    // Reset timer, the airport is not busy anymore
                    airPort.resetTimer();
                    airPort.setBusy(false);
                }else{
                    airPort.increaseTimer();
                    // Increase counter for planes in the queues
                    airPort.addToFiveMinCounter();              // TODO OBS! This should not affect current active customer!!! FIX IT!!!

                }

            }else if(airPort.getPlanesInAir().size() > 0){

                for(int id = 0; id < airPort.getPlanesInAir().size(); id++ ){
                    AirPlane airPlane = airPort.getPlanesInAir().get(id);
                    if(!airPlane.isHappy()){
                        airPort.setActiveCustomer(id, true);
                        airPort.setBusy(true);
                        break;
                    }
                }

            }else if(airPort.getPlanesOnGround().size() > 0){
                for(int id = 0; id < airPort.getPlanesOnGround().size(); id++ ){
                    AirPlane airPlane = airPort.getPlanesOnGround().get(id);
                    if(!airPlane.isHappy()){
                        airPort.setActiveCustomer(id, false);
                        airPort.setBusy(true);
                        break;
                    }
                }
            }
        }

        // Check delays
        int happyCounter = 0;
        for(AirPlane airPlane: airPort.getPlanesInAir()){
            if(airPlane.isHappy()){
                happyCounter++;
            }
        }
        System.out.println("Planes that landed: " + happyCounter);

        happyCounter = 0;
        for(AirPlane airPlane: airPort.getPlanesOnGround()){
            if(airPlane.isHappy()){
                happyCounter++;
            }
        }

        System.out.println("Planes that lifted: " + happyCounter);
    }
}


