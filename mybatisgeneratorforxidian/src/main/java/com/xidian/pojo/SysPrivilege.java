package com.xidian.pojo;

import javax.persistence.*;

@Table(name = "sys_privilege")
public class SysPrivilege {
    @Id
    private Integer id;

    /**
     * 权限标识
     */
    private String privilege;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取权限标识
     *
     * @return privilege - 权限标识
     */
    public String getPrivilege() {
        return privilege;
    }

    /**
     * 设置权限标识
     *
     * @param privilege 权限标识
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}