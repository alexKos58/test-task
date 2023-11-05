package ru.kostyushin.testTask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kostyushin.testTask.service.FrequencyService;
import ru.kostyushin.testTask.service.impl.FrequencyServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FrequencyServiceTests {
    FrequencyService frequencyService;

    @BeforeEach
    public void setUp() {
        frequencyService = new FrequencyServiceImpl();
    }

    @Test
    public void testCalculateFrequency() {
        String inputString = "1223334444";
        List<Map.Entry<Character, Integer>> result = frequencyService.calculateFrequency(inputString);

        assertEquals(4, result.size());

        assertEquals('4', result.get(0).getKey().charValue());
        assertEquals(4, result.get(0).getValue());

        assertEquals('3', result.get(1).getKey().charValue());
        assertEquals(3, result.get(1).getValue());

        assertEquals('2', result.get(2).getKey().charValue());
        assertEquals(2, result.get(2).getValue());

        assertEquals('1', result.get(3).getKey().charValue());
        assertEquals(1, result.get(3).getValue());
    }

    @Test
    public void testCalculateFrequencyWithEmptyString() {
        String inputString = "";
        List<Map.Entry<Character, Integer>> result = frequencyService.calculateFrequency(inputString);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testCalculateFrequencyWithLongString() {
        String inputString = "A".repeat(10000);
        List<Map.Entry<Character, Integer>> result = frequencyService.calculateFrequency(inputString);

        assertEquals(1, result.size());
    }

    @Test
    public void testCalculateFrequencyWithSingleCharacter() {
        String inputString = "A";
        List<Map.Entry<Character, Integer>> result = frequencyService.calculateFrequency(inputString);

        assertEquals(1, result.size());
        assertEquals('A', result.get(0).getKey().charValue());
        assertEquals(1, result.get(0).getValue());
    }

    @Test
    public void testCalculateFrequencyWithVeryLongString() {
        String inputString = String.join("", Collections.nCopies(1000000, "ABC"));
        List<Map.Entry<Character, Integer>> result = frequencyService.calculateFrequency(inputString);

        assertEquals(3, result.size());
        assertEquals('A', result.get(0).getKey().charValue());
        assertEquals(1000000, result.get(0).getValue());
    }
}
