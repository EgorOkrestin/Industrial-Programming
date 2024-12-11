// Окрестин, 2 курс 5 группа
import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
public class Main {
    public static String DeleteRepeatableMailAddress(String line){
        line = line.replaceAll("(,)*( )*(\\d{6})$", "");
        return line.replaceAll("^(\\d{6})\\s\\d{6}", "$1");
    }
    public static String DeleteUnnecessaryNumbers(String line){
        return line.replaceFirst("(\\d{6})(,)* (\\S+) \\d+", "$1 $3");
    }
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Adres_input.txt"), StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new FileWriter("Adres_output.txt"))){
            String line;
            while((line = br.readLine()) != null){
                line = DeleteRepeatableMailAddress(line);
                line = DeleteUnnecessaryNumbers(line);
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
        }
        catch(IOException e){
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
