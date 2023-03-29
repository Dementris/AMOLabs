package com.amo.labs.lab2;

import java.util.*;

public class AlgorithmData {
    public int COUNT;

    AlgorithmData algorithmData;
    List<Algorithms> algorithmsList = new ArrayList<>();

    Map<String,int[]> lengthTimeFeauter = new HashMap<>();

    public List<Algorithms> getAlgorithmsList() {
        return algorithmsList;
    }

    public Map<String, int[]> getLengthTimeFeauter() {
        return lengthTimeFeauter;
    }

    public void addPlotParams(Algorithms algorithms){
        int[] lenghtTimeInt = new int[2];
        lenghtTimeInt[0] = algorithms.getLenght();
        lenghtTimeInt[1] = algorithms.getTime();
        lengthTimeFeauter.put("ID"+algorithms.getID(),lenghtTimeInt);
    }

    public void save(Algorithms algorithms){
        algorithms.setID(COUNT);
        algorithmsList.add(algorithms);
        COUNT++;
    }

}
