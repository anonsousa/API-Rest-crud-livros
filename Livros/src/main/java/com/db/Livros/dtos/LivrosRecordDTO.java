package com.db.Livros.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record LivrosRecordDTO(
        @NotBlank
        String name,
        @NotBlank
        String author,
        @NotBlank
        String publisher,
        @NotBlank
        String language,
        @NotNull
        int numberPages,
        @NotBlank
        String publicationDate,
        @NotNull
        BigDecimal value) {
}
