package dev.um6p;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();
        
        placesToVisit.add(new Place("Sydney", 0));
        
        addPlace(placesToVisit, new Place("Melbourne", 877));
        addPlace(placesToVisit, new Place("Brisbane", 917));
        addPlace(placesToVisit, new Place("Adelaide", 1374));
        addPlace(placesToVisit, new Place("Alice Springs", 2771));
        addPlace(placesToVisit, new Place("Perth", 3923));
        addPlace(placesToVisit, new Place("Darwin", 3972));

        visitPlaces(placesToVisit);
    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        if (list.contains(place)) {
            System.out.println("Found duplicate: " + place);
            return;
        }

        ListIterator<Place> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getDistance() > place.getDistance()) {
                iterator.previous();
                iterator.add(place);
                return;
            }
        }
        
        list.add(place);
    }

    private static void visitPlaces(LinkedList<Place> list) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Place> listIterator = list.listIterator();

        if (list.isEmpty()) {
            System.out.println("No places in the itinerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            String input = scanner.nextLine().toUpperCase();
            switch (input) {
                case "F":
                    if (!forward) {  
                        forward = true;
                        if (listIterator.hasNext()) {
                            listIterator.next(); 
                        }
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        forward = false;
                    }
                    break;
                case "B":
                    if (forward) {  
                        forward = false;
                        if (listIterator.hasPrevious()) {
                            listIterator.previous(); 
                        }
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        forward = true;
                    }
                    break;
                case "L":
                    printList(list);
                    break;
                case "M":
                    printMenu();
                    break;
                case "Q":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    printMenu();
                    break;
            }
        }
    }

    private static void printList(LinkedList<Place> list) {
        System.out.println("=".repeat(40));
        System.out.println("Trip itinerary:");
        System.out.println("=".repeat(40));
        for (Place place : list) {
            System.out.println(place);
        }
        System.out.println("=".repeat(40));
    }

    private static void printMenu() {
        System.out.println("""
                
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit""");
    }
}

