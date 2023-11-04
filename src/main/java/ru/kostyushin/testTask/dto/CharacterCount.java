package ru.kostyushin.testTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CharacterCount {

    @Schema(description = "Буква")
    private char character;

    @Schema(description = "Кол-во вхождений в строку")
    private int count;

}

