package service;

import model.*;

import java.util.*;

public class ReservationService implements IRoom {

    public static Set<Reservation> reservations = new HashSet<>();
    // A reservation has a customer, a room, a check-in and a "check-out date".
    public static Map<String, Reservation> reservationRoomIds = new HashMap<String, Reservation>();

    // All the rooms
    public static Set<Room> roomsList = new HashSet<>();

    // A queue of rooms available
    public static Set<Room> freeRoomsQueue = new HashSet<>();

    public static void addRoom(IRoom room){
       roomsList.add((Room) room);
    }

    public static IRoom getARoom(String roomId){

        Room returnedRoom = null ;
        for (Room room: roomsList){
            if(room.getRoomNumberFind().equals(roomId)){
                returnedRoom = room;
            }
        }
        return returnedRoom;
    }

    public  static Reservation reserveARoom(Customer customer, IRoom room , Date checkIndate, Date checkOutdate){
        Reservation reservation = new Reservation(customer, room, checkIndate, checkOutdate);
        if( ! reservations.contains(reservation) || freeRoomsQueue.contains(room)){
            reservations.add(reservation);
            String retrievedRoomnumber = null;
            retrievedRoomnumber = room.getRoomNumberFind();
            reservationRoomIds.put(retrievedRoomnumber, reservation);
            return reservation;
        }
       else{
           System.out.println("A reservation cannot be made with the corresponding parameter");
           return null;
       }

    }


    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> availableRoomsPeriod = new HashSet<>();
        Collection<IRoom> availableRoomsNext = new HashSet<>();

        // Manipulate time for later availability
        Calendar calendar_first = Calendar.getInstance();
        calendar_first.setTime(checkInDate);
        calendar_first.add(Calendar.DAY_OF_MONTH, 7);


        Calendar calendar_second  = Calendar.getInstance();
        calendar_second.setTime(checkOutDate);
        calendar_second.add(Calendar.DAY_OF_MONTH,7);

        for (Room existingRoom: roomsList){
            for (Reservation reservation : reservations) {
                    if((checkInDate.after(reservation.getCheckOutDate() )) || (checkOutDate.before(reservation.getCheckInDate() ))    )  {
                        availableRoomsPeriod.add(existingRoom);
                    }
                    else if((calendar_first.after(reservation.getCheckOutDate() )) || (calendar_second.before(reservation.getCheckInDate() ))    ) {
                        availableRoomsNext.add(existingRoom);
                    }
                    else{
                       System.out.println("No available next");
                       for(IRoom room: availableRoomsNext){
                           System.out.println(room.toString());
                       }
                    }
            }
        }
        return availableRoomsPeriod;

    }

    public static Collection<Reservation> getCustomersReservation(Customer customer){
            return reservations;
    }

    public static void printAllReservation(){
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

    @Override
    public String getRoomNumberFind() {
        return null;
    }
}
