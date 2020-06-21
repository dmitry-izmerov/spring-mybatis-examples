package ru.demi.springmybatisexamples;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
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

    @Test
    public void shouldInsertProduct() {
        Product product = new Product();
        product.setName("Kefir");
        product.setPrice(new BigDecimal("75.50"));
        product.setProducer("AO Sofrino");
        product.setCountry("Russia");

        int result = productMapper.insert(product);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldUpdatePrice() {
        int result = productMapper.updatePrice(3, new BigDecimal("27.25"));
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldDeleteProductById() {
        int result = productMapper.deleteById(1);
        assertThat(result).isEqualTo(1);
    }
}