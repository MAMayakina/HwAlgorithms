package com.skypro.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgorithmsService implements AlgorithmsInterface {
    public static int COUNT = 10;
    public static List<Integer> numbers = new ArrayList<>(COUNT);

    public static List<Integer> getNumbers() {
        return numbers;
    }

    public static void clearNumbers() {
        numbers.clear();
    }

    // Добавление элемента.
    // Вернуть добавленный элемент в качестве результата выполнения.
    public Integer add(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Некорректные входные данные");
        }
        numbers.add(item);
        return item;
    }

    // Добавление элемента на определенную позицию списка.
    // Если выходит за пределы фактического количества элементов или массива, выбросить исключение.
    // Вернуть добавленный элемент в качестве результата выполнения.
    public Integer add(int index, Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Некорректные входные данные");
        } else if (index >= numbers.size()) {
            grow();
        }
        numbers.add(index, item);
        return item;
    }

    // Установить элемент на определенную позицию, затерев существующий.
    // Выбросить исключение, если индекс больше фактического количества элементов или выходит за пределы массива.
    public Integer set(int index, Integer item) {
        if (item == null || index >= numbers.size()) {
            throw new IllegalArgumentException("Некорректные входные данные");
        } else {
            numbers.set(index, item);
        }
        return item;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    public Integer remove(Integer item) {
        if (item != null && numbers.contains(item)) {
            numbers.remove(item);
        }
        return 0;
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    public Integer remove(int index) {
        Integer removeNumber;
        if (index < numbers.size()) {
            removeNumber = numbers.get(index);
            numbers.remove(index);
        } else {
            throw new IllegalArgumentException("Некорректные входные данные");
        }
        return removeNumber;
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    public boolean contains(Integer item) {
        if (item != null && numbers.contains(item)) {
            return true;
        }
        return false;
    }

    // Поиск элемента.
    // Вернуть индекс элемента или -1 в случае отсутствия.
    public int indexOf(Integer item) {
        if (item != null && numbers.contains(item)) {
            return numbers.indexOf(item);
        } else {
            return -1;
        }
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента или -1 в случае отсутствия.
    public int lastIndexOf(Integer item) {
        if (item != null && numbers.contains(item)) {
            return numbers.lastIndexOf(item);
        } else {
            return -1;
        }
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение, если выходит за рамки фактического количества элементов.
    public Integer get(int index) {
        if (index < numbers.size()) {
            return numbers.get(index);
        } else {
            throw new IllegalArgumentException("Некорректные входные данные");
        }
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение, если передан null.
    public boolean equals(List otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Некорректные входные данные");
        } else if (numbers.equals(otherList)) {
            return true;
        }
        return false;
    }

    // Вернуть фактическое количество элементов.
    public int size() {
        return numbers.size();
    }

    // Вернуть true, если элементов в списке нет, иначе false.
    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    // Удалить все элементы из списка.
    public void clear() {
        numbers.clear();
    }

    // Создать новый массив из строк в списке и вернуть его.
    public Integer[] toArray() {
        Integer[] array = new Integer[numbers.size()];
        int i = 0;
        for (Integer number : numbers) {
            array[i] = number;
            i++;
        }
        return array;
    }

    //Сортировка массива
    public void quickSort(int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(begin, end);
            quickSort(begin, partitionIndex - 1);
            quickSort(partitionIndex + 1, end);
        }
    }

    private int partition(int begin, int end) {
        Integer pivot = numbers.get(end);
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (numbers.get(j) <= pivot) {
                i++;
                swapElements(i, j);
            }
        }
        swapElements(i + 1, end);
        return i + 1;
    }

    private void swapElements( int left, int right) {
        Integer temp = numbers.get(left);
        numbers.set(left, numbers.get(right));
        numbers.set(right, temp);
    }

    //Бинарный поиск
    public int binarySearch(Integer number) {
        return Collections.binarySearch(numbers, number);
    }

    private List<Integer> grow() {
        COUNT = (int) (numbers.size() * 1.5);
        List<Integer> newNumbers = new ArrayList<>(COUNT);
        newNumbers = List.copyOf(numbers);
        return newNumbers;
    }
}
