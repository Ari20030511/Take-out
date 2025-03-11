package com.sky.controller.admin;


import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetMealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin/setmeal")
@Slf4j
@Api(tags = "套餐相关接口")
@RestController
public class SetMealController {

    @Autowired
    private SetMealService setMealService;

    /**
     * 分页查询接口
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页查询相关接口")
    public Result<PageResult> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO){
        log.info("开始分页查询：{}",setmealPageQueryDTO);
        PageResult pageResult = setMealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }


    /**
     * 新增套餐
     * @param setmealDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增套餐")
    public Result save(@RequestBody SetmealDTO  setmealDTO){
        setMealService.save(setmealDTO);
        return Result.success();
    }

    /**
     * 根据id批量删除套餐接口
     * @param ids
     * @return
     */
    @DeleteMapping
    @ApiOperation("根据id批量删除套餐接口")
    public Result deletByIds(@RequestParam List<Long> ids){
        log.info("开始批量删除套餐:{}",ids);
        setMealService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * id select setmeal
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询套餐")
    public Result<SetmealVO> getById(@PathVariable Long id){

        SetmealVO setmealVO = setMealService.getById(id);
        return Result.success(setmealVO);
    }

    /**
     *
     * @param setmealDTO
     * @return
     */
    @PutMapping()
    @ApiOperation("修改套餐")
    public Result update(@RequestBody SetmealDTO setmealDTO){
        setMealService.update(setmealDTO);
        return Result.success();
    }

    /**
     * 套餐起售停售
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("套餐起售停售")
    public Result startOrStop(@PathVariable Integer status, Long id) {
        setMealService.startOrStop(status, id);
        return Result.success();
    }

}
