package org.example;

import java.time.*;

public class Athlete {

    private Integer number;
    private String name;
    private String countryCode;
    private String skiTimeResult;
    private String[] shootingRange = new String[3];
    private String finalTimeResult = "";
    private Integer finalTimeResultInSeconds = 0;

    public Athlete(Integer number, String name, String countryCode, String skiTimeResult, String[] shootingRange) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.shootingRange = shootingRange;
        calculatePenalties();
    }


    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public String[] getShootingRange() {
        return shootingRange;
    }

    private void calculatePenalties() {
        int penalties = 0;
        int tmpMins;
        int tmpSec;

        for (int i = 0; i < 3; i++) {
            for (char c : shootingRange[i].toCharArray()) {
                if (c == 'o') {
                    penalties += 10;
                }
            }
        }

        //split the time result string in 2 substrings: Minutes and Seconds;
        String[] temp = this.skiTimeResult.split(":");
        tmpSec = Integer.parseInt(temp[1]) + penalties;

        if (tmpSec / 60 >= 1) {
            tmpMins = Integer.parseInt(temp[0]) + ( tmpSec / 60 );
            tmpSec = tmpSec - ((tmpSec / 60) * 60);
        } else {
            tmpMins = Integer.parseInt(temp[0]);
        }

        this.finalTimeResult = Integer.toString(tmpMins)+ ":" + Integer.toString(tmpSec);
        this.finalTimeResultInSeconds = (tmpMins * 60) + tmpSec;

    }

    public String getFinalTimeResult() {
        return finalTimeResult;
    }

    public Integer getFinalTimeResultInSeconds() {
        return finalTimeResultInSeconds;
    }
}
