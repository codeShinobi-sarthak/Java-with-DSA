public class megabiteconvertor {
    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(2500);
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {

        System.out.println(kiloBytes < 0 ? "Invalid Value"
                        : kiloBytes + " KB = " + kiloBytes / 1024 + " MB and " + kiloBytes % 1024 + "KB"
                );
    }

}

