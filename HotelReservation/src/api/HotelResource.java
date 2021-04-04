package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static service.ReservationService.getARoom;

public class HotelResource {

    public Customer getCustomer(String email){
        return CustomerService.customersMails.get(email);
    }

    public static void createACustomer(String email, String firstName, String lastName){

        Customer customer = new Customer(firstName, lastName ,email);
        CustomerService.customers.add(customer);
        CustomerService.customersMails.put(email, customer);
    }

    public static IRoom getRoom(String roomNumber){
        return getARoom(roomNumber);

    }

    public static ArrayList<Room> getAllRooms(){
        //TODO
        for (Room room: ReservationService.roomsList
        ) {
            System.out.println(room.toString());
            }

        return ReservationService.roomsList;
    }

    public static Reservation bookARoom(String customerEmail, IRoom room , Date checkInDate, Date checkOutDate){

        Customer customer = CustomerService.customersMails.get(customerEmail);

        // create a reservation
        Reservation reservation =  new Reservation( customer,  room, checkInDate,  checkOutDate);
        // Add it to the structure
        ReservationService.reservationRoomIds.put(customerEmail,reservation);

        return ReservationService.reserveARoom(customer,room, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail){

        Customer customer = CustomerService.customersMails.get(customerEmail);
        return ReservationService.getCustomersReservation(customer);
    }


    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        return ReservationService.findRooms(checkIn,checkOut);

    }


}
