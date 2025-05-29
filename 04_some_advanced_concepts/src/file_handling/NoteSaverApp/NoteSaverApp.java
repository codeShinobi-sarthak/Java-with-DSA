package file_handling.NoteSaverApp;

import java.io.*;
import java.util.Scanner;

public class NoteSaverApp {
    private static final String FILE_NAME = "notes.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> writeNote();
                case 2 -> readNote();
                case 3 -> clearNotes();
                case 4 -> System.out.println("👋 Exiting NoteSaver.");
                default -> System.out.println("❌ Invalid choice. Try again!");
            }
        } while (choice != 4);
    }

    private static void readNote() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("📭 No notes found or file does not exists");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String note;
            System.out.println("\n🗒️ Your Saved Notes:");
            while ((note = reader.readLine()) != null) {
                System.out.println("-" + note);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading notes.");
            e.printStackTrace();
        }
    }

    private static void clearNotes() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("🧹 All notes cleared!");
            } else {
                System.out.println("❌ Could not clear notes.");
            }
        } else {
            System.out.println("⚠️ No notes file to delete.");
        }
    }

    private static void writeNote() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            System.out.print("🖊️ Write your note: ");
            String note = scanner.nextLine();
            writer.write(note);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("❌ Failed to write note.");
            e.getStackTrace();
        }
    }

    private static void printMenu() {
        System.out.println("\n======= 📝 NoteSaver Menu =======");
        System.out.println("1. Add a new note");
        System.out.println("2. Read all notes");
        System.out.println("3. Clear all notes");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }
}
