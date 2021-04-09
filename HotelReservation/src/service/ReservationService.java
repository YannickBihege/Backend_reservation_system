package service;

import model.*;

import java.util.*;

public class ReservationService implements IRoom {

    public static Set<Reservation> reservations = new HashSet<>();

    public static Map<String, Reservation> reservationRoomIds = new HashMap<String, Reservation>();

    public static Set<Room> roomsList = new HashSet<>();

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
        // Find available rooms. That is rooms which checkOutDate are prior today. The queue of freerooms will be updated
        findRooms( checkIndate,  checkOutdate);

        Reservation reservation = new Reservation(customer, room, checkIndate, checkOutdate);

        if( ! reservations.contains(reservation) || freeRoomsQueue.contains(room)){
            return reservation;
        }
       else{
           System.out.println("The room is not available");
           return null;
       }

    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){

        // todo
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

        // Display the queues of available rooms
        for (Room room: freeRoomsQueue){
            System.out.println(room.toString());
        }

        if (freeRoomsQueue.isEmpty() ) {
            for (Room room : freeRoomsQueue
            ) {
                System.out.println("List of rooms available in one week");
                Date today = new Date();
                Calendar calendar_first = Calendar.getInstance();

                calendar_first.setTime(checkOutDate);
                int day = calendar_first.get(Calendar.DAY_OF_MONTH);

                int newDay = day + 1;

                Calendar calendar_second  = Calendar.getInstance();
                calendar_second.add(Calendar.DAY_OF_MONTH,newDay);

                // if (today.after(calendar)) {

                if (today.after(checkInDate)&& today.before(checkOutDate) )  {
                    // Set the elements to free
                    room.setFree(true);
                    // add room to the list of free rooms
                    freeRoomsQueue.add((FreeRoom) room);
                }
                else{
                    System.out.println("No rooms available YET");
                   // if()

                }

            }
        }

        return (Collection<IRoom>) freeRoomsQueue.poll();
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
}
