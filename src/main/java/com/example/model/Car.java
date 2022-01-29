package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    private String id;
    private String name;
    private int productionYear;

    public Car(String name, int productionYear) {
        this.name = name;
        this.productionYear = productionYear;
    }
}
