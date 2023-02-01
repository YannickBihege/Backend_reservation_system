package test.api;

import model.Customer;
import model.FreeRoom;
import model.Room;
import model.RoomTypeEnumeration;
import service.CustomerService;
import service.ReservationService;

public class AdminResourceTest {

    public static void main(String[] args) {
        getCustomerReturnsEmailCustomerSetIsEmpty();
        addRoomAddElementTo();
    }
    CustomerService customerService = new CustomerService();
    ReservationService reservationService = new ReservationService();
    public static void getCustomerReturnsEmailCustomerSetIsEmpty() {
        Customer result = CustomerService.customersMails.get("mail@y.com");
        if(result != null) {
            throw new RuntimeException(String.format(
                    "getCustomer not Passed Calling the function should return a null object "
                    ));
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
        ReservationService.freeRoomsQueue.add((FreeRoom) room);

        if(ReservationService.freeRoomsQueue.isEmpty() ) {
            throw new RuntimeException(String.format(
                    "addRoomAddElementTo not Passed. A room should be available %d was returned",ReservationService.freeRoomsQueue.isEmpty()
            ));
        } else {
            System.out.println("addRoomAddElementTo Passed");
        }


    }
}
