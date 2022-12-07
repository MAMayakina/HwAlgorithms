package com.skypro.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.skypro.algorithms.AlgorithmsService.numbers;


public class AlgorithmsServiceTest {
    private AlgorithmsService algorithmsService;
    private List<Integer> expected;

    @BeforeEach
    public void setup() {
        Integer number1 = generateNumber();
        Integer number2 = generateNumber();
        Integer number3 = generateNumber();

        algorithmsService = new AlgorithmsService();
        algorithmsService.clearNumbers();
        algorithmsService.add(number1);
        algorithmsService.add(number2);
        algorithmsService.add(number3);

        expected = new ArrayList<>();
        expected.add(number1);
        expected.add(number2);
        expected.add(number3);
    }

    private Integer generateNumber() {
        return (int) (Math.random() * 100);
    }

    @ParameterizedTest
    @MethodSource("addTest")
    // Добавление элемента.
    public void addTest(Integer item) {
        algorithmsService.add(item);
        expected.add(item);
        Assertions.assertEquals(expected, algorithmsService.getNumbers());
    }

    @ParameterizedTest
    @MethodSource("addByIndexTest")
    // Добавление элемента на определенную позицию списка.
    public void addByIndexTest(int index, Integer item) {
        algorithmsService.add(index, item);
        expected.add(index, item);
        Assertions.assertEquals(expected, algorithmsService.getNumbers());
    }

    @ParameterizedTest
    @MethodSource("setTest")
    // Установить элемент на определенную позицию, затерев существующий.
    public void setTest(int index, Integer item) {
        algorithmsService.set(index, item);
        expected.set(index, item);
        Assertions.assertEquals(expected, algorithmsService.getNumbers());
    }

    @ParameterizedTest
    @MethodSource("removeTest")
    // Удаление элемента.
    public void removeTest(Integer item) {
        algorithmsService.remove(item);
        expected.remove(item);
        Assertions.assertEquals(expected, algorithmsService.getNumbers());
    }

    @ParameterizedTest
    @MethodSource("removeByIndexTest")
    // Удаление элемента по индексу.
    public void removeByIndexTest(int index) {
        algorithmsService.remove(index);
        expected.remove(index);
        Assertions.assertEquals(expected, algorithmsService.getNumbers());
    }

    @ParameterizedTest
    @MethodSource("containsTest")
    // Проверка на существование элемента.
    public void containsTest(Integer item) {
        Assertions.assertEquals(expected.contains(item), algorithmsService.contains(item));
    }

    @ParameterizedTest
    @MethodSource("indexOfTest")
    // Поиск элемента.
    public void indexOfTest(Integer item) {
        Assertions.assertEquals(expected.indexOf(item), algorithmsService.indexOf(item));
    }

    @ParameterizedTest
    @MethodSource("lastIndexOfTest")
    // Поиск элемента с конца.
    public void lastIndexOfTest(Integer item) {
        Assertions.assertEquals(expected.lastIndexOf(item), algorithmsService.lastIndexOf(item));
    }

    @ParameterizedTest
    @MethodSource("getTest")
    // Получить элемент по индексу.
    public void getTest(int index) {
        Assertions.assertEquals(expected.get(index), algorithmsService.get(index));
    }

    @ParameterizedTest
    @MethodSource("equalsTest")
    // Сравнить текущий список с другим.
    public void equalsTest(List<Integer> otherList) {
        boolean check = true;
        if (otherList.size() != expected.size()) {
            check = false;
        } else {
            int i = 0;
            for (Integer item : otherList) {
                if (expected.get(i) != item) {
                    check = false;
                }
                i++;
            }
        }
        Assertions.assertEquals(check, algorithmsService.equals(otherList));
    }

    @Test
    // Вернуть фактическое количество элементов.
    public void sizeTest() {
        Assertions.assertEquals(expected.size(), algorithmsService.size());
    }

    @Test
    // Вернуть true, если элементов в списке нет, иначе false.
    public void isEmptyTest() {
        Assertions.assertEquals(expected.isEmpty(), algorithmsService.isEmpty());
    }

    @Test
    // Удалить все элементы из списка.
    public void clearTest() {
        algorithmsService.clear();
        Assertions.assertEquals(0, algorithmsService.getNumbers().size());
    }

    @Test
    // Создать новый массив из строк в списке и вернуть его.
    public void toArrayTest() {
        Assertions.assertEquals(expected.toArray().length, algorithmsService.toArray().length);
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.toArray()[i], algorithmsService.toArray()[i]);
        }
    }

    @Test
    //Сортировка массива
    public void quickSort() {
        algorithmsService.quickSort(0, numbers.size()-1);
        for (int i=1; i<numbers.size(); i++) {
            if(numbers.get(i)<numbers.get(i-1)){
                Assertions.fail("Ошибка");
            }
        }
    }

    @ParameterizedTest
    @MethodSource("binarySearch")
    //Бинарный поиск
    public void binarySearch(Integer number) {
        Assertions.assertEquals(Collections.binarySearch(expected, number), algorithmsService.binarySearch(number));
    }

    public static List<Arguments> addTest() {
        return List.of(
                Arguments.of(4),
                Arguments.of(3)
        );
    }

    public static List<Arguments> addByIndexTest() {
        return List.of(
                Arguments.of(2, 9),
                Arguments.of(1, 1)
        );
    }

    public static List<Arguments> setTest() {
        return List.of(
                Arguments.of(1, 4),
                Arguments.of(2, 0)
        );
    }

    public static List<Arguments> removeTest() {
        return List.of(
                Arguments.of(1),
                Arguments.of(2)
        );
    }

    public static List<Arguments> removeByIndexTest() {
        return List.of(
                Arguments.of(1),
                Arguments.of(2)
        );
    }

    public static List<Arguments> containsTest() {
        return List.of(
                Arguments.of(3),
                Arguments.of(0)
        );
    }

    public static List<Arguments> indexOfTest() {
        return List.of(
                Arguments.of(1),
                Arguments.of(2)
        );
    }

    public static List<Arguments> lastIndexOfTest() {
        return List.of(
                Arguments.of(1),
                Arguments.of(2)
        );
    }

    public static List<Arguments> getTest() {
        return List.of(
                Arguments.of(2),
                Arguments.of(0)
        );
    }

    public static List<Arguments> equalsTest() {
        return List.of(
                Arguments.of(List.of(1, 3, 4, 2)),
                Arguments.of(List.of(1, 3, 4))
        );
    }

    public static List<Arguments> binarySearch() {
        return List.of(
                Arguments.of(3),
                Arguments.of(4)
        );
    }

}
