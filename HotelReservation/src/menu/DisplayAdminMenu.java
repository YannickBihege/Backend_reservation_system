package menu;

import api.HotelResource;
import model.Room;
import model.RoomTypeEnumeration;
import service.CustomerService;
import service.ReservationService;

import java.util.Scanner;

public class DisplayAdminMenu {


    public static void displayLine() {
        System.out.println("---------------------------------------------------");
    }

    public static void numberSelectionAdmin ( int selection){
        if (selection == 1) {
            System.out.println("List of customers");
            CustomerService.getAllCustomers();
            System.out.println(CustomerService.getAllCustomers());
            //reset
            displayAdminMenu();
        } else if (selection == 2) {
            System.out.println("List of all rooms");
            System.out.println(HotelResource.getAllRooms());
            displayAdminMenu();
        } else if (selection == 3) {
            System.out.println("The list of reservations");
            ReservationService.printAllReservation();
            displayAdminMenu();
        } else if (selection == 4) {
            System.out.println("Add a room");
            boolean errorValidation = false;
            do {
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("Please enter a room number:");
                    int roomNumber = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please enter a roomType: single or double please:");
                    String roomTypeEntry = (scanner.nextLine());
                    RoomTypeEnumeration roomtype = null;
                    if (roomTypeEntry.equals("single")) {
                        roomtype = RoomTypeEnumeration.SINGLE;
                    } else if (roomTypeEntry.equals("double")) {
                        roomtype = RoomTypeEnumeration.DOUBLE;
                    } else {
                        System.out.println("Not a valid room type");
                        displayAdminMenu();
                    }
                    System.out.println("Please enter a price");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Boolean isFree: enter true");
                    boolean isFree = Boolean.parseBoolean(scanner.nextLine());
                    Room room = new Room(String.valueOf(roomNumber), roomtype, price, isFree);
                    System.out.println(room);
                    ReservationService.roomsList.add(room);
                    displayAdminMenu();
                } catch (Exception e) {
                    System.out.println("This is not a valid entry numberSelectionAdmin(intern) ");
                    displayAdminMenu();
                }
            } while (errorValidation);
            displayAdminMenu();
        } else if (selection == 5) {
            //displayMenu();
            MainMenu.displayMenu();
        } else {
            System.out.println("This is not a valid entry: choose a number from the menu");
            displayAdminMenu();
        }
    }

    public static void displayAdminMenu () {
        displayLine();
        System.out.println("ADMINISTRATION MENU");
        System.out.println("1.See all Customers");
        System.out.println("2.See all rooms");
        System.out.println("3.See all Reservations");
        System.out.println("4.Add a room");
        System.out.println("5.Exit");
        displayLine();

        boolean errorValidation = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select a number for the menu option");
            int selection = Integer.parseInt(scanner.nextLine());
            numberSelectionAdmin(selection);
            System.out.println("This is not a valid entry: displayAdminMenu()");
        } while (errorValidation);
    }
}
