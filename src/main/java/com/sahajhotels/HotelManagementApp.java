package com.sahajhotels;

import com.sahajhotels.structures.Floor;
import com.sahajhotels.structures.Hotel;
import com.sahajhotels.utils.PowerConsumptionMonitor;
import com.sahajhotels.utils.Sensors;

import java.util.List;
import java.util.Scanner;

public class HotelManagementApp {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Number of floors: ");
        int floors = s.nextInt();

        System.out.print("HotelManagementApp corridors per floor: ");
        int mainCorridors = s.nextInt();

        System.out.print("Sub corridors per floor: ");
        int subCorridors = s.nextInt();

        final Hotel hotel1 = new Hotel(floors, mainCorridors, subCorridors);
        final List<Floor> allFloors = hotel1.getAllFloors();


        printPowerConsumed(allFloors);

        PowerConsumptionMonitor.monitorPowerConsumption(allFloors);

        System.out.println("Inputs from Sensors:");
        int j = 0;

        Sensors.inputsFromSensors(s, hotel1, allFloors, j);
    }

    public static void printPowerConsumed(List<Floor> allFloors) {
        for (Floor floor : allFloors) {
            System.out.println("Max power consumption allowed in Floor " +
                    floor.getFloorNum() + ": " + floor.getPowerThreshold());
        }
    }
}