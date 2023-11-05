package ru.kostyushin.testTask.service;

import java.util.List;
import java.util.Map;

public interface FrequencyService {

    /**
     * Метод для подсчета количества вхождений символов в заданной строке
     *
     * @param inputString - входная строка
     * @return выходной результат(кол-во вхождений каждого символа)
     */
    List<Map.Entry<Character, Integer>> calculateFrequency(String inputString);
}
