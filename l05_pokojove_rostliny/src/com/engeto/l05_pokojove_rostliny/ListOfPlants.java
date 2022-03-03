package com.engeto.l05_pokojove_rostliny;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfPlants {

    private List<Plant> listOfPlants;

    public ListOfPlants() {
        listOfPlants = new ArrayList<>();
    }

    public void addPlant(Plant plant){
        listOfPlants.add(plant);
    }

    public void getPlant(int id){
        listOfPlants.get(id);
    }

    public void deletePlant(int id){
        listOfPlants.remove(id);
    }

    public void loadFromFile(String filename, String delimiter) throws PlantException {
        try( Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()){
                String inputLine = scanner.nextLine();
                String[] partsOfLine = inputLine.split(delimiter);

                String name = partsOfLine[0];//první položka jméno
                String note = partsOfLine[1]; //druhá položka poznámka
                LocalDate planted = LocalDate.parse(partsOfLine[2]); //třetí položka datum zasazení
                LocalDate watering = LocalDate.parse(partsOfLine[3]);//čtvrtá položka datum zalévání
                int frequencyOfWatering = Integer.parseInt(partsOfLine[4]);

                Plant plant = new Plant(name, note, planted, watering,frequencyOfWatering);
                listOfPlants.add(plant);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile(String inputFilename, String delimiter){
        try(PrintWriter writer = new PrintWriter(new FileWriter(inputFilename))) {
            for (Plant plant: listOfPlants) {
                String outputLine = plant.getName() + delimiter;
                outputLine += plant.getNotes() + delimiter;
                outputLine += plant.getPlanted().toString() + delimiter;
                outputLine += plant.getWatering().toString() + delimiter;
                outputLine += plant.getFrequencyOfWatering();
                writer.println(outputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Plant> getAllPlants(){
        return new ArrayList<>(listOfPlants);
    }

    public int size(){
        return listOfPlants.size();
    }

}
