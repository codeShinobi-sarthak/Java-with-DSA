package Encapsulation.Challenge;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = tonerLevel;
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "tonerLevel=" + tonerLevel +
                ", pagesPrinted=" + pagesPrinted +
                ", duplex=" + duplex +
                '}';
    }

    public int addToner(int tonerAmount){
        if (tonerAmount < 0 || tonerAmount > 100){
            return -1;
        }

        return this.tonerLevel = tonerAmount;
    }

    public int printPages(int pages){
        if (duplex){
            System.out.println("its a duplex printer");
        }
        return this.pagesPrinted = pages;
    }

}
