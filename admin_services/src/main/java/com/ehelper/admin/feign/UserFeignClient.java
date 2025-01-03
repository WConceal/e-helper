package com.ehelper.admin.feign;

import com.ehelper.admin.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="userservices",fallback = UserFeignClientFallBack.class)
public interface UserFeignClient {
    @RequestMapping(value="/user/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer id);
}
