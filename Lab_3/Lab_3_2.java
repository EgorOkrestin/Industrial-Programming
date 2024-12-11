// Окрестин, 2 курс 5 группа
/*
10.	Строки текстового файла input.txt состоят из слов, разделенных одним или несколькими пробелами.
Перед первым, а также после последнего слова строки пробелы могут отсутствовать. Требуется найти слова
максимальной и минимальной длины и поменять их местами. Если таких слов несколько – брать первые.
 */
/*  Входной файл:
    word longestword word word wd
    wd word word longestword

    Выходной файл:
    word wd word word longestword
    longestword word word wd
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите расположение входного файла");
        String fileName = scanner.nextLine();
        System.out.println("Введите расположение выходного файла");
        String outputFileName = scanner.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            FileWriter writer = new FileWriter(outputFileName);

            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);

                String minWord = null;
                String maxWord = null;
                boolean minReplaced = false;
                boolean maxReplaced = false;

                while (tokenizer.hasMoreTokens()) {
                    String currentWord = tokenizer.nextToken().trim();
                    if (minWord == null || currentWord.length() < minWord.length()) {
                        minWord = currentWord;
                    }
                    if (maxWord == null || currentWord.length() > maxWord.length()) {
                        maxWord = currentWord;
                    }
                }

                StringBuilder replacedLine = new StringBuilder();
                tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    String currentWord = tokenizer.nextToken().trim();
                    if (!minReplaced && currentWord.equals(minWord)) {
                        replacedLine.append(maxWord).append(" ");
                        minReplaced = true;
                    } else if (!maxReplaced && currentWord.equals(maxWord)) {
                        replacedLine.append(minWord).append(" ");
                        maxReplaced = true;
                    } else {
                        replacedLine.append(currentWord).append(" ");
                    }
                }
                writer.write(replacedLine.toString().trim() + "\n");
            }
            br.close();
            writer.close();

            System.out.println("Преобразования выполнены успешно. Результат записан в файл " + outputFileName);
        }
        catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}