// Окрестин Егор, 2 курс 5 группа
// Вычисление арктангенса

import java.math.BigInteger;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.io.*;
import java.text.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        try {
            System.out.println("Введите x ∈ (-1,+1): ");
            String line=br.readLine();
            double x = Double.parseDouble(line);
            
            System.out.println("Введите точность k (целое число): ");
            String secondLine=br.readLine();
            int k = Integer.parseInt(secondLine);
            
            double result = 0;
            double num = 1;
            
            for(int i = 0; i <= k; i++){
                if (i % 2 == 0){
                    continue;
                }
                else{
                    result += num * Math.pow(x, i) / i;
                    num *= -1;
                }
            }
            System.out.println("По ряду Тейлора: arctan = " + result);
            System.out.println("Встроенная библиотека: arctan = " + Math.atan(x));
        }
        catch (NumberFormatException e) {
            System.out.println("Не число");
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения с клавиатуры");
        }
    }
}
