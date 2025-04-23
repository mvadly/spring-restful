package com.mvadly.spring_restful.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestItem {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @DecimalMin("1")
    private Double price;

    @NotNull
    @Min(1)
    private int stock;
}
