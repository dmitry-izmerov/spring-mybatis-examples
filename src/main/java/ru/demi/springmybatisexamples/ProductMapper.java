package ru.demi.springmybatisexamples;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM Products WHERE id = #{id}")
    Product getById(@Param("id") Long id);

    @Select("SELECT * FROM Products WHERE country = #{country}")
    List<Product> getAllByCountry(@Param("country") String country);

    @Select("SELECT country, COUNT(*) FROM Products GROUP BY country ORDER BY country ASC")
    @Result(property = "count", column = "count(*)")
    List<CountByCountry> getAllCountsByCountry();

}
