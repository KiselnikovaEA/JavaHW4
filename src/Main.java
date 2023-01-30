import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("SomeText.txt");
        writer.write("Эта строка будет записываться в файл.\nА затем выгружаться из него.\n");
        writer.flush();
        writer.close();

//        FileReader reader = new FileReader("SomeText.txt");
//        Scanner scan = new Scanner(reader);
//        while (scan.hasNextLine()) {
//            System.out.println(scan.nextLine());
//        }
//        reader.close();

        FileReader reader = new FileReader("SomeText.txt");
        while (reader.ready()) {
            System.out.print((char)reader.read());
        }



    }
}