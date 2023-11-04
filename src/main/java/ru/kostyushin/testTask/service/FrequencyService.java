package ru.kostyushin.testTask.service;

import ru.kostyushin.testTask.dto.CharacterCount;

import java.util.List;

public interface FrequencyService {
    List<CharacterCount> calculateFrequency(String inputString);
}
