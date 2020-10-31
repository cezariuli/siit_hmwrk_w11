package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    String inputFileName = "athletes.csv";
    String line = "";

    Set<Athlete> athleteList = new TreeSet<Athlete>(new ResultComparator());

    @Test
    public void testSortingByResult()
    {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            while ((line = br.readLine()) != null) {
                String[] input = line.split(",");
                String[] shootingRanges = {input[4], input[5], input[6]};
                athleteList.add(new Athlete(Integer.parseInt(input[0]), input[1], input[2], input[3], shootingRanges));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not accessible");
        }
        int i = 1;
        System.out.println("Position\t\tAthlete\t\tCountry\t\tFinal Result");
        for (Athlete athlete:athleteList) {
            System.out.print(i + "\t\t");
            System.out.print(athlete.getName() + "\t\t");
            System.out.print(athlete.getCountryCode() + "\t\t");
            System.out.println(athlete.getFinalTimeResult());
            i++;
        }
        assertTrue( true );
    }

    @Test
    public void testReadingInputFile() {



        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            while ((line = br.readLine()) != null) {
                String[] input = line.split(",");
                String[] shootingRanges = {input[4], input[5], input[6]};
                for (int i = 0; i < 7; i++) {
                    System.out.println(input[i]);
                }
                //athleteList.add(new Athlete(Integer.parseInt(input[0]), input[1], input[2], input[3], shootingRanges));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not accessible");
        }
        assertTrue(true);
    }
}
