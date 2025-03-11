package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
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
}
