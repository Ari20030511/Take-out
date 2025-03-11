package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    /**
     *
     * @param setmealPageQueryDTO
     * @return
     */
    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    @AutoFill(value = OperationType.INSERT)
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into setmeal(category_id,description,image,name,price,status,create_time, update_time, create_user, update_user) " +
            "values (#{categoryId},#{description},#{image},#{name},#{price},#{status},#{createTime}, #{updateTime}," +
            "    #{createUser}, #{updateUser})")
    void save(Setmeal setmeal);

    /**
     * 根据id删除套餐
     * @param setMealId
     */
    @Delete("delete from setmeal where  id = #{id}")
    void deleteById(Long setMealId);

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    @Select("SELECT * from setmeal where id =#{id}")
    Setmeal getById(Long id);


    /**
     *
     * @param id
     * @return
     */
    @Select("SELECT * from setmeal_dish where setmeal_id=#{id}")
    List<SetmealDish> getSetmealById(Long id);


    @AutoFill(value = OperationType.UPDATE)
    void update(Setmeal setmeal);
}
