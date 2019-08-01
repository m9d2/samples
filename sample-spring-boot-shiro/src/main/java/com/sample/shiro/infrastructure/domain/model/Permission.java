package com.sample.shiro.infrastructure.domain.model;

import com.sample.shiro.common.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaoy
 * @since 2019-06-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Permission对象", description="")
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private int id;

    @ApiModelProperty(value = "权限名")
    private String permissionName;

    @ApiModelProperty(value = "外键关联role")
    private Integer roleId;


}
