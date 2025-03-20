package Inheritance;

public class NewCar {
    private Engine engine;
    private MediaPlayer player =  new MediaPlayer();

    public NewCar(Engine engine) {
        this.engine = engine;
    }

    public NewCar() {
        this.engine = new PowerEngine();
    }


    public void start(){
        engine.start();
    }

    public void stop(){
        engine.stop();
    }

    public void startMusic(){
        player.start();
    }

    public void stopMusic(){
        player.stop();
    }

}
