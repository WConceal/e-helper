package com.ehelper.admin.feign;

import com.ehelper.admin.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class UserFeignClientFallBack implements UserFeignClient{
    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("use fall back function");
        return user;
    }
}
