import java.io.*;
import java.util.*;

public class Model {
    // обрання колекції LinkedList зумовлено швидкістю додавання елементів
    private LinkedList<Integer> numbers;

    public Model(File file) {
        numbers = new LinkedList<Integer>();
        try (BufferedReader input = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
            // не знаємо, скільки елементів вдасться прочитати
            while (true) {
                try {
                    // читаємо, поки не дійдемо до кінця
                    numbers.add(Integer.parseInt(input.readLine()));
                } catch (EOFException | NumberFormatException e) {
                    break;
                }
            }
        } catch (IOException e) {
            // використовуємо більш загальний клас виключення, щоб у будь-якому випадку передбачити заповненість даними
            // (нехай це буде 1 елемент рівний 0)
            numbers.add(0);
        }
    }

    public void printUnique() {
        StringBuilder sb = new StringBuilder();
        new HashSet<Integer>(numbers).stream().forEach(e -> {sb.append(e); sb.append(" ");});
        Console.println("Унікальні значення", sb.toString());
    }

    public void printEvenNumbers() {
        StringBuilder sb = new StringBuilder();
        numbers.stream().forEach(e -> {
            if (e % 2 == 0) {
                sb.append(e); sb.append(" ");
            }
        });
        Console.println("Парні числа", sb.toString());
    }

    public void printElements() {
        Map<String,Integer> map = new LinkedHashMap<>(); // щоб у порядку додавання елементів

        int index = 1;
        for (Integer number : numbers) {
            map.put(index + "-ий елемент", number);
            ++index;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            sb.append(key + " - " + map.get(key) + "\n");
        }
        Console.println("Елементи", sb.toString());
    }
}
