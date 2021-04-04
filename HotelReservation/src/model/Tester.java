package model;

import service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Tester {
    public static void main(String [] args){
        /**
         * This class is mainly used to test the program execution and the creation of objects.
         *
         */
        Customer customer  = new Customer("first", "second","j@domain.com");
        System.out.println(customer);


        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        Date date = calendar.getTime();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String dateF = sdf.format(date);
        System.out.println(dateF);


        Room room = new Room( String.valueOf("1"), RoomTypeEnumeration.SINGLE , 2, true);
        System.out.println(room.toString());

        ReservationService.roomsList.add(room);

        Reservation reservation = new Reservation(customer, room, new Date(), new Date());
        ReservationService.reservationRoomIds.put("1",reservation);
        for (Map.Entry<String,Reservation> entry : ReservationService.reservationRoomIds.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
}
