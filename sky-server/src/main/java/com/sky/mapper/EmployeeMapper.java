package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 新增员工
     * @param employee
     */
    @Insert("insert into employee(name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user)" +
            "values  " +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insert(Employee employee);

    /**
     * 分页查询
     * @param employeePageQueryDTO
     * @return
     */
    Page<Employee> pageSelect(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 启用禁用员工账号
     * @param employee
     *
     */
    @Update("update employee set " +
            "status = #{status}," +
            "update_time = #{updateTime}," +
            "update_user = #{updateUser} " +
            "where id = #{id}")
    void startOrStop(Employee employee);

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @Select("select * from employee where id = #{id}")
    Employee getById(Integer id);

    /**
     * 修改数据
     * @param employee
     */
    void update(Employee employee);
}
