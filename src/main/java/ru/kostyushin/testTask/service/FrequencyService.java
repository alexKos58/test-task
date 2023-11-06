package ru.kostyushin.testTask.service;

import java.util.List;
import java.util.Map;

public interface FrequencyService {

    /**
     * Метод для подсчета количества вхождений каждого символа в переданной пользователем строке.
     * Результат сортируется по убыванию количества вхождений символа в заданную строку.
     *
     * @param inputString - входная строка, заданная пользователем
     * @return выходной результат(кол-во вхождений каждого символа)
     */
    Map<Character, Integer> calculateFrequency(String inputString);
}
