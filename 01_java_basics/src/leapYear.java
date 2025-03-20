// not yet completed

public class leapYear {
    public static void main(String[] args) {
        System.out.println(isLeapYear(2000));;
        System.out.println(getDaysInMonth(2000, 2));

    }

    public static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        return true;
                    } else return false;
                } else return true;
            } else return false;
        } else return false;
    }

    public static int getDaysInMonth(int year, int month) {
        if (month >= 1 && month <= 12 || year >= 1 && year <= 9999) {
            switch (month) {
                case 4, 6, 9, 11 -> {
                    return 30;
                }
                case 1, 3, 5, 7, 8, 10, 12 -> {
                    return 31;
                }
                case 2 -> {
                    if (isLeapYear(year)) {
                        return 29;}
                    return 28;
                }
            }

        } else return -1;

        return year;
    }
}