package file_handling;

import java.io.*;

public class CreateWriteRead {
    public static void main(String[] args) {
        File file = new File("note.txt");

        // ✅ Fixing File Creation Check
        try {
            if (file.createNewFile()) {
                System.out.println("File is being created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("File creation failed: " + e.getMessage());
        }

        // ✅ Take Input & Write to File
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("note.txt")) {

            System.out.println("Enter text you want to write in file: ");
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // ✅ Read & Print File Content
        try (FileReader f = new FileReader("note.txt")) {
            int letters = f.read();
            while ((letters = f.read()) != -1) {
                System.out.println((char) letters);
//                letters = file.read();
            }
//            file.close();
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
