package Encapsulation;

public class Player {

    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage){
        health -= damage;
        if (health<= 0){
            System.out.println("player knocked out");
        }
    }

    public void restoreHealth(int extraHealth){
        health += extraHealth;
        if (health >= 100){
            System.out.println("player restored 100% health");
        }
    }

    public int healthRemaining(){
        return health;
    }

}
