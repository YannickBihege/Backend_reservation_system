package model;

public class FreeRoom extends Room {
    /**
     * Freeroom extends the class Room.
     * The class Room implements the interface IRoom
     */

    public FreeRoom(String roomNumber, RoomTypeEnumeration roomTypeEnumeration, double price, boolean isFree){
        super(roomNumber, roomTypeEnumeration , 0 ,true);
    }

    @Override
    public String toString() {
        return "The following room is free: available number: " + roomNumber   ;
    }
}
