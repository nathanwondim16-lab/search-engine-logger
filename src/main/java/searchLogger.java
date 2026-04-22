import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class searchLogger {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-d");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm:ss a");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt"));
            writer.write(LocalDate.now().format(dateFormat) + "  " + LocalTime.now().format(timeFormat) + " launch\n");
            while(true) {
                System.out.print("Enter a search term (X to exit): ");
                String search = scanner.nextLine().strip();
                writer.write(LocalDate.now().format(dateFormat) + "  " + LocalTime.now().format(timeFormat) + " ");
                if(search.equalsIgnoreCase("x")) {
                    writer.write("exit\n");
                    break;
                } else {
                    writer.write("search : " + search + "\n");
                }
            }
            writer.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
