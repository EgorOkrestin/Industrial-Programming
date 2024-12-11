// Окрестин, 2 курс 5 группа
/*
    10.	Дана строка, слова в которой состоят из букв латинского алфавита и десятичных цифр.
    Остальные символы считаются разделителями между словами. Получить новую строку, выполняя
    в заданной строке замены по следующему правилу. Все слова, имеющие длину более 4 символов
    и состоящие только из букв, заменяются словами, записанными в обратном порядке. Слова в
    исходной строке разделяются некоторым множеством разделителей. Слова в новой строке должны
    разделяться ровно одним пробелом.
 */
/*
    Ввод:
    word wordБББlongword word1
    Вывод:
    word word drowgnol word1
 */
// С использованием String

import java.util.Scanner;

public class Main {
    public static String reverseString(String word){
        String result = "";
        for(int i = word.length() - 1; i >= 0; i--){
            result += word.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Введите строку");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] words = str.split("[^a-zA-Z0-9]");
        String result = "";
        for(String word : words){
            if(word.isEmpty()){
                continue;
            }
            if(word.length() > 4 && word.matches("[^0-9]*")){
                word = reverseString(word);
            }
            result += word + " ";
        }
        System.out.println(result);
    }
}
