// Окрестин, 2 курс 5 группа
// Задача 38
/*
    Характеристикой строки целочисленной матрицы назовем сумму ее положительных четных элементов.
    Переставляя строки заданной матрицы, расположить их в соответствии с ростом характеристик.
 */
/*
    Ввод 1:
    4 3
     1 2 3
    -4 5 6
     7 8 1
     2 3 4
    Вывод 2:
    1 2 3     sum = 2
    -4 5 6     sum = 6
    2 3 4     sum = 6
    7 8 1     sum = 8
 */
/*
    Ввод 2:
    5 3
    5   1  4
    8   3  2
    25  5  9
    245 54 3
    3   6  3
    Вывод 2:
    25 5 9     sum = 0
    5 1 4     sum = 4
    3 6 3     sum = 6
    8 3 2     sum = 10
    245 54 3     sum = 54
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int rowSum(ArrayList<ArrayList<Integer>> arr, int rowNum){
        ArrayList<Integer> row = arr.get(rowNum);
        int sum = 0;
        for(int num : row){
            if(num > 0 && num % 2 == 0){
                sum += num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // Создание матрицы
        System.out.println("Введите размерность матрицы и введите её содержимое");
        Scanner scanner = new Scanner(System.in);
        int m_size = scanner.nextInt();
        int n_size = scanner.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < m_size; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n_size; j++) {
                row.add(scanner.nextInt());
            }
            arr.add(row);
        }

        // Сортировка
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (rowSum(arr, i) > rowSum(arr, j)) {
                    ArrayList<Integer> temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }

        // Вывод преобразованной матрицы
        for(int i = 0; i < m_size; i++){
            for(int j = 0; j < n_size; j++){
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println("    sum = " + rowSum(arr, i));
        }
    }
}