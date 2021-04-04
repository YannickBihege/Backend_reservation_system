package service;

import model.*;

import java.util.*;

public class ReservationService implements IRoom {

    public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public static Map<String, Reservation> reservationRoomIds = new HashMap<String, Reservation>();

    public static ArrayList<Room> roomsList = new ArrayList<Room>();

    // A queue of rooms
    public static Queue<Room> freeRoomsQueue = new LinkedList<>(roomsList);


    public static void addRoom(IRoom room){
        freeRoomsQueue.add((Room) room);
       roomsList.add((Room) room);
    }

    public static IRoom getARoom(String roomId){

            return (IRoom) reservationRoomIds.get(roomId);
    }

    public  static Reservation reserveARoom(Customer customer, IRoom room , Date checkIndate, Date checkOutdate){
        Reservation reservation = new Reservation(customer, room, checkIndate, checkOutdate);

        return reservation;
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        // TODO
        for (Room room: freeRoomsQueue
             ) {
            Date today = new Date();
            if(today.after(checkOutDate) ){
               // Set the elements to free
                room.setFree(true);
                // add room to the list of free rooms
                freeRoomsQueue.add((FreeRoom) room);
            }
        }
        return (Collection<IRoom>) freeRoomsQueue.poll();
    }

    public static Collection<Reservation> getCustomersReservation(Customer customer){
            return reservations;
    }

    public static void printAllReservation(){
        /*
        for (Reservation reservation: reservations
             ) {
                System.out.println(reservation);
        }
        */
        System.out.println(reservations);
        for (Map.Entry<String,Reservation> entry : ReservationService.reservationRoomIds.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }


    @Override
    public String getRoomNumber(String roomNumber) {
        return roomNumber;
    }

    @Override
    public double getRoomPrice(double price) {
        return price;
    }

    @Override
    public RoomTypeEnumeration getRoomType(RoomTypeEnumeration roomType) {
        return roomType;
    }

    @Override
    public boolean isFree(boolean isFree) {
        return false;
    }
}
