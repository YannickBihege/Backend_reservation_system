package model;

import java.util.Objects;

public class Room implements IRoom{

    // The room number one set by the admin is not supposed to change . I deleted the setter.
    protected  final String roomNumber;

    protected RoomTypeEnumeration roomType;
    protected double price;
    protected boolean isFree;

    public Room(String roomNumber, RoomTypeEnumeration roomType , double price, boolean isFree){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isFree = isFree;
    }

    @Override
    public String getRoomNumber(String roomNumber) {
        return roomNumber;
    }

    @Override
    public double getRoomPrice(double price) {
        return 0;
    }

    @Override
    public RoomTypeEnumeration getRoomType(RoomTypeEnumeration roomType) {
        return roomType;
    }

    @Override
    public boolean isFree(boolean isFree) {
        return false;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public void setRoomType(RoomTypeEnumeration roomType) {
        this.roomType = roomType;
    }

    /*
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    */


    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", roomType=" + roomType +
                ", price=" + price +
                ", isFree=" + isFree +
                '}';
    }
    /*
      equals and hashCode to determine whether the object exists or not.
      This is especially useful while working with collections.
      More importantly it makes it possible to use the method contains.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Double.compare(room.price, price) == 0 && isFree == room.isFree && Objects.equals(roomNumber, room.roomNumber) && roomType == room.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomType, price, isFree);
    }
}


