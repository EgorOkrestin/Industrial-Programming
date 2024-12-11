// Окрестин, 2 курс 5 группа
// Задача 10
/*
    Расстояние между k-й и 1-й строками матрицы А определяется как сумма произведений модулей соответствующих элементов.
    Указать номер строки, максимально удаленной от первой строки заданной матрицы.
 */
/*
    Ввод 1:
    3 2
    1 4
    2 5
    3 6
    Вывод 1:
    Номер строки, наиболее далёкой от 0-ой: 2
 */

/*
    Ввод 2:
    4  3
    4 -9  2
    6  9 -3
    12 2 -1
    3  4  5
    Вывод 2:
    Номер строки, наиболее далёкой от 0-ой: 1
 */

import java.util.Scanner;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите размерность матрицы и введите её содержимое");
        Scanner scanner = new Scanner(System.in);
        int m_size = scanner.nextInt();
        int n_size = scanner.nextInt();
        int[][] arr = new int[m_size][n_size];
        for (int i = 0; i < m_size; i++) {
            for (int j = 0; j < n_size; j++) {
                arr[i][j] = scanner.nextInt();
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
        System.out.println("Номер строки, наиболее далёкой от 0-ой: " + str_num);
        scanner.close();
    }
}
