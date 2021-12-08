package com.advent.code.dayone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /*
        Example data
        199
        200
        208
        210
        200
        207
        240
        269
        260
        263

        This is the depths scanned by the sonar.
        First, count the number of times a depth measurement increases from the previous measurement.
        First measurement has nothing before it.

        Quiz question.
        How many measurements are larger than the previous measurement?
     */


    public static void main(String[] args){

        //Create List from console input
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            List<Long> measurements = new ArrayList<>();
            boolean endInput = false;

            while(!endInput){
                System.out.println("Please provide a measurement as a number with no decimals: ");
                String measurementFromInput = bufferedReader.readLine();
                try{
                    measurements.add(Long.parseLong(measurementFromInput));
                }catch(NumberFormatException e){
                    System.out.println("The provided measurement is not a valid number.");
                    continue;
                }
                System.out.println("Do you want to continue? Y/N");
                String insertAgain = bufferedReader.readLine();
                if(insertAgain != null &&
                        insertAgain.equalsIgnoreCase("N")){
                    endInput = true;
                }
            }

            Long increasedMeasurements = 0L;
            for(int i = 1; i< measurements.size(); i++){
                Long measurement = measurements.get(i);
                if(measurement > measurements.get(i - 1)){
                    increasedMeasurements += 1;
                }
            }

            System.out.println("The number of increased measurements is: " + increasedMeasurements);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
