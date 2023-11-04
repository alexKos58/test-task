package ru.kostyushin.testTask.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.kostyushin.testTask.dto.CharacterCount;
import ru.kostyushin.testTask.service.FrequencyService;

import java.util.List;

@RestController
@Tag(description = "Контроллер для тестового задания", name = "TestController")
@RequestMapping("/api/test-task")
@AllArgsConstructor
public class CharacterCountController {

    private final FrequencyService frequencyService;

    @PostMapping("/calculate")
    @Operation(summary = "Вычислить частоту встречи символов по заданной строке")
    @ResponseStatus(HttpStatus.OK)
    public List<CharacterCount> calculateCharacterFrequency(
            @Parameter(description = "Входная строка") @RequestParam(defaultValue = "aaaaabcccc") String inputString) {
        return frequencyService.calculateFrequency(inputString);
    }
}
