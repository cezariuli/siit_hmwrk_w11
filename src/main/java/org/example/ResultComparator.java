package org.example;

import java.util.Comparator;

public class ResultComparator implements Comparator<Athlete> {


    @Override
    public int compare(Athlete o1, Athlete o2) {
        return o1.getFinalTimeResultInSeconds().compareTo(o2.getFinalTimeResultInSeconds());
    }
}
