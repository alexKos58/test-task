package ru.kostyushin.testTask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kostyushin.testTask.dto.CharacterCount;
import ru.kostyushin.testTask.service.FrequencyService;
import ru.kostyushin.testTask.service.FrequencyServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestTaskApplicationTests {
    FrequencyService frequencyService;

    @BeforeEach
    public void setUp() {
        frequencyService = new FrequencyServiceImpl();
    }

    @Test
    public void testCalculateFrequency() {
        String inputString = "1223334444";
        List<CharacterCount> result = frequencyService.calculateFrequency(inputString);

        assertEquals(4, result.size());

        assertEquals('4', result.get(0).getCharacter());
        assertEquals(4, result.get(0).getCount());

        assertEquals('3', result.get(1).getCharacter());
        assertEquals(3, result.get(1).getCount());

        assertEquals('2', result.get(2).getCharacter());
        assertEquals(2, result.get(2).getCount());

        assertEquals('1', result.get(3).getCharacter());
        assertEquals(1, result.get(3).getCount());
    }

    @Test
    public void testCalculateFrequencyWithEmptyString() {
        String inputString = "";
        List<CharacterCount> result = frequencyService.calculateFrequency(inputString);

        assertTrue(result.isEmpty());
    }
}
