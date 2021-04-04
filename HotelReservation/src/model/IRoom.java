package model;

public interface IRoom {

    // Note that the methods declared in an interface are always abstract by default.
    public String getRoomNumber(String roomNumber);

    public double getRoomPrice(double price);

    public  RoomTypeEnumeration getRoomType(RoomTypeEnumeration roomType);

    public boolean isFree(boolean isFree);
}
