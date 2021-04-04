package model;

public class Room implements IRoom{

    protected String roomNumber;
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

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

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
}


