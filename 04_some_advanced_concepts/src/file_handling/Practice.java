package file_handling;

import java.io.*;

public class Practice {
    public static void main(String[] args) {
//        try (InputStreamReader reader = new InputStreamReader(System.in)) {
//            System.out.println("Enter here : ");
//            int letters = reader.read();
//            while (reader.ready()) {
//                System.out.println(letters); //? this will print numbers
//                System.out.println((char) letters); //? this will print the char as typed
//                letters = reader.read();
//            }
//            reader.close(); //! BTW not too necessary as it will automatically be done
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


//        output writer
        OutputStream os = System.out;
//        os.write(😟); //? range is exceeded
        System.out.println();

        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)){
            osw.write("Hello world\n");
            osw.write(84);
            osw.write(97);
            osw.write("A");
            osw.write("\n");
            char[] arr = "hello world".toCharArray();
            osw.write(arr);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
