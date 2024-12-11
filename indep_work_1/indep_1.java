// Окрестин, 2 курс 5 группа
// Предплагается, что стоимость станков меньшей мощности не может быть больше стоимости станков большей мощности
/*
    Сначала по возрастанию сортируется массив, хранящий информацию о мощностях станков. Вместе с ним сортируется
    массив со стоимостью станков так, чтобы соответствие по индексам между этими двумя массивами сохранилась.
    Затем из всего множества станков, проверяя все подмножества идущих подряд станков, находим первое подмножество,
    которое подходило бы по требуемым условиям, то есть по стоимости, мощности и количеству.
    Пример обхода трёх станков:
        0 1 2 - Индексы станков
      1 [][][]
      2   [][]
      3     []
      4 [][]
      5   []
      6 []
 */
/*
Пример ввода:
Введите количество станков
5
Введите стоимость станков
3 5 4 7 6
Введите мощности станков
5 5 5 7 5
Введите необходимую мощность станков
19
Введите максимальное число станков, которые могут стоять на заводе
4
Введите сумму, которой располагает организация
20

Результат:
Количество покупаемых станков: 4 (требовалось не более 4)
Общая мощность станков: 20 (требовалось 19)
Общая стоимость станков: 18 (требовалось не более 20)
Покупаются станки под следующими индексами: 0 1 2 3
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество станков");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] prices = new int[size];
        int[] powers = new int[size];
        System.out.println("Введите стоимость станков");
        for(int i = 0; i < size; i++){
            prices[i] = scanner.nextInt();
        }
        System.out.println("Введите мощности станков");
        for(int i = 0; i < size; i++){
            powers[i] = scanner.nextInt();
        }
        System.out.println("Введите необходимую мощность станков");
        int min_power = scanner.nextInt();
        System.out.println("Введите максимальное число станков, которые могут стоять на заводе");
        int max_amount = scanner.nextInt();
        System.out.println("Введите сумму, которой располагает организация");
        int max_price_sum = scanner.nextInt();

        for(int i = 0; i < size - 1; i++){
            for(int j = i + 1; j < size; j++){
                if(powers[i] > powers[j]){
                    int temp = powers[i];
                    powers[i] = powers[j];
                    powers[j] = temp;

                    temp = prices[i];
                    prices[i] = prices[j];
                    prices[j] = temp;
                }
            }
        }

        boolean[] will_be_bought = new boolean[size];
        int result_power = 0;
        int result_price = 0;
        int result_amount = 0;
        boolean is_possible_to_buy = false;

        for(int i = size - 1; i >= 0; i--){
            result_power = 0;
            result_price = 0;
            result_amount = i + 1;
            for(int k = 0; k < result_amount; k++) {
                will_be_bought[k] = true;
                result_power += powers[k];
                result_price += prices[k];
            }
            for(int j = 0; j <= i; j++){
                if(max_price_sum >= result_price && max_amount >= result_amount && min_power <= result_power){
                    is_possible_to_buy = true;
                    break;
                }
                else{
                    will_be_bought[j] = false;
                    result_power -= powers[j];
                    result_price -= prices[j];
                    result_amount--;
                }
            }
            if(is_possible_to_buy){
                break;
            }
        }

        if(is_possible_to_buy){
            System.out.println("Количество покупаемых станков: " + result_amount + " (требовалось не более " + max_amount + ")");
            System.out.println("Общая мощность станков: " + result_power + " (требовалось " + min_power + ")");
            System.out.println("Общая стоимость станков: " + result_price + " (требовалось не более " + max_price_sum + ")");
            System.out.print("Покупаются станки под следующими индексами: ");
            for(int i = 0; i < size; i++){
                if(will_be_bought[i]){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
        else{
            System.out.println("Невозможно приобрести станки на выделенные средства необходимой мощности");
        }
    }
}
