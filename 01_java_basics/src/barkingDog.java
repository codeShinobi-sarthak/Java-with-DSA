public class barkingDog {
    public static void main(String[] args) {


    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {

        if (barking && hourOfDay < 8 && hourOfDay > 0) {
            return true;
        } else return barking && hourOfDay > 8 && hourOfDay < 23;
   }


}