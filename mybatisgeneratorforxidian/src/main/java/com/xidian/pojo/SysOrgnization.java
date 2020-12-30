package com.xidian.pojo;

import javax.persistence.*;

@Table(name = "sys_orgnization")
public class SysOrgnization {
    /**
     * 组织机构表
     */
    @Id
    private Integer id;

    /**
     * 组织机构名称
     */
    @Column(name = "org_name")
    private String orgName;

    /**
     * 机构所属学院
     */
    @Column(name = "dept_id")
    private Integer deptId;

    /**
     * 机构英文缩写
     */
    private String abbrevation;

    /**
     * 获取组织机构表
     *
     * @return id - 组织机构表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置组织机构表
     *
     * @param id 组织机构表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取组织机构名称
     *
     * @return org_name - 组织机构名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置组织机构名称
     *
     * @param orgName 组织机构名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取机构所属学院
     *
     * @return dept_id - 机构所属学院
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * 设置机构所属学院
     *
     * @param deptId 机构所属学院
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取机构英文缩写
     *
     * @return abbrevation - 机构英文缩写
     */
    public String getAbbrevation() {
        return abbrevation;
    }

    /**
     * 设置机构英文缩写
     *
     * @param abbrevation 机构英文缩写
     */
    public void setAbbrevation(String abbrevation) {
        this.abbrevation = abbrevation;
    }
}