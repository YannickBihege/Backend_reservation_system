package menu;

import api.HotelResource;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class MainMenu {

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayLine() {
        System.out.println("---------------------------------------------------");
    }

    public static void displayMenu() {
        displayLine();
        System.out.println("1.Find and reserve a room");
        System.out.println("2.See my reservations");
        System.out.println("3.Create an account");
        System.out.println("4.Admin");
        System.out.println("5.Exit admin Mod");
        displayLine();

        boolean errorValidation = false;
        do {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Please select a number for the menu option");
                int selection = Integer.parseInt(scanner.nextLine());
                numberSelection(selection);
                System.out.println("Input validated");
                errorValidation = false;
            } catch (Exception e) {
                System.out.println("This is not a valid entry displayMenu() function");
            }
        } while (errorValidation);
    }

    public static void numberSelection(int selection) {
        switch (selection) {
            case 1: {
                System.out.println("Find and reserve a room");
                // See the list of available rooms before the reservation
                HotelResource.getAllRooms();
                try (Scanner scanner = new Scanner(System.in)) {

                    System.out.println("Please enter the email corresponding to your account ");
                    String customerEmail = (scanner.nextLine());
                    System.out.println("Enter the desired room number");
                    int roomNumber = Integer.parseInt(scanner.nextLine());
                    HotelResource.getRoom(String.valueOf(roomNumber));
                    Room room = (Room) HotelResource.getRoom(String.valueOf(roomNumber));
                    System.out.println("Enter the desired checkInDate: yyyy-dd-MM");
                    String checkInDate = (scanner.nextLine());
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
                    //Parsing the given String to Date object
                    Date dateCheckInDate = formatter.parse(checkInDate);
                    System.out.println("Enter the desired checkOutDate: yyyy-dd-MM");
                    String checkOutDate = (scanner.nextLine());
                    //Parsing the given String to Date object
                    Date dateCheckOutDate = formatter.parse(checkOutDate);
                    Date today = new Date();
                    if (dateCheckInDate.after(today) && dateCheckOutDate.after(today) && dateCheckInDate.before(dateCheckOutDate)) {
                        HotelResource.bookARoom(customerEmail, room, dateCheckInDate, dateCheckOutDate);
                    } else {
                        System.out.println("Please retry, your check out Date should be posterior to your check-in." +
                                "Your check-in and check-out dates cannot be in the past");
                        displayMenu();
                    }
                    // create the reservation
                    Reservation reservation = new Reservation(CustomerService.customersMails.get(customerEmail), room, dateCheckInDate, dateCheckOutDate);
                    ReservationService.reservations.add(reservation);
                    displayMenu();
                } catch (Exception e) {
                    System.out.println("Not a valid roomNumber");
                    displayMenu();
                }
                displayMenu();
            }
            case 2: {
                System.out.println("See my reservations");
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("Enter an email associated with a reservation");
                    String customerEmail = (scanner.nextLine());
                    // Find all reservation
                    System.out.println("List of all reservations");
                    ReservationService.printAllReservation();
                    displayMenu();
                } catch (Exception e) {
                    System.out.println("Not a valid mail");
                    displayMenu();
                }
            }
            case 3: {
                System.out.println("Create an account");
                // START VALIDATION
                boolean errorValidation = false;
                do {
                    try (Scanner scanner = new Scanner(System.in)) {
                        System.out.println("Please enter an email");
                        String email = (scanner.nextLine());
                        System.out.println("Please your first name");
                        String firstName = (scanner.nextLine());
                        System.out.println("Please enter your last name");
                        String lastName = (scanner.nextLine());
                        HotelResource.createACustomer(email, firstName, lastName);
                        System.out.println("Account successfully created");
                        displayMenu();
                    } catch (Exception e) {
                        System.out.println("This is not a valid. Re-try to create an account ");
                    }
                } while (errorValidation);
                displayMenu();
            }
            case 4: {
                DisplayAdminMenu.displayAdminMenu();
            }
            case 5: {
                System.out.println("Exit the application");
                exitProgram();
            }
            default: {
                System.out.println("Entry not valid");
                displayMenu();
            }
        }
    }

    public static int exitProgram() {
        return 0;
    }


}

