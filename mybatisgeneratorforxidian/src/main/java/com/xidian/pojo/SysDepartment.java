package com.xidian.pojo;

import javax.persistence.*;

@Table(name = "sys_department")
public class SysDepartment {
    /**
     * 学院表
     */
    @Id
    private Integer id;

    @Column(name = "department_name")
    private String departmentName;

    /**
     * 英文缩写
     */
    private String abbreviate;

    /**
     * 获取学院表
     *
     * @return id - 学院表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置学院表
     *
     * @param id 学院表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return department_name
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 获取英文缩写
     *
     * @return abbreviate - 英文缩写
     */
    public String getAbbreviate() {
        return abbreviate;
    }

    /**
     * 设置英文缩写
     *
     * @param abbreviate 英文缩写
     */
    public void setAbbreviate(String abbreviate) {
        this.abbreviate = abbreviate;
    }
}