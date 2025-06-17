package com.xworkz.duster.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DusterDTO {
    String material;

    String color;

    int cost;

    LocalDate dateOfManufac;

    int quantity;

    String isUseful;

}
