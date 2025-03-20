package CompositionChallenge;

public class SmartKitchen {

    private CoffeeMaker brewMaster;
    private Refrigerator refrigirate;
    private DishWasher dishWash;

    public SmartKitchen() {
        this.brewMaster = new CoffeeMaker();
        this.refrigirate = new Refrigerator();
        this.dishWash = new DishWasher();
    }

    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }

    public Refrigerator getRefrigirate() {
        return refrigirate;
    }

    public DishWasher getDishWash() {
        return dishWash;
    }

    public void setKitchenState(boolean coffeeFlag, boolean fridgeFlag, boolean dishWasherFlag){
        brewMaster.isHasWorkToDo(coffeeFlag);
        refrigirate.isHasWorkToDo(fridgeFlag);
        dishWash.isHasWorkToDo(dishWasherFlag);
    }

    public void doKitchenWork(){
        brewMaster.brewCoffee();
        refrigirate.orderFood();
        dishWash.doDishes();
    }
}

class CoffeeMaker {
    private boolean hasWorkToDo;

    public void isHasWorkToDo(boolean hasWorkToDo) {
         this.hasWorkToDo = hasWorkToDo;
    }

    public void brewCoffee(){
        if (hasWorkToDo){
            System.out.println("brew coffee");
            hasWorkToDo = false;
        }
    }
}

class Refrigerator  {
    private boolean hasWorkToDo;

    public void isHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void orderFood(){
        if (hasWorkToDo){
            System.out.println("order food");
            hasWorkToDo = false;
        }
    }
}


class DishWasher {
    private boolean hasWorkToDo;

    public void isHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void doDishes(){
        if (hasWorkToDo){
            System.out.println("do dishes");
            hasWorkToDo = false;
        }
    }
}


