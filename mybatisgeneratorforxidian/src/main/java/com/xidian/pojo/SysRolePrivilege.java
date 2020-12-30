package com.xidian.pojo;

import javax.persistence.*;

@Table(name = "sys_role_privilege")
public class SysRolePrivilege {
    /**
     * 角色权限表
     */
    @Id
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "privilege_id")
    private Integer privilegeId;

    /**
     * 获取角色权限表
     *
     * @return id - 角色权限表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置角色权限表
     *
     * @param id 角色权限表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return privilege_id
     */
    public Integer getPrivilegeId() {
        return privilegeId;
    }

    /**
     * @param privilegeId
     */
    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }
}