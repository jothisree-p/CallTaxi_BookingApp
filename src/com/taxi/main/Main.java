package com.taxi.main;

import com.taxi.service.TaxiService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TaxiService taxiService = new TaxiService(4);

        while (true) {

            System.out.println("\n===== CALL TAXI BOOKING SYSTEM =====");
            System.out.println("1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();

                    System.out.print("Enter Pickup Point (A-F): ");
                    char from = scanner.next().toUpperCase().charAt(0);

                    System.out.print("Enter Drop Point (A-F): ");
                    char to = scanner.next().toUpperCase().charAt(0);

                    System.out.print("Enter Pickup Time (Hour): ");
                    int pickupTime = scanner.nextInt();

                    if (from < 'A' || from > 'F' || to < 'A' || to > 'F') {
                        System.out.println("Invalid Location! Points must be between A and F.");
                        break;
                    }

                    if (from == to) {
                        System.out.println("Pickup and Drop cannot be same.");
                        break;
                    }

                    taxiService.bookTaxi(customerId, from, to, pickupTime);
                    break;

                case 2:
                    taxiService.displayTaxiDetails();
                    break;

                case 3:
                    System.out.println("Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}