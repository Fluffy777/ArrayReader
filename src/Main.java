import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        Model model = new Model(new File("Input.txt"));

        Scanner scanner = new Scanner(System.in);
        String temp;
        boolean flag = true;

        while (flag) {
            temp = scanner.nextLine();

            switch(temp) {
                case "unique":
                    model.printUnique();
                    break;
                case "even":
                    model.printEvenNumbers();
                    break;
                case "elements":
                    model.printElements();
                    break;
                case "quit":
                    flag = false;
                    break;
            }
        }

        Writer writer = new FileWriter("Output.txt");
        writer.append((System.currentTimeMillis()-start) + " ms");
        writer.flush();
        writer.close();
    }
}
