package com.chris.entities;

import java.util.ArrayList;

public class Population {
    private double popScore;
    private double popNumber;
    private int bestIndex;
    private int secondBestIndex;
    private int thirdBestIndex;
    private int fourthBestIndex;
    private int fifthBestIndex;
    private double bestScore;
    private double secondaryScore;
    private double tertiaryScore;
    private ArrayList<ArrayList<Room>> population = new ArrayList<ArrayList<Room>>();

    public double getBestScore() {
        return bestScore;
    }

    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    public double getTertiaryScore() {
        return tertiaryScore;
    }

    public void setTertiaryScore(double tertiaryScore) {
        this.tertiaryScore = tertiaryScore;
    }

    public double getSecondaryScore() {
        return secondaryScore;
    }

    public void setSecondaryScore(double secondaryScore) {
        this.secondaryScore = secondaryScore;
    }

    public void increasePopNumber() {
        this.popNumber++;
    }

    public double getPopNumber() {
        return this.popNumber;
    }

    public void setPopNumber(double popNumber) {

        this.popNumber = popNumber;
    }

    public double getPopScore() {
        return popScore;
    }

    public void setPopScore(double score) {
        this.popScore = score;
    }

    public void setClassList(ArrayList<ArrayList<Room>> population) {
        this.population = population;
    }


    public ArrayList<ArrayList<Room>> getPopulation() {
        return population;
    }

    public void addClass(ArrayList<Room> r) {
        population.add(r);
    }


    public int getFifthBestIndex() {
        return fifthBestIndex;
    }

    public void setFifthBestIndex(int fifthBestIndex) {
        this.fifthBestIndex = fifthBestIndex;
    }

    public int getFourthBestIndex() {
        return fourthBestIndex;
    }

    public void setFourthBestIndex(int fourthBestIndex) {
        this.fourthBestIndex = fourthBestIndex;
    }

    public int getSecondBestIndex() {
        return secondBestIndex;
    }

    public void setSecondBestIndex(int secondBestIndex) {
        this.secondBestIndex = secondBestIndex;
    }

    public int getBestIndex() {
        return bestIndex;
    }

    public void setBestIndex(int bestIndex) {
        this.bestIndex = bestIndex;
    }

    public int getThirdBestIndex() {
        return thirdBestIndex;
    }

    public void setThirdBestIndex(int thirdBestIndex) {
        this.thirdBestIndex = thirdBestIndex;
    }
}