package com.amo.labs.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgorithmData {
    public int COUNT;

    AlgorithmData algorithmData;
    List<Algorithms> algorithmsList = new ArrayList<>();

    Map<Integer,Integer> lenghtTimeFeature = new HashMap<>();

    public List<Algorithms> getAlgorithmsList() {
        return algorithmsList;
    }

    public void save(Algorithms algorithms){
        algorithms.setID(COUNT);
        algorithmsList.add(algorithms);
        lenghtTimeFeature.put(algorithms.getLenght(),algorithms.getTime());
        COUNT++;
    }



}
