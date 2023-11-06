package ru.kostyushin.testTask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kostyushin.testTask.service.FrequencyService;
import ru.kostyushin.testTask.service.impl.FrequencyServiceImpl;

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
        String inputString = "1223334444fffff";
        Map<Character, Integer> result = frequencyService.calculateFrequency(inputString);

        assertEquals(5, result.size());

        assertEquals(5, result.get('f'));
        assertEquals(4, result.get('4'));
        assertEquals(3, result.get('3'));
        assertEquals(2, result.get('2'));
        assertEquals(1, result.get('1'));
    }

    @Test
    public void testCalculateFrequencyWithEmptyString() {
        String inputString = "";
        Map<Character, Integer> result = frequencyService.calculateFrequency(inputString);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testCalculateFrequencyWithNullString() {
        Map<Character, Integer> result = frequencyService.calculateFrequency(null);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testCalculateFrequencyWithLongString() {
        String inputString = "A".repeat(10000);
        Map<Character, Integer> result = frequencyService.calculateFrequency(inputString);

        assertEquals(1, result.size());
        assertEquals(10000, result.get('A'));
    }

    @Test
    public void testCalculateFrequencyWithSingleCharacter() {
        String inputString = "A";
        Map<Character, Integer> result = frequencyService.calculateFrequency(inputString);

        assertEquals(1, result.size());
        assertEquals(1, result.get('A'));
    }

    @Test
    public void testCalculateFrequencyWithVeryLongString() {
        String inputString = "ABC".repeat(1000000);
        Map<Character, Integer> result = frequencyService.calculateFrequency(inputString);

        assertEquals(3, result.size());
        assertEquals(1000000, result.get('A'));
        assertEquals(1000000, result.get('B'));
        assertEquals(1000000, result.get('C'));
    }
}
