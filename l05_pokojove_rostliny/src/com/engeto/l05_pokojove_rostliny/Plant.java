package com.engeto.l05_pokojove_rostliny;

import java.time.LocalDate;

public class Plant {

    private String name, notes;
    private LocalDate planted, watering;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) throws PlantException {
        checkFrequencyOfWatering(frequencyOfWatering);
        checkWatering(watering, planted);
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, LocalDate planted, int frequencyOfWatering) throws PlantException {
        checkFrequencyOfWatering(frequencyOfWatering);
        checkWatering(watering, planted);
        this.name = name;
        this.planted = planted;
        this.frequencyOfWatering = frequencyOfWatering;
        notes = "";
        watering = LocalDate.now();
    }

    public Plant(String name) {
        this.name = name;
        notes = "";
        watering = LocalDate.now();
        planted = LocalDate.now();
        frequencyOfWatering = 7;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getNotes() {return notes;}

    public void setNotes(String notes) {this.notes = notes;}

    public LocalDate getPlanted() {return planted;}

    public void setPlanted(LocalDate planted) {this.planted = planted;}

    public LocalDate getWatering() {return watering;}

    public void setWatering(LocalDate watering) throws PlantException {
        checkWatering(watering, planted);
        this.watering = watering;
    }

    public int getFrequencyOfWatering(){
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) throws PlantException {
        checkFrequencyOfWatering(frequencyOfWatering);
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public String getWateringInfo(){
        return "jméno: " + name + ", datum poslední zálivky: " + watering + ", datum doporučené příští zálivky: " + watering.plusDays(frequencyOfWatering);
    }

    static void checkFrequencyOfWatering (int frequencyOfWatering) throws PlantException{
        if (frequencyOfWatering < 1){
            throw new PlantException("frekvence zalévání musí být větší než 0"); }
        else {
            System.out.println("Frequency of wateing id correct.");
        }
    }

    static void checkWatering (LocalDate watering, LocalDate planted) throws PlantException {
        if (watering.compareTo(planted) < 0){
            throw new PlantException("Datum zalévání nesmí být menší než datum zasazení");
        }
        else {
            System.out.println("Watering is correct.");
        }
    }

    @Override
    public String toString() {
        return "Jméno rostliny: " + name +
                ", poznámka: " + notes +
                ", zasazeno: " + planted +
                ", zalét: " + watering +
                ", frekvece zalévání: " + frequencyOfWatering;
    }
}
