package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    /**
     * 批量插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * delete flavor for certain dish
     * @param dishId`
     */
    @Delete("delete from  dish_flavor where  dish_id =#{dishId}")
    void deleteByDishId(Long dishId);

    /**
     *
     * @param dishId
     * @return
     */
    @Select("SELECT * from  dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);
}
