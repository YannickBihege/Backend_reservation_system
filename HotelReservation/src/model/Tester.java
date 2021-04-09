package model;

import java.util.Calendar;
import java.util.Date;

public class Tester {
    public static void main(String [] args){
        /**
         * This class is mainly used to test the program execution and the creation of objects.
         *
         */

        // Customer customer  = new Customer("first", "second","j@domain.com");
        // System.out.println(customer);

        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        System.out.println("-----------------------------||-----------------------------------");

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int newDay = day + 1;
        calendar.add(Calendar.DAY_OF_MONTH,newDay);

        Calendar calendar_first = Calendar.getInstance();
        calendar_first.setTime(today);

        System.out.println("0");
        System.out.println(calendar_first.getTime());
        System.out.println("1");
        Calendar calendar_second  = Calendar.getInstance();
        calendar_second.add(Calendar.DAY_OF_MONTH,newDay);
        System.out.println(calendar_second.getTime());

        System.out.println("check this");
        if(calendar_first.after(calendar_second)){
            System.out.println("Yes");
        }else{
            System.out.println("No");

        }

        /*

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

            */

    }
}
