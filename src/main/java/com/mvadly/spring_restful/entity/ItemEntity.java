package com.mvadly.spring_restful.entity;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "item")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("stock")
    private int stock;


}