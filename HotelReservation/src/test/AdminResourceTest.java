package test;

import model.Customer;
import model.FreeRoom;
import model.Room;
import model.RoomTypeEnumeration;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdminResourceTest {

    public static void main(String[] args) {
        //Test getCustomer
        getCustomerReturnsEmailCustomerSetIsEmpty();
        // Test addRoom
        addRoomAddElementTo();
        // Test customer service
        getAllCustomersIsnotnull();
    }
    public static void getCustomerReturnsEmailCustomerSetIsEmpty() {
        Customer result = CustomerService.customersMails.get("mail@y.com");
        if(result != null) {
            throw new RuntimeException("getCustomer not Passed Calling the function should return a null object ");
        } else {
            System.out.println("getCustomer Passed The method returned a not null object");
        }
    }

    public static  void addRoomAddElementTo(){
        int roomNumber = 0;
        RoomTypeEnumeration roomType =RoomTypeEnumeration.SINGLE ;
        double price =100;
        boolean isFree = true;
        boolean inputValid = true;
        Room room = new model.Room(String.valueOf(roomNumber), roomType , price, isFree);
        ReservationService.freeRoomsQueue.add(room);

        if(ReservationService.freeRoomsQueue.isEmpty() ) {
            throw new RuntimeException(String.format(
                    "addRoomAddElementTo not Passed. A room should be available %d was returned",ReservationService.freeRoomsQueue.isEmpty()
            ));
        } else {
            System.out.println("addRoomAddElementTo Passed");
        }
    }

    public static void getAllCustomersIsnotnull(){
        Set<Customer> customers = new HashSet<Customer>();
        CustomerService.addCustomer("yaa@ymail.com","Y","Y");

        Collection<Customer> result = CustomerService.getAllCustomers();
        if(result.isEmpty()) {
            throw new RuntimeException(String.format(
                    "getAllCustomers not Passed. A customer has been created."
            ));
        } else {
            System.out.println("getAllCustomersIsnotnull Passed");
        }
    }
}
