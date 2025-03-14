package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetMealService {
    /**
     *
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     *
     * @param setmealDTO
     */
    void save(SetmealDTO setmealDTO);

    /**
     * 根据id批量删除套餐
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     *
     * @param id
     * @return
     */
    SetmealVO getById(Long id);

    /**
     *
     * @param setmealDTO
     */
    void update(SetmealDTO setmealDTO);

    /**
     *
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);
    /**
     * 条件查询
     * @param setmeal
     * @return
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据id查询菜品选项
     * @param id
     * @return
     */
    List<DishItemVO> getDishItemById(Long id);

}
