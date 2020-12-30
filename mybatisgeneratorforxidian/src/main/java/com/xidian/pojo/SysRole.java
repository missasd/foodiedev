package com.xidian.pojo;

import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    /**
     * 角色id
     */
    @Id
    private Long id;

    /**
     * 角色名
     */
    private String rolename;

    /**
     * 获取角色id
     *
     * @return id - 角色id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置角色id
     *
     * @param id 角色id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取角色名
     *
     * @return rolename - 角色名
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * 设置角色名
     *
     * @param rolename 角色名
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}