package ru.kostyushin.testTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.kostyushin.testTask.service.FrequencyService;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FrequencyControllerTests {

    @MockBean
    private FrequencyService frequencyService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateCharacterFrequency() throws Exception {
        String inputString = "1223334444";

        List<Map.Entry<Character, Integer>> expectedResult = Arrays.asList(
                new AbstractMap.SimpleEntry<>('4', 4),
                new AbstractMap.SimpleEntry<>('3', 3),
                new AbstractMap.SimpleEntry<>('2', 2),
                new AbstractMap.SimpleEntry<>('1', 1)
        );

        when(frequencyService.calculateFrequency(inputString)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/test-task/calculate")
                .param("inputString", inputString)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(new ObjectMapper().writeValueAsString(expectedResult)));
    }

    @Test
    public void testCalculateCharacterFrequencyWithEmptyString() throws Exception {
        String inputString = "";

        List<Map.Entry<Character, Integer>> expectedResult = Collections.emptyList();

        when(frequencyService.calculateFrequency(inputString)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/test-task/calculate")
                .param("inputString", inputString)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(new ObjectMapper().writeValueAsString(expectedResult)));
    }
}
