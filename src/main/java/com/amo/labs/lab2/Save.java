package com.amo.labs.lab2;

public class Save {
    private int ID;
    private String firstData;
    private int time;

    private int[] firstArray;

    private int[] sortedArray;

    public Save(int ID, String firstData, int time, int[] firstArray, int[] sortedArray) {
        this.ID = ID;
        this.firstData = firstData;
        this.time = time;
        this.firstArray = firstArray;
        this.sortedArray = sortedArray;
    }
}
