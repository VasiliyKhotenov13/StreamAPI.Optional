import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> streamList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        System.out.println("Текущий массив чисел: " + streamList);

        Stream<Integer> todo1 = streamList.stream();
        System.out.println("В данном массиве: ");

        findMinMax(
                todo1,
                Comparator.naturalOrder(),
                (x, y) -> System.out.println("min = " + x + ", max = " + y)
        );

        Stream<Integer> todo2 = streamList.stream();
        System.out.println("Кол-во чётных чисел: " + searchEvenNumbers(todo2.toList()));
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> minMax = stream.sorted(order).collect(Collectors.toList());
        if (!minMax.isEmpty()) {
            minMaxConsumer.accept(minMax.get(0), minMax.get(minMax.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static int searchEvenNumbers(List<Integer> list) {
        return (int) list.stream()
                .filter(i -> i % 2 == 0)
                .count();
    }
}