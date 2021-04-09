package menu;

import api.HotelResource;
import model.Reservation;
import model.Room;
import model.RoomTypeEnumeration;
import service.CustomerService;
import service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class MainMenu {

    public static void main(String [] args){
        displayMenu();
    }

    public static void displayLine(){
        System.out.println("---------------------------------------------------");
    }

    public static void displayMenu(){
        displayLine();
        System.out.println("1.Find and reserve a room");
        System.out.println("2.See my reservations");
        System.out.println("3.Create an account");
        System.out.println("4.Admin");
        System.out.println("5.Exit admin Modus");
        displayLine();

        boolean errorValidation = false;
        do{
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Please select a number for the menu option");
                int selection = Integer.parseInt(scanner.nextLine());
                numberSelection(selection);
                System.out.println("Input validated");
                errorValidation = false;
            } catch (Exception e) {
                System.out.println("This is not a valid entry displayMenu() function");
            }
        }while(errorValidation);
    }

    public static void numberSelection(int selection){
        if(selection == 1){
            System.out.println("Find and reserve a room");
            // See the list of available rooms before the reservation
            // See available rooms
            HotelResource.getAllRooms();

            try (Scanner scanner = new Scanner(System.in)) {

                System.out.println("Please enter the email corresponding to your account ");
                String customerEmail = (scanner.nextLine());

                System.out.println("Enter the desired room number");
                int roomNumber = Integer.parseInt(scanner.nextLine());
                //
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
                Date DateCheckOutDate = formatter.parse(checkOutDate);
                HotelResource.bookARoom(customerEmail,  room ,  dateCheckInDate,  DateCheckOutDate);

                // create the reservation
                Reservation reservation = new Reservation(CustomerService.customersMails.get(customerEmail), room, dateCheckInDate, DateCheckOutDate);
                ReservationService.reservations.add(reservation);

                displayMenu();
            }catch(Exception e){
                System.out.println("Not a valid roomNumber");
            }

            displayMenu();
        }
        else if(selection ==2){
            System.out.println("See my reservations");
            // TODO
            //
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter an email associated with a reservation");
                String customerEmail = (scanner.nextLine());

                // System.out.println(HotelResource.getCustomersReservations(customerEmail) );

                // Find all reservation
                System.out.println("List of all reservations");
                ReservationService.printAllReservation();

                displayMenu();
            }
            catch (Exception e){
                System.out.println("Not a valid mail");
                displayMenu();
            }
        }
        else if(selection ==3){
            System.out.println("Create an account");
            // START VALIDATION
            boolean errorValidation = false;
            do{
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("Please enter an email");
                    String email = (scanner.nextLine());

                    System.out.println("Please your first name");
                    String firstName = (scanner.nextLine());

                    System.out.println("Please enter your last name");
                    String lastName = (scanner.nextLine());

                    HotelResource.createACustomer( email,  firstName,  lastName);
                    System.out.println("Account successfully created");
                    displayMenu();

                } catch (Exception e) {
                    System.out.println("This is not a valid. Re-try to create an account ");
                }
            }while(errorValidation);

            displayMenu();
        }
        else if(selection ==4){
            displayAdminMenu();
        }
        else if(selection ==5){
            System.out.println("Exit the application");
            exitProgram();
        }
    }

    public static void numberSelectionAdmin(int selection){
        if(selection == 1){
            System.out.println("List of customers");
            CustomerService.getAllCustomers();
            System.out.println(CustomerService.getAllCustomers());
            //reset
            displayAdminMenu();
        }
        else if(selection ==2){
            System.out.println("List of all rooms");
            System.out.println(HotelResource.getAllRooms());
            displayAdminMenu();
        }
        else if(selection ==3){
            System.out.println("The list of reservations");
            ReservationService.printAllReservation();
            displayAdminMenu();
        }
        else if(selection ==4){
            System.out.println("Add a room");

            boolean errorValidation = false;
            do{
                try (Scanner scanner = new Scanner(System.in)) {
                    System.out.println("Please enter a room number:");
                    int roomNumber = Integer.parseInt(scanner.nextLine());

                    System.out.println("Please enter a roomType: single or double please:");
                    String roomTypeEntry = (scanner.nextLine());

                    RoomTypeEnumeration roomtype = null;
                    if (roomTypeEntry.equals("single")){
                        roomtype = RoomTypeEnumeration.SINGLE;
                    }
                    else if(roomTypeEntry.equals("double")){
                        roomtype = RoomTypeEnumeration.DOUBLE;
                    }
                    else{
                        System.out.println("Not a valid room type");
                        displayAdminMenu();
                    }

                    System.out.println("Please enter a price");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.println("Boolean isFree: enter true");
                    boolean isFree = Boolean.parseBoolean(scanner.nextLine());

                    Room room = new Room( String.valueOf(roomNumber), roomtype , price, isFree);
                    System.out.println(room.toString());
                    ReservationService.roomsList.add(room);
                    displayAdminMenu();

                } catch (Exception e) {
                    System.out.println("This is not a valid entry numberSelectionAdmin(intern) ");
                    displayAdminMenu();
                }
            }while(errorValidation);
            displayAdminMenu();
        }
        else if(selection ==5){
            displayMenu();
        }
        else{
            System.out.println("This is not a valid entry: choose a number from the menu");
            displayAdminMenu();
        }
    }

    public static void displayAdminMenu(){
        displayLine();
        System.out.println("ADMINISTRATION MENU");
        System.out.println("1.See all Customers");
        System.out.println("2.See all rooms");
        System.out.println("3.See all Reservations");
        System.out.println("4.Add a room");
        System.out.println("5.Exit");
        displayLine();

        boolean errorValidation = false;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select a number for the menu option");
            int selection = Integer.parseInt(scanner.nextLine());
            numberSelectionAdmin(selection);
            System.out.println("This is not a valid entry: displayAdminMenu()");

            /*
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Please select a number for the menu option");
                int selection = Integer.parseInt(scanner.nextLine());
                numberSelectionAdmin(selection);

            } catch (Exception e) {
                System.out.println("This is not a valid entry: displayAdminMenu()");
                inputValid = false;
                System.out.println("Value of inputValid: " + inputValid);
            }
             */
        }while(errorValidation);
    }

    public static int  exitProgram(){
        return 0;
    }


}
