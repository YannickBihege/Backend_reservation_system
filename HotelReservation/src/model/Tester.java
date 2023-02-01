package model;

import java.util.Calendar;
import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        /**
         * This class is mainly used to test the program execution and the creation of objects.
         *
         */

        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println("-----------------------------||-----------------------------------");

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int newDay = day + 1;
        calendar.add(Calendar.DAY_OF_MONTH, newDay);

        Calendar calendar_first = Calendar.getInstance();
        calendar_first.setTime(today);

        System.out.println("0");
        System.out.println(calendar_first.getTime());
        System.out.println("1");
        Calendar calendar_second = Calendar.getInstance();
        calendar_second.add(Calendar.DAY_OF_MONTH, newDay);
        System.out.println(calendar_second.getTime());

        System.out.println("check this");
        if (calendar_first.after(calendar_second)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }


    }
}
