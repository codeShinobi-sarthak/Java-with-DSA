package CompositionChallenge;

public class Main {
    public static void main(String[] args) {
        SmartKitchen SK = new SmartKitchen();

        SK.setKitchenState(true, true, true);

//        SK.getBrewMaster().brewCoffee();
//        SK.getDishWash().doDishes();
//        SK.getRefrigirate().orderFood();

        SK.doKitchenWork();
    }
}