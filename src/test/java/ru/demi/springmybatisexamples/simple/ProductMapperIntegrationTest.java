package ru.demi.springmybatisexamples.simple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductMapperIntegrationTest {
 
    @Autowired
    ProductMapper productMapper;
 
    @Test
    public void shouldReturnProductById() {
        Product product = productMapper.getProductById(1L);
 
        assertThat(product).isNotNull();
        assertThat(product.getId()).isNotNull();
        assertThat(product.getName()).isNotNull();
        assertThat(product.getPrice()).isNotNull();
        assertThat(product.getProducer()).isNotNull();
        assertThat(product.getCountry()).isNotNull();
    }
}