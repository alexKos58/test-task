package ru.kostyushin.testTask.service.impl;

import org.springframework.stereotype.Service;
import ru.kostyushin.testTask.service.FrequencyService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FrequencyServiceImpl implements FrequencyService {

    public List<Map.Entry<Character, Integer>> calculateFrequency(String inputString) {

        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        inputString.chars()
                .mapToObj(c -> (char) c)
                .forEach(character -> frequencyMap.merge(character, 1, Integer::sum));

        return frequencyMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toList());
    }
}

