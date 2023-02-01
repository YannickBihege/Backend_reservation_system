package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import static service.ReservationService.getARoom;

public class HotelResource {

    public Customer getCustomer(String email) {
        return CustomerService.customersMails.get(email);
    }

    public static void createACustomer(String email, String firstName, String lastName) {

        /*
          The email should be added to a set to ensure their uniqueness.
         */
        CustomerService.mails.add(email);
        Customer customer = new Customer(firstName, lastName, email);
        CustomerService.customers.add(customer);
        CustomerService.customersMails.put(email, customer);
    }

    public static IRoom getRoom(String roomNumber) {
        return getARoom(roomNumber);
    }

    public static Set<Room> getAllRooms() {

        return ReservationService.roomsList;
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = CustomerService.customersMails.get(customerEmail);
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        ReservationService.reservationRoomIds.put(customerEmail, reservation);
        return ReservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail) {
        Customer customer = CustomerService.customersMails.get(customerEmail);
        return ReservationService.getCustomersReservation(customer);
    }


    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return ReservationService.findRooms(checkIn, checkOut);

    }


}
