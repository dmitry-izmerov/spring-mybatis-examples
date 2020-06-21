package ru.demi.springmybatisexamples;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM Products WHERE id = #{id}")
    Product getById(@Param("id") long id);

    @Select("SELECT * FROM Products WHERE country = #{country}")
    List<Product> getAllByCountry(@Param("country") String country);

    @Select("SELECT country, COUNT(*) FROM Products GROUP BY country ORDER BY country ASC")
    @Result(property = "count", column = "count(*)")
    List<CountByCountry> getAllCountsByCountry();

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO Products(name, price, producer, country) VALUES (#{name}, #{price}, #{producer}, #{country})")
    int insert(Product product);

    @Update("UPDATE Products SET price = #{price} WHERE id = #{id}")
    int updatePrice(@Param("id") long id, @Param("price") BigDecimal price);
}
