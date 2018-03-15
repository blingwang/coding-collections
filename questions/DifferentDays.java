package com.blingwang.playground;

/**
 * @author edward
 */
public class DifferentDays {
    private static final int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static class Date {
        int d, m, y;

        Date(int d, int m, int y) {
            this.d = d;
            this.m = m;
            this.y = y;
        }
    }

    public static int getDifference(Date dt1, Date dt2) {
        return countDays(dt2) - countDays(dt1);

    }

    private static int countDays(Date date) {
        int days = date.d;
        for (int i = 0; i < date.m - 1; i++) {
            days += monthDays[i];
        }
        days += date.y * 365 + countLeapYears(date);
        return days;
    }

    private static int countLeapYears(Date date) {
        int years = date.y;
        if (date.m <= 2) {
            years--;
        }
        return years / 4 - years / 100 + years / 400;
    }

    public static void main(String[] args) {
        Date dt1 = new Date(1, 2, 2000);
        Date dt2 = new Date(1, 2, 2004);
        System.out.println("Difference between two dates is " + getDifference(dt1, dt2));
    }
}
