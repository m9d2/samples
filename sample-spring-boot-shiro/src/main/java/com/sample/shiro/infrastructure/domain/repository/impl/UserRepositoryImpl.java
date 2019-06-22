package com.sample.shiro.infrastructure.domain.repository.impl;

import com.sample.shiro.infrastructure.domain.model.User;
import com.sample.shiro.infrastructure.mapper.UserMapper;
import com.sample.shiro.infrastructure.domain.repository.UserRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaoy
 * @since 2019-06-22
 */
@Service
public class UserRepositoryImpl extends ServiceImpl<UserMapper, User> implements UserRepository {

}
