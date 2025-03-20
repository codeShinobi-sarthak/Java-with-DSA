package ComputerFactory;

public class PersonalComputer extends Product {

    private ComputerCase computerCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PersonalComputer(String model, String manufacturer,
                            ComputerCase computerCase, Monitor monitor,
                            Motherboard motherboard) {
        super(model, manufacturer);
        this.computerCase = computerCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    private void drawLogo() {
        monitor.drawPixelArt(1200, 50, "yellow");
    }

    public void powerUp() {
        computerCase.pressPowerButton();
        drawLogo();
    }

//    public ComputerFactory.ComputerCase getComputerCase() {
//        return computerCase;
//    }
//
//    public ComputerFactory.Monitor getMonitor() {
//        return monitor;
//    }
//
//    public ComputerFactory.Motherboard getMotherboard() {
//        return motherboard;
//    }
}
