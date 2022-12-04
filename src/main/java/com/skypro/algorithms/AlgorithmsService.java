package com.skypro.algorithms;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmsService implements AlgorithmsInterface {
    private final static int COUNT = 10;
    public static List<String> fruits = new ArrayList<>(COUNT);

    public static List<String> getFruits() {
        return fruits;
    }

    public static void clearFruits() {
        fruits.clear();
    }

    // Добавление элемента.
    // Вернуть добавленный элемент в качестве результата выполнения.
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Некорректные входные данные");
        }
        fruits.add(item);
        return item;
    }

    // Добавление элемента на определенную позицию списка.
    // Если выходит за пределы фактического количества элементов или массива, выбросить исключение.
    // Вернуть добавленный элемент в качестве результата выполнения.
    public String add(int index, String item) {
        if (item == null || index >= fruits.size()) {
            throw new IllegalArgumentException("Некорректные входные данные");
        } else {
            fruits.add(index, item);
        }
        return item;
    }

    // Установить элемент на определенную позицию, затерев существующий.
    // Выбросить исключение, если индекс больше фактического количества элементов или выходит за пределы массива.
    public String set(int index, String item) {
        if (item == null || index >= fruits.size()) {
            throw new IllegalArgumentException("Некорректные входные данные");
        } else {
            fruits.set(index, item);
        }
        return item;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    public String remove(String item) {
        if (item != null && fruits.contains(item)) {
            fruits.remove(item);
        } else {
            throw new IllegalArgumentException("Некорректные входные данные");
        }
        return item;
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент или исключение, если подобный элемент отсутствует в списке.
    public String remove(int index) {
        String removeFruit;
        if (index < fruits.size()) {
            removeFruit = fruits.get(index);
            fruits.remove(index);
        } else {
            throw new IllegalArgumentException("Некорректные входные данные");
        }
        return removeFruit;
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    public boolean contains(String item) {
        if (item != null && fruits.contains(item)) {
            return true;
        }
        return false;
    }

    // Поиск элемента.
    // Вернуть индекс элемента или -1 в случае отсутствия.
    public int indexOf(String item) {
        if (item != null && fruits.contains(item)) {
            return fruits.indexOf(item);
        } else {
            return -1;
        }
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента или -1 в случае отсутствия.
    public int lastIndexOf(String item) {
        if (item != null && fruits.contains(item)) {
            return fruits.lastIndexOf(item);
        } else {
            return -1;
        }
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение, если выходит за рамки фактического количества элементов.
    public String get(int index) {
        if (index < fruits.size()) {
            return fruits.get(index);
        } else {
            throw new IllegalArgumentException("Некорректные входные данные");
        }
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение, если передан null.
    public boolean equals(List otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Некорректные входные данные");
        } else if (fruits.equals(otherList)) {
            return true;
        }
        return false;
    }

    // Вернуть фактическое количество элементов.
    public int size() {
        return fruits.size();
    }

    // Вернуть true, если элементов в списке нет, иначе false.
    public boolean isEmpty() {
        return fruits.isEmpty();
    }

    // Удалить все элементы из списка.
    public void clear() {
        fruits.clear();
    }

    // Создать новый массив из строк в списке и вернуть его.
    public String[] toArray() {
        String[] array = new String[fruits.size()];
        int i = 0;
        for (String fruit : fruits) {
            array[i] = fruit;
            i++;
        }
        return array;
    }
}
