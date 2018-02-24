package cn.unisolution.demo.service.impl;

import cn.unisolution.demo.domain.User;
import cn.unisolution.demo.domain.UserRepository;
import cn.unisolution.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * User 业务层实现
 *
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;


    @Autowired
    RedisTemplate redisTemplate;

    private String key = "springBoot_userList";

    @Override
    public List<User> findAll() {

        // 从缓存中获取信息

        List<User>  list = redisTemplate.opsForList().range(key,0,-1);
        System.out.println(list);

        if(list == null || list.size() == 0){
            list = userRepository.findAll();
            list.forEach(u -> redisTemplate.opsForList().leftPush(key,u));
        }

        return list;
    }

    @Override
    public User insertByUser(User user) {
        LOGGER.info("新增用户：" + user.toString());
        redisTemplate.delete(key);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        LOGGER.info("更新用户：" + user.toString());
        redisTemplate.delete(key);
        return userRepository.save(user);
    }

    @Override
    public User delete(Long id) {

        redisTemplate.delete(key);
        User user = userRepository.findOne(id);
        userRepository.delete(user);

        LOGGER.info("删除用户：" + user.toString());
        return user;
    }

    @Override
    public User findById(Long id) {
        LOGGER.info("获取用户 ID ：" + id);
        return userRepository.findOne(id);
    }
}
