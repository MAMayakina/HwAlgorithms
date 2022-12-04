package com.skypro.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;


public class AlgorithmsServiceTest {
    private AlgorithmsService algorithmsService;
    private List<String> expected;

    @BeforeEach
    public void setup() {
        String fruit1 = "Яблоко";
        String fruit2 = "Груша";
        String fruit3 = "Банан";

        algorithmsService = new AlgorithmsService();
        algorithmsService.clearFruits();
        algorithmsService.add(fruit1);
        algorithmsService.add(fruit2);
        algorithmsService.add(fruit3);

        expected = new ArrayList<>();
        expected.add(fruit1);
        expected.add(fruit2);
        expected.add(fruit3);
    }

    @ParameterizedTest
    @MethodSource("addTest")
    // Добавление элемента.
    public void addTest(String item) {
        algorithmsService.add(item);
        expected.add(item);
        Assertions.assertEquals(expected, algorithmsService.getFruits());
    }

    @ParameterizedTest
    @MethodSource("addByIndexTest")
    // Добавление элемента на определенную позицию списка.
    public void addByIndexTest(int index, String item) {
        algorithmsService.add(index, item);
        expected.add(index, item);
        Assertions.assertEquals(expected, algorithmsService.getFruits());
    }

    @ParameterizedTest
    @MethodSource("setTest")
    // Установить элемент на определенную позицию, затерев существующий.
    public void setTest(int index, String item) {
        algorithmsService.set(index, item);
        expected.set(index, item);
        Assertions.assertEquals(expected, algorithmsService.getFruits());
    }

    @ParameterizedTest
    @MethodSource("removeTest")
    // Удаление элемента.
    public void removeTest(String item) {
        algorithmsService.remove(item);
        expected.remove(item);
        Assertions.assertEquals(expected, algorithmsService.getFruits());
    }

    @ParameterizedTest
    @MethodSource("removeByIndexTest")
    // Удаление элемента по индексу.
    public void removeByIndexTest(int index) {
        algorithmsService.remove(index);
        expected.remove(index);
        Assertions.assertEquals(expected, algorithmsService.getFruits());
    }

    @ParameterizedTest
    @MethodSource("containsTest")
    // Проверка на существование элемента.
    public void containsTest(String item) {
        Assertions.assertEquals(expected.contains(item), algorithmsService.contains(item));
    }

    @ParameterizedTest
    @MethodSource("indexOfTest")
    // Поиск элемента.
    public void indexOfTest(String item) {
        Assertions.assertEquals(expected.indexOf(item), algorithmsService.indexOf(item));
    }

    @ParameterizedTest
    @MethodSource("lastIndexOfTest")
    // Поиск элемента с конца.
    public void lastIndexOfTest(String item) {
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
    public void equalsTest(List<String> otherList) {
        boolean check = true;
        if (otherList.size() != expected.size()) {
            check = false;
        } else {
            int i = 0;
            for (String item : otherList) {
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
        Assertions.assertEquals(0, algorithmsService.getFruits().size());
    }

    @Test
    // Создать новый массив из строк в списке и вернуть его.
    public void toArrayTest() {
        Assertions.assertEquals(expected.toArray().length, algorithmsService.toArray().length);
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.toArray()[i], algorithmsService.toArray()[i]);
        }
    }

    public static List<Arguments> addTest() {
        return List.of(
                Arguments.of("Киви"),
                Arguments.of("Апельсин")
        );
    }

    public static List<Arguments> addByIndexTest() {
        return List.of(
                Arguments.of(2, "Персик"),
                Arguments.of(1, "Абрикос")
        );
    }

    public static List<Arguments> setTest() {
        return List.of(
                Arguments.of(1, "Ананас"),
                Arguments.of(2, "Гранат")
        );
    }

    public static List<Arguments> removeTest() {
        return List.of(
                Arguments.of("Груша"),
                Arguments.of("Банан")
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
                Arguments.of("Киви"),
                Arguments.of("Банан")
        );
    }

    public static List<Arguments> indexOfTest() {
        return List.of(
                Arguments.of("Яблоко"),
                Arguments.of("Груша")
        );
    }

    public static List<Arguments> lastIndexOfTest() {
        return List.of(
                Arguments.of("Яблоко"),
                Arguments.of("Груша")
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
                Arguments.of(List.of("Яблоко", "Груша", "Банан", "Апельсин")),
                Arguments.of(List.of("Яблоко", "Груша", "Банан"))
        );
    }


}
