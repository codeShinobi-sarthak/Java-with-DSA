package Inheritance;

public class MediaPlayer implements Media{
    @Override
    public void start() {
        System.out.println("media player is started, music....");
    }

    @Override
    public void stop() {
        System.out.println("media player is stopped");
    }
}
