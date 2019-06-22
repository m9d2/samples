package com.sample.shiro.infrastructure.domain.repository.impl;

import com.sample.shiro.infrastructure.domain.model.Permission;
import com.sample.shiro.infrastructure.mapper.PermissionMapper;
import com.sample.shiro.infrastructure.domain.repository.PermissionRepository;
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
public class PermissionRepositoryImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionRepository {

}
