package com.sample.shiro.infrastructure.domain.repository.impl;

import com.sample.shiro.infrastructure.domain.model.Role;
import com.sample.shiro.infrastructure.mapper.RoleMapper;
import com.sample.shiro.infrastructure.domain.repository.RoleRepository;
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
public class RoleRepositoryImpl extends ServiceImpl<RoleMapper, Role> implements RoleRepository {

}
