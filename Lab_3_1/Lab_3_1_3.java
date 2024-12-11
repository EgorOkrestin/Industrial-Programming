// Окрестин, 2 курс 5 группа
/*
    Для выполнения заданий использовать регулярные выражения.
    Каждое задание реализовать в отдельном методе.
    Строку получать из текстового файла input.txt.
    Результат работы методов записывать в выходной текстовый файл output.txt.

    1. Из заданной строки исключить символы, расположенные внутри круглых скобок. Сами скобки тоже должны быть исключены.

    2. Из заданной строки удалить из каждой группы идущих подряд цифр, в которой более двух цифр, все цифры, начиная с третьей.

    3. Из заданной строки удалить из каждой группы идущих подряд цифр все незначащие нули.

 */
/*
    Пример
    input.txt:
    1234567 Какой-то текст (со скобками), в котором 1234567 есть 0000012 цифры 1234567890. 0000012

    output.txt:
    12 Какой-то текст , в котором 12 есть 0 цифры 12. 0
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
    public static String removeBrackets(String line){
        return line.replaceAll("\\([^)]*\\)", "");
    }

    private static String removeBigNumbers(String line){
        return line.replaceAll("\\b(\\d{2})\\d+", "$1");
    }

    private static String removeZeros(String line) {
        return line.replaceAll("\\b0+(\\d+)", "$1");
    }

    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line = br.readLine();

            line = removeBigNumbers(line);
            line = removeBrackets(line);
            line = removeZeros(line);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
                writer.write(line);
            } catch (IOException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
            System.out.println("Преобразования в input.txt выполнены успешно. Результат записан в output.txt");
        }
        catch(IOException e){
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}