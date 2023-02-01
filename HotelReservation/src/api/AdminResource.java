package api;

import model.*;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Scanner;

public class AdminResource {

    public Customer getCustomer(String email){
        return CustomerService.customersMails.get(email);
    }

    public  static void addRoom(){
        int roomNumber = 0;
        RoomTypeEnumeration roomType =RoomTypeEnumeration.SINGLE ;
        double price =0;
        boolean isFree = true;
        boolean inputValid = true;

        // Room number validation
        do{
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter the room number");
                int selection = Integer.parseInt(scanner.nextLine());
                roomNumber = selection;
            } catch (Exception e) {
                System.out.println("This is not a valid entry for the room number:");
                inputValid = false;
            }
        }while(!inputValid);

        // Enum type validation
        do{
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter a room type 1.SINGLE or 2.DOUBLE");
                int selection = Integer.parseInt(scanner.nextLine());
                if (selection ==1){
                    roomType= RoomTypeEnumeration.SINGLE;
                }else if(selection==2){
                    roomType= RoomTypeEnumeration.DOUBLE;
                }
                else{
                    System.out.println("The type of room does not exit");
                    inputValid = false;
                }
            } catch (Exception e) {
                System.out.println("This is not a valid entry for the room type");
                inputValid = false;
            }
        }while(!inputValid);

        do{
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Please set a price");
                double selection = Double.parseDouble(scanner.nextLine());
                price = selection;
            } catch (Exception e) {
                System.out.println("This is not a valid entry for a price.");
                inputValid = false;
            }
        }while(!inputValid);

        // Inputs are validated
        Room room = new model.Room(String.valueOf(roomNumber), roomType , price, isFree);
        ReservationService.freeRoomsQueue.add(room);
    }


    public Collection<Customer> getAllCustomers(){
        /**
         * The collection is imported from the customer service.
         * @returns the function returns a list of customers.
         */
        return CustomerService.customers;
    }

    public void displayAllReservation(){
        for (Reservation reservation: ReservationService.reservations
        ) {
            System.out.println(reservation);
        }
    }
}
