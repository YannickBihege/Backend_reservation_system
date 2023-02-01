package model;

public interface IRoom {

    // Note that the methods declared in an interface are always abstract by default.

    // remove the param roomNumber
    String getRoomNumber(String roomNumber);

    double getRoomPrice(double price);

    RoomTypeEnumeration getRoomType(RoomTypeEnumeration roomType);

    boolean isFree(boolean isFree);

    //I need to access the room number at a certain point. The parameter in getRoomNumber does not allow it.
    String getRoomNumberFind();
}
