// Окрестин, 2 курс 5 группа
// Задача 24
/*
    24.	Определить, становится ли симметричной (относительно главной диагонали) заданная матрица после
    замены на число 0 каждого локального минимума. Элемент матрицы называется локальным минимумом, если
    он строго меньше всех имеющихся у него соседей. Соседями элемента ajj в матрице назовем элементы aki
    с i-1<=k<=i+1, j-1<=l<=j+1, (k,l)!=(i,j).
 */
/*
    Ввод 1:
    3
    2 1 2
    2 2 2
    1 2 2
    Вывод 1:
    2 0 2
    2 2 2
    0 2 2
    Матрица не становится симметричной
 */
/*
    Ввод 2:
    3
    2 2 0
    2 2 2
    1 2 2
    Вывод 2:
    2 2 0
    2 2 2
    0 2 2
    Матрица становится симметричной
 */

import java.util.Vector;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ввод массива
        System.out.println("Введите размерность квадратной матрицы и введите её содержимое");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Vector<Vector<Integer>> arr = new Vector<>();
        for (int i = 0; i < size; i++) {
            Vector<Integer> row = new Vector<>();
            for (int j = 0; j < size; j++) {
                row.add(scanner.nextInt());
            }
            arr.add(row);
        }

        // Зануление локальных минимумов
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i != 0 && arr.get(i).get(j) >= arr.get(i - 1).get(j)){
                    continue;
                }
                if(j != 0 && arr.get(i).get(j) >= arr.get(i).get(j - 1)){
                    continue;
                }
                if(i != 0 && j != 0 && arr.get(i).get(j) >= arr.get(i - 1).get(j - 1)){
                    continue;
                }
                if(i != 0 && j != size - 1 && arr.get(i).get(j) >= arr.get(i - 1).get(j + 1)){
                    continue;
                }
                if(i != size - 1 && j != 0 && arr.get(i).get(j) >= arr.get(i + 1).get(j - 1)){
                    continue;
                }
                if(i != size - 1 && arr.get(i).get(j) >= arr.get(i + 1).get(j)){
                    continue;
                }
                if(j != size - 1 && arr.get(i).get(j) >= arr.get(i).get(j + 1)){
                    continue;
                }
                if(i != size - 1 && j != size - 1 && arr.get(i).get(j) >= arr.get(i + 1).get(j + 1)){
                    continue;
                }

                arr.get(i).set(j, 0);
            }
        }

        // Проверка симметричности
        boolean is_symmetric = true;
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                if(!arr.get(i).get(j).equals(arr.get(j).get(i))){
                    is_symmetric = false;
                    break;
                }
            }
            if(!is_symmetric){
                break;
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }

        System.out.print("Матрица ");
        if(!is_symmetric){
            System.out.print("не ");
        }
        System.out.println("становится симметричной");
    }
}