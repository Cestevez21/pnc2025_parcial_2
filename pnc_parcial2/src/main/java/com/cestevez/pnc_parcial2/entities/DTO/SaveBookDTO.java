package com.cestevez.pnc_parcial2.entities.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SaveBookDTO {

    @NotBlank
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    private String title;

    @NotBlank
    @NotNull
    private String author;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^(?=(?:[^0-9]*[0-9]){10}(?:(?:[^0-9]*[0-9]){3})?$)[\\d-]+$")
    private String isbn;

    @NotNull
    @Min(1900)
    @Max(2025)
    private Integer publicationYear;

    @NotBlank
    @NotNull
    private String genre;

    @NotNull
    @Min(10)
    private Integer pages;

    private String language;

}
