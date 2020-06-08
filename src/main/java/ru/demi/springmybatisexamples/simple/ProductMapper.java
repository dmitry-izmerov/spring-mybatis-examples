package ru.demi.springmybatisexamples.simple;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {
    @Select("SELECT * FROM Products WHERE id = #{id}")
    Product getProductById(@Param("id") Long id);
}