package com.amo.labs.lab2;

import java.util.Arrays;

public class Algorithms {
    private int ID;
    private String firstData;
    private int time;

    private int[] firstArray;

    private int[] sortedArray;

    private int lenght;

    public Algorithms(){

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstData() {
        return firstData;
    }

    public void setFirstData(String firstData) {
        this.firstData = firstData;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int[] getFirstArray() {
        return firstArray;
    }

    public void setFirstArray(int[] firstArray) {
        this.firstArray = firstArray;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }

    public String getFirstArrayStr() {
        return Arrays.toString(firstArray);
    }

    public String getSortedArrayStr() {
        return Arrays.toString(sortedArray);
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    @Override
    public String toString() {
        return "Algorithms{" +
                "ID=" + ID +
                ", firstData='" + firstData + '\'' +
                ", time=" + time +
                ", firstArray=" + Arrays.toString(firstArray) +
                ", sortedArray=" + Arrays.toString(sortedArray) +
                '}';
    }
}
