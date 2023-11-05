package ru.kostyushin.testTask.service;

import org.springframework.stereotype.Service;
import ru.kostyushin.testTask.dto.CharacterCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FrequencyServiceImpl implements FrequencyService {

    public List<CharacterCount> calculateFrequency(String inputString) {

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char character : inputString.toCharArray()) {
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }

        return frequencyMap.entrySet().stream()
                .map(entry -> new CharacterCount(entry.getKey(), entry.getValue())).
                        sorted((a, b) -> Integer.compare(b.getCount(), a.getCount())).
                        collect(Collectors.toList());
    }
}
