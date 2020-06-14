package ru.demi.springmybatisexamples;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductMapperIntegrationTest {
 
    @Autowired
    ProductMapper productMapper;
 
    @Test
    public void shouldReturnProductById() {
        Product product = productMapper.getById(1L);
 
        assertThat(product).isNotNull();
        assertThat(product.getId()).isNotNull();
        assertThat(product.getName()).isNotNull();
        assertThat(product.getPrice()).isNotNull();
        assertThat(product.getProducer()).isNotNull();
        assertThat(product.getCountry()).isNotNull();
    }

    @Test
    public void shouldReturnProductsByCountry() {
        List<Product> products = productMapper.getAllByCountry("Spain");
        assertThat(products.size()).isEqualTo(2);
    }

    @Test
    public void shouldReturnCountsByCountry() {
        List<CountByCountry> countsByCountry = productMapper.getAllCountsByCountry();
        assertThat(countsByCountry.size()).isEqualTo(3);
    }
}