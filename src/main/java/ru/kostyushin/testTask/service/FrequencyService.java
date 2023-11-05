package ru.kostyushin.testTask.service;

import ru.kostyushin.testTask.dto.CharacterCount;

import java.util.List;

public interface FrequencyService {

    /**
     * Метод для подсчета количества вхождений символов в заданной строке
     *
     * @param inputString - входная строка
     * @return выходной результат(кол-во вхождений каждого символа)
     */
    List<CharacterCount> calculateFrequency(String inputString);
}
