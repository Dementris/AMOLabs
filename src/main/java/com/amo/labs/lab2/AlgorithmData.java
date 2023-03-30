package com.amo.labs.lab2;

import java.util.*;

public class AlgorithmData {
    public int COUNT;

    AlgorithmData algorithmData;
    List<Algorithms> algorithmsList = new ArrayList<>();

    Map<String,int[]> lengthTimeFeauter = new HashMap<>();

    private int[][] logarr = new int[][]{{2, 2}, {4, 8}, {8, 24}, {16, 64}, {32, 160}, {64, 384}, {128, 896}, {256, 2048}, {512, 4608}, {1024, 10240}};;

    public int[][] getLogarr() {
        return logarr;
    }

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
