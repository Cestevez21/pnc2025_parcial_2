package com.cestevez.pnc_parcial2.entities.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateBookDTO {

    @NotBlank
    @NotNull
    private UUID id;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$")
    private String title;

    private String language;
}
