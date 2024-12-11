// Окрестин, 2 курс 5 группа
// Задача 10
/*
    Расстояние между k-й и 1-й строками матрицы А определяется как сумма произведений модулей соответствующих элементов.
    Указать номер строки, максимально удаленной от первой строки заданной матрицы.
 */
/*
    Ввод 1:
    3 2
    Вывод 1:
    [[4, 2], [1, 6], [3, 3]]
    Номер строки, наиболее далёкой от 0-ой: 2
 */

/*
    Ввод 2:
    5 3
    Вывод 2:
    [[3, 3, 0], [5, 4, 4], [1, 5, 5], [6, 6, 4], [1, 1, 6]]
    Номер строки, наиболее далёкой от 0-ой: 3
 */

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Введите размерность матрицы");
        Scanner scanner = new Scanner(System.in);
        int m_size = scanner.nextInt();
        int n_size = scanner.nextInt();
        int[][] arr = new int[m_size][n_size];
        for (int i = 0; i < m_size; i++) {
            for (int j = 0; j < n_size; j++) {
                arr[i][j] = random.nextInt(7);
            }
        }

        int max_distance = 0;
        int str_num = 0;
        for(int i = 1; i < m_size; i++){
            int distance = 0;
            for (int j = 0; j < n_size; j++){
                distance += abs(arr[0][j]) * abs(arr[i][j]);
            }
            if (distance > max_distance){
                max_distance = distance;
                str_num = i;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println("Номер строки, наиболее далёкой от 0-ой: " + str_num);
        scanner.close();
    }
}