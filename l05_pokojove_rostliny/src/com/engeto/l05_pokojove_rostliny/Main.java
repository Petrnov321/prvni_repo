package com.engeto.l05_pokojove_rostliny;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws PlantException {
	// write your code here
        Plant plant = new Plant("rostlina","poznámka", LocalDate.now(),LocalDate.of(2022,3,22), 1);
        ListOfPlants listOfPlants = new ListOfPlants();




        //chybové hlášky fungují i když se špatná data zadají už v konstruktoru
        //plant.setFrequencyOfWatering(0);
        //plant.setWatering(LocalDate.of(2022,2,16));

        listOfPlants.loadFromFile("kvetiny.txt", ", ");

        listOfPlants.addPlant(plant);
        listOfPlants.addPlant(plant);
        listOfPlants.deletePlant(listOfPlants.size() - 1);

        listOfPlants.saveToFile("vystup.txt", ", ");
        listOfPlants.loadFromFile("vystup.txt", ", ");



        //for (Plant pplant: listOfPlants.getAllPlants()) {System.out.println(pplant.toString());}



    }
}
