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
// С использованием StringBuffer

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите строку");
        Scanner scanner = new Scanner(System.in);
        StringBuffer str = new StringBuffer(scanner.nextLine());
        String[] tempWords = str.toString().split("[^a-zA-Z0-9]");
        StringBuffer[] words = new StringBuffer[tempWords.length];
        for(int i = 0; i < tempWords.length; i++){
            words[i] = new StringBuffer(tempWords[i]);
        }
        StringBuffer result = new StringBuffer();

        for(StringBuffer word : words){
            if(word.isEmpty()){
                continue;
            }
            if(word.length() > 4 && word.toString().matches("[^0-9]*")){
                word.reverse();
            }
            result.append(word).append(" ");
        }
        System.out.println(result);
    }
}