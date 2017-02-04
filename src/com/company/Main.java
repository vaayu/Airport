package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Simulation simulation = new Simulation(1,5,10);


        for(int i = 0; i < simulation.getSimulationYears(); i++){
            //Check if we have a plane that wants to lift of or land
            int landingOrTakingOf = simulation.randomInt(1,20);

            if(landingOrTakingOf == simulation.getLandingAirplane()){
                // We have a airplane that want's to land
                simulation.addPlaneLanding();


            }else if(landingOrTakingOf == simulation.getTakingOfAirplane()){
                // We have a airplane that wants to take of.. and be free..
                simulation.addPlaneTakingOf();
            }

            // Check if we currently have an airplane that is landing or taking of (landing/taking of takes 4 loops)
            // if no then,
            // check if we have any planes that want to land
            // if no then check if we have any airplanes that want to take of

        }

    }
}


