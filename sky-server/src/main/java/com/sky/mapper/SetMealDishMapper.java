package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetMealDishMapper {

    /**
     *根据菜品id查询套餐id
     * @param dishId
     * @return
     */

    List<Long> getSetMealIdByDishId(List<Long> dishId);



    /**
     *
     * @param setmealDishes
     */

    void insertBatch(List<SetmealDish> setmealDishes);

    @Delete("delete from setmeal_dish where id = #{setMealId}")
    void deleteBySetMealId(Long setMealId);
}
