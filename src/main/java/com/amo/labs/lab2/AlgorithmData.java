package com.amo.labs.lab2;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmData {
    public int COUNT;

    AlgorithmData algorithmData;
    List<Algorithms> algorithmsList = new ArrayList<>();

    public List<Algorithms> getAlgorithmsList() {
        return algorithmsList;
    }

    public void save(Algorithms algorithms){
        algorithms.setID(COUNT);
        algorithmsList.add(algorithms);
        COUNT++;
    }



}
