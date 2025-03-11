package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("userShopController")//设置bean的名字防止重复
@RequestMapping("/user/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取店铺的营业状态为
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("用户获取营业状态")
    public Result<Integer> inquiryStatus(){

         Integer status =(Integer) redisTemplate.opsForValue().get("shop_status");
         log.info("返回的营业状态值为：{}",status==1?"营业中":"打烊了");
         return Result.success(status);
    }
}
