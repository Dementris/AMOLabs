package com.amo.labs.lab2;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SecondLabModel implements LabService{

    @Override
    public void binarySort(Algorithms algorithms) {
        int i, loc, j, selected;
        algorithms.setSortedArray(algorithms.getFirstArray().clone());
        int a[] = algorithms.getSortedArray();
        int n = a.length;
        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = a[i];

            // find location where selected should be inserted
            loc = binarySearch(a, selected, 0, j);

            // Move all elements after location to create space
            while (j >= loc) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = selected;
        }
    }

    @Override
    public int binarySearch(int[] a, int item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (item == a[mid])
                return mid + 1;
            else if (item > a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;

    }

    @Override
    public void stringArrtoInt(Algorithms algorithms) {
        String string = algorithms.getFirstData();
        String[] strings = string.trim().split("\\s*,\\s*");
        int[] arrays = new int[strings.length];
        int val;
        for (int i = 0; i < arrays.length; i++) {
            val = convert(strings[i]);
            arrays[i]=val;
        }
        System.out.println(Arrays.toString(arrays));
        algorithms.setFirstArray(arrays);
    }
    @Override
    public int convert(String str)
    {
        int val = 0;
        try {
            val = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid String");
        }
        return val;
    }
}
