package com.cestevez.pnc_parcial2.entities.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BooksByPagesDTO {

    @NotNull
    @Min(10)
    private int min;
    
    @NotNull
    @Min(11)
    private int max;
}
