package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetMealDishMapper {

    /**
     *根据菜品id查询套餐id
     * @param dishId
     * @return
     */

    List<Long> getSetMealIdByDishId(List<Long> dishId);
}
