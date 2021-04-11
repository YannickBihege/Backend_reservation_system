package model;

public interface IRoom {

    // Note that the methods declared in an interface are always abstract by default.

    // remove the param roomNumber
    public String getRoomNumber(String roomNumber);

    public double getRoomPrice(double price);

    public  RoomTypeEnumeration getRoomType(RoomTypeEnumeration roomType);

    public boolean isFree(boolean isFree);

    //I need to access the room number at a certain point. The parameter in getRoomNumber does not allow it.
    public String getRoomNumberFind();
}
