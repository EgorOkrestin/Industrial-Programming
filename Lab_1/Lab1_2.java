// Окрестин Егор, 2 курс 5 группа
// Вычисление арктангенса

import java.math.BigInteger;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.io.*;
import java.text.*;
import java.math.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        try {
            System.out.println("Введите x ∈ (-1,+1): ");
            String line=br.readLine();
            BigDecimal x = new BigDecimal(line);
            
            System.out.println("Введите точность k (целое число): ");
            String secondLine=br.readLine();
            BigDecimal k = new BigDecimal(secondLine);
            
            BigDecimal result = new BigDecimal(0);
            BigDecimal num = new BigDecimal(1);
            
            for(int i = 0; i <= k.doubleValue(); i++){
                if (i % 2 == 0){
                    continue;
                }
                else{
                    BigDecimal divider = new BigDecimal(i);
                    BigDecimal power = x.pow(i);
                    result = result.add((num.multiply(power)).divide(divider, 50, RoundingMode.HALF_UP));
                    num = num.negate();
                }
            }
            System.out.println("По ряду Тейлора: arctan = " + result);
            System.out.println("Встроенная библиотека: arctan = " + Math.atan(x.doubleValue()));
        }
        catch (NumberFormatException e) {
            System.out.println("Не число");
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения с клавиатуры");
        }
    }
}