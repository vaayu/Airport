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
                // Increase counter for planes in the queues
                airPort.addToFiveMinCounter();              // TODO OBS! This should not affect current active customer!!!

                if(airPort.getTimer() == 4){
                    // TODO !!!! Check if you need to find the plane in the list also!
                    // Alternative use a pointer to the object for changing the object in the list
                    airPort.getActiveCustomer().setHappy(true);             // Mission accomplished
                    airPort.resetTimer();
                }else{
                    airPort.increaseTimer();
                }

            }else if(airPort.getPlanesInAir().size() > 0){
                for(AirPlane airPlane: airPort.getPlanesInAir()){
                    if(!airPlane.isHappy()){
                        airPort.setActiveCustomer(airPlane);
                    }
                }
            }else if(airPort.getPlanesOnGround().size() > 0){
                for(AirPlane airPlane: airPort.getPlanesOnGround()){
                    if(!airPlane.isHappy()){
                        airPort.setActiveCustomer(airPlane);
                    }
                }
            }
        }

        // Check delays

    }
}


