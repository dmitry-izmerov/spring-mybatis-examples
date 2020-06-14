package ru.demi.springmybatisexamples;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private String producer;
    private String country;
}
