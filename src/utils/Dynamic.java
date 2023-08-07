package utils;

import java.util.List;

public class Dynamic {
    // Для перебора всех возможных вариантов рекурсией
    // Рекурсивная функция содержит текущее состояние (какое-то минимальное)
    // Общий массив можно вынести в контекст
    // Нужно дать условие окончания рекурсии
    // Т.к. мы перебираем варианты - у нас идет ветвление. На каждой итерации мы должны выбрать ветку


    // Набрать наибольшее количество баллов, двигаясь поэлементно или прыгая через 1 элемент
    // f([0,1,2,3,4]) = 10
    // f([2,5,-7,2]) = 9
    // f([1,-2,-3,4]) = 3
    // f([3,5,2,-10]) = 10
    // f([-10,1,2,3]) = 6
    // f([1,2,-3,-10,-200,-100,10]) = -97
    // f([-10]) = 0
    // f([-10,-20]) = -10

    public static void main(String[] args) throws Exception {
        Utils.printAll(
            grasshopper(0,1,2,3,4),
            grasshopper(2,5,-7,2),
            grasshopper(1,-2,-3,4),
            grasshopper(3,5,2,-10),
            grasshopper(-10,1,2,3),
            grasshopper(1,2,-3,-10,-200,-100,10),
            grasshopper(-10),
            grasshopper(-10,-20)
        );
    }

    static Integer grasshopper (List<Integer> points, int pos, Integer score) {
        // условие выхода из рекурсии
        if (pos+1 == points.size()) {
            return score;
        }

        // выбор одной ветки из двух с учетом концевых условий
        Integer step1 = grasshopper(points, pos + 1, score + points.get(pos + 1));
        if (pos+2 == points.size()) {
            return step1 > score ? step1 : score;
        }
        Integer step2 = grasshopper(points, pos + 2, score + points.get(pos + 2));
        return step1 > step2 ? step1 : step2;
    }

    static Integer grasshopper(Integer ... points) {
        return grasshopper(List.of(points), -1, 0);
    }
}
